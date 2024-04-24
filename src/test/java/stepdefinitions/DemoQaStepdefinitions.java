package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoQaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class DemoQaStepdefinitions {

    DemoQaPage demoQaPage = new DemoQaPage();

    @Then("alerts’e tiklar")
    public void alerts_e_tiklar() {
        demoQaPage.alertsButonu.click();
    }
    @Then("On button click, alert will appear after {int} seconds karsisindaki click me butonuna basin")
    public void on_button_click_alert_will_appear_after_seconds_karsisindaki_click_me_butonuna_basin(Integer int1) {

        demoQaPage.appearAfter5SecondsButonu.click();

    }
    @Then("Allert’in gorunur olmasini bekler")
    public void allert_in_gorunur_olmasini_bekler() {
        // implicitly wait bu konuda calismadi

        // java wait kullanalim
        // ReusableMethods.bekle(7);
        // ise yaradi ancak Thread.sleep() yoneticiler tarafindan cok sevilmez

        // Dinamik bekleme yapabilmek icin Explicit wait kullanalim
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

    }
    @Then("Allert uzerindeki yazinin {string} oldugunu test eder")
    public void allert_uzerindeki_yazinin_oldugunu_test_eder(String expectedAlertYazisi) {

        String actualAlertYazisi = Driver.getDriver()
                                        .switchTo().alert()
                                        .getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
    }


    @And("tamam diyerek alert'i kapatir")
    public void tamamDiyerekAlertIKapatir() {
        Driver.getDriver()
                .switchTo().alert()
                .accept();
    }
}
