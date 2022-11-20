package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void selectRandomGender(){
        getRandomElement(allGenders).click();
    }

    public void selectRandomExperience(){
        getRandomElement(experience).click();
    }

    public void selectRandomProfession(){
        getRandomElement(professions).click();
    }

    public void selectMale(){
        allGenders.get(0).click();
    }


    public WebElement getRandomElement(List<WebElement> elements){
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
