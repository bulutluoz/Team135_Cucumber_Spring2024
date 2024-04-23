
  Feature: US1016 web table'daki tum bilgiler yazdirilabilmeli

    @wip
    Scenario: TC23 Web tablosunda istenen bilgiler yazdirilabilmeli

      Given kullanici "demoUrl" anasayfaya gider
      And 3 saniye bekler
      Then isteniyorsa demoUrl sayfasindaki cookies'i kabul eder
      And 2 saniye bekler
      And "Company", sutunundaki tum degerleri yazdirir
      And 2 saniye bekler
      #And sayfayi kapatir
