Scenario: Todos can be edited
Given there are no stored todos for 'testuser'
Given there are stored todo 'My stored todo' for user 'testuser'
When the user logs in with 'testuser'
When the user modifies 'My stored todo' to 'My edited todo'
Then they should see 'My edited todo' in the todos list
When the user logs out
When the user logs in with 'testuser'
Then they should see 'My edited todo' in the todos list
