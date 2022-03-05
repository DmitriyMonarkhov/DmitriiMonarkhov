Feature: Login,check the elements at Home Page and Different Elements Page
  Scenario: Check elements at Home Page and Different Elements Page
    Given I open page Home Page
    And I login as user 'Roman Iovlev'
    When I click on 'Different Elements' subcategory in 'Service' button in Header menu
    And I select water checkbox on Different Elements Page
    And I select wind checkbox on Different Elements Page
    And I select selen radio button on Different Elements Page
    And I select yellow color from dropdown list on Different Elements Page
    Then Log rows are displayed on Different Elements page