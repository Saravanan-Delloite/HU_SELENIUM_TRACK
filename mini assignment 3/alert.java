import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;


public class alert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement next = driver.findElement(By.xpath("//div[@id='content']//a[text()='JavaScript Alerts']"));
        next.click();
        WebElement prompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        prompt.click();
        driver.switchTo().alert().sendKeys("x- Test");
        driver.switchTo().alert().accept();
        String result;
        String expected="x- Test";
        result=driver.findElement(By.xpath("//p[@id='result']")).getText();

        driver.close();
        check(result,expected);


    }
    public static void check(String s1,String s2)
    {
        if(s1.contains(s2))
        {
            System.out.print(s2+"is the result.");
        }
        else {
            System.out.print("Result is not" +s2);
        }

    }
}