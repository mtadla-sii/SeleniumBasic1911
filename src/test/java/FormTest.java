import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;


public class FormTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("http://51.75.61.161:9102/form.php");

        WebElement firstNameInput = driver.findElement(By.id("inputFirstName3"));
        firstNameInput.sendKeys("Jan");

        driver.findElement(By.id("inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.id("inputEmail3")).sendKeys("j.k@w.pl");
        driver.findElement(By.id("inputAge3")).sendKeys("35");

//        opcja w 1 linijce
//        driver.findElements(By.name("gridRadiosSex")).get(0).click();

//        opcja w 2 linijkach
//        List<WebElement> allGenders = driver.findElements(By.name("gridRadiosSex"));
//        allGenders.get(0).click();

//        opcja losująca element z listy w 1 linijce
//        getRandomElement(driver.findElements(By.name("gridRadiosSex"))).click();

//        opcja losująca element z listy w 2 linijkach
        List<WebElement> allGenders = driver.findElements(By.name("gridRadiosSex"));
        getRandomElement(allGenders).click();
    }

    public WebElement getRandomElement(List<WebElement> elements){
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }

}
