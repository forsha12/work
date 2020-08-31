<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	12/2/2019
		File:	sha.php
		Purpose: read in files given, create data structures for them, search through to find value given by user
					task 2 final 
-->
<html>
<head>
	<title>SHA Lookup</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>
		<h1>SHA Lookup</h1>
		
		<form action="sha.php" method = "post">
		<p>Enter hash value:
		<input type = "text" size = "20" name = "searched">
		</p>
		<p>
			
         <button type="submit">Search</button>
		</form>
		
		</p>
<body>

<?php
	$searched = $_POST['searched'];


	/*pull information from each file*/
	//sha1
	$passwordFile = fopen("sha1_list.txt","r");
	$sha1Length = 0;
	$sha1 = array(array());
	while (!feof($passwordFile)) {
            $line = fgets($passwordFile); //read one line
            $line = str_replace(array("\n", "\r"), '', $line);  //remove newlines
            if(!feof($passwordFile)) {
                $sha1[$sha1Length] = explode(":",$line); 
                $sha1Length++;			
			}
        }
		fclose($passwordFile);
	
	//sha224
		$passwordFile = fopen("sha224_list.txt","r");
	$sha224Length = 0;
	$sha224 = array(array());
	while (!feof($passwordFile)) {
            $line = fgets($passwordFile); //read one line
            $line = str_replace(array("\n", "\r"), '', $line);  //remove newlines
            if(!feof($passwordFile)) {
                $sha224[$sha224Length] = explode(":",$line); 
                $sha224Length++;			
			}
        }
		fclose($passwordFile);

	//sha256
		$passwordFile = fopen("sha256_list.txt","r");
	$sha256Length = 0;
	$sha256 = array(array());
	while (!feof($passwordFile)) {
            $line = fgets($passwordFile); //read one line
            $line = str_replace(array("\n", "\r"), '', $line);  //remove newlines
            if(!feof($passwordFile)) {
                $sha256[$sha256Length] = explode(":",$line); 
                $sha256Length++;			
			}
        }
		fclose($passwordFile);
		
		
	/*all three are collected. now, do the search*/
		$type = "";
		$pw = "";
		$found = FALSE;
		$i = 0;
		//search through sha1
		while($i < $sha1Length && !$found)
		{
			if($searched == $sha1[$i][1])
			{
				$found = TRUE;
				$type = "SHA-1";
				$pw = $sha1[$i][0];
			}
			$i++;
		}
		
		//search through sha224
		$i = 0;
		while($i < $sha224Length && !$found)
		{
			if($searched == $sha224[$i][1])
			{
				$found = TRUE;
				$type = "SHA-224";
				$pw = $sha224[$i][0];
			}
			$i++;
		}
		
		//search through sha256
		$i = 0;
		while($i < $sha256Length && !$found)
		{
			if($searched == $sha256[$i][1])
			{
				$found = TRUE;
				$type = "SHA-256";
				$pw = $sha256[$i][0];
			}
			$i++;
		}
		
		
		
	//print statement
	if($found)
	{
		print("<p>You searched <b>".$searched."</b>.<p> The password is <b>".$pw."</b> and the hash function was <b>".$type."</b></p>");
	}
	else
	{
		print("<p>You searched <b>".$searched."</b> and it was not found.</p>");
	}
		
?>
</body>
</html>