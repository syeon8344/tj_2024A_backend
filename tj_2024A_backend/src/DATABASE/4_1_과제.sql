create table employees (
	employee_id smallint, first_name varchar(10), last_name varchar (10),
	email varchar(40), hire_date date, job_id varchar(20)
);
create table products (
	product_id smallint,
	product_name varchar(30),
	category varchar(30),
	price float,
	stock_quantity mediumint
);
select * from employees, products;

# [문제1]: employees 테이블에 새로운 직원을 추가하세요.
insert into employees values (101, "John", "Doe", "johndoe@example.com", "2024-06-24", "IT_PROG");

# [문제2]: products 테이블에 새로운 제품을 추가하세요.
insert into products (product_id, product_name, category, price, stock_quantity)
	values (201, 'Wireless Mouse', 'Electronics', 29.99, 150);

# [문제3]: employees 테이블에서 모든 직원의 first_name과 email을 조회하세요.
select first_name, email from employees;

# [문제4]: products 테이블에서 price가 1000 인 제품의 product_name과 price를 조회하세요.
select product_name, price from products where price = 1000;

# [문제5]: employees 테이블에서 employee_id가 101인 직원의 email을 'john.doe@company.com'으로 업데이트하세요.
update employees set email = 'john.doe@company.com' where employee_id = 101;

# [문제6]: products 테이블에서 product_id가 201인 제품의 price를 24.99로 업데이트하세요.
update products set price = 24.99 where product_id = 201;

# [문제7]: employees 테이블에서 employee_id가 101인 직원을 삭제하세요.
delete from employees where employee_id = 101;

# [문제8]: products 테이블에서 product_id가 201인 제품을 삭제하세요.
delete from products where product_id = 201;