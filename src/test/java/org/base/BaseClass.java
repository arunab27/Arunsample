package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Select s;
	public static Select r;

	public static void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void launchurl(String url) {
		driver.get(url);
	}

	public static void maxwindow() {
		driver.manage().window().maximize();
	}

	public static void towait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void filltextbox(WebElement e, String val) {
		e.sendKeys(val);
	}

	public static void clk(WebElement e) {
		e.click();
	}

	public static void Select(WebElement e, String val) {
		s = new Select(e);
		s.selectByValue(val);
	}

//	public static void selectInd(WebElement e, int val) {
//		r = new Select(e);
//		r.selectByIndex(val);
//	}

	public static String readexcel(int rowno, int cellno) throws IOException {
		File fil = new File("C:\\Users\\kanag\\eclipse-workspace\\PojoTask\\Excel\\Book1.xlsx");
		FileInputStream fin = new FileInputStream(fil);
		XSSFWorkbook book = new XSSFWorkbook(fin);
		XSSFSheet sh1 = book.getSheet("Sheet1");
		XSSFRow row = sh1.getRow(rowno);
		XSSFCell cell = row.getCell(cellno);
		// type
		int type = cell.getCellType();
		String name = "";

		if (type == 1) {
			name = cell.getStringCellValue();
		} else {
			double d = cell.getNumericCellValue();
			long l = (long) d;// down casting
			name = String.valueOf(l);
		}

		return name;

	}

	public static String gettext(WebElement e) {
		String t = e.getAttribute("value");
		return t;
	}

	public static void Screenshot(String name) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File s1 = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\kanag\\eclipse-workspace\\PojoTask\\ScreenShot\\" + name + ".png\\");
		FileUtils.copyDirectory(s1, dest);

	}

	@SuppressWarnings("resource")
	public static String getname() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the3 filename");
		String name = sc.next();
		return name;

	}

}
