drop database if exists shop;
/*�������ݿ⣬�����ñ���*/
create database shop default character set utf8;

use shop;
/*ɾ������Ա��*/
drop table if exists account;
/*ɾ����Ʒ����*/
drop table if exists category;
/*ɾ����Ʒ��Ϣ��*/
drop table if exists product;

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
   aid int,
   constraint aid_FK foreign key(aid) references account(id)
);

/*=============================*/
/* Table: ��Ʒ��ṹ	 		   */
/*=============================*/
create table product
(
   /* ��Ʒ���,�Զ����� */
   id                  int primary key not null auto_increment,
   /* ��Ʒ���� */
   name                varchar(50),
   /* ��Ʒ�۸� */
   price               decimal(8,2),
   /* ��ƷͼƬ */
   pic                 varchar(300),
   /* ��Ʒ�򵥽��� */
   remark              longtext,
   /* ��Ʒ��ϸ���� */
   xremark             longtext,
   /* ��Ʒ�������� */
   date                timestamp default CURRENT_TIMESTAMP,
   /* �Ƿ�Ϊ�Ƽ���Ʒ,�Ƽ���Ʒ���п�����ʾ���̳���ҳ */
   commend             bool,
   /* �Ƿ�Ϊ��Ч��Ʒ,��Ч��Ʒ���п�����ʾ���̳���ҳ */
   open                bool,
   /* ��Ʒ���ڵ������*/
   cid                  int,
   constraint cid_FK foreign key(cid) references category(id)
);


/*�����������*/
insert into account(login,name,pass) values('admin','����Ա','admin');
insert into account(login,name,pass) values('zhangsan','����','user');

INSERT INTO category (type,hot,aid) VALUES ('��ʿ����',true,1);
INSERT INTO category (type,hot,aid) VALUES ('Ůʿ����',true,1);
INSERT INTO category (type,hot,aid) VALUES ('��ͯ����',true,2);
INSERT INTO category (type,hot,aid) VALUES ('��������',true,2);

/* ��Ʒ�������� */
INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('ʥ������',2999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('��������',1999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('��������',3999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('����������',4999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('����Ůװ',199.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('ѩ��ѥ',299.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('ŷ��Ůװ',3999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('Ů������',4999.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,2);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('���ܵ�����',3998.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('��ʿ������',299.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('����Ӳ��',599.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('��ˮţ����',399.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,3);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('������',150.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('�ϰ���',199.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('�յ�',3599.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('����',699.00,'test.jpg','�����Ǽ򵥽���','��������ϸ����',true,true,4);

SELECT * FROM account;
SELECT * FROM category;
SELECT * FROM product;