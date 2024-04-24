package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ExcelOtomasyonStepdefinitions {
    Sheet sayfa1;
    String istenenHucredekiData;
    Map<String,String> ulkelerMap;

    @Given("kullanici baskentler exceline ulasir")
    public void kullanici_baskentler_exceline_ulasir() throws IOException {
        String dosyaYolu = "src/test/resources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        sayfa1 = workbook.getSheet("Sayfa1");

    }
    @Then("{int}.satir {int}.hucredeki datayi yazdirir")
    public void satir_hucredeki_datayi_yazdirir(Integer satirNo, Integer sutunNo) {

        System.out.println(satirNo+".satir, "+ sutunNo+ ".sutundaki data : "
                            + sayfa1.getRow(satirNo - 1).getCell(sutunNo - 1));

    }
    @Then("{int}.satir {int}.hucredeki datayi bir string degiskene kaydeder")
    public void satir_hucredeki_datayi_bir_string_degiskene_kaydeder(Integer satirNo, Integer sutunNo) {

        istenenHucredekiData = sayfa1.getRow(satirNo-1)
                                     .getCell(sutunNo-1)
                                     .toString();
    }
    @Then("kaydedilen datanin {string} oldugunu test eder")
    public void kaydedilen_datanin_oldugunu_test_eder(String expectedData) {

        Assert.assertEquals(expectedData,istenenHucredekiData);
    }
    @Then("ingilizce baskenti {string} olan ulkenin Turkce isminin {string} oldugunu test eder")
    public void ingilizceBaskentiOlanUlkeninTurkceIsmininOldugunuTestEder(String verilenBaskent, String expectedUlkeIsmi) {

        for (int i = 0; i <= sayfa1.getLastRowNum() ; i++) {

            // i.indexdeki satirda bulunan ingilizce baskent ismini bulalim
            String satirdakiIngilizceBaskent = sayfa1
                                                .getRow(i)
                                                .getCell(1)
                                                .toString();

            // eger satirdaki ingilizce baskent ismi verilenBaskent ile ayni ise
            if (satirdakiIngilizceBaskent.equalsIgnoreCase(verilenBaskent)){
                // satirdaki turkce ulke ismini kaydedip
                String satirdakiTurkceUlkeIsmi = sayfa1
                                                    .getRow(i)
                                                    .getCell(2)
                                                    .toString();

                // expected ulke ismi ile ayni oldugunu test edecegiz

                Assert.assertEquals(expectedUlkeIsmi,satirdakiTurkceUlkeIsmi);
            }
        }
    }
    @Then("excelde kayitli ulke sayisinin {int} oldugunu test eder")
    public void excelde_kayitli_ulke_sayisinin_oldugunu_test_eder(Integer expectedUlkesayisi) {
        Integer actualUlkeSayisi = sayfa1.getLastRowNum();
        // son satirin index'ini verir
        // kullanilan satir sayisi index+1
        // baslik oldugu icin ulke sayisi index+1-1 ==> index

        Assert.assertEquals(expectedUlkesayisi,actualUlkeSayisi);

    }
    @Then("excelde kullanilan fiziki satir sayisinin {int} oldugunu test eder")
    public void excelde_kullanilan_fiziki_satir_sayisinin_oldugunu_test_eder(Integer expectedSatirSayisi) {
        Integer fizikiKullanilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();

        Assert.assertEquals(expectedSatirSayisi,fizikiKullanilanSatirSayisi);
    }
    @When("Tum bilgileri map olarak kaydedip")
    public void tum_bilgileri_map_olarak_kaydedip() {
        ulkelerMap = new TreeMap<>();

        for (int i = 1; i <= sayfa1.getLastRowNum() ; i++) {
            // key ingilizce baskent
            // value aralarinda - olarak diger bilgiler olsun

            String satirdakiKey = sayfa1.getRow(i).getCell(1).toString(); // ing baskent
            String satirdakiValue =   sayfa1.getRow(i).getCell(0).toString() // ing ulke ismi
                                    + "-"
                                    + sayfa1.getRow(i).getCell(2).toString() // turkce ulke ismi
                                    + "-"
                                    + sayfa1.getRow(i).getCell(3).toString(); // turkce baskent

            ulkelerMap.put(satirdakiKey,satirdakiValue);
        }

    }


    @Then("baskenti {string} olan ulkenin tum bilgilerini yazdirir")
    public void baskentiOlanUlkeninTumBilgileriniYazdirir(String verilenBaskent) {

        System.out.println(ulkelerMap.get(verilenBaskent));
    }

    @And("mapi kullanarak baskenti {string} olan bir ulke bulundugunu test eder")
    public void mapiKullanarakBaskentiOlanBirUlkeBulundugunuTestEder(String verilenBaskent) {

        Assert.assertTrue(ulkelerMap.containsKey(verilenBaskent));

    }
}
