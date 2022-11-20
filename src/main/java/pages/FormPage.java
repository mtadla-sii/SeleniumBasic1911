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


    @FindBy(className = "btn-primary")
    private WebElement sendFormBtn;

    @FindBy(id = "validator-message")
    private WebElement validatorLabel;

    public String getValidatorMsg() {
        return validatorLabel.getText();
    }

    public FormPage sendForm() {
        sendFormBtn.click();
        return this;
    }

    public FormPage uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }


    public FormPage selectContinent(String continentValue) {
        new Select(continentsSelect).selectByValue(continentValue);
        return this;
    }

    public FormPage selectSeleniumCommands(String command) {
        new Select(selectSeleniumCommands).selectByValue(command);
        return this;
    }

    public FormPage selectSeleniumCommands(String[] commands) {
        for (String command : commands) {
            selectSeleniumCommands(command);
        }
        return this;
    }


    public FormPage selectRandomGender() {
        getRandomElement(allGenders).click();
        return this;
    }

    public FormPage selectRandomExperience() {
        getRandomElement(experience).click();
        return this;
    }

    public FormPage selectRandomProfession() {
        getRandomElement(professions).click();
        return this;
    }

    public FormPage selectMale() {
        allGenders.get(0).click();
        return this;
    }

    public FormPage selectGender(Gender gender) {
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
        return this;
    }


    public WebElement getRandomElement(List<WebElement> elements) {
        Random random = new Random();
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }


    public FormPage setFirstName(String name) {
        firstNameInput.sendKeys(name);
        return this;
    }

    public FormPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public FormPage setAge(int age) {
        // 5 -> "5"
        ageInput.sendKeys(String.valueOf(age));
        return this;
    }
}
