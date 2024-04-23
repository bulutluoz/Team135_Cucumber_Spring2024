Feature: US1010 Kullanici verilen gecersiz kullanici adi ve sifrelerle
                giris yapilamadigini test eder

  @sistem
  Scenario Outline: TC18 liste olarak verilen gecersiz bilgiler ile giris yapilamaz

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    When email olarak "<verilenEmail>" girer
    And password olarak "<verilenPassword>" girer
    Then signIn butonuna basar
    And giris yapilamadigini test eder
    And 1 saniye bekler
    Then sayfayi kapatir
    Examples:
      |verilenEmail    	|verilenPassword    	|
      |toGecerliEmail  	|toGecersizPassword 	|
      |toGecersizEmail 	|toGecerliPassword  	|
      |toGecersizEmail 	|toGecersizPassword 	|
      |toGecersizEmail2	|toGecersizPassword2	|
      |toGecersizEmail3	|toGecersizPassword3	|
