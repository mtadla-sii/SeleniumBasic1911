import enums.Gender;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FormFluentPopTest extends TestBase {
    FormPage formPage;
    File file;


    @BeforeMethod
    public void testSetup() {
        driver.get("http://51.75.61.161:9102/form.php");
        formPage = new FormPage(driver);
        file = new File("src/main/resources/file.txt");
    }


    @Test
    public void shouldFillFormWithSuccess() {
        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("j.k@wp.pl")
                .setAge(40)
                .selectGender(Gender.MALE)
                .selectRandomExperience()
                .selectRandomProfession()
                .selectContinent("europe")
                .selectSeleniumCommands(new String[]{"navigation-commands", "wait-commands"})
                .uploadFile(file)
                .sendForm();

        Assert.assertEquals(formPage.getValidatorMsg(), "Form send with success");
    }


    @Test
    public void shouldFillFormWithSuccessV2() {
        Assert.assertEquals(
                formPage.setFirstName("Jan")
                        .setLastName("Kowalski")
                        .setEmail("j.k@wp.pl")
                        .setAge(40)
                        .selectGender(Gender.MALE)
                        .selectRandomExperience()
                        .selectRandomProfession()
                        .selectContinent("europe")
                        .selectSeleniumCommands(new String[]{"navigation-commands", "wait-commands"})
                        .uploadFile(file)
                        .sendForm()
                        .getValidatorMsg(), "Form send with success");
    }
}
