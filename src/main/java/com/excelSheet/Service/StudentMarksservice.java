package com.excelSheet.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excelSheet.Entity.StudentMarks;
import com.excelSheet.Repository.StudentMarksRepo;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class StudentMarksservice {
	@Autowired
	private StudentMarksRepo studentmarksrepository;
	
//	@Autowired
//	private ExcelSheetUpload excelsheet;

	public void saveStudentMarkstoDatabase(MultipartFile file) {
		
		if (ExcelSheetUpload.isValidFile(file)) {
			InputStream inputStream=null;
			
			try {
				inputStream =file.getInputStream();
				List<StudentMarks> student = ExcelSheetUpload.getStudentData(inputStream);
				this.studentmarksrepository.saveAll(student);
			} catch (IOException e) {
				throw new IllegalArgumentException("this fileis not valid excel file");
			}
			finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public List<StudentMarks> getStudentData() {
		return studentmarksrepository.findAll();

	}
}


