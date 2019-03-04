package kr.co.yjy.domain;

//��Ϻ����� �ϴܿ� ��µǴ� ������ ��ȣ�� ���õ� VO Ŭ����
public class PageMaker {

	//��ü ������ ����
	private int totalCount;
	
	//�����ϴ� ������ ��ȣ�� ������ ������ ��ȣ
	private int startPage;
	private int endPage;
	
	//���� �� ���� ��ũ ����
	private boolean prev;
	private boolean next;
	
	//������ ��ȣ ��� ����
	private int displayPageNum = 5;
	
	//������ ������ �ɼ� ���� �����ϱ� ���� ����
	private Criteria criteria;

	//������ �޼ҵ�
	public int getTotalCount() {
		return totalCount;
	}

	//��ü ������ ������ �˰� ���� ��������ȣ(criteria.page)�� 
	//����� ������ ����(displayPageNum)�� �˸� �������� ���� ��� �� �� �ֽ��ϴ�.
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//Math.ceil �Լ��� �ø��� ���ִ� �Լ� �Դϴ�.
		//							���� ������ ��ȣ			�ѹ��� ������ ������ ��ȣ
		endPage =(int)(Math.ceil(criteria.getPage()/(double)displayPageNum)) * displayPageNum;
		//���� ������ ��ȣ
		startPage = endPage - displayPageNum + 1;
		//���� ������ ��ũ ����
		//	������������ȣ�� 1�̸� false �ƴϸ� true
		prev = startPage==1 ? false : true;
		//�� ������ ��ȣ�� �� ������ �� Ȯ��
		//�� ���� ������ ��ȣ�� ��ü �������� ������ �������� ũ��
		//��ü �������� ������ ������ ����
		int pagesu = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		if(endPage > pagesu) {
			endPage = pagesu;
		}
		//������ ������ ��ȣ�� ������ ������ ������ ������ ���� �ʿ� ����
		next = endPage == pagesu ? false : true;
		/*next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;*/
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDiaplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", diaplayPageNum=" + displayPageNum + ", criteria=" + criteria + "]";
	}
		
}