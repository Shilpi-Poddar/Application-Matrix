package com.applicationmatrix;

	import java.io.File;
	import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
	import java.io.PrintWriter;
import java.util.ArrayList;

//import java.util.Map;
    //import java.util.HashMap;
    import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.applicationmatrixbean.FederationBean;
import com.applicationmatrixbean.ReverseProxyBean;
import com.applicationmatrixdao.FederationDao;
import com.applicationmatrixdao.ReverseProxyDao;


	public class ApplicationServlet {
		String search;
		String type;
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		ArrayList<FederationBean> matrixList = new ArrayList<FederationBean>();
		ArrayList<ReverseProxyBean> matrixList1 = new ArrayList<ReverseProxyBean>();
		ArrayList<String> headerList = new ArrayList<String>();
		ArrayList<String> header = new ArrayList<String>();
		FederationDao matrixDao = new FederationDao();
		ReverseProxyDao reverseDao = new ReverseProxyDao();
		
		public ArrayList<FederationBean> getMatrixList() {
			return matrixList;
		}

		public void setMatrixList(ArrayList<FederationBean> matrixList) {
			this.matrixList = matrixList;
		}
		
		public ArrayList<String> getHeaderList() {
			return headerList;
		}

		public void setHeaderList(ArrayList<String> headerList) {
			this.headerList = headerList;
		}

		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}

	

		public ArrayList<String> getHeader() {
			return header;
		}

		public void setHeader(ArrayList<String> header) {
			this.header = header;
		}

		public String execute() throws IOException{
			
			
			switch(type) {
			
			case "0":headerList = matrixDao.getHeader(0);			
			         matrixList = matrixDao.inputOutput(search.trim());
			         return "success";
				     
			case "1":headerList = matrixDao.getHeader(1);
				     matrixList1 = reverseDao.inputOutput(search.trim());
				     return "success1";
				     
			case "2":System.out.println("no output");
			
			case "3":headerList = matrixDao.getHeader(0);
			         matrixList = matrixDao.inputOutput(search.trim());
			         header = matrixDao.getHeader(1);
				     matrixList1 = reverseDao.inputOutput(search.trim());
				     return "success";
				
			}
			return "error";
							
			
			
		}

		public ArrayList<ReverseProxyBean> getMatrixList1() {
			return matrixList1;
		}

		public void setMatrixList1(ArrayList<ReverseProxyBean> matrixList1) {
			this.matrixList1 = matrixList1;
		}
		

	}
