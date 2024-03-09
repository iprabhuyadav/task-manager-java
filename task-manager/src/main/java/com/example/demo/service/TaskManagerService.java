package com.example.demo.service;

import com.example.demo.dto.TaskManagerDto;
import com.example.demo.entity.Response;
import com.example.demo.entity.TaskManager;

public interface TaskManagerService {

	Response<Object> createTask(TaskManagerDto taskManagerDto);

	Response<Object> updateTask(TaskManagerDto taskManagerDto, Integer taskId);

	Response<Object> getTaskByTaskId(Integer taskId);

	Response<Object> getAllTasks();

	Response<Object> deleteTask(Integer taskId);

}
