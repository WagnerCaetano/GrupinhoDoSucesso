create table WCidadeHoteis(
	CityId int primary key identity,
	City_Name varchar(50) not null,
	State_Name char(2) not null
)
insert into WCidadeHoteis(City_Name,State_Name) values ('Campinas','SP'),('São Paulo','SP'),('Sorocaba','SP'),
('Porto Alegre','RS'),('Osório','RS'),('Gramado','RS'),('Rio de Janeiro','RJ'),('Niteroi','RJ'),('Nova Friburgo','RJ')
select * from WCidadeHoteis

create table WHotel (
	HotelId int primary key identity,
	Category varchar(50) not null,
	HotelName varchar(50) not null,
	Rating int ,
	Street varchar(100) not null,
	Cityid int not null,
	constraint fk_cidade foreign key (CityId) references WCidadeHoteis(CityId)
)
create rule r_rating as @rating >=1 and @rating <=5 
exec sp_bindrule r_rating,'WHotel.Rating'
drop table WHotel
insert into WHotel(Category,HotelName,Rating,Street,Cityid) values ('Principal','Mc Camly Plaza Hotel',5.0,'Rua João Felipe Xavier da Silva',1),('Principal','Cushing Manor Bed & Breakfast',4.8,'Rua General Andrade Neves',4),('Principal','Vip Hotel',4.2,'Rua 1º de Março',7),
('Litoraneo','Long Island Hotels',4.5,'Rua Tomás Gonzaga',2),('Litoraneo','Siouxland Resort',4.7,'Rua Luiz João Batista',5),('Litoraneo','Golden Eagle Resort',4.0,'Rua Olavo de Paula',8),
('Barato','Sunapee Harbor Cottages',3.2,'Rua Professor Walter Carretero',3),('Barato','Rebecca Sharrow',2.8,'Rua Madre Verônica',6),('Barato','Home Ridge Inn & Suites',3.8,'Rua Monerat',9)
SELECT * FROM WHotel
create table WClienteHoteis(
id_Cliente int PRIMARY KEY identity,
firstname VARCHAR (20) not null,
name VARCHAR (40) NOT NULL,
cpf varchar(9) not null,
zip VARCHAR(5) not null,
address CHAR(40) NOT NULL,
cityid int not null,
constraint fk_cityId foreign key (cityid) references WCidadeHoteis(cityid)
)

CREATE TABLE WQuarto(
id_quarto int primary key identity,
hotelId int not null,
numeroQuarto int not null,
id_Cliente int,
isOcupado bit not null,
preco money not null,
constraint fk_hotelId foreign key (hotelid) references WHotel(Hotelid),
constraint fk_clienteid foreign key(id_cliente) references WClienteHoteis(id_Cliente)
)
insert into WQuarto (hotelId,numeroQuarto,isOcupado,preco) values (1,7,0,289.99),(1,14,0,253.59),(2,3,0,220.00),(2,8,0,279.99),(3,21,0,239.99),(3,15,0,260.60),
(4,18,0,450.0),(4,30,0,360.00),(5,5,0,399.99),(5,2,0,300.00),(6,9,0,320.30),(6,7,0,349.99),
(7,9,0,198.99),(7,16,0,139.99),(8,22,0,164.99),(8,11,0,184.40),(9,12,0,127.90),(9,13,0,150.90)

select * from WQuarto , WHotel , WCidadeHoteis where WQuarto.hotelId = WHotel.HotelId and WCidadeHoteis.CityId = WHotel.cityid