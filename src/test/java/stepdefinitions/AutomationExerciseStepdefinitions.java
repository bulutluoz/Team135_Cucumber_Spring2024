package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AutomationExercisePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class AutomationExerciseStepdefinitions {
    AutomationExercisePage automationExercisePage = new AutomationExercisePage();
    Faker faker = new Faker();
    String fakeIsim;

    @Given("user sign up linkine tiklar")
    public void user_sign_up_linkine_tiklar() {
        automationExercisePage.signUpLinki.click();
    }
    @Given("user Create an account bolumune email adresi girer")
    public void user_create_an_account_bolumune_email_adresi_girer() {
        automationExercisePage
                .signUpEmailKutusu
                .sendKeys(faker.internet().emailAddress());
        fakeIsim = faker.name().firstName();
        automationExercisePage
                .signUpIsimKutusu
                .sendKeys(fakeIsim);

    }
    @Given("signUp butonuna basar")
    public void sign_up_butonuna_basar() {
        automationExercisePage.signUpSayfasindakiSignUpButonu.click();
    }
    @Given("user kisisel bilgilerini ve iletisim bilgilerini girer")
    public void user_kisisel_bilgilerini_ve_iletisim_bilgilerini_girer() {

        automationExercisePage.kayitSayfasiMrButonu.click();

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys("20")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1996")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeIsim)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .perform();
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()).perform();
    }
    @Given("user Create Account butonuna basar")
    public void user_create_account_butonuna_basar() {

    }
    @Then("hesap olustugunu test eder")
    public void hesap_olustugunu_test_eder() {

    }

    @Then("automationExercise cookies kabul eder")
    public void automationexerciseCookiesKabulEder() {

        automationExercisePage.cookiesAcceptButonu.click();
    }
}
