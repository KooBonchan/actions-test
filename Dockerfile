FROM gradle:jdk17 as builder
WORKDIR /build
COPY build.gradle settings.gradle ./
COPY gradlew ./
COPY gradle ./gradle
COPY src ./src
RUN gradle build --parallel --continue


FROM amazoncorretto:17
WORKDIR /app

COPY --from=builder /build/build/libs/*-SNAPSHOT.jar ./app.jar
EXPOSE 8094


USER nobody
ENTRYPOINT [                                              \
  "java",                                                 \
#  "-Dspring.profiles.active=${PROFILES}",                 \
#  "-Dserver.env=${ENV}",                                  \
  "-jar",                                                 \
  "app.jar"                                               \
]