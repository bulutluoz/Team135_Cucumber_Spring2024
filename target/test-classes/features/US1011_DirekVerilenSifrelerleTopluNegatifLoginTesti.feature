Feature: US1011 Kullanici verilen gecersiz kullanici adi ve sifrelerle
  giris yapilamadigini test eder


  Scenario Outline: TC19 liste olarak verilen gecersiz bilgiler ile giris yapilamaz

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    When email listesinden "<verilenEmail>" girer
    And password listesinden "<verilenPassword>" girer
    And 3 saniye bekler
    Then signIn butonuna basar
    And giris yapilamadigini test eder
    And 1 saniye bekler
    Then sayfayi kapatir

    Examples:
      |verilenEmail    	|verilenPassword    	|
      |murat@akar.com  	|76jrf6 	|
      |selcuk@gmail.com	|53535  	|
      |selin@wise.com 	|rdgdtds 	|
      |damra@gmail.com	|g56435 	|
      |bugra@gmail.com	|23456  	|
