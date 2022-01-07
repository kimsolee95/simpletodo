package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {

	@Query("select * from Todo t where t.userId = ?1")
	List<TodoEntity> findByUserId(String userId);

}
