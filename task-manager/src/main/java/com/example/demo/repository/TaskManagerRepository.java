package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tasks;

@Repository
public interface TaskManagerRepository extends JpaRepository<Tasks, Integer> {

	@Query("select new map(taskId as taskId,taskName as taskName , activeFlag as activeFlag, dueDate as dueDate) from Tasks where activeFlag='Active'")
	List<?> findAllActive();

	@Query("select new map(t.taskId as taskId,t.taskName as taskName , t.activeFlag as activeFlag, t.dueDate as dueDate,t.userId as userId, t.collaboratorEmail as collaboratorEmail) "
			+ "from Tasks t left join UserRegistration ur on ur.emailAddress = t.collaboratorEmail "
			+ "where t.activeFlag='Active' and t.userId=?1 ")
	List<?> findAllActiveByUserId(Integer userId);

	@Query("select new map(t.taskId as taskId,t.taskName as taskName , t.activeFlag as activeFlag, t.dueDate as dueDate,ur.userId as userId, ur.emailAddress as emailAddress) "
			+ "from UserRegistration ur inner join Tasks t on ur.emailAddress = t.collaboratorEmail "
			+ "where t.activeFlag='Active' and ur.userId=?1 ")
	List<?> getAllSharedTasksByUserId(Integer userId);

}
