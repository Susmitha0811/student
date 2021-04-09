package com.stdmngmt.std.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stdmngmt.std.entity.Student;
@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer>{

}
