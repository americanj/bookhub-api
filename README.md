# BookHub Microservice API

### Instruções

Para rodar o projeto de forma correta siga os passos a seguir:

- Ter instalado o banco de dados MariaDB versão 11.3.2 (porta 3306).
- Após instalado, rode o Script abaixo como administrador do banco de dados (root).
```sql
CREATE DATABASE bookhub_db;

CREATE USER bookhub_admin@localhost IDENTIFIED BY 'admin';

GRANT ALL PRIVILEGES ON bookhub_db.* TO bookhub_admin@localhost;

FLUSH PRIVILEGES;
```
- Configurar a aplicação para rodar em profile de dev.
```sh
spring.profiles.active=dev
```

## Possíveis Alterações
- [ ] No `AuthorMapper` fazer o mapstruct mapear os objetos de lista sozinho, sem precisar de implementação manual.
- [ ] Passar tipo requests e conversões para as classes de serviços. 
- [ ] No bookModel, analisar se deve ou nao retornar null quando não adicionar um autor.
- [ ] Criar função para desativar um stock e ativar.


**Desenvolvido por: `Igor de Oliveira`**



