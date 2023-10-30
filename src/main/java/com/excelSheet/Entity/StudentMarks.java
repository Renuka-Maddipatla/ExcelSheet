package com.excelSheet.Entity;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class StudentMarks {
	@Id
	 private int id;
	 
	 private String Student_Name;
	 
	 private String Student_Subject;
	 
	 private int Student_Marks;
	 
	 
	}

