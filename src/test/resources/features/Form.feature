Feature: Verify Registration Form

	Background: Verify fields in the form
	Given User is on form page

  @regression
  Scenario Outline: Verifying the Test case ID "<testCaseID>",field "<fieldID>"
		
		When User puts values in the fields "<valueName>" "<valuePhone>" "<valueEmail>" "<valueUserID>" "<valuePassword>"
		And Clicks on button "<button>"
		Then expected result is "<expectedMessage>" for "<fieldID>"

	  Examples:
		  | testCaseID | fieldID   		| valueName           			| valuePhone 	  | valueEmail	 	  	| valueUserID | valuePassword | expectedMessage 						| button 	|
		  | TC1 	   | name   		| Amy        	  				| +1234567890     | example@example.com	| user1	  	  | Secur3P@ssw	  | Form submitted successfully!     		| Submit 	|
		  | TC2 	   | name   		| Christopher Johnson Smith   	| +1234567890     | example@example.com | user1	  	  | Secur3P@ssw	  | Form submitted successfully!     		| Submit 	|
		  | TC3 	   | name   		| Christopher Johnson-Smith  	| +1234567890     | example@example.com | user1	  	  | Secur3P@ssw	  | Please match the requested format.     	| Submit 	|
		  | TC4 	   | name   		| Jo        	  				| +1234567890	  | example@example.com | user1	  	  | Secur3P@ssw	  | Please match the requested format.     	| Submit 	|
		  | TC5 	   | name   		| Alexandra Mary Windsor Simon	| +1234567890 	  | example@example.com | user1	  	  | Secur3P@ssw	  | Please match the requested format.     	| Submit 	|
		  | TC6 	   | phoneNumber	| Amy        	  				| +1234567890     | example@example.com	| user1	  	  | Secur3P@ssw	  | Form submitted successfully!     		| Submit 	|
		  | TC7 	   | phoneNumber	| Amy        	  				| 012345678		  | example@example.com | user1	  	  | Secur3P@ssw	  | Form submitted successfully!     		| Submit 	|
		  | TC8 	   | phoneNumber	| Amy        	  				| 123456789       | example@example.com | user1	  	  | Secur3P@ssw	  | Please match the requested format.     	| Submit 	|
		  | TC9 	   | phoneNumber	| Amy        	  				| 1234567	  	  | example@example.com | user1	  	  | Secur3P@ssw	  | Please match the requested format.     	| Submit 	|
		  | TC10 	   | phoneNumber	| Amy        	  				| +12345678901234 | example@example.com | user1	  	  | Secur3P@ssw	  | Please match the requested format.     	| Submit 	|
		  | TC11 	   | email			| Amy        	  				| +1234567890	  | example@example.com | user1	  	  | Secur3P@ssw	  | Form submitted successfully!	     	| Submit 	|
		  | TC12 	   | email			| Amy        	  				| +1234567890	  | 1111@ds.cd			| user1	  	  | Secur3P@ssw	  | Form submitted successfully!	     	| Submit 	|
		  | TC21 	   | password		| Amy        	  				| +12345678901234 | example@example.com | user1	  	  | P@ss		  | Form submitted successfully!	     	| Submit 	|
