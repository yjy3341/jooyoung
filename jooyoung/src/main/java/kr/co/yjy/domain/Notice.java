package kr.co.yjy.domain;

public class Notice {
	private int nno;
	private String title;
	private String content;
	private String regdate;
	private int readcnt;
	private String id;
	private String nickname;
	
	//��� ������ ������ ����
	private int replycnt;
	//��¥ �� �ð��� ����� ����
	//���� �ۼ��� ���� �ð��� ���� ������ �ۼ��� ���� ��¥�� ���
	private String dispDate;
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	public String getDispDate() {
		return dispDate;
	}
	public void setDispDate(String dispDate) {
		this.dispDate = dispDate;
	}
	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "Notice [nno=" + nno + ", title=" + title + ", content=" + content + ", regdate=" + regdate
				+ ", readcnt=" + readcnt + ", id=" + id + ", nickname=" + nickname + ", replycnt=" + replycnt
				+ ", dispDate=" + dispDate + "]";
	}

}
