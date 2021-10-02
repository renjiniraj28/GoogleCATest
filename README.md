# GoogleCATest

Notes

Automation is done using Selenium and Java. 
Tests are run using TestNG. 
The results can be verified in test-output folder (refresh project after run).
Website url and search keywords are saved and read from config.properties.

Under src/test/java, created 3 packages.
ca.google.tests – has test cases
ca.google.methods – has classes with re-useable methods
ca.google.results – saves screenshot on test failure

Acceptance Criteria:
Use a browser to navigate to “https://www.google.ca/”
Search for “Kira Systems”
Verify the first result is a link to “https://kirasystems.com/”
Take a screenshot if test cases failed

Test Cases:

searchForKiraSystemsUsingKeypressAndVerifyLink – User enters “Kira Systems” into search box and press enter. Then verifies the first link to be “https://kirasystems.com/”
searchForKiraSystemsUsingAutoSuggestionAndVerifyLink – User enters “Kira Systems” into search box and select “Kira Systems” from suggestions. Then verifies the first link to be “https://kirasystems.com/”
invalidSearch – User enters “Kira” and press enter. Then verifies the first link to be “https://kirasystems.com/”. This test case will fail as this is a negative scenario.

