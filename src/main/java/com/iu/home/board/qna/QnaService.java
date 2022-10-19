package com.iu.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	
	public List<QnaVO> getList(Pager pager) throws Exception{
		Long totalCount = qnaMapper.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		return qnaMapper.getList(pager);
	}

	public int setAdd(QnaVO qnaVO, HttpSession session) throws Exception {
		
		String realpath = session.getServletContext().getRealPath("/static/upload/qna");
		log.info("RealPath : {} "+realpath);
		File file = new File(realpath);
		
		if (! file.exists()) {
			boolean check = file.mkdirs();
			log.info("Check + {}", check);
		}
		
		for (MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("FileName : {}", f.getOriginalFilename());
			}
		}
		
		int result = qnaMapper.setAdd(qnaVO);
		return 1;
	}

}
