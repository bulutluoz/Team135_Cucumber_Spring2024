
Feature: US1013 excelden verilen satirlardaki urunler icin
                minumum miktar veya daha fazla sonuc bulunabilmeli


 Scenario Outline: TC20 excelde her icin verilen min sayida urun bulunabilmeli

    Given kullanici "toUrl" anasayfaya gider
    Then <satirNo>.satirdaki urunu aratir
    And bulunan urun sayisinin <satirNo>.satirdaki min urun sayisina esit veya daha fazla oldugunu test eder
    And 3 saniye bekler
    And sayfayi kapatir

    Examples:
   |satirNo|
   |2      |
   |4      |
   |5      |
