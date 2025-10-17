# Use an official Maven image with JDK 17 to build the application
FROM eclipse-temurin:17-jdk AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY mvnw mvnw.cmd pom.xml ./

# Copy the Maven wrapper directory
COPY .mvn .mvn

# Download dependencies (this layer can be cached)
RUN ./mvnw dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Use a smaller JRE image for the runtime
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/productmanager-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
