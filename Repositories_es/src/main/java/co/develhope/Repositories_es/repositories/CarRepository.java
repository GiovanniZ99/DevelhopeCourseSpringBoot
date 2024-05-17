package co.develhope.Repositories_es.repositories;

import co.develhope.Repositories_es.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {
}
// post1
/*Response Status
201 (Created)
Response Headers
connection	keep-alive
content-type	application/hal+json
date	Fri, 17 May 2024 19:15:36 GMT
keep-alive	timeout=60
location	http://localhost:8080/cars/1
transfer-encoding	chunked
vary	Origin, Access-Control-Request-Method, Access-Control-Request-Headers
Response Body
{
  "modelName": "Panda",
  "serialNumber": "1",
  "currentPrice": 18000,
  "_links": {
    "self": {
      "href": "http://localhost:8080/cars/1"
    },
    "car": {
      "href": "http://localhost:8080/cars/1"
    }
  }
}
// post2
Response Status
201 (Created)
Response Headers
connection	keep-alive
content-type	application/hal+json
date	Fri, 17 May 2024 19:16:34 GMT
keep-alive	timeout=60
location	http://localhost:8080/cars/2
transfer-encoding	chunked
vary	Origin, Access-Control-Request-Method, Access-Control-Request-Headers
Response Body
{
  "modelName": "Panda2",
  "serialNumber": "2",
  "currentPrice": 25000,
  "_links": {
    "self": {
      "href": "http://localhost:8080/cars/2"
    },
    "car": {
      "href": "http://localhost:8080/cars/2"
    }
  }
}
//get
Response Status
200 (OK)
Response Headers
connection	keep-alive
content-type	application/hal+json
date	Fri, 17 May 2024 19:17:02 GMT
keep-alive	timeout=60
transfer-encoding	chunked
vary	Origin, Access-Control-Request-Method, Access-Control-Request-Headers
Response Body
{
  "_embedded": {
    "cars": [
      {
        "modelName": "Panda",
        "serialNumber": "1",
        "currentPrice": 18000,
        "_links": {
          "self": {
            "href": "http://localhost:8080/cars/1"
          },
          "car": {
            "href": "http://localhost:8080/cars/1"
          }
        }
      },
      {
        "modelName": "Panda2",
        "serialNumber": "2",
        "currentPrice": 25000,
        "_links": {
          "self": {
            "href": "http://localhost:8080/cars/2"
          },
          "car": {
            "href": "http://localhost:8080/cars/2"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/cars?page=0&size=20"
    },
    "profile": {
      "href": "http://localhost:8080/profile/cars"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 2,
    "totalPages": 1,
    "number": 0
  }
}
*/