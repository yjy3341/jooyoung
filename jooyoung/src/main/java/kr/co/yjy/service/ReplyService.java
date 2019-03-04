package kr.co.yjy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.yjy.domain.Reply;

public interface ReplyService {

	//´ñ±Û ÀúÀå
	public boolean register(HttpServletRequest request);
	
	//´ñ±Û¸ñ·Ï °¡Á®¿À±â
	public List<Reply> reply(HttpServletRequest request);
	
	//´ñ±Û »èÁ¦
	public boolean delete(HttpServletRequest request);
	
	//´ñ±Û ¼öÁ¤
	public boolean update(HttpServletRequest request);
}
