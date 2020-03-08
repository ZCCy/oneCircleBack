create table commodity_pools_ (
                       id            integer unsigned auto_increment,
                       title         varchar(255) not null,
                       status        varchar(20) not null comment '1：在售，0：交易中，2已下架',
                       update_by     integer not null,
                       update_time   timestamp    default CURRENT_TIMESTAMP  on update CURRENT_TIMESTAMP,
                       create_time   timestamp    default CURRENT_TIMESTAMP ,
                       del_flag      integer      default 0,
                       primary key(id)
);
alter table commodity_pools_ add  star bool default  0;