<!DOCTYPE html>
<!--	Author: Paige Forsha 
		Date:	12/1/19
		File:	writeFilms.html
		Purpose: Task 1 of final
		
-->
<html>
<head>
	<title>Data Generator</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>
<p>File films.txt has been written to.</p>
<br>
<br>

	<?php
        $film_titles_fixed = array(array());
		$count_per_category = array();
		$counter = 1;
		while($counter < 17) //categories are 1-16
		{
			$mysqli = new mysqli("localhost", "root", "", "sakila");
			if($mysqli->connect_error) {
				exit('Error connecting to database'); //Should be a message a typical user could understand in production
			}
			mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
			
			//run the sql, does a diff cat id for each
			$mysqli->set_charset("utf8mb4");
			$stmt = $mysqli->prepare("select title
				from film f, film_category fc
				where fc.film_id = f.film_id and
				fc.category_id = ?;");
			$stmt->bind_param("i", $counter);
			$stmt->execute();
			$result = $stmt->get_result();
			if($result->num_rows === 0) exit('No rows');
			
			//put the results in an associative array
			$i = 0;
			$film_titles = [];
			while($row = $result->fetch_row())
			{
				$film_titles[] = $row;
			}
			$stmt->close();
			$mysqli->close();
			
			$k = 0;
			while($k < sizeOf($film_titles))
			{	
				$film_titles_fixed[$counter-1][$k] = $film_titles[$k][0];
				$k++;
			}
			//count per each cat
			$count_per_category[] = sizeOf($film_titles);
			
			$counter++;
		}
			$category = array("Action", "Animation", "Children", "Classics", "Comedy",
							"Documentary", "Drama", "Family", "Foreign", "Games", "Horror",
							"Music", "New", "Sci-Fi", "Sports", "Travel");
		
					//make the column headers		
			print("<h1>Films</h1>");
			print("<table border='1'>");
			print("<tr><th>Category</th><th>Number of Films</th><th>List of Movies</th></tr>");
			
			$i = 0;
			while($i < 16)
			{
				print("<tr><td>".$category[$i]."</td><td>".$count_per_category[$i]."</td>");
				$k = 0;
				print("<td>");
				while($k < $count_per_category[$i])
					{
						if($k != $count_per_category[$i] - 1)
							print($film_titles_fixed[$i][$k].", ");
						else
							print($film_titles_fixed[$i][$k]."");
						$k++;
					}
				print("</td></tr>");
				$i++;
			} 

		//write to file
		$myfile = fopen("films.txt", "w") or die("Unable to open file!");
		$i = 0;
		while($i < 16)
		{
		$txt = $category[$i].":".$count_per_category[$i].":";
			$k = 0;
			while($k < $count_per_category[$i])
					{
						if($k != $count_per_category[$i] - 1)
							$txt .= $film_titles_fixed[$i][$k].", ";
						else
							$txt .= $film_titles_fixed[$i][$k]."";
						$k++;
					}
		$txt .= ";\n";	
		$i++;
		fwrite($myfile, $txt);
		}
		fclose($myfile);
			
			
        
	?>