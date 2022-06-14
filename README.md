# **Proyecto Back-end**
![GitHub repo size](https://img.shields.io/github/repo-size/alex-vinicio/backtarea)
<picture>

  <img style="width:150px" alt="Shows an illustrated sun in light color mode and a moon with stars in dark color mode." src="https://cdn-icons-png.flaticon.com/512/226/226777.png">
</picture>

## **Descripcion**
Es el proyecto de prueba para el curso del Banco Pichincha, enfocado Back-end.
> Se enfoca en la creacion de una API Rest de gestion (CRUD) de Usuarios y Cuentas.

## Tecnologicas
- [Javas](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
    - JDK 11
- [PostgreSQL](https://www.postgresql.org/download/)
    - pgAdmin 4 v6
- [Spring boot](https://start.spring.io/)
    - JPA
    - Hibernate = Update
- Maven
    - 2.7
## Propiedades

```properties
Puerto server: 8081 -> localhost:8081
````
#### Configuracion en application.properties para la Base de datos
```properties
#codigo anterior
spring.datasource.username={tu nombre de usuario} -> ....username=posgres

spring.datasource.password={tu contra..}  -> ....password=1234

spring.datasource.url=jdbc:postgresql://localhost:{puertoPostres}/{nombre de la BD}?useSSL=false -> 
....url=jdbc:postgresql://localhost:5432/bd_bpalextarea?useSSL=false
#codigo siguiente
```
## **Estructura del proyecto**
- Arquitectura en Ncapas - MVC
  - Capa Controllers.
  - Capa Entity.
  - Capa Service - Injeccion de dependencias.
  - Capa Repository.
  - Capa Exceptions.

### **Otros detalles**
![YouTube Channel Views](https://img.shields.io/youtube/channel/views/UCxjuoksUCWEE91mUNnzk4CA?style=social)
![GitHub](https://img.shields.io/github/license/alex-vinicio/backtarea)
