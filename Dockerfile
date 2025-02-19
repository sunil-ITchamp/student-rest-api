# Use an official OpenJDK runtime as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/student-rest-api-0.0.1-SNAPSHOT.jar /app/student-rest-api-1.0.jar

# Make port 8085 available to the world outside this container
EXPOSE 8085

# Run the JAR file
ENTRYPOINT ["java", "-jar", "student-rest-api-1.0.jar"]