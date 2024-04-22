Feature: Login 
  I want to verify the login feature

@Smoke
Scenario: To verify valid login flow
   	Given : User launch browser 
   	When : User open url "https://admin-demo.nopcommerce.com/login?"
   	Then : User enters Email as "admin@yourstore.com" and Password as "admin"
   	And  : User clicks on Login button
   	Then : Page title should be "Dashboard / nopCommerce administration"
   	When : User clicks on Logout button
   	Then : Page title should be "Your store. Login"
   	And  : Close the browser
   
@Regression	  
Scenario: To verify invalid login flow
   	Given : User launch browser 
   	When : User open url "https://admin-demo.nopcommerce.com/login?"
   	Then : User enters Email as "admin@yourstore.com" and Password as "12min"
   	And  : User clicks on Login button
   	Then : User should get validation error message as "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect"
   	And  : Page title should be "Your store. Login"
   	And  : Close the browser
   	
 
   	