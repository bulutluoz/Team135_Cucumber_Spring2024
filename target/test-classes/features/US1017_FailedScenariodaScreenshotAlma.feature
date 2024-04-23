Feature: US1017 scenario failed olursa screenshot alip kaydetmeli

  @wip
  Scenario: TC24 Kullanici parametre ile istedigi kelimeyi aratabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna "dress" yazip enter tusuna basar
    And 5 saniye bekler
    Then arama sonucunda urun bulunabildigini test eder
