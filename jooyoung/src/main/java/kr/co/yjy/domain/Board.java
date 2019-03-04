package kr.co.yjy.domain;

public class Board {
	private int bno;
	private String title;
	private String content;
	private String regdate;
	private int readcnt;
	private String id;
	private String nickname;
	private String image;
	private String genre;
	//��� ������ ������ ����
	private int replycnt;
	//��¥ �� �ð��� ����� ����
	//���� �ۼ��� ���� �ð��� ���� ������ �ۼ��� ���� ��¥�� ���
	private String dispDate;
	

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDispDate() {
		return dispDate;
	}
	public void setDispDate(String dispDate) {
		this.dispDate = dispDate;
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", readcnt="
				+ readcnt + ", id=" + id + ", nickname=" + nickname + ", image=" + image + ", genre=" + genre
				+ ", replycnt=" + replycnt + ", dispDate=" + dispDate + "]";
	}
	

	
	
}
