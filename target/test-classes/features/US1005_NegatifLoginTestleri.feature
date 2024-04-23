Feature: US1005 gecersiz bilgilerle giris yapilamamali

  Scenario: TC11 gecerli username ve gecersiz password ile giris yapilamamali

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    When email olarak "toGecerliEmail" girer
    And password olarak "toGecersizPassword" girer
    And signIn butonuna basar
    Then giris yapilamadigini test eder
    And sayfayi kapatir



  Scenario: TC12 gecersiz username ve gecerli password ile giris yapilamamali

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    When email olarak "toGecersizEmail" girer
    And password olarak "toGecerliPassword" girer
    And signIn butonuna basar
    Then giris yapilamadigini test eder
    And sayfayi kapatir

  @E2E
  Scenario: TC13 gecersiz username ve gecersiz password ile giris yapilamamali

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    When email olarak "toGecersizEmail" girer
    And password olarak "toGecersizPassword" girer
    And signIn butonuna basar
    Then giris yapilamadigini test eder
    And sayfayi kapatir