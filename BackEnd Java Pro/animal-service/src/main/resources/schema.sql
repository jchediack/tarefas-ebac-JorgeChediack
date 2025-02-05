  CREATE TABLE animal (
      id INT AUTO_INCREMENT NOT NULL,
      tipo_animal VARCHAR(50) NOT NULL,
      nome_provisorio VARCHAR(255) NOT NULL,
      idade_estimada INT NOT NULL,
      raca VARCHAR(255) NOT NULL,
      data_entrada DATE NOT NULL,
      data_adocao DATE,
      condicoes_chegada TEXT NOT NULL,
      nome_recebedor VARCHAR(255) NOT NULL,
      data_obito DATE,
      porte VARCHAR(50) NOT NULL,
      CONSTRAINT pk_animal PRIMARY KEY (id)
  );