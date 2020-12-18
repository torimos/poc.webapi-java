FROM java:8
WORKDIR /
COPY target/test-webapi-1.0-SNAPSHOT-jar-with-dependencies.jar /test-webapi.jar
EXPOSE 9090
CMD ["java", "-jar", "test-webapi.jar"]
