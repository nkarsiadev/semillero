/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2016                    */
/* Created on:     12/6/2022 20:17:32                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CUENTA') and o.name = 'FK_CUENTA_RELATIONS_USUARIO')
alter table CUENTA
   drop constraint FK_CUENTA_RELATIONS_USUARIO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('USUARIO') and o.name = 'FK_USUARIO_INHERITAN_PERSONA')
alter table USUARIO
   drop constraint FK_USUARIO_INHERITAN_PERSONA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CUENTA')
            and   name  = 'RELATIONSHIP_1_FK'
            and   indid > 0
            and   indid < 255)
   drop index CUENTA.RELATIONSHIP_1_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CUENTA')
            and   type = 'U')
   drop table CUENTA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PERSONA')
            and   type = 'U')
   drop table PERSONA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('USUARIO')
            and   name  = 'INHERITANCE_4_FK'
            and   indid > 0
            and   indid < 255)
   drop index USUARIO.INHERITANCE_4_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USUARIO')
            and   type = 'U')
   drop table USUARIO
go

/*==============================================================*/
/* Table: CUENTA                                                */
/*==============================================================*/
create table CUENTA (
   IDCUENTA             varchar(1024)        not null,
   ID                   int                  not null,
   IDUSUARIO            varchar(1024)        not null,
   TIPOCUENTA           varchar(1024)        null,
   NROCUENTA            varchar(1024)        null,
   SALDO                decimal              null,
   constraint PK_CUENTA primary key (IDCUENTA)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/




create nonclustered index RELATIONSHIP_1_FK on CUENTA (ID ASC,
  IDUSUARIO ASC)
go

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   ID                   int                  not null,
   NOMBRES              varchar(1024)        null,
   APELLIDOS            varchar(1024)        null,
   constraint PK_PERSONA primary key (ID)
)
go

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID                   int                  not null,
   IDUSUARIO            varchar(1024)        not null,
   NOMBRES              varchar(1024)        null,
   APELLIDOS            varchar(1024)        null,
   TIPOUSUARIO          varchar(1024)        null,
   DIRECCION            varchar(1024)        null,
   constraint PK_USUARIO primary key (ID, IDUSUARIO)
)
go

/*==============================================================*/
/* Index: INHERITANCE_4_FK                                      */
/*==============================================================*/




create nonclustered index INHERITANCE_4_FK on USUARIO (ID ASC)
go

alter table CUENTA
   add constraint FK_CUENTA_RELATIONS_USUARIO foreign key (ID, IDUSUARIO)
      references USUARIO (ID, IDUSUARIO)
go

alter table USUARIO
   add constraint FK_USUARIO_INHERITAN_PERSONA foreign key (ID)
      references PERSONA (ID)
go

