# Usa OpenJDK 17
FROM openjdk:17-jdk-slim

# Define directorio de trabajo
WORKDIR /app

# Copia build.gradle y gradle wrapper
COPY build.gradle settings.gradle gradlew ./
COPY gradle/ gradle/

# Copia el código fuente
COPY src/ src/

# Construye el jar
RUN ./gradlew build -x test

# Expone el puerto del backend
EXPOSE 8080

# Ejecuta el jar generado
CMD ["java", "-jar", "build/libs/barber-0.0.1-SNAPSHOT.jar"]
