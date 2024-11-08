FROM gradle:jdk17-alpine AS build
WORKDIR /app

COPY src src
COPY build.gradle.kts build.gradle.kts
COPY settings.gradle.kts settings.gradle.kts

RUN gradle build

FROM gradle:jdk17-alpine

ARG JAR=/app/build/libs/backend-1.0-SNAPSHOT.jar

COPY --from=build ${JAR} ./app.jar

ENTRYPOINT ["java", "-jar", "./app.jar"]