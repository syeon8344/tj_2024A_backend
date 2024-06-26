#drop tables product, cart, category, orderTable, orderDetail;

create table category(
	categoryCode int auto_increment,
    categoryName varchar(20),
    primary key (categoryCode)
);

create table product(
	productCode int auto_increment,
    productName varchar(20),
    productPrice mediumint,
    categoryCode int,
    primary key (productCode),
    foreign key (categoryCode) references category(categoryCode)
);

create table cart(
	cartCode int auto_increment,
	productCode int,
    amount smallint,
    primary key (cartCode),
    foreign key (productCode) references product(productCode)
);
create table orderTable(
	orderCode int auto_increment,
    orderTime datetime,
    primary key (orderCode)
);

create table orderDetail(
	orderDetailCode int auto_increment,
    orderCode int,
    productCode int,
    orderAmount smallint,
    primary key (orderDetailCode),
    foreign key (productCode) references product(productCode),
    foreign key (orderCode) references orderTable(orderCode)
);