Scenario: Todos can be deleted
Given there are stored todos for 'testuser': 'My todo|My other todo'
When the user logs in with 'testuser'
When the user deletes todo 'My todo'
Then they should not see 'My todo' in todos list
Then they should see the footer with status: 'one item left'
When the user logs out
When the user logs in with 'testuser'
Then they should not see 'My todo' in todos list
