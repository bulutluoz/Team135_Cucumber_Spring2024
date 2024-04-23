package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DemoUrlPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class DemoUrlStepdefinitions {

    DemoUrlPage demoUrlPage = new DemoUrlPage();

    @Then("isteniyorsa demoUrl sayfasindaki cookies'i kabul eder")
    public void isteniyorsa_demo_url_sayfasindaki_cookies_i_kabul_eder() {

        Driver.getDriver().switchTo().frame(demoUrlPage.cookiesIframe);

        demoUrlPage.acceptCookiesButonu.click();

    }
    @Then("{string}, sutunundaki tum degerleri yazdirir")
    public void sutunundaki_tum_degerleri_yazdirir(String istenenBaslik) {

        String dinamikSutunBasligiXpath = ""; // (//thead//th)[  3   ]
        String dinamikSutundakiTumDatalarXpath = ""; // (//tbody)[2]/tr/td[2]

        // basligi Company olan sutundaki tum datalari yazdirin

        // 1- tum basliklari bir liste olarak alirim


        // 2- tum basliklari bir loop ile gozden gecirip

        for (int i = 1; i <= demoUrlPage.baslikElementleriListesi.size() ; i++) {

            dinamikSutunBasligiXpath = "(//thead//th)[" + i + "]";
            String sutundakiBaslik = Driver.getDriver()
                                            .findElement(By.xpath(dinamikSutunBasligiXpath))
                                            .getText();

            // 3- istenen basligi hangi index'de bulursam
            //    o index'deki tum datalari yazdiririm

            if (sutundakiBaslik.equalsIgnoreCase(istenenBaslik)){

                dinamikSutundakiTumDatalarXpath = "(//tbody)[2]/tr/td[" + i + "]";

                List<WebElement> istenenSutundakiElementlerListesi =
                        Driver.getDriver().findElements(By.xpath(dinamikSutundakiTumDatalarXpath));

                System.out.println(ReusableMethods.stringListeDonustur(istenenSutundakiElementlerListesi));
            }


        }









    }
}
