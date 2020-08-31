<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	09/16/2019
		File:	updateInfo.php
		Purpose: Read in information sent from the userInfo.html form. Validate the info brought in. If data is incorrect, display message and link 
		back to html form. Once data is correct, send information to userInfo.txt. This file must be read in, and the data must be resorted by
		lastNames in alphabetical order.
		
		Used https://stackoverflow.com/questions/9351306/how-to-check-if-a-php-string-contains-only-english-letters-and-digits for help with validation checking.
		
		
		Note: can't figure out how to get this to work if there's nothing in the userInfo.txt file. Works just fine when there's content.
				Would love advice on that, but if I look at this any more I'm going to have a breakdown.
-->
<html>
<head>
	<title>USER REPORT</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>

	<?php
	//first, read in data sent.
	$firstName = $_POST['firstName'];
	$lastName = $_POST['lastName'];
	$phone = $_POST['phone'];
	$email = $_POST['email'];
	
	//set a boolean for data validation
	$error = FALSE;
	
	//now data validate.
	//first name must be 1-20 characters long and only LETTERS
	if (strlen($firstName) < 1 || strlen($firstName) > 20)
	{ 
		$error = TRUE;
	}
	for ($i = 0; $i < strlen($firstName); $i++)
	{
		if (!preg_match('/^[A-Za-z]/', $firstName[$i]))
		{
			$error = TRUE;
		}
	}

	
	//last name must be 1-20 characters long and only LETTERS
	if (strlen($lastName) < 1 || strlen($lastName) > 20)
	{ 
		$error = TRUE;
	}
	if (!preg_match('/^[A-Z]/', $lastName[$0])) //makes sure first letter is capital for sort
		{
			$error = TRUE;
		}
	for ($i = 0; $i < strlen($lastName); $i++)
	{
		if (!preg_match('/^[A-Za-z]/', $lastName[$i]))
		{
			$error = TRUE;
		}
	}
	
	//phone number must be xxx-xxx-xxxx where the x's are digits and the -'s are -. length must be 12
	if (strlen($phone) != 12)
	{ 
		$error = TRUE;
	}
	
	for ($i = 0; $i < strlen($phone); $i++)
	{
		if($i != 3 && $i != 7) //digit checker
		{
			if(!preg_match('/^[0-9]/', $phone[$i]))
				{
					$error = TRUE;
				}
		}
		else //character 3 and 7 MUST be a dash
		{
			if($phone[$i] != "-")
			{
				$error = TRUE;
			}
		}
	}
	
	//finally checking email.
	//lettersNumbers@letters.com or .edu is the proper format for these. Length max of 30
	if (strlen($email) < 1 || strlen($email) > 30)
	{ 
		$error = TRUE;
	}
	
	$counter = 0;
	while($email[$counter] != "@" && $counter < 30) //check for letters and numbers until the @. make sure it can end
	{
		if (!preg_match('/^[A-Za-z0-9]/', $email[$counter]))
		{
			$error = TRUE;
		}
		$counter++;
	}
	//going through the last loop without an error means that the next character IS an @. add one to counter to account for it
	//check to make SURE the symbol was found
	if($email[$counter] != "@")
	{
		$error = TRUE;
	}
	$counter++;
	//now check until a "." happens
	while($email[$counter] != "." && $counter < 26) //check for letters and numbers until the @. make sure it can end (has to be at least 4 characters for the end)
	{
		if (!preg_match('/^[A-Za-z]/', $email[$counter]))
		{
			$error = TRUE;
		}
		$counter++;
	}
	//going through the last loop without an error means that the next character IS a ".". add one to counter to account for it
		if($email[$counter] != ".")
	{
		$error = TRUE;
	}
	$counter++;
	//check to make SURE the symbol was found
	//check last bit to make sure it ends in edu or com
	if(substr($email, -3) != "com" && (substr($email, -3) != "edu"))
	{
		$error = TRUE;
	}
		
		
	
	
	//if anything went wrong along the way, this error message will display
	if($error == TRUE)
	{
		print("<p>AN ERROR HAS OCCCURED. PLEASE PUT VALID DATA IN. TRY AGAIN.</p>");
		print("<p><a href=\"userInfo.html\">Return to submittal form.</a></p>");	
	}
	else
	{
		print("<p>Data Submitted.</p>");
		
		$userFile =fopen("userInfo.txt","r"); //getting our last names
		
		
		while (!feof($userFile)) 
		{
            $user = fgets($userFile); //read a user (one line)
            $user = str_replace(array("\n", "\r"), '', $user);  //remove newlines
			$user = explode(":",$user); //splits up each line bc of colon delimiter
			if(!feof($userFile) && (sizeof($user) == 4))
			{
				$users[] = $user;
			}	
        }
		$users[sizeof($users)-1] = str_replace(array("\n", "\r"), '', 
                    $users[sizeof($users)-1]);
		
		//gotten a users array that is an array of arrays
		fclose($userFile);
		
		//now add new information to this array
		$user = array($lastName, $firstName, $phone, $email);
		$users[] = $user;
					
		sort($users); //sorting Users in alpabetical order. as the "key" is last name, which is
					 //the first value, it will be correctly sorted. we are assuming nobody has the same last name
 
		$tLName = array();
		$tFName = array();
		$tPhone = array();
		$tEmail = array();
		
		//putting our info into a printable format
		for($i = 0; $i < sizeof($users); $i++)
		{
			if($users[$i] != NULL)
			{	
				array_push($tLName, $users[$i][0]); 
				array_push($tFName, $users[$i][1]); 
				array_push($tPhone, $users[$i][2]); 
				array_push($tEmail, $users[$i][3]); 
			}	
		}	

		
		//now that it's organized, we need to print it in a table
		
		print("<table border = '3' cellpadding = '3'><tr>");
	    for($i = 0; $i < sizeof($users); $i++) 
		{ //for rows
			print("<tr>");
			print("<td>$tLName[$i]</td>");
			print("<td>$tFName[$i]</td>");
			print("<td>$tPhone[$i]</td>");
			print("<td>$tEmail[$i]</td>");
			print("</tr>");
		}
		print("</table>");
		
		//now lets write this sorted information to a file
		$writeFile = fopen("userInfo.txt","w") or die("Unable to open file!");
		for($i = 0; $i < sizeof($users); $i++) 
		{
			$writeLine = implode(":", $users[$i]); //here we have one line of the file ready to be written
			$writeLine.="\n"; //add new line
		
			fwrite($writeFile, $writeLine); //write this line to a file
		}
		fclose($writeFile);
		
	}

	
	?>
</body>
</html>