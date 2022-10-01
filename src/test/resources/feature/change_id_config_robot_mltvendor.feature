Feature: Change Id config robot to NCR Multivendor projects

  @MultivendorConfigRobot
  Scenario Outline: NCR Multivendor requirements
    Given user is login on starc page
    And he select request <numR>  on test cases screen
    When user change value of config box for each scenery in <excelPath>
    Examples:
      | excelPath                                                               | numR |
      | "src/test/resources/datafiles/Cambio_config_robot_Multivendor_ConPagos.xlsx" | 5    |
#      | "src/test/resources/datafiles/Cambio_config_robot_Multivendor_SinPagos.xlsx" | 6    |