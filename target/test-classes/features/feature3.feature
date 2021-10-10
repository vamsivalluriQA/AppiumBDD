Feature: Arithmetic operations

  Background: 
    Given launch app

  Scenario Outline: validate addition operation
    Then validate addition using "<input1>" and "<input2>"
    And close app

    Examples: 
      | input1 | input2 |
      |     23 |     56 |
      |    -78 |     79 |
      |     98 |    -87 |
      |    -34 |    -45 |
      |      0 |     34 |
      |     34 |      0 |
      |      0 |      0 |

  Scenario Outline: validate subtraction operation
    Then validate subtraction using "<input1>" and "<input2>"
    And close app

    Examples: 
      | input1 | input2 |
      |     23 |     56 |
      |    -78 |     79 |
      |     98 |    -87 |
      |    -34 |    -45 |
      |      0 |     34 |
      |     34 |      0 |
      |      0 |      0 |

  Scenario Outline: validate multiply operation
    Then validate multiply using "<input1>" and "<input2>"
    And close app

    Examples: 
      | input1 | input2 |
      |     23 |     56 |
      |    -78 |     79 |
      |     98 |    -87 |
      |    -34 |    -45 |
      |      0 |     34 |
      |     34 |      0 |
      |      0 |      0 |

  @smoketest
  Scenario Outline: validate division operation
    Then validate division using "<input1>" and "<input2>"
    And close app

    Examples: 
      | input1 | input2 |
      |     23 |     56 |
      |    -78 |     79 |
      |     98 |    -87 |
      |    -34 |    -45 |
      |      0 |     34 |
      |     34 |      0 |
      |      0 |      0 |
