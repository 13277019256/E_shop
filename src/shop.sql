drop database if exists shop;
/*�������ݿ⣬�����ñ���*/
create database shop default character set utf8;

use shop;
/*ɾ������Ա��*/
drop table if exists account;
/*ɾ����Ʒ����*/
drop table if exists category;

/*============================*/
/*      Table������Ա��ṹ                       */
/*============================*/
create table account
(
	/* ����Ա��ţ��Զ����� */
	id int primary key not null auto_increment,
	/* ����Ա��¼�� */
	login varchar(20),
	/* ����Ա���� */
	name varchar(20),
	/* ����Ա���� */
	pass varchar(20)
);

/*============================*/
/*     Table����Ʒ����ṹ                      */
/*============================*/
create table category
(
   /* ����ţ��Զ����� */
   id  int primary key not null auto_increment,
   /* ������� */
   type varchar(20),
   /* ����Ƿ�Ϊ�ȵ�����ȵ������п�����ʾ����ҳ*/
   hot  bool default false,
   /* ��������������λ����Ա���� */
   account_id int,
   constraint aid_FK foreign key(account_id) references account(id)
);

/*�����������*/
insert into account(login,name,pass) values('admin','����Ա','admin');
insert into account(login,name,pass) values('user','�ͷ�A','user');

insert into category (type,hot,account_id) values('��ʿ����',true,1);
insert into category (type,hot,account_id) values('Ůʿ����',true,1);
insert into category (type,hot,account_id) values('��ͯ����',true,2);

select * from account;
select * from category;