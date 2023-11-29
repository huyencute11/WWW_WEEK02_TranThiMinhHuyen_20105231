# WWW_WEEK02 (REST API)
JAVA HIBERNATE 
# Database diagram
![img.png](img.png)
# Class diagram
![img_1.png](img_1.png)

# Database
- Can use mySQL, Mariadb,...
# How to run Backend
 - Step 1: Clone code 
 - Step 2: You have to config file: hibernate.cfg.xml and add libs in build.gradle.
 - Step 3: Run class main to generate database (Run into MySessionFactory.java).
 - Step 4: You can import sample data in file: database_week02.sql to test.
 - Step 5: Test api in postman (ex: http://localhost:8081/week2/api/productImage)
![img_2.png](img_2.png)

# Business rule for admin (employees in shop)
 1 Employee
  - List employee
![list_employee.png](public%2Flist_employee.png)
  - Insert employee
![insert_employee.png](public%2Finsert_employee.png)
2 Customer
  - List customer
![list_customer.png](public%2Flist_customer.png)
  - Filter customer (ex: by name)
![filter_by_name_cus.png](public%2Ffilter_by_name_cus.png)
  - Insert customer
![insert_customer.png](public%2Finsert_customer.png)
![after_insert_customer.png](public%2Fafter_insert_customer.png)
3 Order
- List order
![list_order.png](public%2Flist_order.png)
- Admin insert order
![img.png](public%2Fimg.png)
![img_1.png](public%2Fimg_1.png)
Insert success 
![img_2.png](public%2Fimg_2.png)
![img_4.png](public%2Fimg_4.png)
- Order detail!
![img_3.png](public%2Fimg_3.png)
- Report order by date
![reportByDate.png](public%2FreportByDate.png)


# Business rule for customer when shopping online
- Can see all list product
![customer_1.png](public%2Fcustomer_1.png)
Filter product by unit
![customer_6.png](public%2Fcustomer_6.png)
See detail product
![customer_7.png](public%2Fcustomer_7.png)
Customer can search or filter product by name, price
![customer_8.png](public%2Fcustomer_8.png)
![customer_9.png](public%2Fcustomer_9.png)
- Before customer can add product to cart, user have to login (If not exist account, they can register)
![user_1.png](public%2Fuser_1.png)
Customer can update information
![user_2.png](public%2Fuser_2.png)
![user_3.png](public%2Fuser_3.png)
- Add product to cart
![customer_2.png](public%2Fcustomer_2.png)
![customer_3.png](public%2Fcustomer_3.png)
- Payment
![img_3.png](img_3.png)
![customer_5.png](public%2Fcustomer_5.png)