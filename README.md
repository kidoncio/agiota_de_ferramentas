# Agiota de ferramentas

## Como executar o projeto

Necessário possuir um banco de dados MySQL com os seguintes parâmetros:	

- **Host:** localhost
- **Port:** 3306
- **Username:** root
- **Password:** root

Necessário criar um database com o nome **agiotagem**.

```sql
CREATE DATABASE IF NOT EXISTS agiotagem;

USE agiotagem;
```

Necessário criar as seguintes tabelas:

```sql
CREATE TABLE IF NOT EXISTS amigos
(
    id       int          not null,
    nome     varchar(100) null,
    telefone varchar(30)  null,
    email    varchar(100) null,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS ferramentas
(
    id         int           not null,
    nome       varchar(100)  null,
    marca      varchar(50)   null,
    custo      int           null,
    quantidade int default 0 null,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS emprestimos
(
    id   int           not null,
    emprestimo date          null,
    devolucao  date          null,
    id_ferramenta  int           null,
    id_amigo       int           null,
    quantidade      int default 1 null,
    primary key (id),
    constraint id_amigo
        foreign key (id_amigo) references amigos (id),
    constraint id_ferramenta
        foreign key (id_ferramenta) references ferramentas (id)
);

CREATE index id_amigo_idx
    ON emprestimos (id_amigo);

CREATE index id_ferramenta_idx
    ON emprestimos (id_ferramenta);
```
