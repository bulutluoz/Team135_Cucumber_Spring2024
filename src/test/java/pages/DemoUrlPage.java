package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoUrlPage {

    public DemoUrlPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Accept All']")
    public WebElement acceptCookiesButonu;

    @FindBy(id = "gdpr-consent-notice")
    public WebElement cookiesIframe;
}
