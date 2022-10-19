package com.iu.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.home.util.Pager;

@Controller
@RequestMapping("/board/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//목록
	@GetMapping(value = "list")
	public ModelAndView getList (Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<QnaVO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	
	//글쓰기
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String setAdd (HttpSession session) throws Exception{
		QnaVO qnaVO = (QnaVO)session.getAttribute("");
		return "board/write";
	}
	
	//글쓰기
	@PostMapping("write")
	public String setAdd (QnaVO qnaVO, MultipartFile [] files, RedirectAttributes redirectAttributes) throws Exception {
		int result = qnaService.setAdd(qnaVO);
		
		redirectAttributes.addAttribute("result", result);
		return "redirect:./list";
		//log.info("Result : "+result);
	}
	
	
	
	
	
	

}