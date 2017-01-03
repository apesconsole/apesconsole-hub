drop table sensor_data if exists;

create table sensor_data (id integer identity primary key, message varchar(255), log_time timestamp);