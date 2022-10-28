Feature: Verify the Landing HomePage

Background:
Given User is already logged into the application
|UserName|Password|
|sqa@assetpanda.com|Panda@123|

Scenario: Verify the Homepage title
Given user is on homepage
When user gets the title of the page
Then Page title should be "AssetPanda - Management System"

Scenario: Verify the Landing HomePage Sections
Given user is on homepage
Then user gets the drop downs
|Notifications ( 0 )|
|Groups|
|Tools|
|Support|
And drop down section will be 4