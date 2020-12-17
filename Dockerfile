FROM java:8
WORKDIR /
COPY target/myapp-1.0-SNAPSHOT-jar-with-dependencies.jar /myapp.jar
EXPOSE 9090
CMD ["java", "-jar", "myapp.jar"]
