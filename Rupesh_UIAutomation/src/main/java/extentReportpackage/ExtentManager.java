package extentReportpackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();
    
    public synchronized static ExtentReports createExtentReports() 
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "UI Automation");
        extentReports.setSystemInfo("Author", "Rupesh Gupta");
        return extentReports;
        
    }
}
    
