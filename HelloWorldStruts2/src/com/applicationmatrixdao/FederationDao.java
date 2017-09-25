package com.applicationmatrixdao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.applicationmatrixbean.FederationBean;

public class FederationDao {
	
	ArrayList<FederationBean> matrixList = new ArrayList<FederationBean>();
	ArrayList<String> headerList;

	public ArrayList<FederationBean> inputOutput(String search) throws IOException {
		
		search = search.toLowerCase();
		File inputFile = new File("C:\\Users\\spoddar\\Desktop\\AM\\AM_99.xlsx");
		FileInputStream inputStream = new FileInputStream(inputFile);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		XSSFRow inRow = sheet.getRow(0);
		int cellCount = inRow.getLastCellNum();
				
		for (int i=1 ; i<=lastRow ; i++)
		{		
			XSSFRow row1 = sheet.getRow(i);//another variable for rows is row1
			if(row1 != null){
			for( int s=0; s < cellCount; s++)
			{
				if(row1.getCell(s)!= null && row1.getCell(s).getCellType() == XSSFCell.CELL_TYPE_STRING )
				{
					String find = row1.getCell(s).getStringCellValue().toLowerCase();
					if(find.contains(search))
					{
						    FederationBean bean = new FederationBean();
								bean.setApplicationName(row1.getCell(0).getStringCellValue());
								bean.setVendor(row1.getCell(1).getStringCellValue());
								bean.setDescription(row1.getCell(2).getStringCellValue());
								bean.setBusinessArea(row1.getCell(3).getStringCellValue());
								bean.setSaid((int)row1.getCell(4).getNumericCellValue());
								bean.setInternal(row1.getCell(5).getStringCellValue());
								bean.setExternal(row1.getCell(6).getStringCellValue());
								bean.setApplicationOwner(row1.getCell(7).getStringCellValue());
								bean.setContactDetails(row1.getCell(8).getStringCellValue());
								bean.setRcAppLevel(row1.getCell(9).getStringCellValue());
								bean.setApplicationType(row1.getCell(10).getStringCellValue());
								bean.setApplicationStatus(row1.getCell(11).getStringCellValue());
								bean.setApm(row1.getCell(12).getStringCellValue());
								bean.setBrm(row1.getCell(13).getStringCellValue());
								bean.setToc(row1.getCell(14).getStringCellValue());
								bean.setPartnershipName_prod(row1.getCell(15).getStringCellValue());
								bean.setSpid_prod(row1.getCell(16).getStringCellValue());
								bean.setEntityName_prod(row1.getCell(17).getStringCellValue());
								bean.setAcs_prod(row1.getCell(18).getStringCellValue());
								bean.setSso_prod(row1.getCell(19).getStringCellValue());
								bean.setEncryption_prod(row1.getCell(20).getStringCellValue());
								bean.setSpid_qa(row1.getCell(21).getStringCellValue());
								bean.setEntityName_qa(row1.getCell(22).getStringCellValue());
								bean.setAcs_qa(row1.getCell(23).getStringCellValue());
								bean.setSso_qa(row1.getCell(24).getStringCellValue());
								bean.setEncryption_qa(row1.getCell(25).getStringCellValue());
								matrixList.add(bean);
					
						break;
				  }
					
				}
				
			}
				
		}
				
	}
		workbook.close();
		return matrixList;
				
	}
	public ArrayList<String> getHeader(int i) throws IOException {
		
		
		headerList = new ArrayList<String>();
		
		File inputFile = new File("C:\\Users\\spoddar\\Desktop\\AM\\AM_99.xlsx");
		FileInputStream inputStream = new FileInputStream(inputFile);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(i);
		int lastRow = sheet.getLastRowNum();
		XSSFRow inRow = sheet.getRow(0);
		XSSFCell inCell;
		int cellCount = inRow.getLastCellNum();
		
		for(int k =0 ; k < cellCount ; k++){				
			inCell = inRow.getCell(k);
			if(inCell != null){	
				
				headerList.add(inCell.getStringCellValue());
				
			}	
		}
		workbook.close();
		return headerList;
	}
}
