

Feature: US1021 kullanici gerekli beklemeleri yaparak test yapar

  @wip
  Scenario: TC28 Kullanici waitleri kullanarak senkronizasyon yapabilmeli

    Given kullanici "demoQaUrl" anasayfaya gider
    Then alerts’e tiklar
    And On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
    And Allert’in gorunur olmasini bekler
    Then Allert uzerindeki yazinin "This alert appeared after 5 seconds" oldugunu test eder
    And tamam diyerek alert'i kapatir




