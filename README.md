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

# Business rule for admin (Employees are working in shop can manage shop)
 + Add employee, update (for rule admin)
 + Add customer, update (employees)
 + Insert order
 + Manage product: add product, update...
 + Report: Report revenue, order by daily, order by monthly...
## 1 Manage Employee
  - List employee
![list_employee.png](public%2Flist_employee.png)
  - Insert employee
![insert_employee.png](public%2Finsert_employee.png)
## 2 Manage Customer
  - List customer
![list_customer.png](public%2Flist_customer.png)
  - Filter customer (ex: by name)
![filter_by_name_cus.png](public%2Ffilter_by_name_cus.png)
  - Insert customer
![insert_customer.png](public%2Finsert_customer.png)
![after_insert_customer.png](public%2Fafter_insert_customer.png)
## 3 Manage Product
- Get list product
  ![image](https://github.com/huyencute11/WWW_WEEK02/assets/88650282/53006420-ac0a-4747-be2c-cd55464875a9)
  -> See all image product on click see image
  ![image](https://github.com/huyencute11/WWW_WEEK02/assets/88650282/3789c405-b8aa-416a-87c0-9d298a2660c8)

- Add new product
![image](https://github.com/huyencute11/WWW_WEEK02/assets/88650282/fa38c610-f85b-46e8-a042-45d43c17935e)

## 4 Manage Order
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
## 5 Manage Report order by date
- Report order by date
![reportByDate.png](public%2FreportByDate.png)
- Report revenue by employees
  ![28_5](https://github.com/huyencute11/WWW_WEEK02/assets/88650282/43e1245d-2ea0-40d4-9c51-4a9d6fbc055f)
![28_1](https://github.com/huyencute11/WWW_WEEK02/assets/88650282/2282198b-116c-4b45-8dbc-2f927a632967)



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
