Scenario: Todos are stored after logout
Given there are no stored todos for 'testuser'
When the user logs in with 'testuser'
When the user enters 'My Todo' to new todo input field and hits Enter
When the user logs out
When the user logs in with 'testuser'
Then they should see 'My Todo' in the todos list

Scenario: Todos are retrieved from backend
Given there are stored todo 'My stored todo' for user 'testuser'
When the user logs in with 'testuser'
Then they should see 'My stored todo' in the todos list
