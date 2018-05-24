package com.hexgen.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hexgen.model.Customer;
import com.hexgen.model.FileUploadForm;
import com.hexgen.services.CustomerService;



@Controller
public class FileUploadController {
	
	@Autowired 
	private CustomerService customerService;
	
	@RequestMapping(value="FileUpload.htm",method=RequestMethod.GET)
	public ModelAndView showFileUpload(){
		ModelAndView mav=new ModelAndView("fileupload");
		mav.addObject("FileUploadForm", new FileUploadForm());
		return mav;
	}
	
	@RequestMapping(value="/processUploadFile.htm",method=RequestMethod.POST)
	public ModelAndView processFileUpload(@RequestParam MultipartFile file,HttpSession session){
		ModelAndView mav=new ModelAndView("fileuploadsucess");
		  try {
			XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = wb.getSheetAt(0);
			int x=1;
			XSSFCell cell;
			int maxcount=0;
			
			Map<Integer, Customer> custMap=new HashMap<>();
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()){
				Customer customer=new Customer();
				int i=0;
				 int j=0;
				Row rows = rowIterator.next();
				if(rows.getRowNum()==0){
					maxcount=rows.getLastCellNum();
					continue;
				}
				
				 Iterator<Cell> cellIterator = rows.cellIterator();
				 while(cellIterator.hasNext()){
					 
					 Cell cel = cellIterator.next();
					 
					 switch(cel.getCellType()){
					 case Cell.CELL_TYPE_NUMERIC:
						 System.out.print(cel.getNumericCellValue() + "\t");
						 if(i==0){
							 
		                        customer.setCustId((int) cel.getNumericCellValue()); 
		                        i=i+1;
		                        break;
						 }
						 if(i==1){
							 customer.setAge((int)cel.getNumericCellValue());
							 i=i+1;
							 break;
						 }
						 if(i==2){
							 customer.setDate(cel.getDateCellValue());
							 i=i+1;
							 break;
						 }
	                      break;  
	                      
					 case Cell.CELL_TYPE_STRING:
						 System.out.print(cel.getStringCellValue() + "\t");
						 if(j==0){
							 customer.setName(cel.getStringCellValue());	
							 j=j+1;
							 break;
						 }
						
						 if(j==1){
							 customer.setMonth(cel.getStringCellValue());
							 break;
						 }
					 }
				 }
				 
				 custMap.put(x, customer);
				 x=x+1;
			}
			
			List<Customer> customerList=  new ArrayList<Customer>();
	        for (Customer customernew : custMap.values()) {
	        	customerList.add(customernew);

	        }
	        customerService.saveCustomerDetails(customerList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mav;
	}

}
