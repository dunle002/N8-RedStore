Create database Savis_TTS
use Savis_TTS
drop database Savis_TTS
select * from users
------
CREATE TABLE [users] (
  [id] INT IDENTITY(1,1) NOT NULL,
  [pass_word] NVARCHAR(255) NULL,
  [role] INT NOT NULL,
  [status] INT NOT NULL,
  [user_name] NVARCHAR(255) NULL,
  PRIMARY KEY CLUSTERED ([id] ASC)
) 
INSERT INTO users(pass_word,role,status,user_name) VALUES ('admin',3,1,'admin')
,('seller',2,1,'seller')
,('minhduong12',1,0,'duong123')
select * from users
DELETE FROM users
WHERE id = 1;

--------------------------
CREATE TABLE [address] (
  [id] INT IDENTITY(1,1) NOT NULL,
  [description] NVARCHAR(255) NULL,
  [user_id] INT NULL,
  PRIMARY KEY CLUSTERED ([id] ASC),
  CONSTRAINT [FKda8tuywtf0gb6sedwk7la1pgi] FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
) 
SET IDENTITY_INSERT address OFF;
INSERT INTO address(description,user_id) VALUES (N'Nam Từ Liêm,HÀ Nội',3)
,(N'Nội Bài, Hà Nội',1)
,(N'Mỹ Đình, Hà Nội',2)
-----------------------------
CREATE TABLE [bill] (
  [id] INT IDENTITY(1,1) NOT NULL,
  [date] DATE NULL,
  [status] INT NULL,
  [total] FLOAT NOT NULL,
  [user_id] INT NULL,
  PRIMARY KEY CLUSTERED ([id] ASC),
  CONSTRAINT [FKqhq5aolak9ku5x5mx11cpjad9] FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
)
------------------------
CREATE TABLE [bill_detail] (
  [bill_id] int NOT NULL,
  [product_id] int NOT NULL,
  [quantity] int NOT NULL,
  CONSTRAINT [PK_bill_detail] PRIMARY KEY ([bill_id],[product_id]),
  CONSTRAINT [FK_bill_detail_product] FOREIGN KEY ([product_id]) REFERENCES [product] ([id]),
  CONSTRAINT [FK_bill_detail_bill] FOREIGN KEY ([bill_id]) REFERENCES [bill] ([id])
);
-------------------------
CREATE TABLE [card] (
  [id] int NOT NULL IDENTITY(1,1),
  [bank] NVARCHAR(255) NULL,
  [number] NVARCHAR(255) NULL,
  [user_id] int NULL,
  CONSTRAINT [PK_card] PRIMARY KEY ([id]),
  CONSTRAINT [FK_card_user] FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
);
INSERT INTO card(bank,number,user_id) VALUES ('VCB','34059345',1)
,('TP','8345089543',1)
,('SAC','34583405',2)
,('TP','2394307420934',3)
,('VCB','810398120381',3)
,('VCB','06496465487',2)
,('SAC','7987646532132',1)
,('SAC','689712132164',3);
-------------------------
CREATE TABLE [category] (
  [id] int NOT NULL IDENTITY(1,1),
  [name] NVARCHAR(255) NULL,
  CONSTRAINT [PK_category] PRIMARY KEY ([id])
);
drop table category
select * from users
INSERT INTO category(name) VALUES (N'Đồng Hồ'),
(N'Giày'),
(N'Nước Hoa')

