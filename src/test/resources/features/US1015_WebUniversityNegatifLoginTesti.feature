Feature: US1015 rastgele kullanici bilgileri ile giris yapilamaz


  Scenario:TC22 fake kullanici ile giris yapilamamali
    Given kullanici "webUrl" anasayfaya gider
    Then Login Portal' a  kadar asagi iner
    And Login Portal' a tiklar
    When acilan diger window'a gecer
    Then username ve password kutularina fake deger yazdirir
    And login butonuna basar
    Then Popup'ta cikan yazinin validation failed oldugunu test eder
    And Ok diyerek Popup'i kapatir
    When Ilk sayfaya geri doner
    And Ilk sayfaya donuldugunu test eder
    And sayfayi kapatir
