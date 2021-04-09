package com.stdmngmt.std.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stdmngmt.std.entity.Student;
import com.stdmngmt.std.repo.IStudentRepo;
import com.stdmngmt.std.service.IStudentService;
@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentRepo stdRepo;
	
	@Autowired
	private IStudentService stdService;
	@Override
	public void saveStudent(Student student) {	
		stdRepo.save(student);
	}
	@Override
	public List<Student> getAll() {
		return stdRepo.findAll();
	}
	@Override
	public Student getById(Integer id) {
		Optional<Student> op=stdRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
}
