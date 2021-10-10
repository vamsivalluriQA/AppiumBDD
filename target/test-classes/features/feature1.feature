Feature: arithmetic calculation

  @smoketest
  Scenario: validate arithmetic operation for given data
    Given launch app
    Then validate operation with given data
      | operation | input1 | input2 |
      | add       |     23 |     34 |
      | subtract  |     23 |     14 |
      | multiply  |     23 |     34 |
      | divide    |     21 |      8 |
    And close app
