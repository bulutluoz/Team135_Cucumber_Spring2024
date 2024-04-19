Feature: US1012 excel olarak verilen listedeki bulunan urun sayilari testi


  Scenario: TC20 excelde her icin verilen min sayida urun bulunabilmeli

    Given kullanici "toUrl" anasayfaya gider
    Then 4.satirdaki urunu aratir
    And bulunan urun sayisinin 4.satirdaki min urun sayisina esit veya daha fazla oldugunu test eder
    And 3 saniye bekler
    And sayfayi kapatir
