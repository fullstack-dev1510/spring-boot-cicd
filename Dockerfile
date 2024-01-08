FROM openjdk:17
LABEL maintainer="andrews.gs@gmail.com"
ADD ./target/spring-boot-cicd-1.1.jar spring-boot-cicd-1.1.jar
ENTRYPOINT ["java","-jar","/spring-boot-cicd-1.1.jar"]