package com.excelSheet.Controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excelSheet.Entity.StudentMarks;
import com.excelSheet.Service.StudentMarksservice;

import lombok.AllArgsConstructor;

@RequestMapping("StudentMarks")
@AllArgsConstructor
@RestController
public class StudentMarksController {
	
	//@Autowired
   private StudentMarksservice Studentservice;

	@PostMapping("/api")
	public  ResponseEntity<?> uploadStudentMarksData(@RequestParam("file") MultipartFile file){
		this.Studentservice.saveStudentMarkstoDatabase(file);
		return  ResponseEntity.ok(Map.of("Message" , "student data saved to database successfully"));
				
	}
	@GetMapping("/StudentData")
	public ResponseEntity<List<StudentMarks>> getStudentMarks(){
		return new ResponseEntity<>(Studentservice.getStudentData(),HttpStatus.FOUND);
	} 

	
}
	 
