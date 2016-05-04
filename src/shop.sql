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
	id int not null auto_increment,
	/* ����Ա��¼�� */
	login varchar(20),
	/* ����Ա���� */
	name varchar(20),
	/* ����Ա���� */
	pass varchar(20),
	/* ���ñ��Ϊ���� */
	primary key (id)
);

/*============================*/
/*     Table����Ʒ����ṹ                      */
/*============================*/
create table category
(
   /* ����ţ��Զ����� */
   id  int not null auto_increment,
   /* ������� */
   type varchar(20),
   /* ����Ƿ�Ϊ�ȵ�����ȵ������п�����ʾ����ҳ*/
   hot  bool default false,
   /* ��������������λ����Ա���� */
   aid int,
   /* ���������Ϊ����*/
   primary key (id)
);

/*�����������*/
insert into account(login,name,pass) values('admin','����Ա','admin');
insert into account(login,name,pass) values('user','�ͷ�A','user');

insert into category (type,hot,aid) values('��ʿ����',true,1);
insert into category (type,hot,aid) values('Ůʿ����',true,1);
insert into category (type,hot,aid) values('��ͯ����',true,2);

select * from account;
select * from category;