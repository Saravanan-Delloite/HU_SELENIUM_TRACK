import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng

public class main {
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        WebDriver driver ;
        ChromeOptions options= new ChromeOptions();
        options.addArguments("headless");
        driver =new ChromeDriver(options);
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        String expected = "PHPTRAVELS";
        checkvar(title, expected);

        WebElement login = driver.findElement(By.xpath("//nav[@class='clearfix']//a[text()='Login']"));
        String parentwindow=driver.getWindowHandle();
        login.click();
        Thread.sleep(2000);
        String title2=driver.getTitle();
        checkvar(title2,expected);
        String url = driver.getCurrentUrl();
        System.out.print(url);
        driver.switchTo().window(parentwindow);
        WebElement login2 = driver.findElement(By.xpath("//nav[@class='clearfix']//a[text()='Pricing']"));
        login2.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.close();

    }

    public static void checkvar(String string2, String string1) {
        if (string2.contains(string1)) {
            System.out.println("titles are same");
        }
        else {
            System.out.println("titles are not same");
        }
    }
}



