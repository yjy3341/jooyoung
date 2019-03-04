package kr.co.yjy.service;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.yjy.dao.BoardDao;
import kr.co.yjy.domain.Board;
import kr.co.yjy.domain.Criteria;
import kr.co.yjy.domain.PageMaker;
import kr.co.yjy.domain.SearchCriteria;
import kr.co.yjy.domain.User;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	//�۾���
	@Override
	public void register(MultipartHttpServletRequest request) {
		//�Ķ���� �б�
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String genre = request.getParameter("genre");
		//�α��� �� ������ id�� nickname�� session�� user�Ӽ��� ����
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String id = user.getId();
		String nickname = user.getNickname();
		
		//������ �д� ����� �ٸ�
		MultipartFile image = request.getFile("image");
		//������ ������ ��� �����
		//������ �����ηθ� ������ ����
		//������Ʈ ���� img ���丮�� ���� ��θ� �����
		String uploadPath = request.getRealPath("/image");
		//������ 64�ڸ��� ���ڿ� �����
		UUID uid = UUID.randomUUID();
		//���� �����̸� ��������
		String filename = image.getOriginalFilename();
		filename = uid + "_" + filename;
		//���ε��� ������ ���� ��� �����
		String filepath = uploadPath + "\\" + filename;
		//Dao�� �Ķ���ͷ� ����� ��ü
		//���ε��� ���� ��ü �����
		//Dao �޼ҵ带 ȣ���ؾ� �ϴ� ��� Dao �޼ҵ���
		//�Ķ���͸� ����
		Board board = new Board();
		File f = new File(filepath);
			try{
				//���� ���� - ���� ���ε�
				image.transferTo(f);
				//Dao�� �Ķ���� �����
				board.setId(id);
				board.setNickname(nickname);
				board.setContent(content);
				board.setTitle(title);
				board.setGenre(genre);
		
				//�����ͺ��̽����� ���� �̸��� ����
				board.setImage(filename);
				boardDao.register(board);
			}catch(Exception e) {
				System.out.println("�۾��� ����:" + e.getMessage());
			}	
		
	}

	//�Խ��� ��� 
