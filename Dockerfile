# Declare global build arg
#ARG GRADLE_PATH=/home/gradle
#ARG PROJECT_PATH=$GRADLE_PATH/project

FROM gradle:8.4-jdk17-alpine AS gradle_build_stage

LABEL author="Dmitry Vanushkin"

# Use arguments, then will be put here by docker-compose service configuration
ARG GRADLE_PATH
ARG PROJECT_PATH

WORKDIR ${PROJECT_PATH}

COPY ./src ./src
COPY build.gradle.kts ./build.gradle.kts
COPY settings.gradle.kts settings.gradle.kts
COPY ./gradle.properties gragle.properties

RUN gradle bootJar

FROM openjdk:17

## Use global args in this stage (openjdk:17)
ARG PROJECT_PATH

WORKDIR /home/application/

COPY --from=gradle_build_stage ${PROJECT_PATH}/build/libs/*.jar ./app.jar

ENTRYPOINT java -jar app.jar