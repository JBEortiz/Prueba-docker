FROM openjdk:11
VOLUME /tmp 
EXPOSE 8888
ADD ./target/prueba-docker-0.0.1-SNAPSHOT.jar prueba-docker.jar
ENTRYPOINT ["java","-jar","/prueba-docker.jar"]