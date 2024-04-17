
  Feature: US1001 Kullanici testotomasyonu sayfasinda urun aratabilmeli

    Scenario: TC01 Kullanici phone aratabilmeli

      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna phone yazip enter tusuna basar
      Then arama sonucunda urun bulunabildigini test eder
      And sayfayi kapatir