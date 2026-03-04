DROP TABLE IF EXISTS foods;

-- Definindo os tipos das colunas
CREATE TABLE foods (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    image VARCHAR(500)
);

-- Inserindo os dados (o ID será gerado automaticamente)
INSERT INTO foods (title, price, image) VALUES ('Hambúrguer', 29.90, 'https://www.allrecipes.com/thmb/_OKqViGmlNaa9GV_c4cpwpwApGk=/0x512/filters:no_upscale():max_bytes(150000):strip_icc()/25473-the-perfect-basic-burger-DDMFS-4x3-56eaba3833fd4a26a82755bcd0be0c54.jpg');
INSERT INTO foods (title, price, image) VALUES ('Pizza Margherita', 45.00, 'https://media.istockphoto.com/id/1442417585/pt/foto/person-getting-a-piece-of-cheesy-pepperoni-pizza.webp?s=2048x2048&w=is&k=20&c=iUzcFvd1hTa6yr_gZP_xFcOovMp7R9UfM5ik1EzV57A=');
INSERT INTO foods (title, price, image) VALUES ('Batata Frita', 18.50, 'https://images.themodernproper.com/production/posts/2022/Homemade-French-Fries_8.jpg?w=800&q=82&auto=format&fit=crop&dm=1662474181&s=70c29a2dbd0cfbac22bb3fdedf6fbd29');
INSERT INTO foods (title, price, image) VALUES ('Sorvete', 5.90, 'https://becs-table.com.au/wp-content/uploads/2014/01/ice-cream-1.jpg');
INSERT INTO foods (title, price, image) VALUES ('Bolo', 30.99, 'https://cdn.shoppub.io/cdn-cgi/image/w=1000,h=1000,q=80,f=auto/beirario/media/uploads/produtos/foto/xrwupuqt/file.jpg');
INSERT INTO foods (title, price, image) VALUES ('Bife Oswaldo Aranha', 20.87, 'https://cdn.panrotas.com.br/portal-panrotas-statics/media-files-original/2013/07/16/bifeaoswaldoaranha.jpg');
INSERT INTO foods (title, price, image) VALUES ('Macarrão', 12.00, 'https://s.lightorangebean.com/media/20240914160809/Spicy-Penne-Pasta_-done.png.webp');

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL
);

INSERT INTO users(login, senha) VALUES ('admin', '12345')