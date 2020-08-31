<!DOCTYPE html>
<!--	Author: Schwab
		Date:	August 29, 2019
		File:	
		Purpose:PHP Practice
-->
<html>
<head>
	<title>Table Calculator - RESULTS</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>
<?php
	$rows = $_POST['rows'];
	$cols = $_POST['cols'];
    
    print("<p> Number of rows = $rows<br>Number of cols = $cols</p>");
    
    //let's place data into a 2D array, then we will print it in a nice table.
    
    
    for($i = 0; $i < $rows; $i++) {
        for($j = 0; $j < $cols; $j++) {
            //note the syntax below for a "push" operation
            //we are pushing data on to the array
            //first for row 0 we push all the columns,
            //then row 1, push a new value each time through this inner loop.
            $data[$i][] = rand(0,20); //value between 0,20, inclusive
            //the following will work as well:
            //$data[$i][$j] = rand(0,20);
        }
    }
    
    //use this sequence to print pre formatted data - use print_r function 
    print("<pre>"); //for debugging
    print_r($data);
    print("</pre>");
    
    //now we need to print a table with our values:
    //either of the next two lines will work for the table tag in html
    //print("<table border = \"3\"><tr>");
    print("<table border = '3'><tr>");
    for($i = 0; $i < $cols; $i++) {
        print("<th>$i</th>");
    }
    print("</tr>");
    
    for($i = 0; $i < $rows; $i++) { //for rows
        print("<tr>");
        for($j = 0; $j < $cols; $j++) { //for columns
            print("<td align='right'>".$data[$i][$j]."</td>");
            //or
            //$temp = $data[$i][$j];
            //print("<td align='right'>$temp</td>");
        }
        print("</tr>");
    }
    
    
    
    
    
    print("</table>");

?>
</body>
</html>