---------------------
CREATE TABLE [customer_info] (
  [id] int NOT NULL IDENTITY(1,1),
  [birthday] date NULL,
  [email] NVARCHAR(255) NULL,
  [fullname] NVARCHAR(255) NULL,
  [linkavt] NVARCHAR(255) NULL,
  [phone] NVARCHAR(255) NULL,
  [user_id] int NULL,
  CONSTRAINT [PK_customer_info] PRIMARY KEY ([id]),
  CONSTRAINT [FK_customer_info_user] FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
);
INSERT INTO customer_info([birthday],[email],[fullname],[linkavt],[phone],[user_id]) VALUES ('2002-10-17','duong@gmail.com',N'Dương',NULL,'099934567',3)
,('2003-01-04','dunleee105@gmail.com',N'Minh Dương','7d70a5e44c9e44369cab01b4b8ebbf8b.png','966955940',1),
('2004-05-06','huongpham@gmail.com',N'Min Dươn','5edafbfb53ea48e19f509e44c7ef4551.png','966955940',2)
-----------------------------
CREATE TABLE [product] (
  [id] int NOT NULL IDENTITY(1,1),
  [amount] int NOT NULL,
  [name] NVARCHAR(255) NULL,
  [price] float NOT NULL,
  [quantity] int NOT NULL,
  [thumbnail_photo] NVARCHAR(255) NULL,
  [category_id] int NULL,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_product_category] FOREIGN KEY ([category_id]) REFERENCES [category] ([id])
);
INSERT INTO product(amount,name,price,quantity,thumbnail_photo,category_id) VALUES (0,N'Đồng hồ Jacques Lemans',660,20,'1_1_1.jpg',1),
(0,N'Đồng Hồ EPOS SWISS',545,20,'1_2_1.jpg',1),
(20,N'Đồng hồ Diamond D',233,20,'1_3_1.jpg',1),
(20,N'ĐỒNG HỒ PHILIPPE AUGUSTE',780,20,'1_4_1.jpg',1),
(0,N'Đồng hồ Atlantic Swiss',749,20,'1_5_1.jpg',1),
(20,N'GIÀY CONTINENTAL 80',780,20,'6_26_1.jpg',2),
(0,N'GIÀY SUPERSTAR',749,20,'6_27_1.jpg',2),
(0,N'GIÀY SUPERSTAR PRIDE',449,20,'6_28_1.jpg',2),
(0,N'GIÀY STAN SMITH',850,20,'6_29_1.jpg',2),
(20,N'GIÀY STAN SMITH PRIDE',599,20,'6_30_1.jpg',2)
-----------------------------
CREATE TABLE [product_detail] (
  [id] int NOT NULL IDENTITY(1,1),
  [brand] NVARCHAR(255) NULL,
  [color] NVARCHAR(255) NULL,
  [description] NVARCHAR(255) NULL,
  [material] NVARCHAR(255) NULL,
  [product_id] int NULL,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_product_detail_product] FOREIGN KEY ([product_id]) REFERENCES [product] ([id])
);
INSERT INTO product_detail(brand,color,description,material,product_id) VALUES (N'Hublob',N'Đen Xanh',N'Mang lại vẻ sành điệu, lịch lãm và đầy nam tính cho người đàn ông hiện đại.',N'Vàng',1),
(N'Rolex',N'Trắng',N'Mang lại vẻ sành điệu, lịch lãm và đầy nam tính cho người đàn ông hiện đại.',N'Vàng',2),
(N'Rolex',N'Đen Xanh',N'Mang lại vẻ sành điệu, lịch lãm và đầy nam tính cho người đàn ông hiện đại.',N'Vàng',3),
(N'Hublob',N'Đen Xanh',N'Mang lại vẻ sành điệu, lịch lãm và đầy nam tính cho người đàn ông hiện đại.',N'Vàng',4),
(N'Nike',N'Trắng',N'Mang lại vẻ sành điệu, lịch lãm và đầy nam tính cho người đàn ông hiện đại.',N'Vải',5),
(N'Nike',N'Trắng',N'Mang lại vẻ sành điệu, lịch lãm và đầy nam tính cho người đàn ông hiện đại.',N'Vải',6);
--------------------------
CREATE TABLE [product_image] (
  [id] int NOT NULL IDENTITY(1,1),
  [link] NVARCHAR(255) NULL,
  [product_id] int NULL,
  PRIMARY KEY ([id]),
  CONSTRAINT [FK_product_image_product] FOREIGN KEY ([product_id]) REFERENCES [product] ([id])
);
INSERT INTO product_image(link,product_id) VALUES ('1_1_1.jpg',1),
('1_1_2.jpg',1),
('1_1_3.jpg',1),
('1_1_4.jpg',1),
('1_2_1.jpg',2),
('1_2_2.jpg',2),
('1_2_3.jpg',2),
('1_2_4.jpg',2),
('1_3_1.jpg',3),	
('1_3_2.jpg',3),
('1_3_3.jpg',3),
('1_3_4.jpg',3),
('1_4_1.jpg',4),
('1_4_2.jpg',4),
('1_4_3.jpg',4),
('1_4_4.jpg',4),
('1_5_1.jpg',5),
('1_5_2.jpg',5),
('1_5_3.jpg',5),
('1_5_4.jpg',5)






