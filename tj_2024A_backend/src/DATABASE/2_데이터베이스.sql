/*
	# 테이블 / 표 관련
    - 관련 용어
		[관점 차이에 따른 용어]
		파일 시스템			데이터베이스 모델링		관계형 데이터베이스
        ==================================================================
		파일				엔티티				테이블(Table), 릴레이션(Relation)
        레코드			튜플					행
        필드				속성					열
        
		1. 테이블(table) : 표 , 릴레이션(Relation) , 엔티티(Entity)
        2. 레코드(Record) : 튜플(Tuple), 행(Row)
        3. 필드(Field) : 속성(Attribute), 열(Column)
        
	- MYSQL 데이터 타입
    [정수]
		1. TINYINT    1바이트   -128~127
        2. SMALLINT   2바이트   +-3만쯤
        3. MEDIUMINT  3바이트   +-800만쯤
        4. *INT       4바이트   +-20억쯤
        5. BIGINT     8바이트   +-20억이상
	[실수 : 부동소수점, 오차발생가능]
		1. FLOAT	  4바이트
        2. DOUBLE     8바이트
	[문자형태로 저장되는 숫자 , 오차 없는 실수 표현 ]
		1. DECIMAL    : 실수를 오차 없이 표현할 때 사용
	[날짜]
		1. DATE		  : 날짜만, 1000년 ~ 9999년
        2. DATETIME   : 날짜와 시간 표현
	[문자]
		1. *CHAR      : 고정길이, 최대 1~255문자 (~배열 느낌)
			CHAR(5)  유재석 -> [유][재][석][ ][ ]
        2. *VARCHAR   : 가변길이, 최대 1~255문자 (~리스트 느낌)
			VARCHAR(5) 유재석 -> [유][재][석][ ][ ] -> [유][재][석]
		3. TEXT		  : 최대길이 6만자 표현
        4. LONGTEXT   : 최대길이 42억개 글자 표현 (4GB)
	[논리]
		1. BOOL       : true, false 
*/
# !!! 주의 : 어떤 위치/데이터베이스에 테이블을 생성할지
use myDB;
# 1. 테이블 생성, create table 테이블명(열이름 타입, 열이름2 타입)
create table 회원목록( 이름 text, 점수 int);
# 2. 현재 데이터베이스내 테이블 목록 조회
show tables;
# 3. 테이블 삭제
drop table 회원목록;
# 3.1. 만약 테이블이 존재하면 삭제
drop table if exists 회원목록;

# [예1]
drop database if exists SQLweb1;
create database SQLweb1;
use SQLweb1;
drop table if exists member;
create table member(id varchar(20), password varchar(20), age int, signupdate date);
show tables;
select * from member;  # 테이블 확인
# [예2]
drop table if exists board;
create table board( 
	bno int,			-- 번호 (정수)
	title varchar(100), -- 제목 (최대100글자)
	contents longtext,  -- 내용 (긴글 최대 4G)
	view int, 			-- 조회수 (정수)
	writedate datetime	-- 작성일 (날짜와 시간)
 );
 show tables;
 select * from board;
 # [예3]
 drop table if exists student;
 create table student(
	정수1 tinyint, 정수2 smallint, 정수3 mediumint, 정수4 int, 정수5 bigint,
    실수1 float, 실수2 double, 실수3 decimal,
    날짜 date, 날짜시간 datetime,
    문자열1 char(255), 문자열2 varchar(255), 문자열3 text, 문자열4 longtext,
    논리 bool
 );
 show tables;
 select * from student;
# [실습1]
/*
	- 키오스크 개발 메모리 설계
		[요구사항]
			1. 여러 카테고리중에 카테고리 선택해서 카테고리별로 제품들을 출력/확인
            2. 해당 제품 선택해서 수량 입력받아 주문처리 - 한번 주문에 여러개 제품을 주문할 수 있다.
            3. 주문번호를 받아 대기한다
		[메모리 설계 필수 속성]
			식별자 코드, 카테고리명, 가격, 제품명, 주문수량, 주문날짜, 
*/

drop table if exists categoryTable;
drop table if exists productTable;
drop table if exists orderDetailTable;
drop table if exists orderTable;

create table categoryTable(categoryCode int, categoryName varchar(10));
create table productTable(productCode int, productName varchar(20), productPrice int, categoryCode int);
create table orderDetailTable(orderDetailCode int, productCode int, orderAmount tinyint, orderCode int);
create table orderTable(orderCode int, orderTime datetime);

show tables;
select *from categoryTable;
select *from productTable;
select *from orderDetailTable;
select *from orderTable;