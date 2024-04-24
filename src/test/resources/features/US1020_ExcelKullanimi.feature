Feature: US1020 excelde istenen gorevleri yapma

  Scenario: TC27 kullanici excelden istenen bilgileri alabilmeli

    Given kullanici baskentler exceline ulasir
    Then 1.satir 2.hucredeki datayi yazdirir
    And 1.satir 2.hucredeki datayi bir string degiskene kaydeder
    And kaydedilen datanin "Başkent (İngilizce)" oldugunu test eder
    Then ingilizce baskenti "Havana" olan ulkenin Turkce isminin "Küba" oldugunu test eder
    And excelde kayitli ulke sayisinin 190 oldugunu test eder
    And excelde kullanilan fiziki satir sayisinin 191 oldugunu test eder
    When Tum bilgileri map olarak kaydedip
    Then baskenti "Ankara" olan ulkenin tum bilgilerini yazdirir
    And mapi kullanarak baskenti "Berlin" olan bir ulke bulundugunu test eder


