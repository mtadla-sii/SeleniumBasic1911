import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoadingBar extends TestBase{

    @Test
    public void shouldFailOnLoadingBar(){
        driver.get("http://51.75.61.161:9102/progressbar.php");
        driver.findElement(By.className("ui-progressbar-complete"));
    }

    @Test
    public void shouldWaitForLoadingBar(){
        driver.get("http://51.75.61.161:9102/progressbar.php");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.className("ui-progressbar-complete"));
    }

    @Test
    public void shouldWaitForLoadingBarThatWillFail(){
        driver.get("http://51.75.61.161:9102/progressbar.php");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.className("oijuhnasdiouhasdiuhasdiuhasdiuhasdiuhasdiuh"));
    }




    @Test
    public void shouldWaitForLoadingBarBadExample(){
        driver.get("http://51.75.61.161:9102/progressbar.php");

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.className("ui-progressbar-complete"));
    }
}
