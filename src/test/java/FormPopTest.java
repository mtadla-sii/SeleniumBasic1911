import enums.Gender;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FormPopTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("http://51.75.61.161:9102/form.php");

        FormPage formPage = new FormPage(driver);
        File file = new File("src/main/resources/file.txt");

        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("j.k@wp.pl");
        formPage.setAge(40);
        formPage.selectGender(Gender.MALE);
        formPage.selectRandomExperience();
        formPage.selectRandomProfession();
        formPage.selectContinent("europe");
        formPage.selectSeleniumCommands(new String[]{"navigation-commands", "wait-commands"});
        formPage.uploadFile(file);
        formPage.sendForm();

        Assert.assertEquals(formPage.getValidatorMsg(), "Form send with success");
    }
}