
Feature: US1009 Kullanici liste olarak verilen tum urunlerin
          sitede bulundugunu test eder
  # aranacak urunler phone, java, nutella, dress, apple, samsung


  Scenario Outline: : TC17 kullanici coklu urun aramasi yapabilmeli
    Given kullanici "toUrl" anasayfaya gider
    Then arama kutusuna "<aranacakKelimeler>" yazip enter tusuna basar
    And arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir

    Examples:
    |aranacakKelimeler|
    |phone  |
    |java   |
    |nutella|
    |dress  |
    |apple  |
    |samsung|

