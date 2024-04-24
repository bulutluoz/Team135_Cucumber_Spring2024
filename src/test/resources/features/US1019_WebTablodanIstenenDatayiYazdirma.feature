Feature: US1019 Kullanici istedigi satir ve sutundaki datayi yazdirir


  Scenario: TC26 parametre olarak verilen satir ve sutundaki data yazdirilabilmeli

    Given kullanici "demoUrl" anasayfaya gider
    And 5. satir, 1. sutundaki datayi yazdirir
    And "tum tablo" ismi ile tum sayfa screenshot kaydeder

