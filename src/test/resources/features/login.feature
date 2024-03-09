#navigate to url:

#Verify the title is "Techtorial CRM - Login"

#Verify "Log In" is visiable on the page

#Enter correct employee email and password

#Click login button

#Verify title is "Dashboard"
@smoke @regression

  Feature: Testing the functionality of Techtorial Perfex login page

  Background:
  Given User navigates to 'employee' login page
  Given User validates the title is 'Techtorial CRM - Login' from LoginPage
  And User validates the log_in is visible on the page


    Scenario:Happy Path Login Functionality(Positive)
     # Given User validates the title is 'Techtorial CRM - Login' from LoginPage
      #And User validates the log_in is visible on the page
      When User provides 'employee' login and password to the loginPage
      Then User validates the title 'Dashboard' from MainPage


    Scenario: Negative Login Functionality(Incorrect email and password)
     # Given User navigate to Url 'https://techtorialperfex.com/perfexcrm/admin/authentication'
    # Given User validates the title is 'Techtorial CRM - Login' from LoginPage
      #And User validates the log_in is visible on the page
      When User provides 'lia@example.com' and '123456' to the loginPage
      Then User validates 'Invalid email or password' and 'rgba(185, 28, 28, 1)' from loginPage


