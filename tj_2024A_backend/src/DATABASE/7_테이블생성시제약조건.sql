# 제약조건
	# foreign key() references 테이블명() 제약조건옵션
		# 1. on delete restrict : 기본값, pk-fk 참조관계가 있으면 pk 삭제를 막는다
        # 2. on delete cascade : 삭제시 pk-fk 참조관계가 있으면 같이 삭제
        # 3. on delete set null : pk-fk 참조관계가 있을 때 pk삭제시 fk = null
        # a. on update restrict : 기본값, ''
        # b. on update cascade : ''
        # c. on update set null : ''
drop database if exists day07;
create database day07;
use day07;
create table table01(
	mno_pk int,
    primary key (mno_pk)
);

create table table02(
	bno_pk int,
    mno_fk int,
    primary key(bno_pk),
    foreign key(mno_fk) references table01(mno_pk) on delete set null
);

insert into table01 values (1), (2), (3), (4), (5);
select * from table01;
insert into table02 values (1,1),(2,1),(3,2),(4,2),(5,3);
select * from table02;

delete from table01 where mno_pk = 1;  #삭제 불가 : 이 레코드를 참조하고 있는 다른 레코드가 있다
delete from table01 where mno_pk = 4;  #삭제 가능 : 참조되고 있는 레코드가 없음
