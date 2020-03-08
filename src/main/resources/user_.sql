create table user_ (
                                  id            integer unsigned auto_increment,
                                  username      varchar(255) not null,
                                  password      varchar(255) not null ,
                                  root          integer      not null default 0 comment '0:普通用户，1:root',
                                  update_by     integer not null,
                                  update_time   timestamp    default CURRENT_TIMESTAMP  on update CURRENT_TIMESTAMP,
                                  create_time   timestamp    default CURRENT_TIMESTAMP ,
                                  del_flag      integer      default 0,
                                  primary key(id)
);