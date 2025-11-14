package com.study.spring.bbs;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long> {
	Optional<Bbs> findFirstById(Long id);

	List<Bbs> findAllByOrderByIdDesc();

	Page<Bbs> findAll(Pageable p);

	List<Bbs> findAllByOrderByNameDesc();

	void deleteById(Long id);

	Page<Bbs> findByTitleContaining(String title, Pageable p);

//	@Modifying
//	@Query("UPDATE posts p SET p.name = :name, p.title = :title, p.content = :content WHERE u.id = :id")
//	void update(@Param("id") Long id, @Param("name") String name, @Param("title") String title,
//			@Param("content") String content);

}
