package kr.co.yjy.domain;

public class User {
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String gender;
	private String regdate;
	//날짜 및 시간을 출력할 변수
	//오늘 작성한 글은 시간을 어제 이전에 작성된 글은 날짜를 출력
	private String dispDate;
	private String authority;

	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDispDate() {
		return dispDate;
	}
	public void setDispDate(String dispDate) {
		this.dispDate = dispDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", nickname=" + nickname + ", gender=" + gender
				+ ", regdate=" + regdate + ", dispDate=" + dispDate + ", authority=" + authority + "]";
	}
	
	
	
	
	

}
