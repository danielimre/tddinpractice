Scenario: Entering todos page from homepage for the first time
Given the user is on the home page
When the user logs in with 'testuser'
Then they should see empty todos list
Then they should not see the footer
