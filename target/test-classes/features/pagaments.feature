
@tag
Feature: pagaments
  I want to use this template for my feature file

  @tag1
  Scenario Outline: paymet of an hotel
    Given has logged in
    And the user is in the hotel payment page
    



  @tag2
  Scenario Outline: payment of a flight
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
