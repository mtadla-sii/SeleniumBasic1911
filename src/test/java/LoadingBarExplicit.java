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
        wait.until(ExpectedConditions.XXXXXX);
    }

    @Test
    public void waitForProgressBarAttribute(){
        driver.get("http://51.75.61.161:9102/progressbar.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // w progressbar atrybut class bedzie zawierac ui-progressbar-complete
        wait.until(ExpectedConditions.XXXXXX);
    }
}
