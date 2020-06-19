create database if not exists football;

use football;

drop table if exists teams;
drop table if exists members;
drop table if exists season_records;

create table teams (
	team_name varchar(40) not null,
	location varchar(20) not null,
	primary key(team_name)
);

create table members (
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	team_name varchar(40),
	number int(2) not null,
	position varchar(20) not null,
	primary key(team_name)
);

create table season_records (
	team_name varchar(20) not null,
	year int(4) not null,
	record varchar(10) not null,
	primary key(team_name)
);
