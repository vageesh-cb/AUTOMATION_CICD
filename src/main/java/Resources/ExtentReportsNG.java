package Resources;

import java.io.File;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	
		
	public static ExtentReports getReportObject() {
		
		String path=System.getProperty("user.dir")+"\\VCB_MVNRUN_Jenkins_Reports\\Index.html";
		
		
		
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("VCB WEB Test Report");
		reporter.config().setDocumentTitle("Automation Execution Test Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "VCB");
		return extent;
		
		
	}
	
	

}
