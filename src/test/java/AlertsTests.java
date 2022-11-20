import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsTests extends TestBase {

    @Test
    public void shouldWaitForDeleayedAlert(){
        driver.get("http://51.75.61.161:9102/alerts.php");

        driver.findElement(By.cssSelector("#delayed-alert")).click();

        // tutaj bedzie trzeba wstawic waita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        String alertMsg = driver.findElement(By.cssSelector("#delayed-alert-label")).getText();
        Assert.assertEquals(alertMsg, "OK button pressed");
    }


    @Test
    public void shouldAcceptAlert(){
        driver.get("http://51.75.61.161:9102/alerts.php");

        driver.findElement(By.id("simple-alert")).click();

        //wstawienie tekstu do alertu
//        driver.switchTo().alert().sendKeys("jakis tekst");

        // klikniecie w alercie cancel
//        driver.switchTo().alert().dismiss();

        // klikniecie w alercie ok
        driver.switchTo().alert().accept();

        String alertMsg = driver.findElement(By.id("simple-alert-label")).getText();
        Assert.assertEquals(alertMsg, "OK button pressed");
    }

    @Test
    public void shouldFillPromptAlert(){
        driver.get("http://51.75.61.161:9102/alerts.php");

        String name = "Mateusz";

        driver.findElement(By.id("prompt-alert")).click();

        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();

        String alertMsg = driver.findElement(By.id("prompt-label")).getText();
        Assert.assertEquals(alertMsg, "Hello "+ name+ "! How are you today?");
    }
}
