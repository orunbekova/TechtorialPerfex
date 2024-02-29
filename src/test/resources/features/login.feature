#navigate to url:

#Verify the title is "Techtorial CRM - Login"

#Verify "Log In" is visiable on the page

#Enter correct employee email and password

#Click login button

#Verify title is "Dashboard"
@smoke @regression

  Feature: Testing the functionality of Techtorial Perfex login page
    Background:Navigation to the website
      Given User navigates to 'https://techtorialperfex.com/perfexcrm/admin/authentication'

    Scenario:Happy Path Login Functionality(Positive)
      Given User validates the title is 'Techtorial CRM - Login' from LoginPage
      And User validates the log_in is visible on the page
      When User provides correct employee email and password to the loginPage
      Then User validates the title 'Dashboard' from MainPage

