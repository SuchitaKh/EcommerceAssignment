package Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class Homepage extends BaseClass{

    String amznPrice,flipPrice;
    @BeforeMethod
    public void openURL(){
        driver.get("https://www.amazon.in/");
    }

    @Test(priority=1)
    public void search() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone XR (64GB) - Black",Keys.ENTER);

        List<WebElement> result=driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']"));
        System.out.println(result.size());

        for(int i=0;i<result.size();i++){
            String productname=result.get(i).getText();
            if(productname.contains("New Apple iPhone 12 (64GB) - Black")){
                //String price=driver.findElement(By.xpath("//div[@class='a-section a-spacing-medium']/div[2]/div[2]/div/div[3]/div/div/div/div[2]/a/span/span")).getText();
                //System.out.println(price);
                //Thread.sleep(3000);
                //driver.findElement(By.xpath("//a[@class='a-size-base a-link-normal a-text-normal']")).getText();
                 amznPrice=driver.findElement(By.xpath("//span[@class='a-price']")).getText();
                 amznPrice=amznPrice.replaceAll("[^a-zA-Z0-9]","");
                System.out.println("Amazon Price :" + amznPrice);

            }
        }
    }

    @Test(priority = 2)
    public void search2(){
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iPhone XR (64GB) - Black",Keys.ENTER);
        List<WebElement> product=driver.findElements(By.xpath("//div[@class='_4rR01T']"));

        for(int i=0;i<product.size();i++){
            String name=product.get(i).getText();
           // System.out.println(name);
            if(name.equalsIgnoreCase("APPLE iPhone XR (Black, 64 GB)")){
                flipPrice=driver.findElement(By.xpath("//div[@class='_30jeq3 _1_WHN1']")).getText();
                System.out.println("Flipcart Price : "+flipPrice);
                flipPrice=flipPrice.replaceAll("[^a-zA-Z0-9]", "");
            }
        }
    }

    @Test(priority=3)
        public void betterdeal(){
               int fPrice=Integer.parseInt(flipPrice);
               int aPrice= Integer.parseInt(amznPrice);
        if(fPrice<aPrice){
            System.out.println("FlipKart has better deal of Rs."+fPrice +" with savings of Rs."+(aPrice-fPrice));
        } else if(aPrice<fPrice){
            System.out.println("Amazon has better deal of Rs."+ +aPrice+" with savings of Rs."+(fPrice-aPrice));
        }else
            System.out.println("Both have exact same deals");
       }
}
