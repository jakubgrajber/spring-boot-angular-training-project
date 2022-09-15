FROM amazoncorretto:17.0.4-al2

ADD target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar ecommerce-app.jar

ENTRYPOINT ["java", "-jar", "ecommerce-app.jar"]