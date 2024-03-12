package com.example.demo.service;

import com.example.demo.dto.TaskManagerDto;
import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.Response;

public interface TaskManagerService {

	Response<Object> createTask(TaskManagerDto taskManagerDto);

	Response<Object> updateTask(TaskManagerDto taskManagerDto, Integer taskId);

	Response<Object> getTaskByTaskId(Integer taskId);

	Response<Object> getAllTasks();

	Response<Object> deleteTask(Integer taskId);

	Response<Object> userRegistration(UserRegistrationDto userRegistrationDto);

	Response<Object> login(UserRegistrationDto userRegistrationDto);

	Response<Object> getTaskByUserId(Integer userId);

	Response<Object> getAllSharedTasksByUserId(Integer userId);

}
