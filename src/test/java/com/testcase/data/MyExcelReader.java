package com.testcase.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExcelReader {

	public static String xlfile= ".\\Data\\sampledoc.xlsx";
	
	public static void main(String[] args) throws IOException {
		
		// 1. Create File input stream and put the xlsx file in it
		FileInputStream fs = new FileInputStream(xlfile);
		
		// 2. Create XSSFWork book object 
		XSSFWorkbook bk = new XSSFWorkbook(fs);
		
		// 3. Get the sheet form the workbook
        XSSFSheet sht = bk.getSheet("Sheet1");
        
        /* 4. Now get the Rows and columns 
               Get the number of Rows and columns */
        
      //This will return the last row no(no. of rows)
        int rows = sht.getLastRowNum();

        //To get the Number of cells in the rows 
        //in 1st row how many cells we have
        int cols = sht.getRow(1).getLastCellNum();
        
        //Two loop statement to read the data

        //Outer For loop will represent the row 

        //Represents the row
        /*for(int r=0;r<=rows;r++){

           //Get first row from the sheet and read all the cells
           XSSFRow row=sht.getRow(r);     

             //Inner loop will represent the cells
             for(int c=0;c<cols;c++)
                    {
            	 //Get the cell data/Object
                   XSSFCell cell = row.getCell(c); 
                   //This will  the type of data present in the cell
                   //will put in the switch statment 
                   switch(cell.getCellType()) {
                   case STRING : System.out.print(cell.getStringCellValue());
                   break;
                   case NUMERIC : System.out.print(cell.getNumericCellValue());
                   break;
                   case BOOLEAN : System.out.print(cell.getBooleanCellValue());
                   break;
                   
                   }
                   //Put space between the rows
                   System.out.print(" | ");
                    }
             //This is used to print the rows in the next line
             System.out.println();

        }*/
        //Read Data from the Excel using Iterator
        //Create Iterator boject and store it
        
        Iterator itsht = sht.iterator();
        //In while loop we check if there is another record or not !
        while(itsht.hasNext()) 
        {
        	//Capture the value > this will return the first row and stor ein vairable
        	XSSFRow row =(XSSFRow) itsht.next();
        	//Capture all the cells 
        	Iterator<Cell> cellIt = row.cellIterator();
        	//By  using the cellIt we can read all the cells
        	
        	while(cellIt.hasNext()) {
        		XSSFCell cell=(XSSFCell)cellIt.next();
        		   switch(cell.getCellType()) {
                   case STRING : System.out.print(cell.getStringCellValue());
                   break;
                   case NUMERIC : System.out.print(cell.getNumericCellValue());
                   break;
                   case BOOLEAN : System.out.print(cell.getBooleanCellValue());
                   break;
                   
                   }
        		System.out.print(" | ");
        	}
        	System.out.println();
        }
        
        

        
        
        
	}

}
