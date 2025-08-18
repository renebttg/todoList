# 📝 To-Do List — API + Frontend Integrado

Este projeto é uma aplicação Full Stack de gerenciamento de tarefas (To-Do List) desenvolvida com **Spring Boot 3** no backend e **Angular** no frontend.

O frontend foi compilado e incorporado na pasta `resources/static`, permitindo que toda a aplicação seja executada a partir de um único artefato Java. O banco de dados utilizado é SQL (MySQL por padrão), podendo ser alterado via configuração.

> ℹ️ **Código-fonte do Frontend**
> O código-fonte completo do Angular, utilizado para desenvolvimento e consulta, está disponível na branch separada: **[front-end](ttps://github.com/renebttg/todoList/tree/front-end)**.

---

## 🚀 Tecnologias Utilizadas

-   **Backend**: Java 21, Spring Boot 3 (Spring Web, Spring Data JPA), Maven
-   **Frontend**: Angular, TypeScript, HTML5, CSS3
-   **Banco de Dados**: MySQL (padrão) — compatível com qualquer banco SQL suportado pelo Spring Data JPA
-   **Build**: Maven + Angular CLI

---

## 📂 Estrutura do Projeto

A branch `main` está organizada para conter a API Spring e a versão de produção (compilada) do Angular.

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

-   [x] Criar nova tarefa
-   [x] Listar todas as tarefas
-   [x] Marcar tarefa como concluída ou pendente
-   [x] Editar tarefa existente
-   [x] Excluir tarefa

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

### 1. Pré-requisitos

-   Java 21+
-   Maven 3.8+
-   MySQL Server (ou outro banco de dados SQL)

### 2. Configurar o Banco de Dados

**A) Crie um banco de dados no MySQL:**
```sql
CREATE DATABASE todolist;
```

**B) No arquivo src/main/resources/application.properties, configure as credenciais de acesso:**

```properties
# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
------------
## 3. Executar a Aplicação
Você pode executar o projeto de duas maneiras:

**A) Via Maven:**
```bash
mvn spring-boot:run
```
**B) Via JAR (recomendado para "produção"):**
```bash
# 1. Empacote o projeto
mvn clean package

# 2. Execute o arquivo .jar gerado
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
