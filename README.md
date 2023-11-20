# Gestion-Immobiliere

# Backend
- under `backend/src/main/resources` you need to add `application.properties` that contain all configuration:

```
spring.datasource.url=jdbc:mysql://localhost:3306/demo
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql: true
```
**you need to create `demo` database first in your dbserver and download all maven dependencies**