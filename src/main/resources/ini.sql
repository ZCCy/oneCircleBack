create table user_ (
                       id          integer unsigned auto_increment,
                       username    varchar(20) not null,
                       password    varchar(20) not null,
                       email       varchar(255) not null,
                       update_by   integer not null,
                       update_time timestamp    default CURRENT_TIMESTAMP  on update CURRENT_TIMESTAMP,
                       create_time timestamp    default CURRENT_TIMESTAMP ,
                       del_flag    integer      default 0,
                       primary key(id)
);