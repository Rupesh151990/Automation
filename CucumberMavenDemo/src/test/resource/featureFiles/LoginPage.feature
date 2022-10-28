Feature: Login Functionality

Scenario: Verify Login Page title
Given user is on login page
When user gets the title of the page
Then Page title should be "AssetPanda - Management System"

Scenario: Verify the Forgot Link Password
Given user is on login page
Then Forgot link password should be displayed

Scenario: Verify the User login with valid credentails
Given user is on login page
When user enters the userName "sqa@assetpanda.com" 
And user enters the password "Panda@123"
And user clicks on the login button
Then user gets the title of the page
And Page title should be "AssetPanda - Management System"