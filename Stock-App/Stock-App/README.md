### Frameworks and language

---
* Framework : Spring,SpringBoot
* Language : java (Version 17)

### Data Flow

---
> Controller

* StockController
    * getStocksBasedOnType
    * getStocksAbovePriceAndLowerDate
    * getAllStocksAboveMarketCap
    * insertStocks
    * updateTypeById
    * updateStockById
    * removeStocksByOwnerCount


> Service

* StockService


> Repository

* IStockRepository


### Database used in project

* H2 database

### Project Summary

This is a __Stock-App__ built with Java Spring Boot, using an H2 database engine and Maven build tool.Validation is implemented to ensure data integrity. The system supports adding, getting, updating, and deleting jobs. The project follows the Model-View-Controller (MVC) architecture pattern, with separate layers for controller, service, and repository.