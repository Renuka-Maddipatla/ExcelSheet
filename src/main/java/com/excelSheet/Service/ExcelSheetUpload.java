package com.excelSheet.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;



import org.springframework.web.multipart.MultipartFile;

import com.excelSheet.Entity.StudentMarks;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelSheetUpload {
	
	public static boolean isValidFile(MultipartFile file) {
		return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );
	}
	public static List<StudentMarks> getStudentData(InputStream inputStream){
		List<StudentMarks>student = new ArrayList<StudentMarks>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet("student");
			
			int rowIndex = 0;
			for (Row row : sheet) {
				if (rowIndex == 0) {
					rowIndex++;
					continue;
				}
		
		Iterator <Cell> cellIterator = row.iterator();
		int cellIndex = 0;
		StudentMarks students = new StudentMarks();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			switch(cellIndex) {
			case 0 : students.setId((int)cell.getNumericCellValue());		
			case 1 : students.setStudent_Name((String)cell.getStringCellValue());
			case 2 : students.setStudent_Subject((String)cell.getStringCellValue());
			case 3 : students.setStudent_Marks((int)cell.getNumericCellValue());
			default : {
			}
			cellIndex++;
		}
			
		}
		student.add(students);
			}
		}
				
		catch (IOException e) {
				System.out.println(e.getMessage());
				e.getStackTrace();
			}
		return student;
		
	}
	
	}

