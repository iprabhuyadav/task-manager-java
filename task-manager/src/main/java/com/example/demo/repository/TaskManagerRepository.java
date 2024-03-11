package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tasks;

@Repository
public interface TaskManagerRepository extends JpaRepository<Tasks, Integer> {

	@Query("select new map(taskId as taskId,taskName as taskName , activeFlag as activeFlag, dueDate as dueDate) from Tasks where activeFlag='Active' ")
	List<?> findAllActive();

}
