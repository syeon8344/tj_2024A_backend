drop database if exists day06;
create database day06;
use day06;

#1. 회원테이블member
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
    foreign key (mno) references member(mno) on delete set null
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
    foreign key (mno) references member(mno) on delete set null,
    foreign key (bno) references board(bno) on delete set null
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
    
# 1. 전체 검색
select * from member;

# 2. 조건 검색
select * from member where mno = 1; -- mno가 1인 회원 레코드 검색
select * from member where mid = 'aaa'; -- mid가 'aaa;인 회원 레코드 검색

# 아이디 찾기 (회원명과 연락처가 동일한 회원 검색)
# 비교연산자 : > < >= <= =같다 !=같지않다
# 관계연산자 : and or not (java : && || !)
select * from member where mname = 'bbb' and mphone = '111-111-1111';
	-- mname이 'bbb'이고 mphone이 '111-111-1111'인 회원의 레코드 조회
    -- JDBC DAO SQL문 : "SELECT * FROM member WHERE mname = ? AND mphone = ?"
    
# 비밀번호찾기 / 비교 (아이디와 연락처가 동일한 회원 검색)
select * from member where mid = 'aaa' and mphone = '111-111-1111';

# 로그인 / 비교 (아이디와 비밀번호가 동일한 회원 검색)
select mid, mpw from member where mid = 'aaa' and mpw = '1234';