package com.excelSheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelSheet.Entity.StudentMarks;

public interface StudentMarksRepo  extends JpaRepository<StudentMarks, Integer>{

}
