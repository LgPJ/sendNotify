Backend (Java Spring Boot)
Descripción
Este proyecto es un servicio RESTful desarrollado en Java con Spring Boot que permite notificar a los estudiantes sobre incidencias que afectan a sus clases. Utiliza una base de datos H2 en memoria para almacenar la información de los estudiantes y sus matrículas.

Requisitos previos
Java 8 o superior
Maven
Instalación
Clonar el repositorio: git clone https://github.com/tu-usuario/proyecto-backend.git
Navegar al directorio del proyecto: cd proyecto-backend
Compilar el proyecto: mvn clean install
Ejecutar el proyecto: java -jar target/proyecto-backend.jar
Uso
El servicio expone un endpoint POST /notify que recibe un JSON con el siguiente formato:

{
  "listType": "ListaA",
  "message": "Mensaje de la notificación"
}

Donde "listType" puede ser "ListaA", "ListaB", o "ListaC" y "message" es el mensaje que se enviará a los estudiantes.

Ejemplo de solicitud

curl -X POST http://localhost:8080/notify -H "Content-Type: application/json" -d "{\"listType\":\"ListaA\",\"message\":\"Clases de Matemáticas canceladas\"}"
