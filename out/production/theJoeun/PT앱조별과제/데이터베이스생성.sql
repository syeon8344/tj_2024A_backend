create database JAVAPROJECT;
use javaproject;

create table member(					# 회원정보
	memberCode int auto_increment,		# 회원코드
	ID varchar(20) not null unique,		# 회원ID
	PW varchar(30) not null,			# 회원비밀번호
	memberName varchar(10) not null,	# 회원이름
	height smallint not null,			# 키
	exHabit	tinyint not null,			# 운동습관
	gender char(1) not null,			# 성별
	birthDate varchar(20) not null,		# 생년월일
	contact	varchar(20) not null,		# 연락처
	accCategory tinyint not null,		# 회원분류코드
	primary key (memberCode)
);

create table weightrecord(					# 몸무게기록표
	weightCode int auto_increment,			# 몸무게기록코드
	weight smallint not null,				# 몸무게측정결과
	measureTime datetime default now(),		# 몸무게측정시간
	memberCode int,							# 회원코드(fk)
    primary key (weightCode),
    foreign key (memberCode) references member(memberCode)
);

create table atefoodrecord(
	ateFoodCode int auto_increment,
    foodCode int not null,
    ateTime datetime default now(),
    memberCode int,
    primary key (ateFoodCode),
    foreign key (foodCode) references food(foodCode),
    foreign key (memberCode) references member(memberCode)
);

create table workoutrecord(
	workOutCode int auto_increment,
    exCode int not null,
    workOutTime datetime default now(),
    memberCode int,
    primary key (workOutCode),
    foreign key (exCode) references exercise(exCode),
    foreign key (memberCode) references member(memberCode)
);

create table food(
	foodCode int auto_increment,
    foodName varchar(20) not null,
    foodKcal smallint not null,
    primary key (foodCode)
);

create table exercise (
	exCode int auto_increment,
    exName varchar(20) not null,
	exKcal smallint not null,
    exIntensity tinyint not null,
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



