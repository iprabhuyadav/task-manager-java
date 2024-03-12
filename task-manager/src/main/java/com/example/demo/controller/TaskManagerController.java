package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TaskManagerDto;
import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.Response;
import com.example.demo.service.TaskManagerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskManagerController {

	@Autowired
	TaskManagerService taskManagerService;

	// API to create task

	@PostMapping(value = "/createTask")
	public @ResponseBody Response<Object> createTask(@RequestBody TaskManagerDto taskManagerDto) {
		return taskManagerService.createTask(taskManagerDto);
	}

	// API to update task

	@PutMapping(value = "/updateTask/{taskId}")
	public @ResponseBody Response<Object> updateTask(@RequestBody TaskManagerDto taskManagerDto,
			@PathVariable("taskId") Integer taskId) {
		return taskManagerService.updateTask(taskManagerDto, taskId);
	}

	// API to view task by task id

	@GetMapping(value = "/getTask/{taskId}")
	public @ResponseBody Response<Object> getTaskByTaskId(@PathVariable("taskId") Integer taskId) {
		return taskManagerService.getTaskByTaskId(taskId);
	}

	// API to view task all tasks

	@GetMapping(value = "/getAllTasks")
	public @ResponseBody Response<Object> getAllTasks() {
		return taskManagerService.getAllTasks();
	}

	// API to view task all tasks by userId

	@GetMapping(value = "/getAllTasks/{userId}")
	public @ResponseBody Response<Object> getTaskByUserId(@PathVariable("userId") Integer userId) {
		return taskManagerService.getTaskByUserId(userId);
	}

	// API to delete task

	@DeleteMapping(value = "/deleteTask/{taskId}")
	public @ResponseBody Response<Object> deleteTask(@PathVariable("taskId") Integer taskId) {
		return taskManagerService.deleteTask(taskId);
	}

	// API for user-registration

	@PostMapping(value = "/userRegistration")
	public @ResponseBody Response<Object> userRegistration(@RequestBody UserRegistrationDto userRegistrationDto) {
		return taskManagerService.userRegistration(userRegistrationDto);
	}

	// API for user-login

	@PostMapping(value = "/login")
	public @ResponseBody Response<Object> login(@RequestBody UserRegistrationDto userRegistrationDto) {
		return taskManagerService.login(userRegistrationDto);
	}
	
	// API to view task all shared tasks by userId

	@GetMapping(value = "/getAllSharedTasks/{userId}")
	public @ResponseBody Response<Object> getAllSharedTasksByUserId(@PathVariable("userId") Integer userId) {
		return taskManagerService.getAllSharedTasksByUserId(userId);
	}

}
