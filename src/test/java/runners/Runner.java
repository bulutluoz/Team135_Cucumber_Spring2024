package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/rapor.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@wip",
        dryRun = false
)
public class Runner {
    /*
        Runner class'i framework'umuzun build edilmesinde onemlidir
        Java olmayan feature dosyalari ile
        java ile yazdigimiz stepdefinition'larin ilisiklendirilmesini saglar

        Ayni zamanda TestNG'degi .xml dosyalari gibi
        testlerimizi toplu olarak calistirmamizi
        ve istenirse rapor alinmasini saglar

        Runner class'i bos bir class'dir, icinde kod olmaz
        Runner class'in gorevlerini tanimlamak icin
        Notasyonlar kullanilir

        Runner, CucumberOptions'da verilen gorevi yapar
        features klasoru altinda
        tags olarak verilen tag'a sahip scenario'lari bulup
        glue olarak tanimlanan klasordeki Java kodlari ile calistirir

        dryRun = true   secildiginde
        Runner verilen testi CALISTIRMADAN
        sadece eksik stepleri olusturur
        eksik step yoksa, testi calistirmadan direk TestPassed olarak raporlanir
     */

    /*
        Cucumber'da istenen feature veya Scenario(lar) uc sekilde calistirilabilir
        1- direk feature veya scenario'nun yanindaki yesil run tusuna basarak
           bu sekilde calistirinca hic bir HTML rapor alinamaz
           ayrica stepdefinition'larda degisiklik yapildi ise,
           degisikliklerin kontrol edilmesi icin build(cekic) calistirilmalidir
        2- runner class'indan istenen tag yazilarak
           o tag'a sahip tum feature veya scenario'lar calistirilabilir
           bu sekilde calistirilinca runner dosyasina ekledigimiz
           "html:target/html-reports/rapor.html" raporu olusturulur
        3- terminal'den mvn clean verify yazarak
           pom.xml deki surefire ve failsafe plugin'lerinde tanimlanan
           runner dosyalari calistirilabilir

           bu sekilde calistirmada
           hem runner'da eklenen "html:target/html-reports/rapor.html" raporu olusturulur
           hem de plugin olarak ekledigimiz gelismis raporlar olusturulur
     */

}
