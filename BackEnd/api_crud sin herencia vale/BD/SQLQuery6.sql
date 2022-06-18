/*==============================================================*/
/* Table: CUENTA                                                */
/*==============================================================*/
create table CUENTA (
   IDCUENTA             varchar(1024)        not null,
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




create nonclustered index RELATIONSHIP_1_FK on CUENTA (IDUSUARIO ASC)
go

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   ID                   int              IDENTITY    not null,
   IDUSUARIO            varchar(1024)        null,
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
   IDUSUARIO            varchar(1024)        not null,
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

