import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.*;
public class BaseClass
{
    static WebDriver driver;

    public static WebDriver initialSetup() throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ksaravanakumar\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        return null;
    }
    public static WebDriver loginTowebsite() throws Exception
    {
        /*String line = "";
        String splitBy = ",";
        String User="";
        String PassWord="";
        ArrayList<String> lst=new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ksaravanakumar\\Documents\\HU_SELENIUM_TRACK\\mini assignment 4\\login.csv"));
        while ((line = br.readLine()) != null)
        {
            String[] employee = line.split(splitBy);
            User=employee[0];
            PassWord=employee[1];
        }*/
        String User="standard_user";
        String PassWord="secret_sauce";
        WebElement Id = driver.findElement(By.id("user-name"));
        Id.sendKeys(User);
        //System.out.print(User+"-"+"-"+PassWord);

        WebElement Pass = driver.findElement(By.id("password"));
        Pass.sendKeys(PassWord);
        Thread.sleep(3000);
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        return null;
    }
    public static WebDriver selectingitem() throws Exception
    {
        WebElement filter = driver.findElement(By.xpath("//select"));
        filter.click();
        Thread.sleep(1000);
        WebElement filteracc = driver.findElement(By.xpath("//select//option[text()='Price (high to low)']"));
        filteracc.click();
        Thread.sleep(1000);
        try {
            driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        } catch (Exception e) {
            System.out.println("The button is not clickable");
        }
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        return null;
    }
    public static WebDriver checkingPrice() throws Exception{
        String price1=driver.findElement(By.xpath("(//div[@class='inventory_item_price'])")).getText();
        price1=price1.substring(1);
        driver.findElement(By.id("continue-shopping")).click();
        Thread.sleep(1000);
        float count1=Float.parseFloat(price1);
        if(count1<=100)
        {
            System.out.println("The most expensive product is less than or equal $100");
        }
        else
        {
            System.out.println("The most expensive product is greater than $100");
            driver.close();
        }
        return null;
    }
    public static WebDriver addingLeastExpensive()throws Exception
    {
        String number= driver.findElement(By.className("shopping_cart_badge")).getText();
        int count=Integer.parseInt(number);
        driver.findElement(By.xpath("//select")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select//option[text()='Price (high to low)']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[text()='Add to cart'])[5]")).click();
        String number1= driver.findElement(By.className("shopping_cart_badge")).getText();
        int count1=Integer.parseInt(number1);
        if((count+1)!=count1)
        {
            driver.navigate().refresh();
        }
        return null;
    }
    public static WebDriver checkOut() throws Exception
    {
        String line = "";
        String splitBy = ",";
        String FirstName="";
        String LastName="";
        String PinCode="";
        ArrayList<String> lst=new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ksaravanakumar\\Documents\\HU_SELENIUM_TRACK\\mini assignment 4\\userdetails.csv"));
        while ((line = br.readLine()) != null)
        {
            String[] data = line.split(splitBy);
            FirstName=data[0];
            LastName=data[1];
            PinCode=data[2];
        }
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("first-name")).sendKeys(FirstName);
        Thread.sleep(1000);
        driver.findElement(By.id("last-name")).sendKeys(LastName);
        Thread.sleep(1000);
        driver.findElement(By.id("postal-code")).sendKeys(PinCode);
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();
        return null;
    }
    public static WebDriver checkingCorretion() throws Exception
    {
        Thread.sleep(3000);
        String price1=driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
        price1=price1.substring(1);
        String price2=driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[2]")).getText();
        price2=price2.substring(1);
        String tax=driver.findElement(By.className("summary_tax_label")).getText();
        tax=tax.substring(6);
        float count1=Float.parseFloat(price1);
        float count2=Float.parseFloat(price2);
        float count3=Float.parseFloat(tax);
        float calculated_total=count2+count1+count3;
        String obtained_total=driver.findElement(By.className("summary_total_label")).getText();
        obtained_total=obtained_total.substring(8);
        float total=Float.parseFloat(obtained_total);
        //System.out.println(total);
        calculated_total=Float.parseFloat(new DecimalFormat("##.##").format(calculated_total));
        //System.out.println(calculated_total);
        if(total==calculated_total)
        {
            System.out.println("Total amount displayed on CHECKOUT : OVERVIEW page is correct");
        }
        else {
            System.out.println("Total amount displayed on CHECKOUT : OVERVIEW page is incorrect");
        }
        return null;
    }
    public static WebDriver finish() throws Exception
    {
        driver.findElement(By.id("finish")).click();
        Thread.sleep(1000);
        String verification_msg="THANK YOU FOR YOUR ORDER";
        String message=driver.findElement(By.className("complete-header")).getText();
        if(message.equals(verification_msg))
        {
            System.out.print("The success message is verified");
        }
        return null;
    }
    public static WebDriver exit() throws  Exception
    {
        driver.close();
        return null;
    }
}
