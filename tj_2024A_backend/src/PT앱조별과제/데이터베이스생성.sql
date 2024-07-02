create database JAVAPROJECT;
use javaproject;

create table member(
	memberCode int auto_increment,
	ID varchar(20),
	PW varchar(30),
	memberName varchar(10),
	height smallint,
	exHabit	tinyint,
	gender char(1),
	birthDate varchar(20),
	contact	varchar(20),
	accCategory tinyint,
	primary key (memberCode)
);

create table weightrecord(
	weightCode int auto_increment,
	weight smallint,
	measureTime datetime default now(),
	memberCode int,
    primary key (weightCode),
    foreign key (memberCode) references member(memberCode)
);

create table atefoodrecord(
	ateFoodCode int auto_increment,
    foodCode int,
    ateTime datetime default now(),
    memberCode int,
    primary key (ateFoodCode),
    foreign key (foodCode) references food(foodCode),
    foreign key (memberCode) references member(memberCode)
);

create table workoutrecord(
	workOutCode int auto_increment,
    exCode
    workOutTime
    memberCode
    primary key (workOutCode),
    foreign key (sentMCode) references member(memberCode),
    foreign key (sentMCode) references member(memberCode)
);

create table food(
	foodCode int auto_increment,
    foodName varchar(20),
    foodKcal smallint,
    primary key (foodCode)
);

create table exercise (
	exCode int auto_increment,
    exName	
	exKcal
    exIntensity
    primary key (exCode)
);

create table message (
	messageCode int auto_increment,
    sentMCode int,
    receivedMCode int,
    msgTitle varchar(30),
    msgContent text,
	msgView	tinyint,
	msgDate datetime default now(),
    replyContent text,
    replyDate datetime default now(),
    primary key (messageCode),
    foreign key (sentMCode) references member(memberCode),
    foreign key (receivedMCode) references member(memberCode),
);



