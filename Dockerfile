# Utiliza una imagen base de Java
FROM openjdk:23-jdk-slim

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/apirest.jar /app/apirest.jar

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/apirest.jar"]
