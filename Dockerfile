FROM openjdk:8
EXPOSE 9094
COPY ./target/spring-boot-docker.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch spring-boot-docker.jar'
ENTRYPOINT ["java","-jar","spring-boot-docker.jar"]