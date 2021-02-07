# Para rodar o mysql no docker:
#
# docker run --name=mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Ads_12345 -e MYSQL_DATABASE=dbagenda -d mysql
#
##############################################################################################################
#
# Para acessar o console do mysql para executar comandos SQLs nele:
#
# docker exec -it mysql mysql -u root -pAds_12345 --database dbagenda 
#
##############################################################################################################
#
#
# comando para criar uma tabela de contatos suportada para a aplicação
create table contatos ( 
	idcon bigint not null primary key auto_increment, 
	nome varchar(255),
	fone varchar(255),
	fone2 varchar(255),
	email varchar(255),
	tipo varchar(255)
)
