Scenario: Adding new todo item to an empty todo list
Given the user is on the todos page logged in as 'testuser' with empty todos list
When the user enters ' My next task to be done  ' to new todo input field and hits Enter
Then they should see 'My next task to be done' added to the todos list
Then they should see the new todo ('My next task to be done') be marked as incomplete
Then they should see the new todo input field empty
Then they should see the footer with status: '1 item left'
