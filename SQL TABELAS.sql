create table Hotel (
	HotelId int primary key identity,
	Rate float ,
	Category varchar(50) not null,
	Description varchar(60) not null,
	HotelName varchar(50) not null,
	ParkingIncluded bit ,
	Rating int ,
	Street varchar(100) not null,
	Cityid int not null,
	constraint fk_cidade foreign key (CityId) references CidadeHoteis(CityId)
)

create table CidadeHoteis(
	CityId int primary key identity,
	City_Name varchar(50) not null,
	State_Name varchar(50) not null
)

create table ClienteHoteis(
id_Cliente int PRIMARY KEY identity,
firstname VARCHAR (20) not null,
name VARCHAR (40) NOT NULL,
zip VARCHAR(5) not null,
address CHAR(40) NOT NULL,
cityid int not null,
constraint fk_cityId foreign key (cityid) references Cidade(cityid)
)

CREATE TABLE Quarto(
id_quarto int primary key identity,
hotelId int not null,
numeroQuarto int not null,
id_Cliente int not null,
isOcupado bit not null,
preco money not null,
constraint fk_hotelId foreign key (hotelid) references Hotel(Hotelid),
constraint fk_clienteid foreign key(id_cliente) references ClienteHoteis(id_Cliente)
)

CREATE TABLE reservation(
id_reserva int PRIMARY KEY identity,
id_cliente int not null,
id_quarto int not null,
constraint fk_clienteid foreign key(id_cliente) references ClienteHoteis(id_Cliente),
constraint fk_quartoid foreign key (id_quarto) references Quarto(id_quarto)
)