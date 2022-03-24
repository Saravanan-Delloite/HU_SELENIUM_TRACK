import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;


public class Main
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement next = driver.findElement(By.xpath("//div[@id='content']//a[text()='Frames']"));
        next.click();
        WebElement nested = driver.findElement(By.xpath("//div[@id='content']//a[text()='Nested Frames']"));
        nested.click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        driver.findElement(By.cssSelector("body")).getText();
              System.out.print("The frame title is"+title);
    }
}
