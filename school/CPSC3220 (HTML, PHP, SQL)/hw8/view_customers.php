<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	11/12/2019
		Purpose:Generate SQL script to populate database with values
		
		NOTE: Probably overcomplicated it but I could not get the rented movies part to work. I commented it out so it didn't
				break everything else. Please look at it and see if you can figure out what I did wrong. 
				I think I just don't understand the mysqli commands and how they work, which I did try to look up... but
				my research didn't help me understand. Line 98 seems to be the issue, but I can't figure out why $titles[$j] is 
				an array and not the value at $j in the $titles array.
				
				
				
-->
<html>
<head>
	<title>Data Generator</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>
	<form action="manager.html">
         <button type="submit">Back to Manager Page</button>
    </form>
	<br>
	<br>
	<br>
	<?php
        
		define("CUSTOMER_AMOUNT", 599);
		
       $mysqli = new mysqli("localhost", "root", "", "sakila");
        if($mysqli->connect_error) {
          exit('Error connecting to database'); //Should be a message a typical user could understand in production
        }
        mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
        $mysqli->set_charset("utf8mb4");
        //The ? below is a placeholder
        $stmt = $mysqli->prepare("select first_name, last_name, address, city, district, postal_code from customer c, address a, city ci
			where c.address_id = a.address_id and a.city_id = ci.city_id order by last_name;");
        //We now bind the ? to actual values ... in quotes we 
        //show we want to format as a string
        $stmt->execute();
        $result = $stmt->get_result();
        if($result->num_rows === 0) exit('No rows');
        	
				
        print("<h1>Customers</h1>");
        print("<table border='1'>");
        print("<tr><th>First Name</th><th>Last Name</th><th>Address</th><th>City</th><th>District</th><th>Postal Code</th><th>Movies Rented</th></tr>");
        
        $i = 0;
        while($row = $result->fetch_assoc()) {
          $customer_info[$i][] = $row['first_name'];
          $customer_info[$i][] = $row['last_name'];
		  $customer_info[$i][] = $row['address'];
		  $customer_info[$i][] = $row['city'];
		  $customer_info[$i][] = $row['postal_code'];
		  $customer_info[$i][] = $row['district'];
          $i++;
        } //this is all the first part of the information needed
		
		$stmt->close();
		
		/*
		$stmt = $mysqli->prepare("select distinct customer_id from customer;");
		$stmt->execute();
        $result = $stmt->get_result();
		while($row = $result->fetch_row())
		{
			$cust_id[] = $row;
		}	
		$stmt->close(); //getting customer ids so we can put them into the next query one by one
 
		$stmt = $mysqli->prepare("select title from customer c, rental r, film f, inventory i where c.customer_id = ? and
			r.customer_id = c.customer_id and
			i.inventory_id = r.inventory_id and
			f.film_id = i.film_id
			order by title;"); //this is where we'll find the titles of each movie rented per person
			
		
		$i = 0;
		while($i < CUSTOMER_AMOUNT)
		{
			$rented = "";
			$titles[] = NULL;
			$stmt->bind_param("i", $cust_id[$i]);
			$stmt->execute();
			$result = $stmt->get_result();
			
			while($row = $result->fetch_row())
			{
				$titles[] = $row;
			} //getting each title for that customer
			
			$j = 0;
			
			
			while($j < count($titles))
			{
				$rented .= $titles[$j].", ";
				$j++;
			} //putting all the array values into a string
			
			$customer_info[$i][] = $rented;
			$i++;
			
		}	//getting all the titles for each customer and then putting them in a string	
		//then put them into the customer info array at the end
		
		*/
        $mysqli->close();
		
		$i = 0;
		while($i < CUSTOMER_AMOUNT) 
		{	
			print ("<tr><td>".$customer_info[$i][0]."</td><td>".$customer_info[$i][1]."</td><td>".$customer_info[$i][2]."</td><td>".$customer_info[$i][3]."</td>
				<td>".$customer_info[$i][4]."</td><td>".$customer_info[$i][5]."</td></tr>");
			$i++;
		}		
		//add the below line to the print statement before the </tr> if the rented movies section works
		//<td>".$customer_info[$i][6]."</td>
		
       // print("<pre>");
       // print_r($customer_info);
       // print("</pre>");
     
        
	?>
</body>
</html>