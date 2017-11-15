/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  alexandre
 * Created: 15/11/2017
 */

--Criação do banco - Início


--EXEMPLO

CREATE DATABASE dbo.Pizzaria;

CREATE TABLE autor(
    id serial,
    nome varchar(45) NOT NULL,
    constraint pk_Autor PRIMARY KEY (id)
);


CREATE TABLE livro (
    id serial,
    titulo varchar(45),
    constraint pk_Livro PRIMARY KEY (id)
);

CREATE TABLE Livro_Autor (
    idLivro int,
    idAutor int,
    constraint pk_LivroAutor primary key(idLivro, idAutor),
    constraint fk_Liv
);

--Criação do banco - Fim

select * from autor;
select * from livro;
select * from livro_autor;
--teste
SELECT livro.id,livro.titulo FROM livro INNER JOIN livro_autor ON livro.id = livro_autor.idlivro WHERE livro_autor.idautor = 1

roAutor_pk_Livro foreign key(idLivro) references livro(id) on update cascade,