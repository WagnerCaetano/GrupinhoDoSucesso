create table WCidadeHoteis(
	City_Name varchar(50) primary key not null,
	State_Name char(2) not null
)
go

insert into WCidadeHoteis(City_Name,State_Name) values ('Campinas','SP'),('São Paulo','SP'),('Sorocaba','SP'),
('Porto Alegre','RS'),('Osório','RS'),('Gramado','RS'),('Rio de Janeiro','RJ'),('Niteroi','RJ'),('Nova Friburgo','RJ')

go

/*------------------------------------------------------*/
create table WCategoriais(
	CatNome varchar(30) primary key not null,
	Descricao varchar(60) not null
)
go
insert into WCategoriais values ('Principal','Os quartos de hóteis mais requisitados.'),('Litoraneo','Os quartos de hóteis próximos ao mar'),('Barato','Os quartos de hóteis mais
baratos')
go

/*------------------------------------------------------*/

create table WHotel (
	HotelId int primary key identity,
	Category varchar(30) not null,
	HotelName varchar(50) not null,
	Rating float default(1),
	Street varchar(100) not null,
	City varchar(50) not null,
	fotoH image,
	constraint fk_cidade foreign key (City) references WCidadeHoteis(City_Name),
	constraint fk_categorias foreign key(Category) references WCategoriais(CatNome)
)
go
/*create rule r_rating as @rating >=1 and @rating <=5 */
exec sp_bindrule r_rating,'WHotel.Rating'
/*select * from WHOTEL*/

update WHotel set fotoH=(select BulkColumn from Openrowset (Bulk 'E:\github repository\GrupinhoDoSucesso\Fotos\fotos hoteis\01.jpg ',Single_Blob) as img) where HotelId = 1

select * from WHotel

drop table WHotel


select DATALENGTH(fotoH) from Whotel where Hotelid=1
go
insert into WHotel(Category,HotelName,Rating,Street,City) values ('Principal','Mc Camly Plaza Hotel',5.0,'Rua João Felipe Xavier da Silva','Campinas'),('Principal','Cushing Manor Bed & Breakfast',4.8,'Rua General Andrade Neves','Porto Alegre'),('Principal','Vip Hotel',4.2,'Rua 1º de Março','Rio de Janeiro'),
('Litoraneo','Long Island Hotels',4.5,'Rua Tomás Gonzaga','São Paulo'),('Litoraneo','Siouxland Resort',4.7,'Rua Luiz João Batista','Osório'),('Litoraneo','Golden Eagle Resort',4.0,'Rua Olavo de Paula','Niteroi'),
('Barato','Sunapee Harbor Cottages',3.2,'Rua Profes4sor Walter Carretero','Sorocaba'),('Barato','Rebecca Sharrow',2.8,'Rua Madre Verônica','Gramado'),('Barato','Home Ridge Inn & Suites',3.8,'Rua Monerat','Nova Friburgo')
go


/*------------------------------------------------------*/


create table WClienteHoteis(
id_Cliente int PRIMARY KEY identity,
firstname VARCHAR (40) NOT NULL,
lastname varchar(40) not null,
pw VARCHAR(12) not null,
email varchar(70) not null,
cpf varchar(9) not null,
cep VARCHAR(5) not null,
address CHAR(40) NOT NULL,
clicity varchar(50) not null,
)
go
/* regra para a senha e nome */



/*------------------------------------------------------*/



CREATE TABLE WQuarto(
id_quarto int primary key identity,
hotelId int not null,
numeroQuarto int not null,
id_Cliente int,
isOcupado bit not null default(0),
preco money not null default (10),
fotoQ image ,
constraint fk_hotelId foreign key (hotelid) references WHotel(Hotelid),
constraint fk_clienteid foreign key(id_cliente) references WClienteHoteis(id_Cliente)
)
go

insert into WQuarto (hotelId,numeroQuarto,preco) values (1,7,289.99),(1,14,253.59),(2,3,220.00),(2,8,279.99),(3,21,239.99),(3,15,260.60),
(4,18,450.0),(4,30,360.00),(5,5,399.99),(5,2,300.00),(6,9,320.30),(6,7,349.99),
(7,9,198.99),(7,16,139.99),(8,22,164.99),(8,11,184.40),(9,12,127.90),(9,13,150.90)

go

select * from WQuarto
/*
update WQuarto set fotoQ=
(select BulkColumn from Openrowset (Bulk 'E:\github repository\GrupinhoDoSucesso\Fotos\fotos quartos\18.jpg ',Single_Blob) as img) where id_quarto =18
*/
/*------------------------------------------------------*/



create table WCarrinho(
id_Cliente int primary key,
id_quarto int ,
preco money,
constraint fk_id_clienteidC foreign key (id_Cliente) references WClienteHoteis(id_Cliente),
constraint fk_id_quartoid foreign key (id_quarto) references WQuarto(id_quarto)
)
go

/*------------------------------------------------------*/


create table precoQuartoChange(
idTrans int primary key identity,
id_quarto int not null,
precoAntes money not null,
precoDepois money not null,
data datetime not null default(getDATE())
)
go

create table descCategoriaChange(
idTrans int primary key identity,
categoria varchar(30) not null,
descAnterior varchar(60) not null,
descNov varchar(60) not null,
data datetime not null default (getDATE())
)
go


/*---------------Criando trigger de mudança-----------------*/




CREATE TRIGGER sp_alterpreco 
ON WQuarto
FOR UPDATE
AS 
begin
declare @precoAnterior money , @precoAtual money , @id int

SELECT @precoAnterior = deleted.preco ,@id = deleted.id_quarto FROM deleted  
SELECT @precoAtual = inserted.preco from inserted
insert into precoQuartoChange (id_quarto,precoAntes,precoDepois,data) values (@id,@precoAnterior,@precoAtual,GETDATE())

end



drop trigger sp_alterpreco
update WQuarto set preco=55.90 where id_quarto=1
update WQuarto set preco=289.99 where id_quarto=1




CREATE TRIGGER sp_altercat
on WCategoriais
for update
as
begin
declare @descAnterior varchar(60) ,@descNova varchar(60),@categoria varchar(30)
select @descAnterior = deleted.descricao , @categoria = deleted.catnome from deleted
select @descNova = inserted.descricao from inserted

insert into descCategoriaChange(categoria,descAnterior,descNov,data) VALUES (@categoria,@descAnterior,@descNova,getdate())
end


drop trigger sp_altercat
update WCategoriais set descricao='Os quartos de hóteis maisbaratos' where CatNome='Barato'
update WCategoriais set descricao='Os quartos de hóteis mais baratos' where CatNome='Barato'



/* stored procedure */


create proc	sp_catalogo @cidade varchar(50),@hotel varchar(50)
as
begin
	if (@cidade != null)
	begin
	select * from WQuarto , WHotel , WCidadeHoteis,WCategoriais where 
	WQuarto.hotelId = WHotel.HotelId and WCidadeHoteis.City_Name = WHotel.city and WHotel.Category = WCategoriais.CatNome and WHotel.City = @cidade
	end

	else if (@hotel != null)
	begin
	select * from WQuarto , WHotel , WCidadeHoteis,WCategoriais where 
	WQuarto.hotelId = WHotel.HotelId and WCidadeHoteis.City_Name = WHotel.city and WHotel.Category = WCategoriais.CatNome and WHotel.HotelName = @hotel
	end
	
	else 
	begin
	select * from WQuarto , WHotel , WCidadeHoteis,WCategoriais where 
	WQuarto.hotelId = WHotel.HotelId and WCidadeHoteis.City_Name = WHotel.city and WHotel.Category = WCategoriais.CatNome
	end
end

drop proc sp_catalogo



create proc sp_buscarlog @tabela_log varchar(20),@idTrans int
as
begin
		if(isnull(@idTrans,0) = 0)
		begin

			if (@tabela_log = 'categoria')
			begin
				select * from descCategoriaChange
			end
			else if (@tabela_log ='preco')
			begin
				select * from precoQuartoChange
			end
		
		end
		
		else
		begin
			if (@tabela_log = 'categoria')
			begin
				select * from descCategoriaChange where idTrans = @idTrans
			end
			else if (@tabela_log ='preco')
			begin
				select * from precoQuartoChange where idTrans = @idTrans
			end
		end
end

exec sp_catalogo null,null

exec sp_buscarlog 'categoria',null


/* https://social.msdn.microsoft.com/Forums/pt-BR/1d8584bb-62a4-47fb-b71f-d5ef19965d69/trigger-quotfor-each-rowquot-em-sql-server?forum=transactsqlpt */


drop table WCarrinho
go
drop table WClienteHoteis
go
drop table WQuarto
go
drop table WHotel
go
drop table WCategoriais
go
drop table WCidadeHoteis