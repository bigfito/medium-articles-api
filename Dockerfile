# OpenJDK 21
FROM openjdk:21

VOLUME /tmp

# Expose the application port
EXPOSE 8080

# Define JAR_FILE variable
ARG JAR_FILE=target/medium-articles-0.0.1-SNAPSHOT.jar

# ENV variables for POSTGRES
ENV DATABASE_NAME=${DATABASE_NAME}
ENV DATABASE_HOST=${DATABASE_HOST}
ENV DATABASE_PORT=${DATABASE_PORT}
ENV DATABASE_USERNAME=${DATABASE_USERNAME}
ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}

# ENV variables for REDIS
ENV REDIS_HOST=${REDIS_HOST}
ENV REDIS_PORT=${REDIS_PORT}

# Copy the JAR file to the container
ADD ${JAR_FILE} app.jar
  
# Running command, specify resource constraints
ENTRYPOINT ["java", "-jar", "/app.jar"]