FROM openjdk:17

LABEL author="Dmitry Vanushkin"

#RUN adduser --system book-service &&\
#    addgroup --system spring-application &&\
#    adduser book-service spring-application

WORKDIR /home/application/

COPY ./build/libs/*.jar ./app.jar

ENTRYPOINT java -jar app.jar