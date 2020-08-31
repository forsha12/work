<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	11/11/19
		File:	add_film.php
		Purpose: hw8 
-->

<html>
<head>
	<title>Add Film</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>

	<form action="manager.html">
         <button type="submit">Back to Manager Page</button>
    </form>

<?php

$server = "localhost";
$user = "root";
$pw = "";
$db = "sakila";

//create a new connection to the database
$mysqli = new mysqli($server, $user, $pw, $db);
if($mysqli->connect_error) {
  exit('Error connecting to database'); //Should be a message a typical user could understand in production
}
mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
$mysqli->set_charset("utf8mb4");

//grab the info from the $_POST array
$title = $_POST['title'];
$description = $_POST['description'];
$release_year = $_POST['release_year'];
$language_id = $_POST['language_id'];
$rental_duration = $_POST['rental_duration'];
$rental_rate = $_POST['rental_rate'];
$length = $_POST['length'];
$replacement_cost = $_POST['replacement_cost'];
$rating = $_POST['rating'];
$special_features = $_POST['special_features'];


$stmt = $mysqli->prepare("INSERT INTO sakila.film(title,description,release_year,language_id,rental_duration,rental_rate,length,replacement_cost,rating,special_features) 
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

$stmt->bind_param("ssiiididss", $title, $description, $release_year, $language_id, $rental_duration, $rental_rate, $length, $replacement_cost, $rating, $special_features);

$stmt->execute(); //submit query to SQL server
$result = $stmt->get_result();  //get the result

if($stmt->affected_rows === 0) {
    exit('No rows updated');
} else {
	print("	<h1>ADD A NEW FILM RECORD</h1>");
	print ("<p>The following record was added to the film table:</p>");
	print("<table border='0'>
			<tr><td>TITLE</td><td>$title</td></tr>
			<tr><td>DESCRIPTION</td><td>$description</td></tr>
			<tr><td>RELEASE YEAR</td><td>$release_year</td></tr>		
			<tr><td>LANGUAGE ID</td><td>$language_id</td></tr>
			<tr><td>RENTAL DURATION</td><td>$rental_duration</td></tr>
			<tr><td>RENTAL RATE</td><td>$rental_rate</td></tr>
			<tr><td>LENGTH</td><td>$length</td></tr>
			<tr><td>REPLACEMENT COST</td><td>$replacement_cost</td></tr>		
			<tr><td>RATING</td><td>$rating</td></tr>
			<tr><td>SPECIAL FEATURES</td><td>$special_features</td></tr>
			</table>");
}

// close the connection
$stmt->close();  
        
$mysqli->close();
         
 
?>
</body>
</html>