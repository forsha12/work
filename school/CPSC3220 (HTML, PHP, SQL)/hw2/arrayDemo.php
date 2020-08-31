<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	9/5/19
		File: arrayDemo.php
		Purpose: HW 2
-->
<html>
<head>
	<title>Table Calculator - RESULTS</title>
	
</head>

<body>

<?php
	//variables
	$rows = $_POST['rows'];
	$cols = $_POST['cols'];
    $max = $_POST['max'];
	$min = $_POST['min'];
	
    print("<p> Number of rows = $rows<br>Number of cols = $cols</p>");
	print("<p> Minimum = $min<br>Maximum = $max</p>");
    
    
    //creating the data
    for($i = 0; $i < $rows; $i++) {
        for($j = 0; $j < $cols; $j++) {
            $data[$i][$j] = rand($min,$max); 
        }
    }
    
	//printing the original table
	print("<table border = '3'>");
    for($i = 0; $i < $rows; $i++) { //for rows
        print("<tr>");
        for($j = 0; $j < $cols; $j++) { //for columns
            print("<td align='center'>".$data[$i][$j]."</td>");
            //or
            //$temp = $data[$i][$j];
            //print("<td align='right'>$temp</td>");
        }
        print("</tr>");
    }
    print("</table>");
	
	print("<p></p>");
	print("<p></p>");
	
	//second table, math happens here
	
	//variables for easy print
 	$sum = array_fill(0, $rows, NULL);
	$avg = array_fill(0, $rows, NULL);
	$sqdDif = array_fill(0, $rows, NULL);
	$stdDev = array_fill(0, $rows, NULL);
	
	
	//calculating sum
	for($i = 0; $i < $rows; $i++) {
		for($j = 0; $j < $cols; $j++) {
			$sum[$i] += $data[$i][$j]; //for each row, adds all columns together
		}
	}
	   
	
	//calculating avg (only have to go through and do it for each row)
	for($i = 0; $i < $rows; $i++) {
		$avg[$i] = $sum[$i] / $cols;
	}
	
	//get the sum of (number in column - average of the row)^2, this is for Standard Dev
	for($i = 0; $i < $rows; $i++) {
		for($j = 0; $j < $cols; $j++) {
			$sqdDif[$i] += (pow(($data[$i][$j] - $avg[$i]), 2));
		}	
	}
	
	//calculating standard deviation (only have to go through and do it for each row)
	for($i = 0; $i < $rows; $i++) {
		$stdDev[$i] = $sqdDif[$i] / $cols;
	}
	
		//first a header for the table
	print("<table border = '3'><tr>");
		print("<th>ROW</th>");
        print("<th>SUM</th>");
		print("<th>AVG</th>");
		print("<th>STD DEV</th>");
    print("</tr>");
	
    for($i = 0; $i < $rows; $i++) { //for each row
        print("<tr>");
		print("<td>".$i."</td>");
		print("<td>".$sum[$i]."</td>");
		print("<td>".number_format($avg[$i], 3)."</td>");
		print("<td>".number_format($stdDev[$i], 3)."</td>");
        print("</tr>");
    }
    print("</table>");
	
	print("<p></p>");
	print("<p></p>");
	
	//third table, positive or negative?
	//each column has a column directly under it saying if number is + or -
	
	//making a two dimensional array with the signage of each number to go along with the original data
    for($i = 0; $i < $rows; $i++) { //for rows
        for($j = 0; $j < $cols; $j++) { //for columns
			if($data[$i][$j] == 0) {
				$signage[$i][$j] = "zero";
			}	
			elseif($data[$i][$j] < 0) {
				$signage[$i][$j] = "negative";
			}	
			else {
				$signage[$i][$j] = "positive";
			}		
        }
    }
	
	
	print("<table border = '3'>");
	
	
		for($i = 0; $i < ($rows); $i++) { //for rows
			print("<tr>");
			for($j = 0; $j < $cols; $j++) { //for columns
				   print("<td align='center'>".$data[$i][$j]."</td>");
			}
			print("</tr>");
			print("<tr>");
			for($j = 0; $j < $cols; $j++) { //for columns
				   print("<td align='center'>".$signage[$i][$j]."</td>");
			}
			print("</tr>");
		}
	
    print("</table>");
	print("<br>");

	
	

?>
<br>
<p><a href="arrayDemo.html">Click to return.</a></p>

</body>
</html>