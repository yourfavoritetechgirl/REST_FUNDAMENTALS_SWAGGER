package com.simplilearn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadDownloadController {
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	//@ResponseBody
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		
		//Write code to save it
		File savedFile = new File("c:/temp/"+file.getOriginalFilename());
		if(!savedFile.exists()) {
			savedFile.createNewFile();
		}

		FileOutputStream fos = new FileOutputStream(savedFile);
		fos.write(file.getBytes());
		fos.close();
		
		return "File uploaded successfully";
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ResponseEntity<Object>downloadFile(@RequestParam("fileName") String fileName) throws FileNotFoundException{
		
		//Write code to read file
		File downloadFie = new File("c:/temp/"+fileName);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(downloadFie));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; fileName="+fileName);
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/txt")).
		body(resource);
		
	}

}
