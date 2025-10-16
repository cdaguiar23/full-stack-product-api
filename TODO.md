# TODO: Migrate from Flyway and MySQL to Liquibase and PostgreSQL with Docker

- [x] Update pom.xml: Remove Flyway and MySQL dependencies, add Liquibase and PostgreSQL dependencies
- [x] Update docker-compose.yml: Replace MySQL service with PostgreSQL, adjust environment variables
- [x] Update application.properties: Configure for PostgreSQL and Liquibase
- [x] Update migration SQL: Change syntax to PostgreSQL (e.g., SERIAL instead of AUTO_INCREMENT)
- [x] Move migration files to Liquibase structure: Rename db/migration to db/changelog, create a master changelog XML file
- [x] Test the application with PostgreSQL and Liquibase
