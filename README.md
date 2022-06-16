API REST PARA GESTIÓN DE USUARIO Y CUENTAS
La API REST fue realizada en SpringBoot.
Tiene una carpeta modelo.entidades que es donde están mis clases involucradas:
-Persona clase padre o superclase
-Usuario clase hija o subclase hereda los atributos de la clase Persona
-Cuenta 
En la carpeta controlador se implementan los métodos del CRUD
En la carpeta servicios tengo mis clases DAO (Data Access Object) 
En la carpeta repositorios pueden encontrar mis interfaces que extienden de CrudRepository

En mi proyecto aplico los conceptos de herencia, interfaces, genéricos.
