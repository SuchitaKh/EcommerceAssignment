import Assignment1.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FramesAssignment extends BaseClass {

    @Test
    public void framesClass(){

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/frames']")).click();
        driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText());



    }
}
