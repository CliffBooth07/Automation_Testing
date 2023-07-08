Feature: Login feature 
Scenario: Valid login data 
	Given The webpage is Sign in to your account
	When User enters the valid username
	And User enter the password
	Then User click on submit button
	
Scenario: Valid dashboard data 
	Given The webpage is Home
	When User click on profile icon
	And User search Timesheet on placeholder
	Then User click on link
	And User click on Timesheet icon
	
Scenario: Verify user data in Date
	Given The webpage is Timesheet Landing Component
	When User validate 3 week data
	And User enter Date and search
	
Scenario: Verify data in Status
	When User select approve
	Then Data got visible
	When User select overdue
	Then click ok
	When User select partially approved
	Then Data not visible
	When User select pending
	Then Data got show
	When User select saved
	Then Data shown
	When User select send back for Revision
	Then No data found
	When User select submitted for approval
	Then Content not shown

	
	