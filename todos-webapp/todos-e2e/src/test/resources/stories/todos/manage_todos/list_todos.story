Scenario: Entering todos page from homepage for the first time
Given there are no stored todos for 'testuser'
When the user logs in with 'testuser'
Then they should see their username (@testuser) in header
Then they should see empty todos list
Then they should not see the footer
