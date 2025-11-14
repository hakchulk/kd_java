package com.study.spring.file;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "file_upload")
public class FileEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String content;
	private String name;
	private String imageFileName;
	private LocalDateTime createAt;
	private LocalDateTime upatedAt;

	@PrePersist
	public void onCreate() {
		this.createAt = LocalDateTime.now();
		this.upatedAt = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		this.upatedAt = LocalDateTime.now();
	}
}
