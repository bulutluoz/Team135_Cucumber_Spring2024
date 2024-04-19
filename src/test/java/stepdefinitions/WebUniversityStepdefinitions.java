package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebUniversityStepdefinitions {

    WebuniversityPage webuniversityPage = new WebuniversityPage();

    @Then("Login Portal' a  kadar asagi iner")
    public void login_portal_a_kadar_asagi_iner() {
        // login portal zaten gorunuyor, islem yapilmadi
    }
    @Then("Login Portal' a tiklar")
    public void login_portal_a_tiklar() {
        webuniversityPage.loginPortalYazisi.click();
    }
    @When("acilan diger window'a gecer")
    public void acilan_diger_window_a_gecer() {
        ReusableMethods.switchWindow("https://webdriveruniversity.com/Login-Portal/index.html");
    }
    @Then("username ve password kutularina fake deger yazdirir")
    public void username_ve_password_kutularina_fake_deger_yazdirir() {
        Faker faker = new Faker();
        webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());
    }
    @Then("login butonuna basar")
    public void login_butonuna_basar() {
        webuniversityPage.loginButonu.click();
    }
    @Then("Popup'ta cikan yazinin validation failed oldugunu test eder")
    public void popup_ta_cikan_yazinin_validation_failed_oldugunu_test_eder() {
        String expectedAlertYazisi = "validation failed";
        String actualAlertYazisi = Driver.getDriver()
                                         .switchTo().alert()
                                         .getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
    }
    @Then("Ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {
        Driver.getDriver()
                .switchTo().alert()
                .accept();
    }
    @When("Ilk sayfaya geri doner")
    public void ilk_sayfaya_geri_doner() {
        ReusableMethods.switchWindow("https://webdriveruniversity.com/");
    }
    @When("Ilk sayfaya donuldugunu test eder")
    public void ilk_sayfaya_donuldugunu_test_eder() {
        Assert.assertTrue(webuniversityPage.loginPortalYazisi.isDisplayed());
    }
}
