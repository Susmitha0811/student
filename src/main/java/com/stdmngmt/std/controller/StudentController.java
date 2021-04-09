package com.stdmngmt.std.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stdmngmt.std.entity.Student;
import com.stdmngmt.std.service.IStudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private IStudentService stdService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		stdService.saveStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> list=stdService.getAll();
		return ResponseEntity.ok(list);
	}
	@GetMapping("/byId/{id}")
	public ResponseEntity<Student> getById(@PathVariable Integer id){
		Student std=stdService.getById(id);
		return ResponseEntity.ok(std);
	}
	@GetMapping("/getEvenId")
	public ResponseEntity<List<Student>> getEvenId(){
		return ResponseEntity.ok(stdService.getAll().stream().filter(s->s.getId()%2==0).collect(Collectors.toList()));
	}
	@GetMapping("/getNames")
	public ResponseEntity<List<String>> getNames(){
		return ResponseEntity.ok(stdService.getAll().stream().map(m->m.getName()).collect(Collectors.toList()));
	}
	public boolean nullCheck(Student std) {
		boolean b=false;
		if(Objects.nonNull(std) && std.getId()!=null && std.getId()%2==0) {
			b=true;
		}
		return b;
	}
	@GetMapping("/evenId")
	public ResponseEntity<List<Student>> getEven(){
		return ResponseEntity.ok(stdService.getAll().stream().filter(s->nullCheck(s)).collect(Collectors.toList()));
	}
}
