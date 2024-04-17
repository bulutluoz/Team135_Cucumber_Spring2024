package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class testotomasyonuStepdefinitions {

    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @When("arama kutusuna phone yazip enter tusuna basar")
    public void arama_kutusuna_phone_yazip_enter_tusuna_basar() {
       testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {

        int actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualBulunanUrunSayisi > 0);
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }


    @When("arama kutusuna dress yazip enter tusuna basar")
    public void aramaKutusunaDressYazipEnterTusunaBasar() {
        testOtomasyonuPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);
    }

    @When("arama kutusuna baby yazip enter tusuna basar")
    public void aramaKutusunaBabyYazipEnterTusunaBasar() {
        testOtomasyonuPage.aramaKutusu.sendKeys("baby" + Keys.ENTER);
    }

    @When("arama kutusuna java yazip enter tusuna basar")
    public void aramaKutusunaJavaYazipEnterTusunaBasar() {
        testOtomasyonuPage.aramaKutusu.sendKeys("java" + Keys.ENTER);
    }

    @Then("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {
        int actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertEquals(0, actualBulunanUrunSayisi);
    }

    @When("arama kutusuna nutella yazip enter tusuna basar")
    public void aramaKutusunaNutellaYazipEnterTusunaBasar() {

        testOtomasyonuPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);
    }

    @When("arama kutusuna {string} yazip enter tusuna basar")
    public void aramaKutusunaYazipEnterTusunaBasar(String aranacakKelime) {

        testOtomasyonuPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int saniye) {

        ReusableMethods.bekle(saniye);
    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String istenenUrlAdi) {
        Driver.getDriver().get(ConfigReader.getProperty(istenenUrlAdi));
    }
    @Then("account butonuna basar")
    public void account_butonuna_basar() {
       testOtomasyonuPage.accountLinki.click();
    }
    @Then("email olarak {string} girer")
    public void email_olarak_girer(String kullanilacakEmailIsmi) {
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty(kullanilacakEmailIsmi));
    }
    @Then("password olarak {string} girer")
    public void password_olarak_girer(String kullanilacakPasswordIsmi) {
       testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty(kullanilacakPasswordIsmi));
    }
    @Then("signIn butonuna basar")
    public void sign_in_butonuna_basar() {
        testOtomasyonuPage.loginButonu.click();
    }
    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {
       Assert.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
    }

    @Then("giris yapilamadigini test eder")
    public void girisYapilamadiginiTestEder() {

        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
    }
}
