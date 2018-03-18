package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentService {
	Iterable<Department> findAll();
	List<Department> search(String q);
	Department findOne(Long id);
	void saveDepartment(Department department);
	void deleteDepartment(Long id);

}
