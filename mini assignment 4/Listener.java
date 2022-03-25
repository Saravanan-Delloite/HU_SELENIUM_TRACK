import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import java.io.File;

public class Listener extends BaseClass implements ITestListener
{

    int i=1;
    @Override
    public void onTestStart(ITestResult result)
        {
                System.out.println("**Test case "+i+" started**");
        }
    @Override
    public void onTestSuccess(ITestResult result)
    {

        System.out.println("---Test case "+i+" ran successfully---");
        i+=1;
    }
    /*public class takeScreenshot()
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File des=new File(System.getProperty("user.dir")+"FailedScreenshots/"+"sample.jpg");
        FileUtils.copyFile(src,des);
    }*/
}
