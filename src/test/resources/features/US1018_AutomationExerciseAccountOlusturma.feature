
Feature:US1018 Kullanici girdigi bilgilerle yeni kayit olusturur

  @wip
  Scenario: TC25 yeni kayit olusturup, kayit olustugu test eder

    Given kullanici "autoExerciseUrl" anasayfaya gider
    And 1 saniye bekler
    And user sign up linkine tiklar
    And 1 saniye bekler
    And user Create an account bolumune email adresi girer
    And 1 saniye bekler
    And signUp butonuna basar
    And 1 saniye bekler
    #Then automationExercise cookies kabul eder
    And user kisisel bilgilerini ve iletisim bilgilerini girer
    And user Create Account butonuna basar
    Then hesap olustugunu test eder
    And 3 saniye bekler
