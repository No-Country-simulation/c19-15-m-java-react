# MediClinic

## Descripción
Este proyecto es una aplicación en línea para la reserva de citas médicas. Permite a los pacientes reservar citas con doctores y gestionar sus consultas médicas en línea. La aplicación está construida usando React para el frontend, Java con Spring Boot para el backend y PostgreSQL como base de datos.

## Tabla de Contenidos
- [Características](#características)
- [Tecnologías](#tecnologías)
- [Instalación](#instalación)
- [Uso](#uso)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)
- [Integrantes del Equipo](#integrantes-del-equipo)

## Características
- Autenticación y autorización de usuarios
- Gestión de perfiles para doctores y pacientes
- Programación y gestión de citas
- Notificaciones y recordatorios
- Funcionalidad de búsqueda de doctores por especialidad
- Seguimiento del historial del paciente

## Tecnologías
- Frontend: React con Tailwind
- Backend: Java con Spring Boot
- Base de Datos: PostgreSQL
- Otras herramientas: Maven, JWT para seguridad

## Instalación

### Prerrequisitos
- Node.js v20.15.1
- Java Development Kit (JDK) 11 o superior
- PostgreSQL

### Configuración del Backend
1. Clona el repositorio:
    ```bash
    git clone https://github.com/No-Country-simulation/c19-15-m-java-react
    cd c19-15-m-java-react/backend
    ```

2. Configura la base de datos PostgreSQL en `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/tubasededatos
    spring.datasource.username=tuusuario
    spring.datasource.password=tupassword
    ```

3. Construye y ejecuta la aplicación Spring Boot:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### Configuración del Frontend
1. Navega al directorio del frontend:
    ```bash
    cd ../frontend
    ```

2. Instala las dependencias y empieza el servidor de desarrollo:
    ```bash
    npm install
    npm start
    ```

## Uso
1. Abre tu navegador web y ve a `http://localhost:3000`.
2. Regístrate como un nuevo usuario (paciente o doctor).
3. Inicia sesión y empieza a reservar o gestionar citas.

## Licencia
Este proyecto está licenciado bajo la Licencia MIT - mira el archivo [LICENSE](LICENSE) para más detalles.

## Integrantes del Equipo
- **Victor Molinas**
    - **Rol**: Desarrollador Backend
    - **LinkedIn**: [Victor Molinas](https://www.linkedin.com/in/vmolinasg)
    - **GitHub**: [vmolinas](https://github.com/vmolinas)

- **Omar González**
    - **Rol**: Desarrolladora Fullstack
    - **LinkedIn**: [Omar González](https://www.linkedin.com/in/orgc)
    - **GitHub**: [ORCG1](https://github.com/ORCG1)

---
