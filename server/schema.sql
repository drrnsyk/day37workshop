drop database if exists feeds;

create database feeds;

use feeds;

create table posts (
    post_id varchar(8) not null,
    comments mediumtext not null,
    picture mediumblob not null,
    primary key(post_id)
);