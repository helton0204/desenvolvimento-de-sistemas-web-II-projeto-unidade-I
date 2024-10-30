
# 💻 Projeto da unidade I da disciplina Desenvolvimento de Sistemas Web II UFRN

Projeto desenvolvido utilizando Spring Boot com objetivo de gerenciamento de dados e operações básicas em uma aplicação web.

## ⚙️ Funcionalidades

- [x] CRUD de clientes;
- [x] CRUD de produtos;

## 🛠 Tecnologias Utilizadas

- **Java** 21
- **Spring Boot** 3.3.5
- **Spring Data JPA** - Para persistência de dados
- **Spring Web** - Para criação de APIs REST
- **MySQL** - Banco de dados relacional
- **Flyway** - Para versionamento e migração do banco de dados
- **Lombok** - Para reduzir o boilerplate do código

## 📂 Estrutura do Projeto

- `src/main/java` - Contém o código fonte Java
  - `controller` - Controladores REST para gerenciamento das rotas da API
  - `service` - Contém a lógica de negócios da aplicação
  - `repository` - Interfaces para manipulação de dados com Spring Data JPA
  - `model` - Entidades do banco de dados e modelos de dados
  - `dto` - Classes imutáveis que representam os dados de entrada e saída da API
  - `exception` - Recebe as exceções lançadas e retorna o status correto do erro
- `src/main/resources` - Contém arquivos de configuração
  - `application.properties` - Configurações da aplicação, como banco de dados e propriedades do Hibernate
  - `db/migration` - Scripts SQL de migração para o Flyway

## 📝 Licença

Projeto desenvolvido por **Helton Oliveira**

---


