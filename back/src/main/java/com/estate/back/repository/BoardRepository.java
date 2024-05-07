package com.estate.back.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estate.back.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

			List<BoardEntity> findByOrderByReceptionNumberDesc();
			// # Contains / Containing / IsContaining = LIKE '%word%'
			// # StartingWith => LIKE 'word%'
			// # EndingWith => LIKE '%word'
			List<BoardEntity> findByTitleContainsOrderByReceptionNumberDesc(String title);
			BoardEntity findByReceptionNumber(Integer receptionNumber);
}
