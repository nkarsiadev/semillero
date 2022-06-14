/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     10/6/2022 12:13:44                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLIENTE') and o.name = 'FK_CLIENTE_RELATIONS_CUENTA')
alter table CLIENTE
   drop constraint FK_CLIENTE_RELATIONS_CUENTA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MOVIENTO') and o.name = 'FK_MOVIENTO_RELATIONS_CUENTA')
alter table MOVIENTO
   drop constraint FK_MOVIENTO_RELATIONS_CUENTA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CLIENTE')
            and   name  = 'RELATIONSHIP_1_FK'
            and   indid > 0
            and   indid < 255)
   drop index CLIENTE.RELATIONSHIP_1_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CLIENTE')
            and   type = 'U')
   drop table CLIENTE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CUENTA')
            and   type = 'U')
   drop table CUENTA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MOVIENTO')
            and   name  = 'RELATIONSHIP_2_FK'
            and   indid > 0
            and   indid < 255)
   drop index MOVIENTO.RELATIONSHIP_2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('MOVIENTO')
            and   type = 'U')
   drop table MOVIENTO
go

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   IDCLIENTE            int                  not null,
   IDCUENTA             int                  not null,
   NOMBRE               varchar(64)          null,
   DIRECCION            varchar(124)         null,
   constraint PK_CLIENTE primary key nonclustered (IDCLIENTE)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on CLIENTE (
IDCUENTA ASC
)
go

/*==============================================================*/
/* Table: CUENTA                                                */
/*==============================================================*/
create table CUENTA (
   IDCUENTA             int                  not null,
   NUMERO               char(32)             null,
   SALDO                decimal              null,
   constraint PK_CUENTA primary key nonclustered (IDCUENTA)
)
go

/*==============================================================*/
/* Table: MOVIENTO                                              */
/*==============================================================*/
create table MOVIENTO (
   IDMOVIMIENTO         int                  not null,
   IDCUENTA             int                  not null,
   FECHA                datetime             null,
   VALOR                decimal              null,
   SALDOFINAL           decimal              null,
   constraint PK_MOVIENTO primary key nonclustered (IDMOVIMIENTO)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_2_FK on MOVIENTO (
IDCUENTA ASC
)
go

alter table CLIENTE
   add constraint FK_CLIENTE_RELATIONS_CUENTA foreign key (IDCUENTA)
      references CUENTA (IDCUENTA)
go

alter table MOVIENTO
   add constraint FK_MOVIENTO_RELATIONS_CUENTA foreign key (IDCUENTA)
      references CUENTA (IDCUENTA)
go

