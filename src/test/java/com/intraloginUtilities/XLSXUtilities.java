package com.intraloginUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXUtilities {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow rw;
	public static XSSFCell cl;
	
	
	public static int getRowCount(String xlfile ,String xlsheet) throws IOException {
		fi= new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		int rowcount=sh.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	public static int getCellCount(String xlfile ,String xlsheet,int rowNum) throws IOException {
		fi= new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		rw=sh.getRow(rowNum);
		int cellcount=rw.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	public static String getCellData(String xlfile,String xlsheet,int rowNum,int colNum) throws IOException
		{
		
		fi= new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		rw=sh.getRow(rowNum);
		cl=rw.getCell(colNum);
		String data;
		
		try {
			DataFormatter dataformatter= new DataFormatter();
			String cellData=dataformatter.formatCellValue(cl);
			return cellData;
			
	}
		catch(Exception e){
			
			data="";
			
		}
		wb.close();
		fi.close();
		
		return data;
		
	}
	
	public void setCellData(String xlfile,String xlsheet,int rowNum,int colNum,String data) throws IOException {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(xlsheet);
		rw=sh.getRow(rowNum);
		cl=rw.getCell(colNum);
		cl.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();
		
	}

}
