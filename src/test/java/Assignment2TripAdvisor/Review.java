package Assignment2TripAdvisor;

import Assignment1.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Review extends BaseClass {

    @BeforeMethod
    public void getBrowser() {
        driver.get("https://www.tripadvisor.in/");
    }

    @Test
    public void search() {
        WebElement Element = driver.findElement(By.xpath("(//input[@name='q'])[2]"));
        driver.findElement(By.xpath("(//input[@name='q' and @title='Search'])[2]")).sendKeys("Club Mahindra", Keys.ENTER);
        List<WebElement> result = driver.findElements(By.xpath("//div[@data-widget-type='TOP_RESULT']"));

        for(int i=0;i<result.size();i++){
            if(i==1){
                result.get(i).click();
                break;
            }
        }

       System.out.println(driver.getTitle());
        Set<String> id =driver.getWindowHandles();
        Iterator<String> it=id.iterator();
        String parentid= it.next();
        String childid= it.next();
        driver.switchTo().window(childid);
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[@class='_1748LPGe' and contains(text(),'review')]")).click();

        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@id='bubble_rating' and contains(@class,bubble_50)]"))).build().perform();

        driver.findElement(By.xpath("//input[@name='ReviewTitle']")).sendKeys("Title!!!");

        driver.findElement(By.xpath("//*[@id='ReviewText']")).sendKeys("Awesome Hotel!!!");

       System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Hotel Ratings')]")).isDisplayed());



    }
}
