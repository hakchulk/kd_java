package com.study.spring.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Service
@Slf4j
public class FileService {
	@Value("${file.upload-dir}")
	String fileDir;
	@Autowired
	FileRepository fileRepo;

	public void fileCreate(TestDto req) throws IllegalStateException, IOException {
		log.info("----fileCreate() title : " + req.getTitle());
		log.info("----fileCreate() content : " + req.getContent());
		log.info("----fileCreate() name : " + req.getName());

		FileEntity fe = new FileEntity();

		fe.setName(req.getName());
		fe.setTitle(req.getTitle());
		fe.setContent(req.getContent());

		List<MultipartFile> files = req.getFileUpload();
		if (files != null && !files.isEmpty())
			log.info("----fileCreate() files.size() : " + files.size());
		for (MultipartFile file : files) {
			if (file != null && !file.isEmpty()) {
				String originalFilename = file.getOriginalFilename();
				String newName = UUID.randomUUID() + "_" + originalFilename;
				log.info("----fileUpload() getOriginalFilename() : " + originalFilename);
				File folder = new File(fileDir);
				if (!folder.exists())
					folder.mkdir();

//			File destFile = new File(fileDir + '/' + newName);
//			file.transferTo(destFile);
				byte[] fileData = file.getBytes();

				Files.write(Paths.get(fileDir + '/' + newName), fileData); // 원본 저장
				Thumbnails.of(new ByteArrayInputStream(fileData)).size(100, 100).outputFormat("jpg")
						.toFile(fileDir + "/thumb_100_" + newName); // thumbnail 저장
				fe.setImageFileName(newName);
			}
//			fileRepo.save(fe);
		}

	}

	public Resource getFile(String filename) throws IOException {
		String path = fileDir + "/" + filename;
		File file = new File(path);
		if (!file.exists()) {
			return null;
		}

//		Path fileStorageLocation = Paths.get(fileDir).toAbsolutePath().normalize();
//		Path filePath = fileStorageLocation.resolve(filename).normalize();
		org.springframework.core.io.Resource resource = new FileSystemResource(file);

		String contentType = Files.probeContentType(file.toPath());

		log.info("----fileUpload() contentType : " + contentType);
		return resource;
	}

}
