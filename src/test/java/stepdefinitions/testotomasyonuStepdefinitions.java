package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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


    @When("email listesinden {string} girer")
    public void emailListesindenGirer(String verilenEmail) {
        testOtomasyonuPage.emailKutusu.sendKeys(verilenEmail);
    }

    @And("password listesinden {string} girer")
    public void passwordListesindenGirer(String verilenPassword) {
        testOtomasyonuPage.passwordKutusu.sendKeys(verilenPassword);
    }

    @Then("{int}.satirdaki urunu aratir")
    public void satirdakiUrunuAratir(int satirNo) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/urunListesi.xlsx");
        Workbook workBook = WorkbookFactory.create(fileInputStream);

        Sheet sheet1 = workBook.getSheet("Sheet1");

        String satirdakiUrunIsmi = sheet1.getRow(satirNo-1)
                                            .getCell(0)
                                            .toString();


        testOtomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);
    }

    @And("bulunan urun sayisinin {int}.satirdaki min urun sayisina esit veya daha fazla oldugunu test eder")
    public void bulunanUrunSayisininSatirdakiMinUrunSayisinaEsitVeyaDahaFazlaOldugunuTestEder(int satirSayisi) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/urunListesi.xlsx");
        Workbook workBook = WorkbookFactory.create(fileInputStream);

        Sheet sheet1 = workBook.getSheet("Sheet1");

        double satirdakiMinUrunSayisi = sheet1
                                        .getRow(satirSayisi-1)
                                        .getCell(1)
                                        .getNumericCellValue();

        double actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualBulunanUrunSayisi >= satirdakiMinUrunSayisi);
    }

    @Then("exceldeki tum urunleri aratip, minumum urun sayisindan fazla urun bulundugunu test eder")
    public void exceldekiTumUrunleriAratipMinumumUrunSayisindanFazlaUrunBulundugunuTestEder() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/test/resources/urunListesi.xlsx");

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet1 = workbook.getSheet("Sheet1");

        boolean failedOlanVarmi = false;

        for (int i = 1; i <= sheet1.getLastRowNum() ; i++) {

            String satirdakiUrunIsmi = sheet1
                                        .getRow(i)
                                        .getCell(0)
                                        .toString();

            // satirdaki urun ismini to sayfasinda aratip, bulunan sonuc sayisini kaydedelim

            testOtomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);

            double actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();

            double bulunacakMinimumUrunSayisi = sheet1
                                                        .getRow(i)
                                                        .getCell(1)
                                                        .getNumericCellValue();
            System.out.println(satirdakiUrunIsmi + " icin minumum bulunacak sayi : " + bulunacakMinimumUrunSayisi +
                                                    ", actual bulunan urun sayisi : " + actualBulunanUrunSayisi);

            try {
                Assert.assertTrue(actualBulunanUrunSayisi >= bulunacakMinimumUrunSayisi);
            } catch (AssertionError e) {
                System.out.println(satirdakiUrunIsmi + " icin test FAILED oldu");
                failedOlanVarmi = true;
            }

        }

        Assert.assertFalse(failedOlanVarmi);

    }
}
