# Use the official Maven image with Java 17
FROM maven:3.8-openjdk-17 AS build

# Copy the project files to the container
COPY src /home/app/src
COPY pom.xml /home/app

# Set the working directory
WORKDIR /home/app

# Package the application
RUN mvn clean -B package --file pom.xml

# Use OpenJDK 17 for the runtime
FROM openjdk:17

# Copy the built jar file
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]
