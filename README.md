# 🌐 To-Do List — Frontend (Angular Source Code)

Esta branch contém **apenas o código-fonte Angular** da aplicação **To-Do List**.

⚠️ O frontend já está integrado no backend Spring Boot (`src/main/resources/static`), então esta branch é **apenas para consulta ou desenvolvimento**.

---

## 🚀 Tecnologias Utilizadas

- **Angular**
- **TypeScript**
- **HTML5 / CSS3**

---

## 📂 Estrutura do Projeto

```
todo-list/
├── src/
│   ├── app/
│   │   ├── core/
│   │   │   ├── features/
│   │   │   ├── models/
│   │   │   └── services/
│   │   └── app.module.ts
│   ├── assets/
│   ├── environments/
│   └── index.html
├── angular.json
├── package.json
└── tsconfig.json

```
---

## ⚙️ Funcionalidades

- Criar nova tarefa
- Listar todas as tarefas
- Marcar tarefa como concluída ou pendente
- Editar tarefa existente
- Excluir tarefa

---

## ▶️ Como Executar (opcional)

Se você quiser executar o Angular separadamente para desenvolvimento:

1.  **Instale as dependências:**
    ```bash
    npm install
    ```

2.  **Execute o servidor de desenvolvimento:**
    ```bash
    ng serve
    ```

3.  **Acesse no navegador:**
    [http://localhost:4200](http://localhost:4200)

> **Lembre-se:** não é necessário rodar esta branch para usar a aplicação, pois o Angular já está integrado no Spring Boot.

---

## 🌿 Branches Relacionadas

- `main` → Backend Spring Boot + Angular buildado (produção)
- `front-end` → Angular source code apenas (esta branch, para referência / desenvolvimento)