/*	@Override
	public List<Board> board() {
		//���� ��¥�� �ۼ��� �Խñ��� �ð���
		//������ �ۼ��� �Խñ��� ��¥�� ����ϱ� ���ؼ� �۾�
		List<Board> list = boardDao.board();
		//���� ��¥ �����
		Calendar cal = Calendar.getInstance();
		java.sql.Date today = new java.sql.Date(cal.getTimeInMillis());
		//list�� �����͵��� Ȯ���ؼ� ��¥�� �ð��� ����
		for(Board board : list) {
			//�ۼ��� ��¥ ��������
			String regdate = board.getRegdate().substring(0, 10);
			if(today.toString().equals(regdate)) {
				//�ð��� ���� - �б��� ����
				board.setDispDate(board.getRegdate().substring(11,16));
			}else {
				//��¥�� ����
				board.setDispDate(regdate);
			}
		}
		return list;
	}*/
	
	//�Խ��� ��� 
		@Override
		public Map<String, Object> board(SearchCriteria criteria) {

			//����� ������ Map�� ����
			Map<String, Object> map = new HashMap<String, Object>();
			//������ ��������
			List<Board> list = boardDao.board(criteria);
			//������ �������� �ִ� �����Ͱ� 1�� �ۿ� ���� ��
			//�� �����͸� �����ϸ� �� �������� �����ʹ� �����ϴ�.
			if(list.size() == 0) {
				//���� ������ ��ȣ�� 1���ҽ��Ѽ� �����͸� �ٽ� ��������
				criteria.setPage(criteria.getPage()-1);
				list = boardDao.board(criteria);
			}
			
			//���� ��¥�� �ۼ��� �Խñ��� �ð���
			//������ �ۼ��� �Խñ��� ��¥�� ����ϱ� ���ؼ� �۾�
			//���� ��¥ �����
			Calendar cal = Calendar.getInstance();
			java.sql.Date today = new java.sql.Date(cal.getTimeInMillis());
			//list�� �����͵��� Ȯ���ؼ� ��¥�� �ð��� ����
			for(Board board : list) {
				//�ۼ��� ��¥ ��������
				String regdate = board.getRegdate().substring(0, 10);
				if(today.toString().equals(regdate)) {
					//�ð��� ���� - �б��� ����
					board.setDispDate(board.getRegdate().substring(11,16));
				}else {
					//��¥�� ����
					board.setDispDate(regdate);
				}
				//��� ���� ��������
				int replycnt = boardDao.replycnt(board.getBno());

				//��� ���� ����
				board.setReplycnt(replycnt);
			}
			//�Խù� ����� Map�� ����
			map.put("list", list);
			
			//������ ��ȣ ��� �����
			PageMaker pageMaker = new PageMaker();
			//���� �������� ������ �� ��� ������ ����
			pageMaker.setCriteria(criteria);
			//��ü ������ ���� ���� 
			pageMaker.setTotalCount(boardDao.totalCount(criteria));
			//������ ��ȣ ��� Map�� ����
			map.put("pageMaker", pageMaker);
			
			return map;
		}

	//�Խñ� �󼼺���
	@Override
	public Board detail(HttpServletRequest request) {
		//�Ķ���� �б�
		String bno = request.getParameter("bno");
		//��ȸ�� 1���� �޼ҵ� ȣ��
		//String���̹Ƿ� Integer�� ����ȯ 
		boardDao.updatecnt(Integer.parseInt(bno));
		
		return boardDao.detail(Integer.parseInt(bno));
	}

	//�Խñ� ����ȭ��
	@Override
	public Board updateView(HttpServletRequest request) {
		//�Ķ���� �б�
		String bno = request.getParameter("bno");
		// ������ �������� �޼ҵ带 ȣ���ؼ� ����
		return boardDao.detail(Integer.parseInt(bno));
	}

	//�Խñ� ����ó��
	@Override
	public void update(HttpServletRequest request) {
		//�Ķ���� �б�
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String bno = request.getParameter("bno");
		
		//Dao �޼ҵ带 ȣ���ؾ� �ϴ� ��� Dao�޼ҵ��� �Ķ���͸� ����
		Board board = new Board();
		board.setContent(content);
		board.setTitle(title);
		board.setBno(Integer.parseInt(bno));
		
		// Dao �޼ҵ带 ȣ��
		boardDao.update(board);
	}

	//�Խñ� ����ó��
	@Override
	public void delete(HttpServletRequest request) {
		//�Ķ���� �б�
		String bno = request.getParameter("bno");
		//Dao �޼ҵ� ȣ��
		boardDao.delete(Integer.parseInt(bno));
		
	}


	@Override
	public  Map<String, Object> mypage(Criteria criteria, String id) {
		Map<String, Object> map = 
				new HashMap<String, Object>();
	/*	String id = request.getParameter("id");*/
		
		List<Board> list = boardDao.mypage(criteria);
		
		if(list.size() == 0) {
			//���� ������ ��ȣ�� 1���ҽ��Ѽ� �����͸� �ٽ� ��������
			criteria.setPage(criteria.getPage()-1);
			list = boardDao.mypage(criteria);
		}
		Calendar cal = Calendar.getInstance();
		java.sql.Date today = new java.sql.Date(cal.getTimeInMillis());
		for(Board board : list) {
			//�ۼ��� ��¥ ��������
			String regdate = board.getRegdate().substring(0, 10);
			if(today.toString().equals(regdate)) {
				//�ð��� ���� - �б��� ����
				board.setDispDate(board.getRegdate().substring(11,16));
			}else {
				//��¥�� ����
				board.setDispDate(regdate);
			}
		}
		//�Խù� ����� Map�� ����
		map.put("list", list);
		
		
		//������ ��ȣ ��� �����
		PageMaker pageMaker = new PageMaker();
		//���� �������� ������ �� ��� ������ ����
		pageMaker.setCriteria(criteria);
		//��ü ������ ���� ����
		pageMaker.setTotalCount(boardDao.mypageCount(id));
		//������ ��ȣ ��� Map�� ����
		map.put("pageMaker", pageMaker);
		return map;
	}
 
	

	
}
