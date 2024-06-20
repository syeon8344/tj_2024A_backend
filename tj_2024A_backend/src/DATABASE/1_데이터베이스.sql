/* 여러 줄 주석*/
# 한 줄 주석
-- 한 줄 주석
/* SQL 질의어 */
/*
	1. 주의할 점
		sql명령어 문장 입력후 ;로 끝마치기
        - 문자처리 ' ' 혹은 " "
        - 명령어/키워드는 대소문자 구분 안하지만 데이터/자료는 당연히 구분함
	2. 실행
		- 명령어 단위 실행, 전체 실행
        - 명령어 단위 실행 : 실행 명령어에 커서 두고 Ctrl + Enter, 상단 번개모양 I
        - 전체 실행 : Ctrl + Shift + Enter 또는 I 없는 번개 아이콘
	3. 실행 결과
		하단 Result 창
        하단 Output 창 : 실행 결과 상태 창
        
  ---------------------------------------------------------------------
	
    DDL : Data Definition Language / 데이터 정의어
		1. Create
			create database 새로운DB명;
            create table 새로운T명();
		2. Drop
			drop database 삭제할DB명;
				drop database if exits 삭제할DB명;
			drop table 삭제할T명;
				drop table if exists 삭제할T명;
                
		- 그 외
        show
			show databases	: DBSERVER 내 데이터베이스 목락
            show variables like 'datadir' : DBSERVER 내 데이터베이스 S가
		use
			use 사용할DB명
    DML : Data Manipulation Language / 데이터 조작어
    
    DCL : Data Control Language / 데이터 제어어
    
*/
# 현재 DB SERVER 존재하는 데이터베이스를 확인
show databases;
# 2. 현재 DB SERVER 존재하는 로컬(C드라이브) 위치 확인
show variables like 'datadir'; # C:\ProgramData\MySQL\MySQL Server 8.0\Data\ [숨김폴더]

# 3. 데이터베이스 생성
CREATE DATABASE myDB;
show databases;

# 4. 데이터베이스 삭제
# 4. 데이터베이스 삭제
drop database myDB;
# 4.2 해당 데이터베이스가 존재한다면 삭제
drop database if exists myDB;

# 5. DB SERVER에는 여러 데이터베이스가 존재:
use myDB;

# 실습 1
drop database if exists test2;
create database test2;
show databases;
show variables like 'datadir';
use test2;