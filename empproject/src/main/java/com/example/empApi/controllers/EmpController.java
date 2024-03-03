package com.example.empApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.empApi.models.Emp;
import com.example.empApi.services.EmpService;
import com.example.empApi.wrappers.ResponseWrapper1;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/emp")

public class EmpController {
	@Autowired
	EmpService empService;
	
	@Autowired
	ResponseWrapper1 responseWrapper1;
	
	@GetMapping("")
	public ResponseEntity<Emp> getAllEmp() {
		responseWrapper1.setMsg("Employees");
		responseWrapper1.setData(this.empService.getAll());
		return new ResponseEntity(responseWrapper1,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getEmpById(@PathVariable Integer id) {
		Emp empexit=this.empService.getById(id);
		if(empexit==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"emp with id "+id+" not found");
		}
		responseWrapper1.setMsg("emp with id "+id);
		responseWrapper1.setData(empexit);
		return new ResponseEntity(responseWrapper1,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Emp> createemp(@RequestBody @Valid Emp emp){
		responseWrapper1.setMsg("emp created successfully");
		responseWrapper1.setData(this.empService.create(emp));
		return new ResponseEntity(responseWrapper1,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Emp>updateemp(@PathVariable Integer id,@RequestBody Emp emp){
		Emp empexit=this.empService.getById(id);
		if(empexit==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"emp with id "+id+" not found");
		}
		responseWrapper1.setMsg("emp with id "+id+" updated successfully");
		responseWrapper1.setData(this.empService.update(id,emp));
		return new ResponseEntity(responseWrapper1,HttpStatus.OK);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Emp> deleteemp(@PathVariable Integer id){
		Emp empexit=this.empService.getById(id);
		if(empexit==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"emp with id " +id+" not found");
		}
		responseWrapper1.setMsg("emp with id "+id+" deleted successfully");
		responseWrapper1.setData(this.empService.delete(id));
		return new ResponseEntity(responseWrapper1,HttpStatus.OK);
	}
}
