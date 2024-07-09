
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
                          contrasena varchar(55) not null,

                          primary key (id)
);

create table topico(
                          id bigint not null auto_increment,
                          titulo varchar(55) not null,
                          mensaje varchar(100) not null,
                          fecha_creacion date not null,
                          status boolean not null,

                          primary key (id)
);

create table respuesta(
                          id bigint not null auto_increment,
                          mensaje varchar(255) not null,
                          fecha_creacion date not null,
                          solucion varchar(100) not null,

                          primary key (id)
)