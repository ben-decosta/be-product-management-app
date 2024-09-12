drop database product_management;
drop user user_admin;
create user user_admin with password 'password';
create database product_management with template=template0 owner=user_admin;
\connect product_management;
alter default privileges grant all on tables to user_admin;
alter default privileges grant all on sequences to user_admin;

create table product(
	id serial4 NOT NULL,
	name varchar(20) not null default '',
	price numeric(38,2),
	status varchar(20) NOT NULL DEFAULT '',
	description varchar(50) NOT NULL DEFAULT '',
	CONSTRAINT product_pkey PRIMARY KEY (id)
);

create sequence product_seq increment 1 start 1;