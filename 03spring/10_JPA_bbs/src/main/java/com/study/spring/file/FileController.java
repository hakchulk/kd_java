package com.study.spring.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FileController {

	@Autowired
	FileService fileService;

	@Value("${file.upload-dir}")
	String fileDir;

	@PostMapping("/api/upload")
	public ResponseEntity<Object> fileUpload(@ModelAttribute TestDto req) throws IllegalStateException, IOException {

		fileService.fileCreate(req);
		return ResponseEntity.ok("SUCCESS");

		// 리턴으로 업로드 된 파일을 body 로 보낸다.
//		return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/png"))
//				.body(req.getFileUpload().getBytes());
	}

	@GetMapping("/api/image/{filename}")
	public ResponseEntity<Object> getImage(@PathVariable("filename") String filename) throws IOException {
		Resource resource = fileService.getFile(filename);
		String contentType = Files.probeContentType(Paths.get(fileDir + "/" + filename));
		log.info("----fileUpload() contentType : " + contentType);

//		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);
	}
}
