package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.DemoUrlPage;
import utilities.Driver;

public class DemoUrlStepdefinitions {

    DemoUrlPage demoUrlPage = new DemoUrlPage();

    @Then("isteniyorsa demoUrl sayfasindaki cookies'i kabul eder")
    public void isteniyorsa_demo_url_sayfasindaki_cookies_i_kabul_eder() {

        Driver.getDriver().switchTo().frame(demoUrlPage.cookiesIframe);

        demoUrlPage.acceptCookiesButonu.click();

    }
    @Then("{string}, sutunundaki tum degerleri yazdirir")
    public void sutunundaki_tum_degerleri_yazdirir(String string) {

    }
}
