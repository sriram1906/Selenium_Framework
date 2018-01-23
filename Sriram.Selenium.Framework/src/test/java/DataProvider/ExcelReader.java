package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;

import Keywords.Keywords;

public class ExcelReader {
	File src;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	FirefoxDriver driver;
	//Keywords d;
	//Class classObj;
	
	/*File src;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	FirefoxDriver driver;*/
	
	public ExcelReader() throws IOException
	{
		src = new File("./Testdata/Testcases.xlsx");
		 fis = new FileInputStream(src);
		
		 wb = new XSSFWorkbook(fis);
		 sheet1 = wb.getSheet("Sheet1");
	}
	
	public void ReadTestdata() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		
		Keywords d = new Keywords();
		Class classObj = d.getClass();
		Method[] m1 = classObj.getMethods();
		
		
		//Class[] parameterTypes = m1[0].getParameterTypes();
		int j = 2;
		for (int i=1;i<=sheet1.getLastRowNum();i++)
		{
			//for (int j=0;j<=sheet1.getRow(i).getLastCellNum() - 1;j++)
			//{
				if (sheet1.getRow(i).getCell(j)==null)
				{
					System.out.println("Null");
				}
				else if (sheet1.getRow(i).getCell(j).getCellType()==Cell.CELL_TYPE_STRING)
				{
					//System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue());
					String action = sheet1.getRow(i).getCell(2).getStringCellValue();
					for (int b=0; b <= m1.length - 1;b++)
					{
						if (m1[b].getName().equals(action))
						{
						
							Class[] parameterTypes = m1[b].getParameterTypes();
							Method gs1Method = classObj.getMethod(action, parameterTypes);
							gs1Method.invoke(d,new Object[] {sheet1.getRow(i).getCell(3).getStringCellValue(),sheet1.getRow(i).getCell(4).getStringCellValue()} );
						}
					}
					
					//else
					//{
						//System.out.println("no");
					//}
					//Method gs1Method = classObj.getMethod(action, new Class[] {String.class,String.class});
					
					
					//classObj.g
					
					//System.out.println(gs1Method.getName());
					
					//gs1Method.i
				}
				else if (sheet1.getRow(i).getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					System.out.println(sheet1.getRow(i).getCell(j).getRawValue());
				}
			//}

		}
	}

}
