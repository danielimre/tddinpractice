Scenario: Adding new todo item to an empty todo list
Given there are no stored todos for 'testuser'
When the user logs in with 'testuser'
When the user enters ' My next task to be done  ' to new todo input field and hits Enter
Then they should see 'My next task to be done' in the todos list
Then they should see the new todo ('My next task to be done') be marked as incomplete
Then they should see the new todo input field empty
Then they should see the footer with status: 'one item left'
When the user enters '   ' to new todo input field and hits Enter
Then they should see 1 todo in the list
Then they should see the footer with status: 'one item left'
