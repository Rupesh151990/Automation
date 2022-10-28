Feature: Verify the Group Creation Page functionality

Background:
Given User is already logged into the application
|UserName|Password|
|sqa@assetpanda.com|Panda@123|

Scenario: Verify the Homepage title
Given user is on homepage
When user gets the title of the page
Then Page title should be "AssetPanda - Management System"

Scenario: verify User view Setting page
Given User clicks on the setting icon 
When user clicks on the Group Setting option
Then user clicks on the group Setting option on the drop down
|Group Settings|
|Company Settings|
|User Configuration|
|User Templates|
|User Support|
|Welcome Email|
|Notifications|
|Automated Reporting|
|Change Logs|
|API Configuration|
|Integrations|
And verify the list count should be 11

Scenario: User create the new Group
Given User is on the group creation page
And  User clicks on the setting icon 
When user clicks on the Add New Group button
And user naviagte to the Adding Groups and their Fields page 





