import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class main {
    public static void main(String[] args)throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement drag= driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag,drop).perform();
    }
}