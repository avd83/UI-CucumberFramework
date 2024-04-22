Feature: Customers

  
Background: Common steps for below Customer Add and Search Scenario
  	Given : User launch browser 
   	When : User open url "https://admin-demo.nopcommerce.com/login?"
   	Then : User enters Email as "admin@yourstore.com" and Password as "admin"
   	And  : User clicks on Login button
   	Then : User view dahsboard
   	When : User clicks on customer menu
   	And : click on customer menu Item
   	
@Smoke
Scenario: Add new Customer details
	  And : User clicks on Add new button
   	Then : User can view customer page
   	When : User eneters customer info details
   	And : Clicks on save button
   	Then : User can view confirmation message "× The new customer has been added successfully."
   	And : Close the browser 

@Regression
Scenario: Search Customer by FirstName filters
    When : User enters customers FirstName
   	And  : User clicks on Search button 
   	Then : User should get the FirstName in table
   	And : Close the browser
   	
@Regression  	
Scenario: Search Customer by Email filters
    When : User enters customers Email
   	And  : User clicks on Search button 
   	Then : User should get the Email in table
   	And : Close the browser