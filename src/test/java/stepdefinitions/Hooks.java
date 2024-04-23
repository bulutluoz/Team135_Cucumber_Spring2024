package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    /*
        Cucumber'da @After... ve @Before... notasyonlarini kullanirken dikkatli olmaliyiz

        JUnit framework de @After... ve @Before... notasyonlarina sahip method'lari
        TestBase class'ina koyup,
        calismasini istedigimiz test class'larini extends ile TestBase'e child yapiyorduk
        boylece istedigimiz test class'inda TestBase'deki method'lar calisyordu,
        calismasini istemediklerimizi extends yapmadigimiz icin
        TestBase'deki method'lar calismiyordu

        Cucumber'da secim sansimiz yok
        eger stepdefinitions package'i icinde
        bir @After... ve @Before... method'u varsa
        tum scenario'lar icin calisir
     */

    @After // her Scenario'dan sonra calisacak
    public void tearDown(Scenario scenario){
        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
        }
        //Driver.quitDriver();
    }
}
