drop table if exists day05;
create database day05;
use day05;

drop table if exists table01;
create table table01(
	name varchar(100)
);
select * from table01;
set sql_safe_updates = 0