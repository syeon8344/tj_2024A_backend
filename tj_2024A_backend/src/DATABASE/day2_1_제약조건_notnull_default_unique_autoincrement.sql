/*
	제약조건
		not null : null 값 X
        default : 기본값 부여
        unique : 중복값 허용 X
        auto_increment : 자동 번호 증가, MYSQL 전용


*/



# 데이터베이스 생성
drop database if exists day03;
create database day03;

# 테이블 생성
use day03;
drop table if exists member;
create table member(
	회원번호 int, 아이디 varchar(30), 비밀번호 varchar(30),
    연락처 char(13), 광고전송여부 boolean, 가입일 datetime
);
show tables; # 현재 DB 내의 모든 테이블 확인
select * from member; # 테이블 검색

# 제약조건
# 1. not null : 레코드 등록시 (insert) 해당 필드에 null 값을 포함하지 않는다.
	-- 레코드(insert) 등록시 필드에 대입값이 없으면 기본값 null
create table t1(tno int not null, tname varchar(10));
	# 레코드/행/튜플 추가
		#만약 values(값1, 값2) 앞에 필드명을 생략하면 필드 순서대로 대입
        #values(v1,v2) 앞에 필드명을 쓰면 명시된 순서대로 값 대입
insert into t1 values (1, "유재석"); 
insert into t1 (tno, tname) values ( 2, "강호동");
insert into t1 (tname, tno) values ("하하", 3);

insert into t1 (tname) values ("서장훈"); # tno value 오류 (값이 없는 필드가 not null)
insert into t1 (tno) values (4); # 오류 X (값이 없는 필드가 not null이 아님)
# 테이블 확인
select * from t1;

# 2. default : 해당 필드의 기본값 설정
	-- 레코드 삽입시 해당 필드에 값이 없을 때 기본값으로 설정할 값
create table t2 ( 
	tno int not null, 
    tname varchar(10), 
    tdate datetime default now(),
    tstate int default 10
);
	# 레코드 추가
insert into t2(tno, tname) values (1, "유재석");
insert into t2 values (2, "강호동", "2024-06-22 11:11:11", 10);

#확인
select * from t2;

# 3. unique : 해당 필드내 중복된 값을 허용하지 않는다 - 오류 발생 (중복 제거)
create table t3(
	tno int not null unique,
    tname varchar(10), tpoint int default 100);
	#
insert into t3(tno) values (1);
insert into t3(tno, tname) values(1, '유재석'); # unique : 레코드 등록시 중복값 대입 X

select * from t3;

# 4. auto_increment : 레코드 삽입시 해당 필드에 자동 번호 부여
create table t4(
	tno int not null unique auto_increment, tname varchar(10) default "아무개"
);

insert into t4 (tname) values ("유재석"); # 실행시마다 자동으로 tno가 1씩 늘어나며 대입됨)

select * from t4;

delete from t4 where tno = 3; 

# 5. primary key : 기본키, 레코드 내 식별 가능한 고유값 가진 키, 참조 당하는 키 (<-다른테이블)
	-- unique 포함, not null 포함
    -- primary key ( key로 선정할 필드명)
create table t5(
	tno_pk int auto_increment,
    tname varchar(30),
    primary key (tno_pk)
);
select * from t5;
# 6. foreign key : 외래키, 다른 테이블 내 기본키를 참조하는 키, 참조하는 키 (->다른테이블)
create table t6 (
	title text,
    tno_fk int auto_increment,
    foreign key (tno_fk) references t5(tno_pk)
);
select * from t6;

# 예시

# 1. 회원 (상위) (참조됨 2)
create table m(
	mno_pk int, mname varchar(10), 
    mphone char(13),
    primary key (mno_pk)
);

# 2. 게시물 (중위) (참조됨 1 참조함 1)
create table b(
	bno_pk int, btitle varchar(100), bcontent longtext, 
    bdate datetime default now(),
    primary key (bno_pk),
    mno_fk int, foreign key (mno_fk) references m(mno_pk) -- 해당 필드를 fk로 설정
);

# 3. 게시물 댓글 (하위) (참조함 2)
create table r(
	rno_pk int, rcontent text, rpasswd varchar(20),
    primary key (rno_pk), -- 해당 필드를 pk로 설정
    bno_fk int, foreign key (bno_fk) references b(bno_pk), -- 해당 필드를 fk로 설정
    mno_fk int, foreign key (mno_fk) references m(mno_pk) -- 해당 필드를 fk로 설정
);

