package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TaskManagerDto;
import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.Response;
import com.example.demo.entity.Tasks;
import com.example.demo.entity.UserRegistration;
import com.example.demo.repository.TaskManagerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TaskManagerService;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	TaskManagerRepository taskManagerRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Response<Object> createTask(TaskManagerDto taskManagerDto) {

		Tasks taskManager = new Tasks();
		taskManager.setTaskName(taskManagerDto.getTaskName());
		taskManager.setDueDate(taskManagerDto.getDueDate());
		taskManager.setUserId(taskManagerDto.getUserId());
		taskManager.setCollaboratorEmail(taskManagerDto.getCollaboratorEmail());
		taskManager.setActiveFlag("Active");
		
		taskManagerRepository.save(taskManager);

		return new Response<>(200, "Task Created Successfully");
		
	}

	@Override
	public Response<Object> updateTask(TaskManagerDto taskManagerDto, Integer taskId) {

		Optional<Tasks> existingTask = taskManagerRepository.findById(taskId);

		if (existingTask.isPresent()) {
			Tasks taskManager = existingTask.get();
			taskManager.setTaskName(taskManagerDto.getTaskName());
			taskManager.setDueDate(taskManagerDto.getDueDate());
			taskManager.setCollaboratorEmail(taskManagerDto.getCollaboratorEmail());
			taskManager.setActiveFlag("Active");

			taskManagerRepository.save(taskManager);

			return new Response<>(200, "Task Updated Successfully");
		} else {
			return new Response<>(205, "Task Not Found");
		}

	}

	@Override
	public Response<Object> getTaskByTaskId(Integer taskId) {
		Optional<Tasks> existingTask = taskManagerRepository.findById(taskId);

		if (existingTask.isPresent()) {
			Tasks taskManager = existingTask.get();

			return new Response<>(200, "Task Fetch Successfully", taskManager);
		} else {
			return new Response<>(205, "Task Not Found");
		}
	}

	@Override
	public Response<Object> deleteTask(Integer taskId) {
		Optional<Tasks> existingTask = taskManagerRepository.findById(taskId);

		if (existingTask.isPresent()) {
			Tasks taskManager = existingTask.get();
			taskManager.setActiveFlag("Deactive");

			taskManagerRepository.save(taskManager);

			return new Response<>(200, "Task Deleted Successfully", taskManager);
		} else {
			return new Response<>(205, "Task Not Found");
		}
	}

	@Override
	public Response<Object> getAllTasks() {

		List<?> existingTask = taskManagerRepository.findAllActive();

		if (existingTask.isEmpty()) {
			return new Response<>(205, "Task List Not Found");
		} else {
			return new Response<>(200, "Tasks List Fetched Successfully", existingTask);
		}

	}

	@Override
	public Response<Object> userRegistration(UserRegistrationDto userRegistrationDto) {

		Optional<UserRegistration> existingUser = userRepository.findByEmail(userRegistrationDto.getEmailAddress());

		if (existingUser.isPresent()) {
			return new Response<>(205, "User Email Address Already Registered");
		}

		else {
			UserRegistration userRegistration = new UserRegistration();
			userRegistration.setUserName(userRegistrationDto.getUserName());
			userRegistration.setEmailAddress(userRegistrationDto.getEmailAddress());
			userRegistration.setPassword(userRegistrationDto.getPassword());
			userRegistration.setMobileNo(userRegistrationDto.getMobileNo());
			userRegistration.setActiveFlag("Active");

			userRepository.save(userRegistration);

			return new Response<>(200, "User Registered Successfully");
		}

	}

	@Override
	public Response<Object> login(UserRegistrationDto userRegistrationDto) {

		Optional<UserRegistration> existingUser = userRepository
				.findByEmailAndPassword(userRegistrationDto.getEmailAddress(), userRegistrationDto.getPassword());

		if (existingUser.isPresent()) {
			return new Response<>(200, "User Found", existingUser);
		}

		else {
			return new Response<>(205, "User Not Found");
		}
	}

	@Override
	public Response<Object> getTaskByUserId(Integer userId) {
		List<?> existingTask = taskManagerRepository.findAllActiveByUserId(userId);

		if (existingTask.isEmpty()) {
			return new Response<>(205, "Task List Not Found");
		} else {
			return new Response<>(200, "Tasks List Fetched Successfully", existingTask);
		}
	}

	@Override
	public Response<Object> getAllSharedTasksByUserId(Integer userId) {
		List<?> existingTask = taskManagerRepository.getAllSharedTasksByUserId(userId);

		if (existingTask.isEmpty()) {
			return new Response<>(205, "Shared Task List Not Found");
		} else {
			return new Response<>(200, "Shared Tasks List Fetched Successfully", existingTask);
		}
	}
}
