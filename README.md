# MediClinic
![Preview del Proyecto](https://res.cloudinary.com/dxlipkjcl/image/upload/v1721513909/Cohorte%2019/Inicio_1_fbh5ss.png)


## Descripción
Este proyecto es una aplicación en línea para la reserva de citas médicas. Permite a los pacientes reservar citas con doctores y gestionar sus consultas médicas en línea. La aplicación está construida usando React para el frontend, Java con Spring Boot para el backend y MySQL como base de datos.

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
- Base de Datos: MySQL
- Otras herramientas: Maven, JWT para seguridad

## Instalación

### Prerrequisitos
- Node.js v20.15.1
- Java Development Kit (JDK) 11 o superior
- MySQL

### Configuración del Backend
1. Clona el repositorio:
    ```bash
    git clone https://github.com/No-Country-simulation/c19-15-m-java-react
    cd c19-15-m-java-react/backend
    ```

2. Configura la base de datos MySQL en `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/mediClinicDB?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
    spring.datasource.username=username
    spring.datasource.password=password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.database=mysql
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    
   #Show SQL
    spring.jpa.properties.hibernate.show_sql=true

    #Format SQL
    spring.jpa.properties.hibernate.format_sql=true

    logging.level.org.hibernate.orm.jdbc.bind=trace
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
    - **Rol**: Desarrollador Fullstack
    - **LinkedIn**: [Omar González](https://www.linkedin.com/in/orgc)
    - **GitHub**: [ORCG1](https://github.com/ORCG1)

- **Santiago Conrero**
    - **Rol**: Desarrollador Frontend
    - **LinkedIn**: [Santiago Conrero](https://www.linkedin.com/in/santiago-conrero-453315217/)
    - **GitHub**: [santi1961](https://github.com/santi1961)

- **Johanna Vicari**
    - **Rol**: Diseñadora UX/UI
    - **LinkedIn**: [Johanna Vicari](https://www.linkedin.com/in/johannavicari/)
    - **Behance**: [johannavicari](https://www.behance.net/johannavicari)
---
