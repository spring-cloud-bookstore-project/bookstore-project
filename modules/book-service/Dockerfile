FROM openjdk:17

LABEL author="Dmitry Vanushkin"

#RUN adduser --system book-service &&\
#    addgroup --system spring-application &&\
#    adduser book-service spring-application

WORKDIR /home/application/

COPY ./build/dependencies/ ./dependencies
COPY ./build/libs/*-plain.jar ./app.jar

ENTRYPOINT java -cp app.jar:./dependencies/* me.xtopz.bookstore.bookservice.SampleApplicationKt