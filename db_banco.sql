CREATE TABLE categoria(
    idCategoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(50),
    tamanho VARCHAR(20),
    embalagem VARCHAR(20)
);


CREATE TABLE produto (
  idProduto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(50) NOT NULL,
  qtd INT NOT NULL,
  preco DOUBLE NOT NULL,
  quantidadeEstoque INT NOT NULL,
  quantidadeMinima INT NOT NULL,
  quantidadeMaxima INT NOT NULL,

);

select * from categoria;
