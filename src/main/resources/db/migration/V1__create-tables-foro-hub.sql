
create table curso(
    id bigint not null auto_increment,
    nombre varchar(255) not null,
    categoria varchar(100) not null,

    primary key (id)
);

create table perfil(
   id bigint not null auto_increment,
   nombre varchar(55) not null,

   primary key (id)
);

create table usuario(
      id bigint not null auto_increment,
      nombre varchar(155) not null,
      correo_electronico varchar(255) not null unique,
      contrasena varchar(300) not null,
      id_perfil_fk bigint not null,

      primary key (id)
);

create table topico(
    id bigint not null auto_increment,
    titulo varchar(55) not null,
    mensaje varchar(100) not null,
    fecha_creacion date not null,
    status boolean not null,
    id_curso_fk bigint not null,
    id_autor_fk bigint not null,



    primary key (id)
);

create table respuesta(
      id bigint not null auto_increment,
      mensaje varchar(255) not null,
      fecha_creacion date not null,
      solucion varchar(100) not null,
      id_topico_fk bigint not null,
      id_autor_fk bigint not null,


      primary key (id)
);

ALTER TABLE topico ADD FOREIGN KEY (id_curso_fk) REFERENCES curso (id);
ALTER TABLE topico ADD FOREIGN KEY (id_autor_fk) REFERENCES usuario (id);
ALTER TABLE respuesta ADD FOREIGN KEY (id_autor_fk) REFERENCES usuario (id);
ALTER TABLE respuesta ADD FOREIGN KEY (id_topico_fk) REFERENCES topico (id);
ALTER TABLE usuario ADD FOREIGN KEY (id_perfil_fk) REFERENCES perfil (id);
