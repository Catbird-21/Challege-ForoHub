# ForoHub: API RESTful para Comunidades

![Status](https://img.shields.io/badge/Estado-Finalizado-2ea44f?style=flat-square)
![Java Version](https://img.shields.io/badge/Java-17-007396?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-6db33f?style=flat-square)

## Visión General del Proyecto

ForoHub nace con el propósito de ser el motor backend de un espacio digital dedicado al intercambio de conocimientos y resolución de dudas. Esta API RESTful proporciona la estructura necesaria para que una comunidad interactúe de manera segura, permitiendo a los usuarios gestionar temas de discusión bajo un entorno altamente protegido.

El desarrollo de este sistema refleja un compromiso con las buenas prácticas de la ingeniería de software, priorizando la claridad del código, la integridad de la base de datos y la seguridad de la información del usuario mediante arquitecturas modernas.

---

## Ecosistema Tecnológico

Para construir una base sólida y escalable, el proyecto se apoya en las siguientes tecnologías:

* *Lenguaje y Framework:* Java 17 impulsado por Spring Boot 3, garantizando un rendimiento óptimo.
* *Persistencia de Datos:* PostgreSQL como sistema de gestión de bases de datos relacionales, trabajando en conjunto con Spring Data JPA y Hibernate.
* *Control de Versiones BD:* Flyway, asegurando transiciones seguras y un historial limpio de las estructuras de datos (Migraciones).
* *Seguridad y Confianza:* Spring Security integrado con Auth0 (JSON Web Tokens) para un control de acceso robusto y sin estado (Stateless).

---

## Pilares del Sistema

### 1. Protección y Privacidad
El resguardo de la información es fundamental. Por ello, el sistema implementa encriptación asimétrica mediante el algoritmo *BCrypt* para todas las contraseñas. Además, el flujo de autenticación se gestiona a través de tokens JWT, los cuales son interceptados y validados meticulosamente por un filtro de seguridad personalizado antes de conceder acceso a cualquier recurso protegido.

### 2. Gestión de Contenido (CRUD)
La API permite una gestión armoniosa y completa de los temas de discusión:
* *Registro:* Creación de nuevos tópicos pasando por estrictos filtros de validación (DTOs) para asegurar la limpieza de los datos.
* *Consulta:* Visualización estructurada de los temas activos en el foro.
* *Edición y Depuración:* Capacidad de actualizar información o retirar tópicos que ya no aporten valor a la comunidad.

---

## Guía de Despliegue Local

Si deseas explorar el código o levantar el entorno de desarrollo en tu máquina, sigue estos pasos:

### Prerrequisitos
Asegúrate de tener instalados Java (JDK 17+), Maven y PostgreSQL.

### Configuración del Entorno

1.  *Obtener el código fuente:*
    bash
    git clone [https://github.com/SuUsuarioGithub/forohub.git](https://github.com/SuUsuarioGithub/forohub.git)


2.  *Preparar la Base de Datos:*
    Crea una base de datos en PostgreSQL con el nombre forohub_db. Posteriormente, ajusta las credenciales en tu archivo application.properties:
    properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/forohub_db
    spring.datasource.username=TU_USUARIO
    spring.datasource.password=TU_CLAVE

    # Define la firma criptográfica para los tokens
    api.security.secret=ingresa_aqui_una_clave_segura


3.  *Iniciar la Aplicación:*
    Al compilar y correr el proyecto, Flyway generará automáticamente la estructura de tablas necesaria de forma transparente.
    bash
    mvn spring-boot:run


---

## Mapa de Rutas (Endpoints)

La interacción con la API se realiza a través de las siguientes rutas. Todas las respuestas se entregan en un formato JSON limpio y estandarizado.

| Acción | Método | Endpoint | Acceso |
| :--- | :---: | :--- | :---: |
| *Iniciar Sesión* | POST | /login | Público |
| *Crear Tópico* | POST | /topicos | Protegido (JWT) |
| *Listar Tópicos* | GET | /topicos | Protegido (JWT) |
| *Editar Tópico* | PUT | /topicos/{id} | Protegido (JWT) |
| *Borrar Tópico* | DELETE| /topicos/{id} | Protegido (JWT) |

> *Nota de Integración:* Para consumir los endpoints protegidos, es necesario incluir el token obtenido en la ruta de /login dentro de los encabezados de la petición HTTP (Authorization: Bearer <tu_token_aqui>).

---

## Desarrolladora

Construido con dedicación por *Daniela Suárez Matamoros*.
Para conocer más sobre mi trayectoria o explorar otros proyectos, te invito a visitar mi perfil de [LinkedIn](https://www.linkedin.com/in/daniela-su%C3%A1rez-a43686273/) o mi portafolio en [GitHub](https://github.com/Catbird-21).