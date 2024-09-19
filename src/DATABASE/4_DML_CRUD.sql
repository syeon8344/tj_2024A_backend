/*
	[1] INSERT : 레코드 (행, 튜플, 가로단위) 삽입
		1. 모든 필드에 값 대입 : insert into 테이블명 values (필드수에 맞는 값들)
        2. 특정 필드에 값 대입 : insert into 테이블명 (필드명들) values (값들)
        3. 여러개의 필드에 값 대입 : insert into 테이블명 (필드명들) values () ()...
        
	[2] SELECT : 레코드 찾기
		1. 전체 필드 조회 : select * from 테이블명;
        2. 특정 필드 조회 : select (필드명) from 테이블명;
        3. 조건 조회 : select (필드명) from 테이블명 where 조건;
        
	[3] UPDATE : 레코드 수정
		1. 필드 단위 수정 : update 테이블명 set 필드명 = 새로운 값;
        2. 특정 레코드 수정 : update 테이블명 set 필드명 = 새로운 값 where 조건;
        
    [4] DELETE : 레코드 삭제
		1. 전체 삭제 : delete from 테이블명; (DML, 레코드를 하나씩 전체삭제, 되돌리기 가능)
			<-> truncate table 테이블명; (DDL, 레코드들 한번에 전체삭제, 되돌리기 불가)
		2. 특정 조건에 따른 레코드 삭제 : delete from 테이블명 where 조건;
*/




#데이터베이스 생성
drop table if exists day04; # (선택) 이미 있으면 제거
create database day04;		# 생성
use day04;					# 해당 데이터베이스 선택

#테이블 생성
drop table if exists table01;
create table table01(
	mno int, 
    mname varchar(30) not null unique
);

# Data Manipulation Language DML : 조작어
# C.INSERT R.SELECT U.UPDATE D.DELETE

# [1] INSERT : 레코드(행, 튜플, 가로단위) 삽입
# 1. insert into 테이블명 values (테이블 열 개수에 맞는 값들)
insert into table01 values( 1, "박명수");

# 2. insert into 테이블명 (필드명들) values (값들)
insert into table01 (mname,mno) values ("유재석", 2 );
insert into table01 (mname) values ("서장훈");

# 3. 여러개의 레코드 삽입 : insert into 테이블명 (필드명들) values (값들1), (값들2)...
insert into table01 values (4, "강호동"), (5, "김희철");

# 테이블 확인하기
select * from table01;

# [2] SELECT : 레코드(행, 튜플, 가로단위) 조회/검색/찾기
# 1. 전체 필드 조회 : select *(와일드카드) from 테이블명; (* 와일드카드 -> 모든 필드) 
select * from table01;

# 2. 특정 필드 조회 : select 필드명1,필드명2 from 테이블명;
select mname from table01;
select mname, mno from table01;

# 3. 레코드 조건 조회 : select 필드명1, 필드명2 from 테이블명 where 조건절
# "=" 대입이 아니라 같은지 비교 (<=> JS, JAVA "==")
select * from table01 where mname = "유재석";
	# 테이블의 mname 필드가 "유재석"인 데이터 레코드 검색

# [3] UPDATE : 레코드(행, 튜플, 가로단위)의 필드 값 수정
# 1. update 테이블명 set 수정할필드명 = 새로운 값;
update table01 set mno = 10; # mno 열 전체 10으로 수정하기
	# workbench safe mode로 수정이 안됨
	set sql_safe_updates = 0; # workbench safe mode 끄기 (값 1 = 켜기)

# 2. 특정 필드의 조건에 따른 값 수정
# update 테이블명 set 필드명 where 조건문;
update table01 set mno = 3 where mname = "유재석";
update table01 set mname = "유재석B" where mno = 3;

# [4] DELETE : 레코드(행, 튜플, 가로단위) 삭제
# 2. delete from 테이블명 where 조건문;
delete from table01 where mno = 3;
	# mno 필드가 3인 레코드를 삭제
delete from table01 where mname = "강호동";
	# mname 필드가 강호동인 레코드를 삭제
    
# 1. delete from 테이블명;
delete from table01;	# 테이블 레코드 전체 삭제 (레코드 하나씩 처리) * 취소 가능
	# vs
truncate table table01;	# 테이블 레코드 전체 삭제 (전체 처리, 빠름) * 취소 불가능


