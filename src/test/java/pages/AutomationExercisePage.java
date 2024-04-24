package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='fa fa-lock']")
    public WebElement signUpLinki;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    public WebElement signUpEmailKutusu;

    @FindBy(xpath = "//*[@data-qa='signup-name']")
    public WebElement signUpIsimKutusu;


    @FindBy(xpath = "//*[@data-qa='signup-button']")
    public WebElement signUpSayfasindakiSignUpButonu;

    @FindBy(xpath = "//*[@class='fc-button fc-cta-consent fc-primary-button']")
    public WebElement cookiesAcceptButonu;

    @FindBy(id = "id_gender1")
    public WebElement kayitSayfasiMrButonu;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedYaziElementi;


}
