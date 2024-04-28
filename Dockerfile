# OpenJDK 21
FROM openjdk:21

VOLUME /tmp

# Expose the application port
EXPOSE 8080

# Define JAR_FILE variable
ARG JAR_FILE=target/medium-articles-0.0.1-SNAPSHOT.jar

# Copy the JAR file to the container
ADD ${JAR_FILE} app.jar
  
# Running command, specify resource constraints
ENTRYPOINT ["java", "-jar", "/app.jar"]