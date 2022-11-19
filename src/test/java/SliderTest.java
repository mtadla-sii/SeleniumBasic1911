import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SliderTest extends TestBase{

    @Test
    public void shouldMoveSlider(){
        driver.get("http://51.75.61.161:9102/slider.php");

        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_RIGHT);
        }
    }
}
