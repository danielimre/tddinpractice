Scenario: Todos can be edited
Given there are stored todos for 'testuser': 'My stored todo'
When the user logs in with 'testuser'
When the user modifies 'My stored todo' to 'My edited todo'
Then they should see 'My edited todo' in the todos list
When the user logs out
When the user logs in with 'testuser'
Then they should see 'My edited todo' in the todos list
