################### Stage 2: A minimal docker image with command to run the app 
FROM openjdk:8-jre-alpine
ENV APP_FILE event-0.0.1-SNAPSHOT.jar

ENV APP_HOME /usr/apps

ARG JAR_FILE=target/$APP_FILE
COPY $JAR_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -Djava.security.egd=file:/dev/./urandom -jar $APP_FILE"]

EXPOSE 8084

