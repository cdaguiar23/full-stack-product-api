# Product Manager API

Uma API RESTful completa para gerenciamento de produtos, desenvolvida com Spring Boot, PostgreSQL, JWT para autenticação e Swagger para documentação interativa.

## 📋 Descrição

Esta aplicação permite o gerenciamento completo de produtos, incluindo operações CRUD (Criar, Ler, Atualizar, Deletar), com sistema de autenticação seguro baseado em JWT. A API é documentada automaticamente com Swagger UI e utiliza Liquibase para controle de versão do banco de dados.

## 🚀 Funcionalidades

- ✅ **Gerenciamento de Produtos**: CRUD completo de produtos
- 🔐 **Autenticação JWT**: Sistema seguro de login e autorização
- 👥 **Gerenciamento de Usuários**: Registro e listagem de usuários
- 📚 **Documentação Swagger**: Interface interativa para testar a API
- 🗄️ **Banco de Dados PostgreSQL**: Persistência robusta com migrações automatizadas
- 🐳 **Containerização Docker**: Fácil deployment com Docker Compose
- ✅ **Validação de Dados**: Validações automáticas com Bean Validation

## 🛠️ Tecnologias Utilizadas

- **Backend**: Spring Boot 3.5.6
- **Banco de Dados**: PostgreSQL 15
- **Autenticação**: JWT (JSON Web Tokens)
- **Migrações**: Liquibase
- **Documentação**: SpringDoc OpenAPI (Swagger)
- **Containerização**: Docker & Docker Compose
- **Build Tool**: Maven
- **Java**: JDK 17
- **Outros**: Lombok, Spring Security, Spring Data JPA

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- **Java 17** ou superior
- **Maven 3.6+** ou use o wrapper Maven incluído (`mvnw`)
- **Docker** e **Docker Compose** (para execução com containers)
- **Git** (opcional, para clonar o repositório)

## 🚀 Instalação e Execução

### Opção 1: Executar com Docker (Recomendado)

1. **Clone o repositório** (se aplicável):
   ```bash
   git clone <url-do-repositorio>
   cd full-stack-product-api
   ```

2. **Execute com Docker Compose**:
   ```bash
   docker-compose up --build
   ```

3. **Aguarde a inicialização**: A aplicação estará disponível em `http://localhost:8080`

### Opção 2: Executar Localmente

1. **Clone o repositório** (se aplicável):
   ```bash
   git clone <url-do-repositorio>
   cd full-stack-product-api
   ```

2. **Configure o PostgreSQL**:
   - Instale o PostgreSQL localmente
   - Crie um banco de dados chamado `produtos_db`
   - Configure um usuário `postgresuser` com senha `postgrespass`
   - Ou ajuste as configurações em `src/main/resources/application.properties`

3. **Execute a aplicação**:
   ```bash
   # Usando Maven wrapper (recomendado)
   ./mvnw spring-boot:run

   # Ou usando Maven instalado
   mvn spring-boot:run
   ```

4. **A aplicação estará disponível em**: `http://localhost:8080`

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/productmanager/produto/
│   │   ├── ProductmanagerApplication.java          # Classe principal
│   │   ├── config/                                 # Configurações
│   │   │   ├── JwtAuthenticationFilter.java        # Filtro JWT
│   │   │   ├── OpenApiConfig.java                  # Configuração Swagger
│   │   │   └── SecurityConfig.java                 # Configuração Segurança
│   │   ├── controller/                             # Controladores REST
│   │   │   ├── AuthController.java                 # Autenticação
│   │   │   ├── ProdutoController.java              # Produtos
│   │   │   └── UserController.java                 # Usuários
│   │   ├── dto/                                    # Data Transfer Objects
│   │   │   ├── AuthResponse.java
│   │   │   ├── LoginRequest.java
│   │   │   ├── ProdutoDTO.java
│   │   │   └── UserDTO.java
│   │   ├── entity/                                 # Entidades JPA
│   │   │   ├── Produto.java
│   │   │   └── User.java
│   │   ├── repository/                             # Repositórios
│   │   │   ├── ProdutoRepository.java
│   │   │   └── UserRepository.java
│   │   └── service/                                # Serviços de negócio
│   │       ├── AuthService.java
│   │       ├── JwtService.java
│   │       ├── ProdutoService.java
│   │       ├── UserDetailsServiceImpl.java
│   │       └── UserService.java
│   └── resources/
│       ├── application.properties                  # Configurações da aplicação
│       └── db/changelog/                           # Migrações Liquibase
│           ├── db.changelog-master.xml
│           ├── V1__Create_produtos_table.sql
│           ├── V2__Insert_sample_produtos.sql
│           ├── V3__Create_users_table.sql
│           └── V4__Insert_sample_users.sql
└── test/
    └── java/com/productmanager/productmanager/
        └── ProductmanagerApplicationTests.java     # Testes unitários
