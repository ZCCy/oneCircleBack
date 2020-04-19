create table operations_ (
                       id          integer unsigned auto_increment,
                       operations  varchar(255) not null ,
                       operaetions_time timestamp    default CURRENT_TIMESTAMP ,
                       update_by   integer not null,
                       del_flag    integer      default 0,
                       primary key(id)
);
alter table operations_ add  goodId  bigint not null ;