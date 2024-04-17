package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceBookPage {

    public FaceBookPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="email")
    public WebElement loginEmailKutusu;

    @FindBy(id="pass")
    public WebElement loginPasswordKutusu;

    @FindBy(name = "login")
    public WebElement loginSayfasiLoginButonu;

    @FindBy(className = "_9ay7")
    public WebElement loginsayfasiGirisYapilamadiYaziElementi;

    @FindBy(xpath = "//*[text()='Allow all cookies']")
    public WebElement cookiesKabulButonu;

    @FindBy(xpath = "//*[text()='Create new account']")
    public WebElement yeniKayitOlusturButonu;

    @FindBy(name = "websubmit")
    public WebElement signUpButonu;
}
