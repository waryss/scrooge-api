# Docker multi-stage build

# 1. Building the App with Maven and java 14
FROM maven:3-jdk-14

ADD . /scrooge-api
WORKDIR /scrooge-api

# Just echo so we can see, if everything is there :)
RUN ls -l

# Run Maven build
RUN mvn clean install


# 2. Just using the build artifact and then removing the build-container
FROM openjdk:14-jdk

VOLUME /tmp

# Add Spring Boot app.jar to Container
COPY --from=0 "/scrooge-api/target/scrooge-api-*-SNAPSHOT.jar" app.jar

# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
