package com.stdmngmt.std.service;

import java.util.List;

import com.stdmngmt.std.entity.Student;

public interface IStudentService {
	public void saveStudent(Student student);
	public List<Student> getAll();
	public Student getById(Integer id);
}
