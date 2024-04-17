
Feature: US1003 kullanici parametre olarak verilen urunun sitede bulundugunu test eder

  # step yazilirken " " icerisinde yazilan kelimeler ve int sayilar
  # parametre olarak kabul edilir ve dinamik kod yazilir

  Scenario: TC07 Kullanici parametre ile phone aratabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna "phone" yazip enter tusuna basar
    And 3 saniye bekler
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir


  Scenario: TC08 Kullanici parametre ile phone aratabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna "apple" yazip enter tusuna basar
    And 5 saniye bekler
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir

  Scenario: TC09 Kullanici parametre ile Cokokrem arattiginda sonuc bulunamamali
    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna "cokokrem" yazip enter tusuna basar
    Then arama sonucunda urun bulunamadigini test eder
    And sayfayi kapatir