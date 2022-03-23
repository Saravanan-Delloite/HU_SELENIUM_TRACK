import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("http://www.google.com");
        driver.quit();
    }

}
