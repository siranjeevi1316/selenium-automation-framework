package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriver chromeBrowser() {
		
		driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver browserLaunch(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(bname.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		return driver;		
	}
	
	public static WebDriver browserLaunch2(String bname) {
		switch(bname) {
		case "chrome":
			driver=new ChromeDriver();
		case "firefox":
			driver=new FirefoxDriver();
		case "edge":
			driver=new EdgeDriver();		}
		return driver;
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void implicityWait(int a) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}
	
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static void close() {
		driver.close();
	}
	
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	
	public static String getAtt(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	
	public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	
	public static void dragAndDrop(WebElement src,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, target).perform();
	}
	
	public static void selectByIndex(WebElement e,int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement e,String value) {
		Select s = new Select(e);
		s.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement e,String text) {
		Select s = new Select(e);
		s.selectByVisibleText(text);

	}
	
	public static WebElement findElement(String loc,String value) {
		WebElement e =null;
		if(loc.equals("id")) {
			e = driver.findElement(By.id(value));
	    }
		else if(loc.equals("name")) {
			e=driver.findElement(By.name(value));
		}
		else if(loc.equals("xpath")) {
			e=driver.findElement(By.xpath(value));
		}
		return e;		
	}
	
	public static void takeScreenShot(String fileName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Java Testing Course\\Maven_Class\\" + fileName + ".png");
		FileUtils.copyFile(scr, des);
	}
	
	public static void screenShot(WebElement e,String fileName) throws IOException {
		
		File scr = e.getScreenshotAs(OutputType.FILE);
		File des = new File("E:\\Java Testing Course\\Maven_Class\\" + fileName + ".png");		
		FileUtils.copyFile(scr, des);		
	}
	
	public static void Navigatorss(String url) {
		
		Navigation n = driver.navigate();
		n.to(url);
	}
	
	public static void refresh() {
		Navigation n = driver.navigate();
		n.refresh();
	}
	
	public static void forward() {
		Navigation n = driver.navigate();
		n.forward();
	}
	
	public static void backward() {
		Navigation n=driver.navigate();
		n.back();
	}
	
	public static void switchToNewWindow(int index) {
		
		//String mainWindow = driver.getWindowHandle();
	
		Set<String> allWindow = driver.getWindowHandles();
		List<String> l = new LinkedList<String>();
		l.addAll(allWindow);
		
		driver.switchTo().window(l.get(index));
				
		}
		
	
	public static void scrollDown() {
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		
		WebElement down = driver.findElement(By.xpath("//div[text()='What issue are you facing?']"));
		
		js.executeScript("arguments[0].scrollIntoView(true)", down);

	}
	
	public static String getAttribute(WebElement e,String value) {
		return e.getAttribute(value);
		

	}

	public static void clear(WebElement e) {
		e.clear();

	}
		
	public static String readExcel(String filename,String sheet,int row,int c) throws IOException {
		File f =new File("E:\\Java Testing Course\\Maven_Class\\src\\Excel\\"+filename+".xlsx");
		FileInputStream st = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(st);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell cell = r.getCell(c);
		int type = cell.getCellType();
		String value = null;
		if(type==1) {
			 value = cell.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				value = sd.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long num=(long) numericCellValue;
				value = String.valueOf(num);
			}
				
			}
	   return value;	
	
	
	}
		
	public static String alert() {
		
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		a.accept();
		return text;

	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
		

	
	
	
	
	




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

