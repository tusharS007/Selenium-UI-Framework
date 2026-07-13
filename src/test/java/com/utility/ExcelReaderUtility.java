package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> excelReader(String fileName) {

		File file = new File(System.getProperty("user.dir") + "//testData//"+fileName);

		XSSFWorkbook workbook = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailCell;
		Cell pwdCell;
		User user;
		List<User> userList = null;
		try {
			workbook = new XSSFWorkbook(file);
			xssfSheet = workbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();
			userList = new ArrayList<User>();

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailCell = row.getCell(0);
				pwdCell = row.getCell(1);
				user = new User(emailCell.toString(), pwdCell.toString());
				userList.add(user);
			}
			workbook.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
	}

}
