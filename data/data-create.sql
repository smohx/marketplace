create table users
(
	p_userid	varchar(30) primary key,
	p_fullname   varchar(30) not null,
	p_emailid	varchar(30) unique not null,
	p_passwordencoded	varchar(30) not null,
	p_role	varchar(30) not null,
	p_imageurl	varchar(30)
);
create table products
(
	p_code	varchar(30) primary key,
	p_name	varchar(30) not null,
	p_productsku	varchar(30) not null,
	p_description	varchar(30),
	p_defaultimageurl	varchar(30),
	p_price double
);
create table categories
(
	p_code	varchar(30) primary key,
	p_name	varchar(30) not null,
	p_description	varchar(30),
	p_level	varchar(30) not null,
	p_supercategory	varchar(30),
	p_iconurl	varchar(30)
);

create table productmedias
(
	p_mediacode	varchar(30) primary key,
	p_productcode	varchar(30) not null,
	p_mediatype	varchar(30) not null,
	p_mediaurl	varchar(30) not null
);

create table prod2catrel
(
	p_code	varchar(30) primary key,
	p_sourceproduct	varchar(30) not null,
	p_targetcategory	varchar(30) not null
);
CREATE TABLE productsequence (
     id INTeger PRIMARY KEY AUTO_INCREMENT
)AUTO_INCREMENT=1000000;

CREATE TABLE categorysequence (
     id INTeger PRIMARY KEY AUTO_INCREMENT
)AUTO_INCREMENT=1000000;
CREATE TABLE productmediasequence (
     id INTeger PRIMARY KEY AUTO_INCREMENT
)AUTO_INCREMENT=1000000;
CREATE TABLE c2prelationsequence (
     id INTeger PRIMARY KEY AUTO_INCREMENT
)AUTO_INCREMENT=1000000;
CREATE TABLE tempimagesequence (
     id INTeger PRIMARY KEY AUTO_INCREMENT
)AUTO_INCREMENT=1000000;