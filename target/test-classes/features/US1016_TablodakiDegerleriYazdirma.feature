
  Feature: US1016 web table'daki tum bilgiler yazdirilabilmeli

    @wip
    Scenario: TC23 Web tablosunda istenen bilgiler yazdirilabilmeli

      Given kullanici "demoUrl" anasayfaya gider
      Then isteniyorsa demoUrl sayfasindaki cookies'i kabul eder
      And "Istenen Baslik", sutunundaki tum degerleri yazdirir
      And 5 saniye bekler
      And sayfayi kapatir
