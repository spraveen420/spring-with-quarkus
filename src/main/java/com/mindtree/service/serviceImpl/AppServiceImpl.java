package com.mindtree.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Data;
import com.mindtree.repository.DataRepo;
import com.mindtree.service.AppService;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	DataRepo repo;

	public ResponseEntity<String> addUser(Data user) {
		if (repo.existsById(user.getId())) {
			return new ResponseEntity<String>("Can't able to add, user already exist", HttpStatus.CONFLICT);
		} else {
			repo.save(user);
			return new ResponseEntity<String>("User added successfully", HttpStatus.OK);
		}
	}

	public ResponseEntity<Data> getOneUser(int id) {
			return new ResponseEntity<Data>(repo.findById(id).orElse(null), HttpStatus.OK);
	}

	public ResponseEntity<List<Data>> getAllUsers() {
		return new ResponseEntity<List<Data>>(repo.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<String> deleteUser(int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return new ResponseEntity<String>("User removed successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Can't able to delete, user not exist", HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> updateUser(Data user) {
		if (repo.existsById(user.getId())) {
			repo.save(user);
			return new ResponseEntity<String>("User detail updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Can't able to update, user not exist", HttpStatus.BAD_REQUEST);
		}
	}
}
