package com.study.spring.member.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "memberRoleList")
public class Member {
	@Id
	private String email;
	private String pw;
	private String nickname;
	private boolean social;

	@ElementCollection(fetch = FetchType.LAZY) // 엔티티(Entity)가 아닌 단순한 값들을 리스트나 셋으로 관리하고 싶을 때
	@Builder.Default
	private List<MemberRole> memberRoleList = new ArrayList<>();

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@PrePersist
	public void onCreated() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = this.createdAt;
	}

	@PreUpdate
	public void onUpdatedd() {
		this.updatedAt = LocalDateTime.now();
	}

	public void addRole(MemberRole memberRole) {
		memberRoleList.add(memberRole);
	}

	public void clearRole() {
		memberRoleList.clear();
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setSocial(boolean social) {
		this.social = social;
	}
}
