package pages;

import enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstNameInput;
    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;
    @FindBy(id = "inputEmail3")
    private WebElement emailInput;
    @FindBy(id = "inputAge3")
    private WebElement ageInput;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> allGenders;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experience;

    @FindBy(name = "gridCheckboxProfession")
    private List<WebElement> professions;

    @FindBy(id = "selectContinents")
    private WebElement continentsSelect;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement selectSeleniumCommands;

    @FindBy(id = "chooseFile")
    private WebElement fileInput;


    public void uploadFile(File file){
        fileInput.sendKeys(file.getAbsolutePath());
    }











    public void selectContinent(String continentValue){
        new Select(continentsSelect).selectByValue(continentValue);
    }

    public void selectSeleniumCommands(String command){
        new Select(selectSeleniumCommands).selectByValue(command);
    }

    public void selectSeleniumCommands(String[] commands){
        for (String command : commands){
            selectSeleniumCommands(command);
        }
    }







    public void selectRandomGender() {
        getRandomElement(allGenders).click();
    }

    public void selectRandomExperience() {
        getRandomElement(experience).click();
    }

    public void selectRandomProfession() {
        getRandomElement(professions).click();
    }

    public void selectMale() {
        allGenders.get(0).click();
    }

    public void selectGender(Gender gender) {
        switch (gender) {
            case MALE:
                allGenders.get(0).click();
                break;
            case FEMALE:
                allGenders.get(1).click();
                break;
            case OTHER:
                allGenders.get(2).click();
                break;
        }

    }


    public WebElement getRandomElement(List<WebElement> elements) {
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }


    public void setFirstName(String name) {
        firstNameInput.sendKeys(name);
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setAge(int age) {
        // 5 -> "5"
        ageInput.sendKeys(String.valueOf(age));
    }
}
