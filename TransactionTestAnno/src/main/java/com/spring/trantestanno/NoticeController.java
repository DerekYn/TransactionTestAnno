package com.spring.trantestanno;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.trantestanno.model.NoticeVO;
import com.spring.trantestanno.service.InterNoticeService;

// #13. 컨트롤러 선언
@Controller
@Component
/*
   XML에서 빈을 만드는 대신에 클래스명 앞에 @Component 어노테이션을 적어주면
     해당 클래스(지금은 NoticeController)는 bean으로 자동 등록된다.
     그리고 bean의 이름(첫글자는 소문자)은 해당 클래스명(지금은 NoticeController)이 된다.
     지금은 bean의 이름은 noticeController 이 된다.
 */
public class NoticeController {

	@Autowired // 의존객체주입(DI : Dependency Injection)
	private InterNoticeService service;
	
	
	// 시작페이지 요청
	@RequestMapping(value="/index.action", method={RequestMethod.GET}) 
	public String index(HttpSession session) {
		
		// ID가 "hongkd" 인 홍길동으로 로그인 했다라고 간주한다.
		session.setAttribute("loginuser", "hongkd");
		return "index";
	}
	
	
	// 나의포인트페이지 요청
	@RequestMapping(value="/mypoint.action", method={RequestMethod.GET}) 
	public String mypoint(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String loginid = (String)session.getAttribute("loginuser");
		
		// Service단에 요청
		int point = service.getLoginUserPoint(loginid);
		
		req.setAttribute("point", point);
		
		return "mypoint";
	}
	
	
	// transaction 처리가 없는 글쓰기 페이지 요청
	@RequestMapping(value="/add_notransaction.action", method={RequestMethod.GET}) 
	public String add_notransaction() {
		
		return "add_notransaction";
	}
	
	
	// transaction 처리가 없는 글쓰기 완료 요청
	@RequestMapping(value="/addEnd_notransaction.action", method={RequestMethod.POST}) 
	public String addEnd_notransaction(NoticeVO ntvo, HttpServletRequest req) {
		
		ntvo.setContent(ntvo.getContent().replaceAll("\r\n", "<br/>")); 
		
		// Service 단에 요청
		int result = service.addEnd_notransaction(ntvo);
		
		req.setAttribute("result", result);
		
		return "addEnd_notransaction";
	}
	
	/*
	  @ExceptionHandler 에 대해서...
	  ==> 어떤 컨트롤러내에서 발생하는 익셉션이 있을시 익셉션 처리를 해주려고 한다면
	      @ExceptionHandler 어노테이션을 적용한 메소드를 구현해주면 된다.
	      
	    컨트롤러내에서 @ExceptionHandler 어노테이션을 적용한 메소드가 존재하면,
	    스프링은 익셉션 발생시 @ExceptionHandler 어노테이션을 적용한 메소드가 처리해준다.     
	 */
	@ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
	public String hadleSQLIntegrityConstraintViolationException(java.sql.SQLIntegrityConstraintViolationException e, HttpServletRequest req) {  
		String msg = "";
		
		switch (e.getErrorCode()) {
			case 2290:
				msg = "포인트가 최대치가 되어서 글쓰기가 취소되었습니다.";
				break;
	
			default:
				msg = "SQL오류발생 >>오류번호: " + e.getErrorCode();
				break;
		}
		
		String loc = "/trantestanno/index.action";
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		return "msg";
	}
	
	
	// transaction 처리가 있는 글쓰기 페이지 요청
	@RequestMapping(value="/add_transaction.action", method={RequestMethod.GET}) 
	public String add_transaction() {
		
		return "add_transaction";
	}
	
	
	// transaction 처리가 있는 글쓰기 완료 요청
	@RequestMapping(value="/addEnd_transaction.action", method={RequestMethod.POST}) 
	public String addEnd_transaction(NoticeVO ntvo, HttpServletRequest req)
	    throws Throwable {
		
		ntvo.setContent(ntvo.getContent().replaceAll("\r\n", "<br/>")); 
		
		// Service 단에 요청
		int result = service.addEnd_transaction(ntvo);
		
		req.setAttribute("result", result);
		
		return "addEnd_transaction";
	}
	
	
	// 글목록보기 페이지 요청
	@RequestMapping(value="/list.action", method={RequestMethod.GET}) 
	public String list(HttpServletRequest req) {
		
		List<HashMap<String,String>> list = service.list();
		
		req.setAttribute("list", list);
		
		return "list";
	}
	
	
}


