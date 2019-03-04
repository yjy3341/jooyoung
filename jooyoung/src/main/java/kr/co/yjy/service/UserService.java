package kr.co.yjy.service;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.User;

public interface UserService {
	
	//�α���
	public User login(HttpServletRequest request);
	//���̵� �ߺ� üũ
	public String idCheck(HttpServletRequest request);
	//���̵� �ߺ� üũ
	public String nicknameCheck(HttpServletRequest request);
	//ȸ������
	public void register(HttpServletRequest request);
	//ȸ�� Ż��
	public boolean delete(String id);

	//��й�ȣ ����
	public void update(String id, HttpServletRequest request);
	
	//���̵� ã��
	public User idfind(HttpServletRequest request);
}
