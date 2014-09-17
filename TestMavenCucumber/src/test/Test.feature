Feature: Testing for tatoc application

Scenario: Clicking on greenbox
Given I visit Tatoc page
When I click on greenbox
Then I reach color matching page

Scenario: Clicking on redbox
Given I visit tatoc app page
When I click on redbox
Then I reach Error page

