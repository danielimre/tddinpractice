Scenario: Multiple users cannot see each others todos
Given there are no stored todos for 'testuser'
Given there are no stored todos for 'testuser2'
When the user logs in with 'testuser'
When the user enters 'My Isolated Todo' to new todo input field and hits Enter
When the user logs out
When the user logs in with 'testuser2'
Then they should not see 'My Isolated Todo' in todos list
