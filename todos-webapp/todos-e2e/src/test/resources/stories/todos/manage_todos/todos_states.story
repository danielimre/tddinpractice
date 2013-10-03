Scenario: Managing todos' states
Given there are no stored todos for 'testuser'
When the user logs in with 'testuser'
When the user enters 'Todo1' to new todo input field and hits Enter
When the user enters 'Todo2' to new todo input field and hits Enter
When the user enters 'Todo3' to new todo input field and hits Enter
When the user clicks state checkbox on todo #1
Then they should see the footer with status: '2 items left'
