<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	11/25/19
		Purpose: test 2 films
					
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
        
		
       $mysqli = new mysqli("localhost", "root", "", "sakila");
        if($mysqli->connect_error) {
          exit('Error connecting to database'); //Should be a message a typical user could understand in production
        }
        mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
		
		//run the sql
        $mysqli->set_charset("utf8mb4");
        $stmt = $mysqli->prepare("select title, description, rental_duration, rental_rate, length, name as category, (select count(inventory_id)
		from inventory i
		where i.film_id = f.film_id) as film_count
		from film f, category c, film_category fc
		where f.film_id = fc.film_id and
		fc.category_id = c.category_id 
		order by title;");
        $stmt->execute();
        $result = $stmt->get_result();
        if($result->num_rows === 0) exit('No rows');
        	
		//make the column headers		
        print("<h1>Films</h1>");
        print("<table border='1'>");
        print("<tr><th>Title</th><th>Description</th><th>Rental Duration</th><th>Rental Rate</th><th>Length</th><th>Category</th><th>Film Count</th></tr>");
        
		//put the results in an associative array
        $i = 0;
        while($row = $result->fetch_assoc()) {
          $film_info[$i][] = $row['title'];
          $film_info[$i][] = $row['description'];
		  $film_info[$i][] = $row['rental_duration'];
		  $film_info[$i][] = $row['rental_rate'];
		  $film_info[$i][] = $row['length'];
		  $film_info[$i][] = $row['category'];
		  $film_info[$i][] = $row['film_count'];
          $i++;
        } 
		
		$stmt->close();
        $mysqli->close();
		
		//display results
		$j = 0;
		while($j < $i) 
		{	
			print ("<tr><td>".$film_info[$j][0]."</td><td>".$film_info[$j][1]."</td><td>".$film_info[$j][2]."</td><td>".$film_info[$j][3]."</td>
				<td>".$film_info[$j][4]."</td><td>".$film_info[$j][5]."</td><td>".$film_info[$j][6]."</td></tr>");
			$j++;
		}		

     
        
	?>