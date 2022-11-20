import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoadingBarExplicit extends TestBase{

    @Test
    public void waitForProgressBarText(){
        driver.get("http://51.75.61.161:9102/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // text w progresbar label = Complete!
        WebElement progressBarLabel = driver.findElement(By.cssSelector(".progress-label"));
        wait.until(ExpectedConditions.textToBePresentInElement(progressBarLabel, "Complete!"));
    }

    @Test
    public void waitForProgressBarAttribute(){
        driver.get("http://51.75.61.161:9102/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // w progressbar atrybut class bedzie zawierac ui-progressbar-complete
        WebElement progressBar = driver.findElement(By.cssSelector(".ui-progressbar-value"));

        wait.until(ExpectedConditions.attributeContains(progressBar, "class", "ui-progressbar-complete"));
    }
}
