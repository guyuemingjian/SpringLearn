package com.hu.LearnSpringBoot.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@Value("${test.file}")
	private String filePath;

	@GetMapping("/initFile")
	public String initFile() {
		return "upload";
	}
	
	@PostMapping("/singleFileUpload")
	@ResponseBody
	public String singleFileUpload(@RequestParam("file") MultipartFile file) {
		
		try {
			byte[] bytes=file.getBytes();
			//本地存储
			Path path=Paths.get(filePath+file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "upload end";		
	}
	
	@PostMapping("/multiFileUpload")
	@ResponseBody
	public String multiFileUpload(@RequestParam("file") MultipartFile[] files) {
		
		try {
			for(MultipartFile file:files) {
				byte[] bytes=file.getBytes();
				//本地存储
				Path path=Paths.get(filePath+file.getOriginalFilename());
				Files.write(path, bytes);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "upload end";		
	}
}
