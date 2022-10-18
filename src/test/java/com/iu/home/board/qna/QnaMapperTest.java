package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private QnaVO qnaVO;


//------------------------------------------------------------	
	
	//@Test
	void test() throws Exception {
		List<QnaVO> ar = qnaMapper.getList(null);
		log.info("List : "+ar);
		assertNotEquals(0, ar.size());
	}

	//@Test
	void Test2 () {
		log.info("TEST2");
		//qnaMapper.setDelete(qnaVO);
		//qnaMapper.setUpdate(qnaVO);
	}
	
	//@Test
	void setAddTest () throws Exception {
		for (int i=3; i<100; i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("Title"+i);
			qnaVO.setWriter("Writer"+i);
			qnaVO.setContents("Contents"+i);
			
			int result = qnaMapper.setAdd(qnaVO);
			
			if (i%10==0) {
				Thread.sleep(500);
			}
		}
		log.info("Finish");
	}

//------------------------------------------------------------	

	//모든 테스트 메서드 시작 전
	@BeforeAll
	static void before () {
		System.out.println("BEFORE TEST");
		//static 에서는 변수 선언된 log 사용 못함
		//log.info("BEFORE TEST");
	}
	
	//각각의 메서드 시작 전 반복
	@BeforeEach
	void beforeEach () {
		System.out.println("TEST METHOD BEFORE");
		qnaVO = new QnaVO();
		qnaVO.setNum(1L);
		qnaVO.setContents("contents");
	}
	
//------------------------------------------------------------	
	
	//모든 테스트가 끝난 후
	@AfterAll
	static void after () {
		System.out.println("AFTER TEST");
		//log.info("AFTER TEST");
	}
	
	//각각의 메서드가 실행된 후 반복
	@AfterEach
	void afterEach () {
		System.out.println("AFTER EACH");
	}
	
	
}
