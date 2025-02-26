FROM gradle:jdk17 as builder
WORKDIR /build

RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true


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