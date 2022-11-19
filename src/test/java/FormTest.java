import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class FormTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("http://51.75.61.161:9102/form.php");

        WebElement firstNameInput = driver.findElement(By.id("inputFirstName3"));
        firstNameInput.sendKeys("Jan");

        driver.findElement(By.id("inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.id("inputEmail3")).sendKeys("j.k@w.pl");
        driver.findElement(By.id("inputAge3")).sendKeys("35");


//        driver.findElements(By.name("gridRadiosSex")).get(0).click();
        List<WebElement> allGenders = driver.findElements(By.name("gridRadiosSex"));
        allGenders.get(0).click();

    }

}
