package com.example.empApi.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.empApi.models.Emp;

@Service
public class EmpService {
	HashMap<Integer, Emp>data=new HashMap<>();
	AtomicInteger atomicInteger=new AtomicInteger();
	
	public Emp create(Emp emp) {
		emp.setId(atomicInteger.incrementAndGet());
		this.data.put(emp.getId(), emp);
		return emp;
	}
	
	public Collection<Emp>getAll(){
		return this.data.values();	
	}
	
	public Emp getById(Integer id) {
		return this.data.get(id);
	}
	
	public Emp update(Integer id,Emp emp) {
		emp.setId(id);
		this.data.put(emp.getId(), emp);
		return emp;
	}
	
	public Emp delete(Integer id) {
		Emp emp=getById(id);
		this.data.remove(id);
		return emp;
	}
	
	
}
