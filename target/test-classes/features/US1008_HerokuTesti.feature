Feature: US1008 Kullanici delete butonunun calistigini test eder

  @wip
  Scenario: TC16 Delete butonunun calistigini tesyt eder

    Given kullanici "heroUrl" anasayfaya gider
    When kullanici Add Element butonuna basar
    And 2 saniye bekler
    And Delete butonu’nun gorunur oldugunu test eder
    Then Delete tusuna basar
    And Delete butonunun kayboldugunu test eder
    And Add Remove Elements yazisinin gorunur oldugunu test eder
    And 2 saniye bekler
    And sayfayi kapatir
