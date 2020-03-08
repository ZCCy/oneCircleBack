create table operations_ (
                       id          integer unsigned auto_increment,
                       operations  varchar(255) not null ,
                       operaetions_time timestamp    default CURRENT_TIMESTAMP ,
                       del_flag    integer      default 0,
                       primary key(id)
);