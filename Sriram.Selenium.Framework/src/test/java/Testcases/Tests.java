package Testcases;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DataProvider.ExcelReader;

public class Tests {
	ExcelReader xls;
	//ExcelReader xls;
	@BeforeMethod
	public void setup() throws IOException
	{
		//ExcelReader xls = new ExcelReader();
	}
	
	@Test
	public void ExecuteTestcases() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		ExcelReader xls = new ExcelReader();
		xls.ReadTestdata();
	}
	

}
