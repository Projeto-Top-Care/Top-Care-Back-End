INSERT IGNORE INTO especie VALUES (1, 'Cachorro'), (2, 'Gato'), (3, 'Coelho'), (4, 'Pássaro'), (5, 'Hamster'), (6, 'Peixe'), (7, 'Tartaruga');

INSERT IGNORE INTO servico VALUES
       (1, 'Bem estar', 'Utilizamos produtos de alta qualidade e específicos para cada tipo de pelagem, garantindo um banho suave e eficaz, que deixa o seu animal limpo, cheiroso e com a pele saudável. Além disso, oferecemos uma variedade de serviços adicionais.', 'Banho', null),
       (2, 'Bem estar', 'Na tosa, os profissionais realizam cortes adequados às necessidades de cada raça, garantindo um visual bonito e saudável. Além disso, o serviço inclui a limpeza de ouvidos, corte de unhas e, muitas vezes, verificação geral da saúde do animal.', 'Banho e Tosa', null),
       (3, 'Saúde', 'O serviço de consultas médicas em um pet shop garante a saúde e o bem-estar dos animais de estimação. Veterinários experientes realizam exames de rotina, diagnósticos e tratamentos necessários.', 'Consultas', null),
       (4, 'Saúde', 'O serviço de vacinação em um pet shop protege a saúde dos animais de estimação. Veterinários aplicam vacinas essenciais para prevenir doenças graves, garantindo a imunidade necessária. .', 'Vacinação', null);


INSERT IGNORE INTO categoria VALUES (1, 'Alimentação'), (2, 'Medicamentos'), (3, 'Acessórios'), (4, 'Higiene');