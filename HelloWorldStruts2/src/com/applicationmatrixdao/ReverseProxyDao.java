package com.applicationmatrixdao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.applicationmatrixbean.ReverseProxyBean;

public class ReverseProxyDao {
	
	   ArrayList<ReverseProxyBean> matrixList = new ArrayList<ReverseProxyBean>();
	   
	public ArrayList<ReverseProxyBean> inputOutput(String search) throws IOException{
		
		search = search.toLowerCase();
		File inputFile = new File("C:\\Users\\spoddar\\Desktop\\AM\\AM_99.xlsx");
		FileInputStream inputStream = new FileInputStream(inputFile);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(1);
		int lastRow = sheet.getLastRowNum();
		XSSFRow inRow = sheet.getRow(0);
		int cellCount = inRow.getLastCellNum();
		
		for (int i=1 ; i<=lastRow ; i++)
		{
			XSSFRow row1 = sheet.getRow(i);
			if(row1 != null){
			for( int s = 0; s < cellCount; s++)
			{
				if(row1.getCell(s)!= null && row1.getCell(s).getCellType() == XSSFCell.CELL_TYPE_STRING )
				{
					String find = row1.getCell(s).getStringCellValue().toLowerCase();
					if(find.contains(search))
					{
						ReverseProxyBean bean = new ReverseProxyBean();
						 bean.setApplicationName_prod(row1.getCell(0).getStringCellValue());
						 bean.setPoc_prod(row1.getCell(1).getStringCellValue());
						 bean.setAppCode_prod(row1.getCell(2).getStringCellValue());
						 bean.setLowesLink_prod(row1.getCell(3).getStringCellValue());
						 bean.setBackendApp_prod(row1.getCell(4).getStringCellValue());
						 bean.setApplicationName_qa(row1.getCell(5).getStringCellValue());
						 bean.setPoc_qa(row1.getCell(6).getStringCellValue());
						 bean.setAppCode_qa(row1.getCell(7).getStringCellValue());
						 bean.setLowesLink_qa(row1.getCell(8).getStringCellValue());
						 bean.setBackendApp_qa(row1.getCell(9).getStringCellValue());
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

}
