package com.iu.home.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager {
	
	public String saveFile(MultipartFile multipartFile, String path) throws Exception{
		//1. File 객체 생성
		//File file = new File(path);
		
		//2. 중복되지 않는 파일명 생성 (UUID, Date)
		String fileName = UUID.randomUUID().toString();
		
		//3. 확장자
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		bf.append(multipartFile.getOriginalFilename());
		
		//4. File save
		File file = new File(path, bf.toString());
		
		//FileCopyUtils
		//MultipartFile
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		multipartFile.transferTo(file);
		
		return fileName;
		
	}

}
