# Car Booking API

Extension and improvement of our [CLI Car Booking Application](https://github.com/HosamUsef/Car-Booking-Cli-Project) to a REST API that will constitute our backend and expose a series of endpoints.

## Technologies Used
* **Java 17**
* **Maven**
* **Spring Boot 3**
* **Spring Data JPA**
* **PostgreSQL Database** running on
* **Docker*

## Endpoints

| Endpoints                                 | Description                                            |
|-------------------------------------------|--------------------------------------------------------|
| **Customers**                             |                                                        |
| ```GET /api/v1/users```               | Retrieves **All** the **Users**                    |
| ```GET /api/v1/users/{id}```          | Retrieves the **User** with the specified **id**   |
| ```POST /api/v1/users```              | Adds a **New User**                                |
| ```DELETE /api/v1/users/{id}```       | **Deletes** the User with the specified **id**     |
| **Cars**                                  |
| ```GET /api/v1/cars```                    | Retrieves **All** the **Cars**                         |
| ```GET /api/v1/cars/rn/{regNumber}```     | Retrieves the **Car** with the specified **regNumber** |
| ```GET /api/v1/cars/available```          | Retrieves the **available** cars                       |
| ```GET /api/v1/cars/available-electric``` | Retrieves the **availabe electric** cars               |
| ```POST /api/v1/cars```                   | Adds a **New Car**                                     |
| ```DELETE /api/v1/cars/{id}```            | **Deletes** the Car with the specified **id**          |
| **Bookings**                              |
| ```GET /api/v1/bookings```                | Retrieves **All** the **Bookings**                     |
| ```GET /api/v1/bookings/{id}```           | Retrieves the **Booking** with the specified **id**    |
| ```POST /api /v1/bookings```              | Adds a **New Booking**                                 |

