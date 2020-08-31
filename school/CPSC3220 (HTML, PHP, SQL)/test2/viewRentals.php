<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	11/25/19
		Purpose: test 2 rentals
					
-->
<html>
<head>
	<title>Data Generator</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>
	<form action="tasks.html">
         <button type="submit">Back to Tasks Page</button>
    </form>
	<br>
	<br>
	<br>
	<?php
        
		define("RENTAL_AMOUNT", 16044);
		
       $mysqli = new mysqli("localhost", "root", "", "sakila");
        if($mysqli->connect_error) {
          exit('Error connecting to database'); //Should be a message a typical user could understand in production
        }
        mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
		
		//run the sql
        $mysqli->set_charset("utf8mb4");
        $stmt = $mysqli->prepare("select first_name, last_name, title, i.inventory_id, rental_date, return_date
			from customer c, film f, inventory i, rental r
			where c.customer_id = r.customer_id and
			r.inventory_id = i.inventory_id and
			i.film_id = f.film_id
			order by last_name;");
        $stmt->execute();
        $result = $stmt->get_result();
        if($result->num_rows === 0) exit('No rows');
        	
		//make the column headers		
        print("<h1>Rentals</h1>");
        print("<table border='1'>");
        print("<tr><th>First Name</th><th>Last Name</th><th>Title</th><th>Inventory ID</th><th>Rental Date</th><th>Return Date</th></tr>");
        
		//put the results in an associative array
        $i = 0;
        while($row = $result->fetch_assoc()) {
          $rental_info[$i][] = $row['first_name'];
          $rental_info[$i][] = $row['last_name'];
		  $rental_info[$i][] = $row['title'];
		  $rental_info[$i][] = $row['inventory_id'];
		  $rental_info[$i][] = $row['rental_date'];
		  $rental_info[$i][] = $row['return_date'];
          $i++;
        } 
		
		$stmt->close();
        $mysqli->close();
		
		//display results
		$i = 0;
		while($i < RENTAL_AMOUNT) 
		{	
			print ("<tr><td>".$rental_info[$i][0]."</td><td>".$rental_info[$i][1]."</td><td>".$rental_info[$i][2]."</td><td>".$rental_info[$i][3]."</td>
				<td>".$rental_info[$i][4]."</td><td>".$rental_info[$i][5]."</td></tr>");
			$i++;
		}		

     
        
	?>