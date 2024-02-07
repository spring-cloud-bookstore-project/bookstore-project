FROM openjdk:17

LABEL author="Dmitry Vanushkin"

#Define local variable
ARG JAR_FILE="./build/libs/*.jar"

WORKDIR /home/application/

COPY $JAR_FILE ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

VOLUME "/home/application/shared"