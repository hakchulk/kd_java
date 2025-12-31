package com.study.spring.board.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.study.spring.member.entity.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor // default Constructor
@AllArgsConstructor
@Builder
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String name; // 추후 Member 사용
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	private LocalDateTime createdAt;

	@Builder.Default // new ArrayList<>()가 효과를 볼수 있도록. If you want the initializing expression to
						// serve as default.
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Image> images = new ArrayList<>();

	@PrePersist
	public void onCreated() {
		this.createdAt = LocalDateTime.now();
	}

}
