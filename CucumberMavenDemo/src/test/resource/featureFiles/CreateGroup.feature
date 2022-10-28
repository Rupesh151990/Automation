Feature: Verify the Group Creation functionality 
 
Background:
Given User is already logged into the application
|UserName|Password|
|sqa@assetpanda.com|Panda@123|


Scenario: Verify create the new group
Given User is on the group creation page
And  User clicks on the setting icon 
When user clicks on the Add New Group button
And user is on create page 
And user enter the Name "Test-05"
And user select the required check box
Then user click on save button
And user view the successful message "Group successfully saved"
Then User click on the detele button
And User confrim the popup





