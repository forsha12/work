<!DOCTYPE html>
<!--	Author: Paige Forsha
		Date:	10/9/2019
		Purpose: HW5, populating our database. 
-->
<html>
<head>
	<title>Data Generator</title>
	<link rel ="stylesheet" type="text/css" href="sample.css">
</head>

<body>

	<?php
        
		//function to read in data from files provided
        function get_array_data($fileName) {
             
            $handle = fopen($fileName,"r");
                
            while (!feof($handle)) {
                $value = fgets($handle); //read a value (one line)
                $value = str_replace(array("\n", "\r"), '', $value);  //remove newlines
                if(!feof($handle)) {
                    $values[] = $value; //
                    //print("<p>$words[$word], $word</p>");				
                }
            }
            fclose($handle);
            return $values;
        }
		
        //function to write a set of columns and values to an sql script
        function write_table($handle, $database, $table, $columns, $values) {
            //INSERT INTO moviestore4.actor (first_name,last_name) VALUES ('David','Schwab');
            fwrite($handle, "USE $database;\n\n");
            
            fwrite($handle, "SET AUTOCOMMIT=0;\n\n");
            
            fwrite($handle, "INSERT INTO $database.$table (");
            //loop over column names
            for($i = 0; $i < sizeof($columns); $i++) {
                fwrite($handle, $columns[$i]);
                //if i'm not on the last one, print a comma
                if($i != sizeof($columns)-1) {
                    fwrite($handle, ",");
                }
            }
            fwrite($handle, ")\nVALUES\n");
            //now a nested loop to run over the values.
            for($i = 0; $i < sizeof($values); $i++) {
                fwrite($handle, "(");
                for($j = 0; $j < sizeof($values[$i]); $j++) {
                    fwrite($handle, $values[$i][$j]);
                    if($j != sizeof($values[$i]) - 1) {
                        fwrite($handle, ",");
                    }
                }
                fwrite($handle, ")");
                if($i != sizeof($values)-1) {
                    fwrite($handle, ",\n");
                } else {
                    fwrite($handle, ";\n");
                }
            }
            
            fwrite($handle, "COMMIT;\n\n");

        }
        
		
		//constants
        const NUM_CUSTOMERS = 100;
		const NUM_ORDERS = 250;
		const NUM_PRODUCTS = 750;
		const NUM_ORDER_ITEMS = 550;
		const NUM_ADDRESSES = 150;
		const NUM_WAREHOUSES = 25;
		const NUM_PRODUCT_WAREHOUSES = 1250;
		
		//we will do them in this order: address, customer, order, product, warehouse, order_item, product_warehouse
		
		//create table column for address
		$address_columns = array("street", "city", "state", "zip");
		   
        print("<h1>Generating SQL script</h1>");
        
        print("...");
        
		//**** GENERATE ADDRESS INFO
		$street_names = get_array_data("street_names.txt");
		$street_types = get_array_data("street_types.txt");
		$cities = get_array_data("cities.txt");
		$states = get_array_data("states.txt");
		
		//generate 2 dimensional array for the data/values of this table :)
		for($i = 0; $i < NUM_ADDRESSES; $i++) {
			$street_num = rand(0, 1000); // to make an entire STREET value, you need the house number
			$zip = rand(10000, 99999); //zip has to be a five digit number
			$zip = (string)$zip;  //casting it into a string bc that's the data type
			
			$address_values[$i][0] = "'".$street_num." ".$street_names[rand(0, sizeof($street_names)-1)]." ".$street_types[rand(0, sizeof($street_types)-1)]."'"; //$street
			$address_values[$i][1] = "'".$cities[rand(0, sizeof($cities)-1)]."'"; //$city
			$address_values[$i][2] = "'".$states[rand(0, sizeof($states)-1)]."'"; //$state
			$address_values[$i][3] = "'".$zip."'"; //$zip
			
		}
		
		
		//to make sure no address is both a warehouse and a customer's house, 
		//first 100 addresses will be the cust address, next 25 will be warehouse address
		
		//column creation for CUSTOMER
		$customer_columns = array("first_name", "last_name", "email", "phone", "address_id");

		//read in data
        $firstNames = get_array_data("first_names.txt");
        $lastNames = get_array_data("last_names.txt");
		$domains = get_array_data("domains.txt");

		//generate values for table
        for($i = 0; $i < NUM_CUSTOMERS; $i++) {
			$fThree = (string) rand(100, 999);
			$mThree = (string) rand(100, 999);
			$lFour = (string) rand(1000, 9999);
			$addr = (string)($i + 1); //gets 1-100 address_id
			$fName = $firstNames[rand(0, sizeof($firstNames)-1)];
			$lName = $lastNames[rand(0, sizeof($lastNames)-1)];
			
			$customer_values[$i][0] = "'".$fName."'"; //$first_name
			$customer_values[$i][1] = "'".$lName."'"; //$last_name
			$customer_values[$i][2] = "'".$fName.$lName.$domains[rand(0, sizeof($domains)-1)]."'"; //$email
			$customer_values[$i][3] = "'".$fThree."-".$mThree."-".$lFour."'"; //$phone
			$customer_values[$i][4] = $addr ; //$address_id
		}
        
		//column creation for ORDER
		$order_columns = array("customer_id", "address_id");
		
		//no read-in this time
		
		//generate values for table
        for($i = 0; $i < NUM_ORDERS; $i++) {
			$cust = (string) rand(1, NUM_CUSTOMERS);
			$addr = (string) rand(1, NUM_ADDRESSES); //doesn't have to be the address of the customer


			$order_values[$i][0] = $cust; //$customer_id
			$order_values[$i][1] = $addr; //$address_id (where it's being delivered to)

		}
		
		//column creation for PRODUCT
		$product_columns = array("product_name", "description", "weight", "base_cost");
		
		//read-in data
		$products = get_array_data("products.txt");
		
		//generate values for table
		for($i = 0; $i < NUM_PRODUCTS; $i++) {
			$weight = (string) (rand(1, 99999) / 100); //gives you values between .01 and 999.99 formatted with 2 decimal places
			$cost = (string) (rand(1, 9999) / 100); 
			$product = $products[rand(0, sizeof($products)-1)];
		
			$product_values[$i][0] = "'".$product."'"; //$product
			$product_values[$i][1] = "'"."An amazing ".$product." for you to enjoy"."'"; //$description
			$product_values[$i][2] = $weight; //$weight
			$product_values[$i][3] = $cost; //$base_cost
		
		}
		
		//column creation for WAREHOUSE
		$warehouse_columns = array("name", "address_id");
		
		//warehouse will be named after colors
		//read-in data
		$names = get_array_data("warehouse_names.txt");
		
		//generate values for table
		for($i = 0; $i < NUM_WAREHOUSES; $i++) {
			$addr = (string) ($i + 101); // to compensate for the first 100 addresses being taken by customer houses. values at 101-125
			
			
			$warehouse_values[$i][0] = "'".$names[$i]." Warehouse"."'"; //$name
			$warehouse_values[$i][1] = $addr; //$address_id
			
		}
		
		//column creation for ORDER_ITEM
		$order_item_columns = array("order_id", "product_id", "quantity", "price");
		
		//no read-in this time
		
		//generate values for table
		for($i = 0; $i < NUM_ORDER_ITEMS; $i++) {
			//ensure there is no empty orders by giving first 350 order items to a diff order, then put the rest wherever
			if($i < NUM_ORDERS) {
				$ordID = (string) ($i + 1); //1-350
			}
			else {
				$ordID = (string) rand(1, NUM_ORDERS); //puts the rest on a random order
			}
			$prodID = rand(1, NUM_PRODUCTS); //chooses any random product
			$quant = rand(1, 100); //chooses a quantity of said product
			$price = ($product_values[$prodID-1][3] * $quant);//product base_cost * quantity
			
			//format numbers
			$prodID = (string) $prodID;
			$price = number_format($price, 2, ".", "");
			$quant = (string) $quant;
			
			$order_item_values[$i][0] = $ordID; //$order_id
			$order_item_values[$i][1] = $prodID; //$product_id
			$order_item_values[$i][2] = $quant; //$quantity
			$order_item_values[$i][3] = $price; //$price
		
		}
		
		//column creation for PRODUCT_WAREHOUSE
		$product_warehouse_columns = array("product_id", "warehouse_id");
		
		//no read-in data
		
		//genetate values for table
		//***each product must be in at least 1 warehouse, no warehouses will be empty*** 
		for($i = 0; $i < NUM_PRODUCT_WAREHOUSES; $i++) {
			if($i < NUM_PRODUCTS) {
					$prdID = (string) ($i + 1); //1-750, makes sure all products are put in a warehouse
				}
				else {
					$prdID = (string) rand(1, NUM_PRODUCTS); //puts the rest of the products in a random warehouse
				}
			if($i < NUM_WAREHOUSES) {
					$whID = (string) ($i + 1); //1-25, makes sure all warehouses have something in it
				}
				else {
					$whID = (string) rand(1, NUM_WAREHOUSES); //puts the rest of the products in a random warehouse
				}
			
			$product_warehouse_values[$i][0] = $prdID;
			$product_warehouse_values[$i][1] = $whID;
		}
		
        //************* WRITING TABLES********************
        //write the data to the sql file now.
        //function write_table($handle, $database, $table, $columns, $values)
        $handle = fopen("data.sql", "w");

        write_table($handle, "SuperStore", "address", $address_columns, $address_values);
        write_table($handle, "SuperStore", "customer", $customer_columns, $customer_values);
		write_table($handle, "SuperStore", "order", $order_columns, $order_values);
		write_table($handle, "SuperStore", "product", $product_columns, $product_values);
		write_table($handle, "SuperStore", "warehouse", $warehouse_columns, $warehouse_values);
	    write_table($handle, "SuperStore", "order_item", $order_item_columns, $order_item_values);
	    write_table($handle, "SuperStore", "product_warehouse", $product_warehouse_columns, $product_warehouse_values);
	   
        fclose($handle);
    
		print("<h1>FINISHED</h1>");
        
	?>
</body>
</html>