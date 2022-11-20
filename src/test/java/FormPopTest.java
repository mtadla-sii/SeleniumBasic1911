import enums.Gender;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormPopTest extends TestBase {
    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("http://51.75.61.161:9102/form.php");

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("j.k@wp.pl");
        formPage.setAge(40);
        formPage.selectGender(Gender.MALE);
        formPage.selectRandomExperience();
        formPage.selectRandomProfession();
        formPage.selectContinent("europe");

        String[] commands = {"navigation-commands" ,"wait-commands"};
        formPage.selectSeleniumCommands(commands);

    }
}