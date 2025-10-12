# 🎶 M8MUSIC

> Aplicação desenvolvida em **Java** com **Spring** e **OracleSQL**, focada no gerenciamento de eventos e automação de
> processos administrativos.  
> Este projeto integra recursos de documentação via **Swagger** e segue princípios de desenvolvimento em camadas.

---

## 👥 **Integrantes do Grupo**

| Nome Completo | Função / Responsabilidade |
---
| **Henrique Batista de Souza - RM99742** | Líder do Projeto / Desenvolvedor Full-Stack (Java & ASP.NET / React.js &
React-Native & Typescript) |

| **Julia Lima Rodrigues - RM559781** | Desenvolvedora Back-end (Java & ASP.NET) / DevOps (Microsoft Azure) / QA &
Insurance |

| **Felipe Soares Gonçalves - RM559175** | Desenvolvedor Front-End (React.js) / Desenvolvedor Mobile (React-Native) /
Desenvolvedor IOT (Arduino) / Banco de Dados (OracleSQL) |

---

## 🗓️ **Cronograma de Desenvolvimento**

| Etapa | Atividade                                            | Responsável                        | Prazo      | Status      |
|-------|------------------------------------------------------|------------------------------------|------------|-------------|
| 1     | Definição do escopo e divisão das tarefas            | Julia                              | 29/09/2025 | ✅ Concluído |
| 2     | Modelagem das entidades e criação do banco OracleSQL | Felipe                             | 02/10/2025 | ✅ Concluído |
| 3     | Implementação dos controllers e rotas da API         | Julia                              | 08/10/2025 | ✅ Concluído |
| 4     | Integração com o banco de dados                      | Henrique                           | 10/10/2025 | ✅ Concluído |
| 5     | Documentação dos endpoints (Swagger)                 | Julia                              | 11/10/2025 | ✅ Concluído |
| 6     | Gravação e entrega Sprint 1                          | Henrique (Somente o líder entrega) | 11/10/2025 | ✅ Concluído |

---

## ⚙️ **Como Rodar a Aplicação**

### ✅ Pré-requisitos

- **Java 17+**
- **Spring Boot**
- **OracleSQL**
- **Maven 3.8+**

### 🚀 Passos para execução

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/CyPHER298/m8muisc-api.git
   ```

2. **Acessar o diretório do projeto:**
   ```bash
   cd m8music-api
   ```

3. **Configurar o banco de dados no arquivo `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:xe
   spring.datasource.username=rm99742
   spring.datasource.password=290305
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Executar o projeto:**
   ```bash
   mvn spring-boot:run
   ```

5. **Acessar a documentação Swagger:**
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## 🧩 **Diagramas da Aplicação**

### 🗃️ Diagrama de Classes

![Diagrama de Classes](./docs/der_bd.jpeg)

---

## 🎥 **Vídeo de Apresentação**

📺 [Assista à apresentação no YouTube](https://youtu.be/8oGh5lXjscI)

O vídeo apresenta:

- A **proposta tecnológica** e objetivo da aplicação;
- O **público-alvo** (organizadores e participantes de eventos);
- Os **problemas solucionados**, como automação e controle de processos.

---

## 🔗 **Documentação da API (Swagger / OpenAPI)**

### **Principais Endpoints**

| Método     | Endpoint             | Descrição                       |
|------------|----------------------|---------------------------------|
| **GET**    | `/api/clientes`      | Lista todos os clientes         |
| **GET**    | `/api/clientes/{id}` | Retorna um clientes pelo **id** |
| **POST**   | `/api/clientes`      | Cadastra um novo cliente        |
| **PUT**    | `/api/clientes/{id}` | Atualiza um cliente             |
| **DELETE** | `/api/clientes/{id}` | Remove um cliente existente     |
| **GET**    | `/api/cantores`      | Lista todos os cantores         |
| **GET**    | `/api/cantores/{id}` | Retorna um cantor pelo **id**   |
| **POST**   | `/api/cantores`      | Cadastra um novo cantor         |
| **PUT**    | `/api/cantores/{id}` | Atualiza um cantor existente    |
| **DELETE** | `/api/cantores/{id}` | Remove um cantor existente      |
| **GET**    | `/api/musica`        | Lista todos os participantes    |
| **GET**    | `/api/musica/{id}`   | Retorna uma música pelo **id**  |
| **POST**   | `/api/musica`        | Cadastra uma nova música        |
| **PUT**    | `/api/musica/{id}`   | Atualiza uma música existente   |
| **DELETE** | `/api/musica/{id}`   | Remove uma música existente     |
| **GET**    | `/api/pedido`        | Lista todos os pedidos          |
| **GET**    | `/api/pedido/{id}`   | Retorna um pedido pelo **id**   |
| **POST**   | `/api/pedido`        | Cadastra um novo pedido         |
| **PUT**    | `/api/pedido/{id}`   | Atualiza uma pedido existente   |
| **DELETE** | `/api/pedido/{id}`   | Remove um pedido existente      |

---

## 🧾 **Tecnologias Utilizadas**

- **Java 17**
- **Spring Boot**
- **OracleSQL**
- **Swagger**

---

## 📜 **Observação**

Este projeto foi desenvolvido para fins acadêmicos na disciplina de **Desenvolvimento Web — Sprint 1 (Java)**.
