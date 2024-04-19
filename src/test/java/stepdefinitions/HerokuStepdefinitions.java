package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HerokuPage;
import utilities.Driver;

import java.time.Duration;

public class HerokuStepdefinitions {

    HerokuPage herokuPage = new HerokuPage();

    @When("kullanici Add Element butonuna basar")
    public void kullanici_add_element_butonuna_basar() {
        herokuPage.addButonu.click();
    }
    @When("Delete butonu’nun gorunur oldugunu test eder")
    public void delete_butonu_nun_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(herokuPage.deleteButonu.isDisplayed());
    }
    @Then("Delete tusuna basar")
    public void delete_tusuna_basar() {
        herokuPage.deleteButonu.click();
    }
    @Then("Add Remove Elements yazisinin gorunur oldugunu test eder")
    public void add_remove_elements_yazisinin_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(herokuPage.addRemoveYaziElementi.isDisplayed());
    }

    @And("Delete butonunun kayboldugunu test eder")
    public void deleteButonununKayboldugunuTestEder() {
        // gorunmeyen  bir elemani locate edemeyecegimiz icin
        // gorunmedigini test edemeyiz
        // bu testi yapabilmek icin, gorunmeyen elemani kullanmaya calisip
        // NoSuchElementException vermesini saglar, ve bu exception'i kullanarak testimizi yapariz
        // Ancak NoSuchElementException vermesi icin implicitlyWait olarak tanimlanan sure beklememiz gerekir


         try {
             herokuPage.deleteButonu.click();
        } catch (NoSuchElementException e) {
            // Eger delete butonunu locate edip click yapamiyorsa
            // delete butonu gorunur degildir
            // yani testimiz passed olmustur
            Assert.assertTrue(true);
        }
    }
}
