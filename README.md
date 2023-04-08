# Driver Licence Management
Proyecto de ejemplo de uso de Microservicios con Spring Cloud

A continuación se detalla la arquitectura de la aplicación

## Proceso de Construcción

Se utilizaron las siguientes herramientas:

 - SpringBoot con apache por default
 - JpaRepository para manejo de operaciones a la BDD.
 - Arquitectura Hexagonal apoyado por DDD dividiendo la aplicación en Domain, Infraestructure y Application.
 - Uso del patrón de comportamiento **Mediator** para delegar la ejecución de los **Commands** desacoplando las capas.
 - Autenticación y autorización a través de Keycloak con grant_type password.
 - Seguridad con SpringSecurity reforzada con Roles **ROLE_ADMIN** y **ROLE_USER** 
 - Patrón configure (configuración centralizada).
 - Patrón CQRS.
 - Patrón event Driven.
 - Auditoria.
 
## Proceso de ejecución
### Prerequisitos

 - Tener instalado Docker (docker compose)

### Instalación y Ejecución
 1. Clonar el repositorio.
 2. Abrir un terminal en la raíz del proyecto y ejecutar el comando `docker-compose up -d`

## Accesos

Se han configurado tres usuarios en keycloak:

- username: globalAdmin
  rol: admin

- username: user1
  rol: user

- username: user2
  rol: admin y user

Password para todos: password

El endpoint de autenticación es: http://localhost:8080/auth/realms/SpringBootKeycloak/protocol/openid-connect/token el cual devolverá un access_token para enviarlo como Authorization de tipo Bearer en el Header para el resto de requests hacía el Gateway en localhost:8762/api/v1/licencia.


## Documentación API
El documento **LicenseManagerAPI.postman_collection.json** contiene una colección de ejemplo de las llamadas a cada endpoint para Postman. 