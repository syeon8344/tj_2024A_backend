drop database if exists day06;
create database day06;
use day06;

#1. 회원테이블
drop table if exists member;
create table member(  # 아이디, 비밀번호, 이름, 연락처, 가입일, 회원번호 (pk, a_i)
	mid varchar(30) not null unique,
    mpw varchar(30) not null,
    mname varchar(20) not null,
    mphone varchar(15) not null,
    mdate datetime default now(),
    mno int auto_increment, primary key (mno)
);
select * from member;

#2. 게시물테이블
drop table if exists board;
create table board( # 글제목, 글내용,글작성일, 글작성자, 글조회수
	btitle varchar(100) not null, 
    bcontent longtext,
    bdate datetime default now(),
    bview int default 0,
    bno int auto_increment,
    mno int,
    primary key (bno),
    foreign key (mno) references member(mno)
);
select * from board;


#3. 댓글테이블
drop table if exists reply;
create table reply( # 댓글내용, 댓글작성일, 댓글작성자
	rcontent varchar(200) not null, 
    rdate datetime default now(),
    mno int,
    bno int,
    rno int auto_increment,
    primary key (rno),
    foreign key (mno) references member(mno),
    foreign key (bno) references board(bno)
);
select * from reply;

# ERR 다이어그램 확인

# 샘플 데이터 등록
	-- 회원 5명
    -- 게시물 5개
    -- 댓글 5개
insert into member(mid, mpw, mname, mphone) values 
	('aaa', '1234', '김아무개', '010-123-1234'), 
	('bbb', '1111', '이아무개', '010-577-3333'),
    ('ccc', '1221', '박아무개', '010-441-4422'),
    ('ddd', '1341', '윤아무개', '010-234-1223'),
    ('eee', '1152', '최아무개', '010-233-7886');
insert into board(btitle, bcontent, mno) values
	('제목1', '내용1', 1),
    ('제목2', '내용2', 2),
    ('제목3', '내용3', 3),
    ('제목4', '내용4', 1),
    ('제목5', '내용5', 4);
insert into reply(rcontent, mno, bno) values
	('댓글1', 1, 1),
    ('댓글1', 2, 3),
    ('댓글1', 3, 2),
    ('댓글1', 4, 4),
    ('댓글1', 2, 1);