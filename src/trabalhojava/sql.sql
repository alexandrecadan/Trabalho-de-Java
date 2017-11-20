CREATE TABLE cliente (
    id int(11) NOT NULL AUTO_INCREMENT,
    nome varchar(255),
    sobrenome varchar(255),
    telefone varchar(255),
    endereco varchar(255),
    PRIMARY KEY (`id`)    
);

CREATE TABLE pedido (
    id int(11) NOT NULL AUTO_INCREMENT,
    idCliente int,
    idPizza int,
    valorTotal double,
    estado varchar(255),
    PRIMARY KEY (`id`),
    KEY `idCliente` (`idCliente`),
    KEY `idPizza` (`idPizza`)
);

CREATE TABLE status (
    aberto int,
    caminho int,
    entregue int
);

CREATE TABLE pizza (
	id int(11) NOT NULL AUTO_INCREMENT,
    idSaborUm int,
    idSaborDois int,
    idForma int,
    valor double,
	PRIMARY KEY (`id`),
    KEY `idSaborUm` (`idSaborUm`),
    KEY `idSaborDois` (`idSaborDois`),
    KEY `idForma` (`idForma`)
);

CREATE TABLE sabor (
	saborId serial,
    tipoSabor long,
    nomeSabor varchar(255),
    precoSabor double
);

CREATE TABLE forma (
	id int(11) NOT NULL AUTO_INCREMENT,
    idTipoForma int,
    medida double,
    valorForma double,
    valorTotalForma double,
    PRIMARY KEY (`id`),
    KEY `idTipoForma` (`idTipoForma`)
);

CREATE TABLE circulo (
	id int(11) NOT NULL AUTO_INCREMENT,
    raio double,
    PRIMARY KEY (`id`)
);

CREATE TABLE quadrado (
	id int(11) NOT NULL AUTO_INCREMENT,
    lado double,
    PRIMARY KEY (`id`)
);
CREATE TABLE triangulo (
	id int(11) NOT NULL AUTO_INCREMENT,
    lado double,
    PRIMARY KEY (`id`)
);