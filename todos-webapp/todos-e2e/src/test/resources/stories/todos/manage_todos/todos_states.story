Scenario: Managing todos' states
Given the user is on the todos page logged in as 'testuser' with empty todos list
When the user enters 'Todo1' to new todo input field and hits Enter
When the user enters 'Todo2' to new todo input field and hits Enter
When the user enters 'Todo3' to new todo input field and hits Enter
When the user clicks state checkbox on todo #1
Then they should see the footer with status: '2 items left'
