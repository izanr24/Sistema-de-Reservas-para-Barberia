💈 Proyecto Barbería Web App

   Este proyecto tiene como objetivo proporcionar una plataforma para la gestión de citas en una barbería, ofreciendo a los clientes una forma sencilla de reservar sus servicios y a los administradores un panel completo para gestionar dichas reservas.

🧾 Objetivo

   El propósito principal de este proyecto es digitalizar el proceso de reservas de una barbería, permitiendo:

   Facilitar a los clientes la solicitud de citas en línea.

   Optimizar la organización interna de la barbería mediante un panel de administración.

   Ofrecer una experiencia intuitiva y eficiente tanto para clientes como para barberos.

🚀 Características

   Página principal con imágenes de la barbería.

   Reserva de citas:

    Nombre completo, teléfono y email del cliente.

    Selección de servicio (corte de pelo, recorte de barba, afeitado completo, mascarilla facial).

    Elección de barbero (4 disponibles).

    Fecha y hora de la cita.

    Comentarios adicionales.

    Cálculo automático del total.

    Validación de todos los campos antes de confirmar.

    Inicio de sesión para usuarios registrados.

   Dashboard de administración:

    Listado de citas por fecha.

    Detalle de cliente y servicio reservado.

    Acciones: marcar como completada o eliminar.

   Docker para facilitar el despliegue en cualquier entorno.

🧭 Instalación y ejecución

   Sigue estos pasos para ejecutar el proyecto en tu entorno local 👇

   1. Clonar el repositorio

      git clone https://github.com/izanr24/Sistema_de_Reservas_para_Barberia.git
      cd Sistema_de_Reservas_para_Barberia

   2. Crear la base de datos

      Copia el archivo.txt con las tablas a tu base de datos.

   3. Backend (Spring Boot)

      Instala Java 17 y PostgreSQL.

      Crea una base de datos llamada barberia_db.

      Configura las credenciales en el archivo application.properties con tu usuario y contraseña de PostgreSQL.

      Inicia el backend con:   ./gradlew bootRun

      La API quedará disponible en http://localhost:8080.

   4. Frontend (Angular)

      Instala Node.js y Angular CLI si no los tienes.

      Entra a la carpeta del frontend (por ejemplo frontend/).

      Instala las dependencias:

      npm install

      Ejecuta el servidor de desarrollo:

      ng serve

      Abre http://localhost:4200 en tu navegador.

🔧 Tecnologías utilizadas

   Frontend: Angular, Css, TypeScript.

   Backend: Java SpringBoot, Jwt.

   Base de datos: PostgreSql.

   Contenedores: Docker.

📚 ¿Por qué es importante este proyecto?

   En la actualidad, muchos negocios pequeños como barberías aún gestionan sus citas de forma manual. Este proyecto demuestra cómo una solución web sencilla puede:

    Ahorrar tiempo en la administración.

    Evitar errores o pérdidas de información.

    Mejorar la experiencia del cliente con un sistema de reservas online.

📨 Contacto

   Si tienes alguna pregunta o deseas más información sobre el proyecto, puedes contactarme a través de:

   Correo electrónico: romeroizan92@gmail.com

   LinkedIn: www.linkedin.com/in/izan-romero-romero-a747b0265

📄 Licencia

   Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.
