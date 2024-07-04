use day07;
# 1. A 테이블
create table table1(
	num int,
    primary key (num)
);
# 2. B 테이블
create table table2(
	no int, primary key (no),
    num int,
    foreign key(num) references table1(num)
);

# 샘플
insert into table1 values (1),(2),(3),(4),(5);
insert into table2 values (1,1),(2,2),(3,1),(4,1),(5,2);

select * from table1;
select * from table2;

# 1. 단일 테이블의 데이터 검색
select * from table1 where num = 1;
select * from table2 where num = 1;

# 2. 다중 테이블의 데이터 검색 : , 이용한 테이블명 구분
	# select * from table1, table2
    # select * from table1, table2 where table1.필드명 = 조건값
    # select * from table1 별칭
		# 별칭 : 주로 테이블명, 필드명을 간추려 SQL 질의에서 사용할 때
        # as 별칭 : 조회 결과의 필드명 설정
select * from table1, table2; # 레코드 25개, 첫번째 테이블 레코드 * 두번째 테이블 레코드 갯수
select * from table1, table2 where num = num; # pk필드와 fk필드 식별 불가 -> 오류 발생
select * from table1, table2 where table1.num = table2.num;
select * from table1 a , table2 b where a.num = b.num; # table1 별칭 a, table2 별칭 b
# PK와 FK가 같은 경우를 검색하는 이유 : 관계를 찾기 위해서
# 3. JOIN 절
# 3-1 교집합 -> 두개이상의 집합/테이블의 공통된 수/데이터 찾기, pk-fk 교집합
# [1] where 절
select * from table1, table2 where table1.num = table2.num; # where : 일반 조건문
# [2] table1 natural join table2 -- pk 필드명과 fk 필드명이 같아야 한다
select * from table1 natural join table2;
# [3] table1 join table2 on 조인조건
select * from table1 join table2 on table1.num = table2.num; # on : JOIN 조건문 (where절과 기능차이는 없다)
# [4] table1 join table2 using (필드명) -- pk 필드명과 fk 필드명이 같아야 한다
select * from table1 join table2 using(num);
# ***[5] table1 inner join table2 on 조인조건 (내부 JOIN -> 교집합)
select * from table1 inner join table2 on table1.num = table2.num;

# day06 MVC 테스트
use day06;
use day06; select * from board;
# 게시물 출력시 mno가 아닌 mid 출력
	# 1. 두 테이블을 출력한다
select * from board, member;
	# 2. 두 테이블의 관계 기준으로 (내부/교집합) 조인한다.
select * from board, member where board.mno = member.mno;
select * from board natural join member;
select * from board join member on board.mno = member.mno;
select * from board join member using(mno);
select * from board inner join member on board.mno - member.mno;
	# 테이블명을 간소화할때 : 별칭, 테이블명 뒤에 별칭/별명 작성
select * from reply r inner join member m on r.mno = m.mno where r.bno = 1;