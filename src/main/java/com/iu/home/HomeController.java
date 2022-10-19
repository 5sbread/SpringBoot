package com.iu.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaMapper;
import com.iu.home.board.qna.QnaVO;


@Controller
public class HomeController {
	
	@Value("${my.message.hi}")
	private String message;
	
	//org.slf4j
	//private final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaMapper qnaMapper;

//-------------------------------------------
	
	@GetMapping("/")
	// @ResponseBody
	public String home () throws Exception {
		//System.out.println("Message : "+message);
		log.error("Error Message");
		log.warn("Warn Message");
		log.info("Info Message");
		log.debug("Debug Message");
		log.trace("Trace Message");
		
		List<QnaVO> ar = qnaMapper.getList(null);
					//{}안에 ar | size 넣기
		log.info("List : {} | size {}", ar, ar.size());
		
		return "index";
	}

//-------------------------------------------	

}	