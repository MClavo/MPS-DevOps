# MPS-DevOps
Práctica para la asignatura de Metodologías y Procesos Software.

## Compilación y Ejecución
Para construir y ejecutar el programa se utiliza un contenedor de maven con maven y la versión 17 de Java, en específico `maven:3.8.1-openjdk-17-slim`

**Para compilar el programa en una imagen**
``` shell
docker-compose build
```

**Para ejecutar el programa**
``` shell
docker-compose run --rm matrix-app    
```
