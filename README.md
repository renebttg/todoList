#  📝 To-Do List — API + Frontend Integrado

Este projeto é uma aplicação Full Stack de gerenciamento de tarefas (To-Do List) desenvolvida com Spring Boot 3 no backend e Angular no frontend.
O frontend foi compilado e incorporado na pasta resources/static, permitindo que toda a aplicação seja executada a partir de um único artefato Java.
O banco de dados utilizado é SQL (MySQL por padrão), podendo ser alterado via configuração.

## 🚀 Tecnologias Utilizadas

Backend: Java 21, Spring Boot 3 (Spring Web, Spring Data JPA, JPA/Hibernate), Maven

Frontend: Angular, TypeScript, HTML5, CSS3

Banco de Dados: MySQL (padrão) — compatível com qualquer banco SQL suportado pelo Spring Data JPA

Build: Maven + Angular CLI

## 📂 Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/...              # Código fonte da API
 │   ├── resources/
 │   │   ├── static/           # Arquivos buildados do Angular
 │   │   ├── application.properties
 │   │   └── data.sql / schema.sql (opcional)
 frontend/                     # Código-fonte do Angular (não obrigatório no deploy)
 pom.xml
 ```

----------------

## ⚙️ Funcionalidades

- Criar nova tarefa
- Listar todas as tarefas
- Marcar tarefa como concluída ou pendente
- Editar tarefa existente
- Excluir tarefa

-----

## 🔌 Endpoints REST

| Método     | Rota         | Descrição                       |
| ---------- | ------------ | ------------------------------- |
| **GET**    | `/task`      | Lista todas as tarefas          |
| **POST**   | `/task`      | Cria uma nova tarefa            |
| **GET**    | `/task/{id}` | Retorna uma tarefa específica   |
| **PUT**    | `/task/{id}` | Atualiza os dados de uma tarefa |
| **DELETE** | `/task/{id}` | Remove uma tarefa               |

---
## ▶️ Como Executar

### 1️⃣ Configurar Banco de Dados (MySQL)

Crie um banco no MySQL:

```sql
CREATE DATABASE todolist;
```


No arquivo application.properties configure:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

------------
## 2️⃣ Executar o Projeto

Via Maven

```bash
mvn spring-boot:run
```


Via JAR

```bash
mvn clean package
java -jar target/todo-list-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em:
```
http://localhost:8080
```

📌 O frontend Angular será servido automaticamente junto com a API.

---------
## 🌿 Branches

- **main** → Backend API com Angular buildado em `resources/static`

- **front-end** → Apenas o código-fonte Angular para referência (não necessário para execução)

---
## 📜 Licença

Este projeto está licenciado sob a [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0).
