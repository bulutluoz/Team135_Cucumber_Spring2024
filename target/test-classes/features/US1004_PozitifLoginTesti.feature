
Feature: US1004 gecerli bilgilerle giris yapilabilmeli

  Scenario: TC10 test datasi olarak verilen kullanici adi ve sifre ile
            giris yapilabilmeli

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecerliPassword" girer
    Then signIn butonuna basar
    And basarili giris yapilabildigini test eder
    And 3 saniye bekler
    And sayfayi kapatir
