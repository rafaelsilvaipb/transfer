FROM openjdk:18

EXPOSE 8080

ADD target/transfer.jar transfer.jar

ENTRYPOINT ["java", "-jar", "transfer.jar"]
