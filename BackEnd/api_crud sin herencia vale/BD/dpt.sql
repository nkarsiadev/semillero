/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2016                    */
/* Created on:     13/6/2022 1:03:33                            */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CUENTA') and o.name = 'FK_CUENTA_RELATIONS_USUARIO')
alter table CUENTA
   drop constraint FK_CUENTA_RELATIONS_USUARIO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PERSONA') and o.name = 'FK_PERSONA_RELATIONS_USUARIO')
alter table PERSONA
   drop constraint FK_PERSONA_RELATIONS_USUARIO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('USUARIO') and o.name = 'FK_USUARIO_RELATIONS_PERSONA')
alter table USUARIO
   drop constraint FK_USUARIO_RELATIONS_PERSONA
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
            from  sysindexes
           where  id    = object_id('PERSONA')
            and   name  = 'RELATIONSHIP_2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PERSONA.RELATIONSHIP_2_FK
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
            and   name  = 'RELATIONSHIP_3_FK'
            and   indid > 0
            and   indid < 255)
   drop index USUARIO.RELATIONSHIP_3_FK
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
   IDCUENTA             int                  not null,
   IDUSUARIO            int                  not null,
   TIPOCUENTA           varchar(1024)        null,
   NROCUENTA            varchar(1024)        null,
   SALDO                decimal              null,
   constraint PK_CUENTA primary key (IDCUENTA)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/




create nonclustered index RELATIONSHIP_1_FK on CUENTA (IDUSUARIO ASC)
go

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   ID                   int                  not null,
   IDUSUARIO            int                  null,
   NOMBRES              varchar(1024)        null,
   APELLIDOS            varchar(1024)        null,
   constraint PK_PERSONA primary key (ID)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/




create nonclustered index RELATIONSHIP_2_FK on PERSONA (IDUSUARIO ASC)
go

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   IDUSUARIO            int                  not null,
   ID                   int                  null,
   TIPOUSUARIO          varchar(1024)        null,
   DIRECCION            varchar(1024)        null,
   constraint PK_USUARIO primary key (IDUSUARIO)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/




create nonclustered index RELATIONSHIP_3_FK on USUARIO (ID ASC)
go

alter table CUENTA
   add constraint FK_CUENTA_RELATIONS_USUARIO foreign key (IDUSUARIO)
      references USUARIO (IDUSUARIO)
go

alter table PERSONA
   add constraint FK_PERSONA_RELATIONS_USUARIO foreign key (IDUSUARIO)
      references USUARIO (IDUSUARIO)
go

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_PERSONA foreign key (ID)
      references PERSONA (ID)
go

