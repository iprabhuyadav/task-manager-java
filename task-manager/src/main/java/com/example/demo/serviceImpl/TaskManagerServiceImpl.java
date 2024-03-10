package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TaskManagerDto;
import com.example.demo.entity.Response;
import com.example.demo.entity.TaskManager;
import com.example.demo.repository.TaskManagerRepository;
import com.example.demo.service.TaskManagerService;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {
	
	@Autowired
	TaskManagerRepository taskManagerRepository;

	@Override
	public Response<Object> createTask(TaskManagerDto taskManagerDto) {
		
		TaskManager taskManager = new TaskManager();
		taskManager.setTaskName(taskManagerDto.getTaskName());
		taskManager.setDueDate(taskManagerDto.getDueDate());
		taskManager.setActiveFlag("Active");
		
		taskManagerRepository.save(taskManager);
		
		return new Response<>(200, "Task Created Successfully");
	
	}

	@Override
	public Response<Object> updateTask(TaskManagerDto taskManagerDto, Integer taskId) {
		
		Optional<TaskManager> existingTask = taskManagerRepository.findById(taskId);

		if (existingTask.isPresent()) 
		{
		    TaskManager taskManager = existingTask.get();
		    taskManager.setTaskName(taskManagerDto.getTaskName());
		    taskManager.setActiveFlag("Active");
		    
		    taskManagerRepository.save(taskManager);
		    
		    return new Response<>(200, "Task Updated Successfully");
		} 
		else 
		{
		    return new Response<>(205, "Task Not Found");
		}
		
	}

	@Override
	public Response<Object> getTaskByTaskId(Integer taskId) {
		Optional<TaskManager> existingTask = taskManagerRepository.findById(taskId);

		if (existingTask.isPresent()) 
		{
		    TaskManager taskManager = existingTask.get();
		 
		    return new Response<>(200, "Task Fetch Successfully",taskManager);
		} 
		else 
		{
		    return new Response<>(205, "Task Not Found");
		}
	}

	@Override
	public Response<Object> getAllTasks() {

		List<TaskManager> existingTask = taskManagerRepository.findAll();

		if (existingTask.isEmpty()) 
		{
		    return new Response<>(205, "Task List Not Found");		
		} 
		else 
		{
		    return new Response<>(200, "Tasks List Fetched Successfully",existingTask);	
		}
		
	}

	@Override
	public Response<Object> deleteTask(Integer taskId) {
		Optional<TaskManager> existingTask = taskManagerRepository.findById(taskId);

		if (existingTask.isPresent()) 
		{
		    TaskManager taskManager = existingTask.get();
		    taskManager.setActiveFlag("Deactive");
		    
		    taskManagerRepository.save(taskManager);
		    
		    return new Response<>(200, "Task Deleted Successfully",taskManager);
		} 
		else 
		{
		    return new Response<>(205, "Task Not Found");
		}
	}

}
