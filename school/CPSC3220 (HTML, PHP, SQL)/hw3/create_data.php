<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	09/16/2019
		File:	create_data.php
		Purpose: Read in first names and last names and create 25 unique ones. Then, create 25 unique addresses by reading in street 
					names and street types. Then take the names generated and make an email address by adding the read in domain
					names to them.
-->
<html>
<head>
	<title>Names REPORT</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>

	<?php
	
		//!!!!!!note to self: variables i will need in final table: fullNames, emailNames, addresses!!!!!
        
       //first name file is comma delimited
		$namesFile = fopen("first_names.csv","r");
        
        $names = fgets($namesFile); //file is all on one line, this reads the whole file in
        fclose($namesFile);
        
        $firstNames = explode(",",$names); //getting our firstNames array
        
		$firstNames[sizeof($firstNames)-1] = str_replace(array("\n", "\r"), '', 
                    $firstNames[sizeof($firstNames)-1]);  //remove newlines
        //checking first names
        print("<p>FIRST NAMES</p>");
        print("<pre>");
        print_r($firstNames);
        print("</pre>"); 
		
		
        
		$namesFile =fopen("last_names.txt","r"); //getting our last names
        
        while (!feof($namesFile)) {
            $name = fgets($namesFile); //read a name (one line)
            $name = str_replace(array("\n", "\r"), '', $name);  //remove newlines
            if(!feof($namesFile)) {
                $lastNames[] = $name; //
                //print("<p>$words[$word], $word</p>");				
			}
        }
		fclose($namesFile);
       
        //check the last names
		print("<p>LAST NAMES</p>");
		print("<pre>");
        print_r($lastNames);
        print("</pre>");
		
		//they're good. combine them to make 25 unique names
		//get the fullName array
		$fullNames = array();
		for($i = 0; $i < 25; $i++) { //generate 25 names
            $firstInd = rand(0, sizeof($firstNames)-1); //random index into firstNames array
            $lastInd = rand(0, sizeof($lastNames)-1); //random index into lastNames array
            $fullName = $firstNames[$firstInd]." ".$lastNames[$lastInd]; //make a name with space in middle
            while(in_array($fullName, $fullNames)) {//while this name already exists in array (While we have a duplicate - keep trying) 
                $firstInd = rand(0, sizeof($firstNames)-1); 
                $lastInd = rand(0, sizeof($lastNames)-1);
                //make a new name
                $fullName = $firstNames[$firstInd]." ".$lastNames[$lastInd];
            }
            //now we have a new unique name - save it in the array
            $fullNames[] = $fullName;
        }
		
		//lets get the emails out of the way. format = First.Last@random.com
		//make a new array just for the full names with a dot
		$emailNames = array();
		
		$emailNames = str_replace(" ", ".", $fullNames);
		
		print("<p>Full names:</p>");
		print("<pre>");
        print_r($fullNames);
        print("</pre>");
		
		print("<p>Email names:</p>"); //check to make sure it works
		print("<pre>");
        print_r($emailNames);
        print("</pre>");		
		
		//now read in the domain stuff so we can combine it with the names
		$domainsFile = fopen("domains.txt","r");
        
        $domains = fgets($domainsFile); //file is all on one line, this reads the whole file in
        fclose($domainsFile);
        
        $domainStuff = explode(".",$domains); //getting our domainStuff array, delimited with . -- must be fixed later
        
		$domainStuff[sizeof($domainStuff)-1] = str_replace(array("\n", "\r"), '', 
                    $domainStuff[sizeof($domainStuff)-1]);  //remove newlines
					
		//read that in. now need to recombine the "gmail" with the "com" and so on
		$emailEnd = array();
		$sign = '.';
		$count = 0; //so emailEnd has 0-whatever index and doesn't skip by 2
		for($i = 0; $i < sizeof($domainStuff); $i++) {
			$emailEnd[$count] = $domainStuff[$i]."".$sign."".$domainStuff[$i + 1];
			$i++; //so it goes by 2
			$count++;
		}
		
		print("<p>Email enders:</p>"); //check to make sure it works
		print("<pre>");
        print_r($emailEnd);
        print("</pre>");	
		
		//combine emailNames with emailEnd
		for($i = 0; $i < sizeof($emailNames); $i++) {
			$endIndex = rand(0, sizeof($emailEnd)-1); //get random email ender
			$emailNames[$i] = $emailNames[$i]."@".$emailEnd[$endIndex]; 
		}
        
		print("<p>Emails complete:</p>"); //check to make sure it works
		print("<pre>");
        print_r($emailNames);
        print("</pre>");
		
		//finally, need to read in street names and street types. then combine them like i did the first and last names to create 25 unique ones
		$streetFile =fopen("street_names.txt","r"); //getting our last names
        
		$streetNames = array();
        while (!feof($streetFile)) {
            $street = fgets($streetFile); //read a name (one line)
            $street = str_replace(array("\n", "\r"), '', $street);  //remove newlines
			$street = explode(":",$street); //splits up each line bc of colon delimiter
            if(!feof($streetFile)) {
                for($i = 0; $i < sizeof($street); $i++) { //this will put each line together into one array
					array_push($streetNames, $street[$i]);
				}; //
                //print("<p>$words[$word], $word</p>");				
			}
        }
		fclose($streetFile);
		
		print("<p>Street names:</p>"); //check to make sure it works
		print("<pre>");
        print_r($streetNames);
        print("</pre>");
		
		//last file: street types
		$streetFile = fopen("street_types.txt","r");
        
        $streetT = fgets($streetFile); //file is all on one line, this reads the whole file in
        fclose($streetFile);
        
        $streetTypes = explode("..;",$streetT); //getting our streetTypes array
        
		$streetTypes[sizeof($streetTypes)-1] = str_replace(array("\n", "\r"), '', 
                    $streetTypes[sizeof($streetTypes)-1]);  //remove newlines
					
		print("<p>Street types:</p>"); //check to make sure it works
		print("<pre>");
        print_r($streetTypes);
        print("</pre>");			
		
		//lets make addresses
		$addresses = array();
		for($i = 0; $i < 25; $i++) { //generate 25 addresses
            $strName = rand(0, sizeof($streetNames)-1); //random index into streetNames array
            $strType = rand(0, sizeof($streetTypes)-1); //random index into streetTypes array
			$strNum = rand(0, 1000);
            $address = $strNum." ".$streetNames[$strName]." ".$streetTypes[$strType]; //make a name with street number
            while(in_array($address, $addresses)) { //while this name already exists in array (While we have a duplicate - keep trying) 
                $strName = rand(0, sizeof($firstNames)-1); 
                $lastInd = rand(0, sizeof($streetTypes)-1);
                //make a new name
                $fullName = $strNum." ".$streetNames[$strName]." ".$streetTypes[$strType];
            }
            //now we have a new unique name - save it in the array
            $addresses[] = $address;
        }
		
		print("<p>ADDRESSES:</p>"); //check to make sure it works
		print("<pre>");
        print_r($addresses);
        print("</pre>");
		
		//ALL FILES READ IN. NOW SLAP THEM TOGEHTER TO MAKE A TABLE AND ALSO WRITE INFO TO A FILE CALLED CUSTOMERS.TXT
		//DO TABLE FIRST
		//!!!!!!reminder to self: variables i will need in final table: fullNames, emailNames, addresses!!!!!
		
		print("<table border = '3' cellpadding = '3'><tr>");
        print("<th>First Name</th>");
		print("<th>Last Name</th>");
		print("<th>Address</th>");
		print("<th>Email</th>");
		print("</tr>");
    
	
	
	    for($i = 0; $i < 25; $i++) { //for rows
			$splitName = explode(" ",$fullNames[$i]); //splits up first and last name for printing into table
			print("<tr>");
			print("<td>$splitName[0]</td>");
			print("<td>$splitName[1]</td>");
			print("<td>$addresses[$i]</td>");
			print("<td>$emailNames[$i]</td>");
			print("</tr>");
    }
		print("</table>");
		
	//final step, write this to a file
	
	$writeFile = fopen("customers.txt","w") or die("Unable to open file!");
	for($i = 0; $i < 25; $i++) {
		$writeArray = array();
		$splitName = explode(" ",$fullNames[$i]);
		array_push($writeArray, $splitName[0], $splitName[1], $addresses[$i], $emailNames[$i]);
		
		$writeLine = implode(":", $writeArray); //here we have one line of the file ready to be written
		$writeLine.="\n"; 
		
		fwrite($writeFile, $writeLine); //write this line to a file
	}
	fclose($writeFile);

	
	?>
</body>
</html>