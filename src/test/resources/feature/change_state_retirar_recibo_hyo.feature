Feature: Change value in test values of  box to Hyosung's test cases

  @RetirarRecibo
  Scenario Outline: Multifunctional HYO with payments
    Given user is login on starc page
    And he select request <numR>  on test cases screen
    When user change value of print box por each scenery in <excelPath>
    Examples:
      | excelPath                                                                     | numR |
#      | "src/test/resources/datafiles/Cambio_Pantalla_Final_HyO_insumo_ConPagos.xlsx" | 2    |
      | "src/test/resources/datafiles/Cambio_Pantalla_Final_HyO_insumo_SinPagos.xlsx" | 3    |
#