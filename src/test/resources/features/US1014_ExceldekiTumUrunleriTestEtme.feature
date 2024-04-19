Feature: US1014 exceldeki tum urunler icin minumum miktarda urun bulunabilmeli


  Scenario: TC21 exceldeki tum urunler aratildiginda
                 minimum miktar veya daha fazla urun bulunabilmeli

    Given kullanici "toUrl" anasayfaya gider
    Then exceldeki tum urunleri aratip, minumum urun sayisindan fazla urun bulundugunu test eder
    And sayfayi kapatir

