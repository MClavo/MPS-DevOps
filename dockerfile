# Usa una imagen base de Maven para compilar y ejecutar el proyecto
FROM maven:3.8.1-openjdk-17-slim

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo pom.xml y las dependencias del proyecto
COPY core/pom.xml core/pom.xml

# Descarga las dependencias del proyecto
RUN mvn -f core/pom.xml dependency:go-offline

# Copia el código fuente del proyecto
COPY core/src core/src

# Compila el proyecto
RUN mvn -f core/pom.xml clean package

# Especifica el comando para ejecutar el proyecto
CMD ["java", "-jar", "/app/core/target/core-1.0-SNAPSHOT.jar"]