```

## 🔗 Endpoints da API

### Autenticação
- `POST /api/auth/login` - Login de usuário

### Produtos (Requer Autenticação)
- `GET /api/produtos` - Listar todos os produtos
- `GET /api/produtos/{id}` - Buscar produto por ID
- `POST /api/produtos` - Criar novo produto
- `PUT /api/produtos/{id}` - Atualizar produto
- `DELETE /api/produtos/{id}/hard` - Deletar produto permanentemente

### Usuários (Requer Autenticação)
- `GET /api/users` - Listar todos os usuários
- `POST /api/users/register` - Registrar novo usuário

## 🔐 Autenticação

A API utiliza JWT (JSON Web Tokens) para autenticação. Para acessar endpoints protegidos:

1. **Faça login**:
   ```bash
   POST /api/auth/login
   Content-Type: application/json

   {
     "username": "admin",
     "password": "password"
   }
   ```

2. **Use o token retornado** no header `Authorization`:
   ```
   Authorization: Bearer <seu-token-jwt>
   ```

### Usuários de Exemplo
- **Admin**: `admin` / `password`
- **User**: `user` / `password`

## 📚 Documentação da API

A documentação interativa está disponível via Swagger UI em:
- **URL**: `http://localhost:8080/swagger-ui/index.html`

Aqui você pode:
- Visualizar todos os endpoints
- Testar as APIs diretamente na interface
- Ver os modelos de dados
- Baixar especificações OpenAPI

## 🧪 Testes

### Testes HTTP (usando arquivos .http)

O projeto inclui arquivos de teste HTTP que podem ser executados diretamente no VS Code (com extensão REST Client) ou ferramentas similares:

- `teste.http` - Testes dos endpoints de produtos
- `teste_auth.http` - Testes de autenticação e usuários

### Executar Testes Unitários

```bash
# Usando Maven wrapper
./mvnw test

# Ou usando Maven instalado
mvn test
```

## 🐳 Docker

### Comandos Úteis

```bash
# Construir e executar
docker-compose up --build

# Executar em background
docker-compose up -d --build

# Parar containers
docker-compose down

# Ver logs
docker-compose logs -f app

# Reconstruir sem cache
docker-compose build --no-cache
```

### Arquivos Docker

- `Dockerfile` - Configuração para construir a imagem da aplicação
- `docker-compose.yml` - Orquestração dos serviços (app + PostgreSQL)

## ⚙️ Configuração

### Variáveis de Ambiente

As configurações podem ser ajustadas em `src/main/resources/application.properties`:

```properties
# Banco de dados
spring.datasource.url=jdbc:postgresql://localhost:5432/produtos_db
spring.datasource.username=postgresuser
spring.datasource.password=postgrespass

# JWT (pode ser configurado via variáveis de ambiente)
jwt.secret=your-secret-key-here
jwt.expiration=86400000
```

### Docker Environment

No `docker-compose.yml`, as variáveis são definidas para o container:

```yaml
environment:
  SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/produtos_db
  SPRING_DATASOURCE_USERNAME: postgresuser
  SPRING_DATASOURCE_PASSWORD: postgrespass
```

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

### Padrões de Código

- Siga as convenções do Java
- Use nomes descritivos para variáveis e métodos
- Adicione documentação (JavaDoc) para métodos públicos
- Escreva testes para novas funcionalidades

## 📝 Licença

Este projeto está sob a licença [MIT](LICENSE). Veja o arquivo `LICENSE` para mais detalhes.

## 📞 Suporte

Para dúvidas ou problemas:

1. Verifique a documentação do Swagger
2. Consulte os logs da aplicação
3. Abra uma issue no repositório

---

**Desenvolvido com ❤️ usando Spring Boot**
