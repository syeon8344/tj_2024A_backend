drop database if exists javaproject;
create database javaproject;
use javaproject;

create table member(				# 회원정보
	memberCode int auto_increment,		# 회원코드(pk)
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

create table food(						# 음식
	foodCode int auto_increment,			# 음식코드(pk)
    foodName varchar(20) not null,			# 음식이름
    foodKcal smallint not null,				# 음식칼로리(대부분 100g당)
    primary key (foodCode)
);

create table exercise (					# 운동
	exCode int auto_increment,				# 운동코드(pk)
    exName varchar(20) not null,			# 운동이름
	exKcal smallint not null,				# 운동소모칼로리(10분당)
    exIntensity tinyint not null,			# 운동강도(1~3)
    primary key (exCode)
);

create table weightrecord(				# 몸무게기록표
	weightCode int auto_increment,			# 몸무게기록코드(pk)
	weight smallint not null,				# 몸무게측정결과
	measureTime datetime default now(),		# 몸무게측정시간
	memberCode int,							# 회원코드(fk)
    primary key (weightCode),
    foreign key (memberCode) references member(memberCode)
);

create table atefoodrecord(				# 먹은음식기록표
	ateFoodCode int auto_increment,			# 먹은음식기록코드(pk)
    foodCode int not null,					# 음식코드(fk)
    ateTime datetime default now(),			# 먹은음식기록시간
    memberCode int,							# 회원코드(fk)
    primary key (ateFoodCode),
    foreign key (foodCode) references food(foodCode),
    foreign key (memberCode) references member(memberCode)
);

create table workoutrecord(				# 운동기록표
	workOutCode int auto_increment,			# 운동기록코드(pk)
    exCode int not null,					# 운동코드(fk)
    workOutTime datetime default now(),		# 운동기록시간
    memberCode int,							# 회원코드(fk)
    primary key (workOutCode),
    foreign key (exCode) references exercise(exCode),
    foreign key (memberCode) references member(memberCode)
);

create table message (					# 쪽지
	messageCode int auto_increment,			# 쪽지코드(pk)
    sentMCode int,							# 보낸회원코드(fk)
    receivedMCode int,						# 받은회원코드(fk)
    msgTitle varchar(30),					# 쪽지제목
    msgContent text,						# 쪽지내용
	msgView	mediumint,						# 쪽지조회수
	msgDate datetime default now(),			# 쪽지전송시간
    replyContent text,						# 답장내용
    replyDate datetime default now(),		# 답장시간
    primary key (messageCode),
    foreign key (sentMCode) references member(memberCode),
    foreign key (receivedMCode) references member(memberCode)
);



