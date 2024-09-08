## Spring boot V3 - One on One Relationship Database

## System Requirements

- Java openjdk : ( version "17.0.2")
- Spring Boot : (version 3.2.5)
- MySQL Database
- Maven : (Apache Maven 3.9.3)
- Editor : (Intellij IDEA 2023.1.1 Community Edition)

## run project

1. clone project Spring boot
```
https://github.com/rardan97/spring-boot-one-on-one.git
```

2. add new database mysql with name "db_spring_one_on_one"

3. open project with intellij IDEA then edit config database in application.properties change database name, username and password match your config db

   #### location : spring-boot-curd-api/src/main/resources/application.properties

```
spring.application.name=spring-boot-one-on-one
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/db_spring_one_on_one
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name =com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```
