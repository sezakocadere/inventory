# Inventory
## About The Project

A **Spring Boot** application which is used to serve **Rest APIs** and perform database operations. Used **JPA** to interact with **PostgreSQL**. This project using **Lombok** and **Java 17**.

## API DOCS

Type | API Request | Info |
|--|--|--|
| GET | product |List of all products|
| GET | product/filter |Filter product by warehouse, warehouse region, warehouse city and category|
| POST | product |Create product with name, price, categoryId, stocks, and criticalThreshold|
| DELETE | product/{productId} |Remove product (makes the status is passive)|
| PUT | product |Update product|
| PUT | product/{value}/{stockId} |Remove product from inventory, if it falls below threshold, a log entry is made|
| GET | product/{productId} |List warehouses by productId|
| POST | stock |Create stock with productId, warehouseId and quantity|
| POST | warehouse |Create warehouse with name, address, region and city|
| POST | category |Create category with name and description|



 
## Request Examples
### Create Category
```
localhost:8080/category [POST]
Request Body

{
    "name": "sweater",
    "description": "%100 cotton"
    
}


Response Body

{
    "id": 1,
    "name": "sweater",
    "description": "%100 cotton"
}
```
### Create Product
```
localhost:8080/product [POST]
Request Body

{
    "name": "calvin klein sweater",
    "price": 1500,
    "categoryId": 1,
    "criticalThreshold": 2
    
}


Response Body
{
    "id": 2,
    "name": "calvin klein sweater",
    "price": 1500,
    "categoryId": 1,
    "stocks": null,
    "criticalThreshold": 2
}
```

### Filter Product
```
localhost:8080/product/filter [GET]
Request Body

{
    "categoryId":1
   
}


Response Body
[
    {
        "id": 2,
        "name": "calvin klein sweater",
        "price": 1500.00,
        "categoryId": 1,
        "stocks": [],
        "criticalThreshold": 2
    }
]
```


## pgAdmin
http://localhost/browser/
```
username: user@domain.com

password: SuperSecret
```
