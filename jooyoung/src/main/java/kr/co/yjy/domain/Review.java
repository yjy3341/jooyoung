package kr.co.yjy.domain;

public class Review {
	 private int rvno;
	 private int bno; 
	 private String id;
	 private String nickname;
	 private String reviewtext;
	 private int rating;
	 private String regdate;
	 
	public int getRvno() {
		return rvno;
	}
	public void setRvno(int rvno) {
		this.rvno = rvno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public String getReviewtext() {
		return reviewtext;
	}
	public void setReviewtext(String reviewtext) {
		this.reviewtext = reviewtext;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Review [rvno=" + rvno + ", bno=" + bno + ", id=" + id + ", nickname=" + nickname + ", reviewtext="
				+ reviewtext + ", rating=" + rating + ", regdate=" + regdate + "]";
	}
	 
	
}
