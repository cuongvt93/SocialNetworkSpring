package com.example.demo.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Iterable<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public List<Department> search(String q) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDeptName(q);
	}

	@Override
	public Department findOne(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.getOne(id);
	}

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);
		
	}

	@Override
	public void deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
	}

}
