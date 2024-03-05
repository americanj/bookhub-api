# BookHub Microservice API

### Instruções

Para rodar o projeto de forma correta siga os passos a seguir:

- Ter instalado o banco de dados MariaDB (porta 3306).
- Após instalado, rode o Script abaixo como administrador do banco de dados (root).
```sh
CREATE DATABASE bookhub_db;

CREATE USER bookhub_admin@localhost IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON bookhub_db.* TO bookhub_admin@localhost;
FLUSH PRIVILEGES;
```
- Configurar a aplicação para rodar em profile de dev.
```sh
spring.profiles.active=dev
```

**Desenvolvido Igor de Oliveira**


