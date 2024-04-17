package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.FaceBookPage;
import utilities.Driver;

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

    }
    @Then("facebook kayit ol tusuna basar")
    public void facebook_kayit_ol_tusuna_basar() {

    }
}
