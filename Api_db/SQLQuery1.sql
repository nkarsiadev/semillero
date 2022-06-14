/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     9/6/2022 21:36:11                            */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CLIENTE') and o.name = 'FK_CLIENTE_RELATIONS_CUENTA')
alter table CLIENTE
   drop constraint FK_CLIENTE_RELATIONS_CUENTA
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

alter table CLIENTE
   add constraint FK_CLIENTE_RELATIONS_CUENTA foreign key (IDCUENTA)
      references CUENTA (IDCUENTA)
go

