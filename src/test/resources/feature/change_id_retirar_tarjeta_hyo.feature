Feature: Change id in test values of withdraw card to Hyosung's test cases

  @Hyowithpayments
  Scenario Outline: Multifunctional HYO with payments
    Given user is login on starc page
    And he select request <numR>  on test cases screen
    When user change id of withdraw card por each scenery in <excelPath>
    Then id could be change
    Examples:
      | excelPath                                                                     | numR |
      | "src/test/resources/datafiles/Cambio_Pantalla_Final_HyO_insumo_ConPagos.xlsx" | 2    |