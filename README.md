# Prueba-docker
## Esto es una prueba con docker para levantar una imagen de mySql y de esta API basica:
  ## comandos básicos:
   * docker pull (nombre): para descargar imagenes
   * docker images: para ver el numero de imagenes que estan en tu maquina
   * docker ps: imagenes actualmente levantadas
   * docker ps -a: imagenes que has levantado
   * docker start (CONTAINER ID): para arrancar una imagen
   * docker logs (CONTAINER ID o NAME): ver el logs
   * docker logs -f: ver el logs dejarlo en espera
   * docker exec: ejecuta un comando dentro de un contenedor que ya esta levantado 
   * docker run: ejecuta un contenedor nuevo a partir de una imagen
   * docker stop (CONTAINER ID) un o varios: para una imagen
  
  ## Comandos utilizados:
    * docker run -p 3306:3306 --name mysql-example --network prueba -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=db-docker -d mysql:8
    * docker build -t prueba-docker:v1 .
    * docker run -p 8888:8888 --name prueba-docker --network prueba prueba-docker:v1
      
