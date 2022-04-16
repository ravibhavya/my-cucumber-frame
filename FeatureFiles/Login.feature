Feature: Login Funtionality
@tag1
Scenario Outline:
Validate Login
Given User launch url"<Browser>"in browsers
When  user enter"<Username>"in user feild
When  user enter "<Password>"in pass feild
When  user clicks Loginbutton
Then user should verify url text
Then user closes the browser
Examples:
|Browser|Username|Password|
|Firefox|Admin   |qedge123!@#|
|Firefox|Admin   |qedge123!@2|
|Firefox|Admin1   |qedge123!@#|
|Firefox|Admin   |qedge123!@#|
|Firefox|Admin   |Qedge123!@#|
@tag2
Scenario:
validate emp creation
Given I launch url in a browser
When I enter username And password
When I click login button
When I click pim tab
When I click add button
When I enter fname And mname And lname
When I click save button
Then I verify url text
Then I closes the browser
@tag3
Scenario:
validate user creation 
Given we launch url in a browser
When we enter username and password
When we click login button
When we click on admin tab
When we  click on users tab
When we click on add button
When we select userrole 
When we enter empname 
When we enter username in username feild
When we select status
When we enter password in password feild
When we enter cpassword in password feild
When we click save button
Then we verify with url text
Then we closes the browser

