FROM maven:3.9.0-eclipse-temurin-17 as builder
COPY . /src
WORKDIR /src
RUN mvn package -DskipTests

FROM eclipse-temurin:17.0.6_10-jre
COPY --from=builder /src/target/take_a_book-0.0.1-SNAPSHOT.jar /
CMD ["java", "-jar", "take_a_book-0.0.1-SNAPSHOT.jar"] 