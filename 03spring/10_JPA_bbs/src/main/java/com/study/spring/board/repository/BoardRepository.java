package com.study.spring.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.board.dto.BoardListDto;
import com.study.spring.board.dto.BoardListMemberDto;
import com.study.spring.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	// Board : class not table board.
	@Query("""
			select b from Board b order by b.id desc
			""")
	List<Board> findAllOrderByIdDesc();

	@Query("""
			select new com.study.spring.board.dto.BoardListDto(b.id, b.title, b.name, b.createdAt)
			from Board b order by b.id desc
			""")
	List<BoardListDto> findAllListDto();

	@Query("""
			select b from Board b where b.id = :id
			""")
	Optional<Board> findBoard(@Param("id") Long id);

//	@Query(value = "SELECT b FROM Board b",
//	           countQuery = "SELECT COUNT(b) FROM Board b")
	@Query("""
			select b from Board b order by b.id desc
			""")
	Page<Board> findAllWithPage(Pageable pageable);

//	@Query("""
//			select b from Board b order by b.id desc
//			""")
	List<Board> findAll();

	@Query("""
			select new com.study.spring.board.dto.BoardListMemberDto(
				b.id,
				b.title,
				b.content,
				m.name,
				m.email,
				b.createdAt
			)
			from Board b
			join b.member m
			order by b.id desc
			""")
	List<BoardListMemberDto> findWithMemberById();

//	left join fetch : 한번에 가져오기
//	@Query("""
//			select distinct b
//			from Board b
//			left join fetch b.images i
//			join fetch b.member m
//			order by b.id desc
//			""")
//	List<Board> findWithImage();

	// where b.member is not null 를 사용해서 에러 방지
	@EntityGraph(attributePaths = { "images" })
	@Query("""
			select b
			from Board b
			where b.member is not null
			order by b.id desc
			""")
	List<Board> findWithImage();

	@Query("""
			select distinct b
			from Board b
			left join fetch b.images i
			join fetch b.member m
			order by b.id desc
			""")
	Page<Board> findWithImagePage(Pageable pageable);

	@Query("""
			select distinct b
			from Board b
			left join fetch b.images i
			where b.id = :id
			""")
	Board findWithImageById(@Param("id") Long id);
}
