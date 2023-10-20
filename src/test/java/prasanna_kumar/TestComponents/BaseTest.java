package prasanna_kumar.TestComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public WebDriver startDriver() {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();
		return driver;
	}


	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file );
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	
	}
	
//	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
//
//	{
//
//	Calendar calendar = Calendar.getInstance();
//
//	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
//
//	//String png= System.currentTimeMillis()+ ".png";
//
//	TakesScreenshot ts=(TakesScreenshot) driver;
//
//	File source =ts.getScreenshotAs(OutputType.FILE);
//
//	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+formater.format(calendar.getTime())+".png";
//
//	FileUtils.copyFile(source,new File(destinationFile));
//
//	return destinationFile;
//
//	}

	


	
}
