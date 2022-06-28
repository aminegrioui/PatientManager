# Develop a web application to manage Patient card using spring boot Framework


#  REST API with Spring Boot, Mysql, JPA and Hibernate 

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/aminegrioui/PatientManager.git
```

**2. Create Mysql database**
```bash
create database user_database
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/Patientenverwaltung-0.0.1-SNAPSHOT.jar

```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following  APIs.
To test these apis it will be used Postman

## Get all patients

### Request

`GET /api/v1/allPatients`

      GET /api/v1/allPatients
      
  ### Response
    [
    {
        "id": 2,
        "firstName": "Alex",
        "lastName": "Schmitz",
        "dateOfBirth": "1970-01-12",
        "insuranceNumber": "F123456784",
        "healthInsuranceName": "TK",
        "institutionOfInsurance": 260326822,
        "expirationDate": "2026-07-10"
    }
    ]
## Create a Patient

### Request

`POST /api/v1/postPatient`
#### Body 
  {
    "firstName": "Alex",
    "lastName": "Schmitz",
    "dateOfBirth": "01.12.1970",
    "insuranceNumber": "G123456784",
    "healthInsuranceName": "TK",
    "institutionOfInsurance": 260326822,
    "expirationDate": "10.07.2026"
   }

### Response

      {
    "id": 1,
    "firstName": "Alex",
    "lastName": "Schmitz",
    "dateOfBirth": "1970-12-01",
    "insuranceNumber": "G123456784",
    "healthInsuranceName": "TK",
    "institutionOfInsurance": 260326822,
    "expirationDate": "2026-07-10"
   }

    
## Update a patient

### Request

`PUT /api/v1/{patientId}`

#### Body 
{
    "firstName": "Alex",
    "lastName": "Schmitz",
    "dateOfBirth": "01.12.1970",
    "insuranceNumber": "G123456784",
    "healthInsuranceName": "TK",
    "institutionOfInsurance": 260326822,
    "expirationDate": "10.07.2026"
}

### Response

{
    "id": 1,
    "firstName": "Alaba",
    "lastName": "Schmit",
    "dateOfBirth": "1970-12-01",
    "insuranceNumber": "G123456784",
    "healthInsuranceName": "TK",
    "institutionOfInsurance": 260326822,
    "expirationDate": "2026-07-10"
}
