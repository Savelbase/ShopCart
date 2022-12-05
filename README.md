# <p align="center">ShopCart<p>

## Performing a test task for the position of a Java developer

Application written with Spring Boot

You can use Test profile, to run app with H2 database If you want start app with PostgreSQL, you need to initialize a new user and database :

		create user shop_manager with password 'shop_manager_pass';
		create database shop_cart_app_db;
		alter database shop_cart_app_db owner to shop_manager;

Or you can execute init-database.sql file , which locate in the root package

Also you can see SWAGGER by url :

            http://localhost:8080/swagger.html
