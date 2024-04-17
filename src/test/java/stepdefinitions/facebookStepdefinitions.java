package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.FaceBookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class facebookStepdefinitions {
    FaceBookPage faceBookPage = new FaceBookPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Then("facebook cookies kabul eder")
    public void facebook_cookies_kabul_eder() {
        faceBookPage.cookiesKabulButonu.click();
    }
    @Then("facebook'da yeni hesap olustur butonuna basar")
    public void facebook_da_yeni_hesap_olustur_butonuna_basar() {
        faceBookPage.yeniKayitOlusturButonu.click();
    }
    @When("Faker class'indan bilgilerle facebook kayit formunu doldurur")
    public void faker_class_indan_bilgilerle_facebook_kayit_formunu_doldurur() {
        String fakeEmail= faker.internet().emailAddress();

        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail).perform();
        ReusableMethods.bekle(2);
        actions .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1989")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();


    }
    @Then("facebook kayit ol tusuna basar")
    public void facebook_kayit_ol_tusuna_basar() {
        faceBookPage.signUpButonu.click();
    }
}
