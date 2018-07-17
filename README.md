## Springboot-memcached-simple-operations

	This is a sample project in springboot and memcached server
	
	Setting up memcached
	--------------------
	Follow this link for instructions
	[Installing and configuring memcached for windows] (https://commaster.net/content/installing-memcached-windows)
	
### Sample operations and url requests
--------------------------------------
1. Set key value pair

	> http://localhost:8080/set?id=1&name=Harry

2. Get value with given key value

	> http://localhost:8080/get/1

3. Delete the data using key

	> http://localhost:8080/delete/1

#### Links

	* http://javadox.com/com.whalin/Memcached-Java-Client/3.0.0/overview-summary.html
	
	* https://www.tutorialspoint.com/memcached/