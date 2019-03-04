package kr.co.yjy.domain;

//���� ������ ��ȣ�� ������ �� ����� ���� �׸��� ���� �������� ��µ� �������� ���� ��ȣ�� �����ϴ� VO Ŭ������ ����

//���� ������ ��ȣ, ������ �� ����� ������ ����, 
//�������� ��µ� �������� ���� ��ȣ�� �����ϴ� VO Ŭ����
public class Criteria {
	//���� ��� �� �� ������ ��ȣ�� ������ ����
	private int page;
	
	//�������� ����� ������ ����
	private int perPageNum;
	
	//���� �������� ��µ� �������� ���� ��ȣ
	//�� �����ʹ� page �� perPageNum�� �����Ǹ� �ڵ����� �����Ǵ� �׸�
	private int pageStart;
	
	//������ - ��ü�� ���� �� ó�� ȣ��Ǵ� �޼ҵ�
	//������ �ν��Ͻ� ������ �ʱ�ȭ�� ���ؼ� �������մϴ�.
	public Criteria() {
		page = 1;
		perPageNum = 5;
	}

	//������ �޼ҵ�
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getPageStart() {
		//�ڵ����� ���
		//page-���� ������ ��ȣ
		//perPageNum-������ �� ��� ����
		pageStart = (page-1)*perPageNum + 1;
		return pageStart;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", pageStart=" + pageStart + "]";
	}

	/*
	//���� �������� ������ ���� ��ȣ�� �Է¹޴� �׸��� �ƴϹǷ�
	//setter�� �����ؼ� ������ ��츦 ����մϴ�.
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	*/

	
}
