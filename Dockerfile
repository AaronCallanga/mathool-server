# Use OpenJDK as base image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR into the container
COPY target/mathool-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]