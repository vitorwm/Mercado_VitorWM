
# Mercado_VitorWM

Aplicação RESTful para controle de estoque. Possui autenticação JWT.

## Funcionalidades

- CRUD de Produto. 
- Cadastrar Movimentação de estoque (Entrada ou saida).
- Listar movimentações de estoque.
- Listar o lucro das movimentações.
- Listar movimentações pelo tipo do produto
- Cadastrar Usuário
- Realizar login do usuário


## Instalação

- Instalar node.js LTS
- Instalar npm install -g @angular/cli@13.3.10
- O Banco de Dados deve ser criado no Postgre com o nome: 'estoque'
- Senha de conexão utilizada pelo Banco de Dados:123456
- Por padrão a string de conexão é jdbc:postgresql://localhost:5432/estoque
- Configurado pelo application.properties na pasta target/classes/com/ do Back-end

- Portas Utilizadas:
BackEnd: 8080, postgre: 5432, FrontEnd: 4200

- Instalar todas as extensões do vscode

- Back-end: Clicar na barra lateral do vscode para abrir a Spring Boot Dashboard.
   Clicar no botão run para executar o projeto

- Front-end: Entrar na pasta e executar no terminal os comandos:
```bash
  npm install
  ng serve -o
```

- Script Json para testar o BackEnd utilizando postman: Backend Estoque Unimed.postman_collection.json
- (Não é obrigatório utilizar o postman e os testes do back-end para poder utilizar o front-end da aplicação)
- Abra o Postman, clique em File > Import > selecione onde foi clonado o repositório e selecione o arquivo citado a cima.
- Primeiro realizar o cadastro do usuário pelo usuario.http
- copiar o token retornado ao realizar o cadastro apertando o texto Send Request
- Com o token copiado, abra a requisição que pretende realizar pelo postman, entre na aba Authorization, selecione o tipo Bearer token e cole o token no campo de texto.
- Para alterar os dados da requisição entre na aba body e mude o valor dos atributos


    
## Extensões do vscode
Back-end
- Java Extension Pack
- Spring Boot Extension Pack
- REST Client

Front-end
- Angular Language Service
- Angular Schematics
- HTML CSS Support
- Live Server
- Material Icon theme 
## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/vitorwm/Mercado_VitorWM
```

Entre no diretório do projeto

```bash
  cd Mercado_VitorWM
```

Crie o Banco de dados


Inicie o servidor de API

```bash
  cd BackEnd
```

```bash
Clique na barra lateral do vscode para abrir a Spring Boot Dashboard. Clique no botão run para executar o projeto.
```

Instale as dependências do Front-end;

```bash
  cd ..
  cd FrontEnd
```


```bash
  npm install
```

Inicie o Front-end

```bash
  ng serve -o
```

Crie um usuário e depois faço o seu login.


## Dependências do pom
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Spring Data JDBC
- Spring Boot Actuator
- Spring Security
- PostgreSQL Driver
- Validation I/O

- ModelMapper
- JJWT
- Spring Boot Starter Web
- Spring Boot Starter Test
- Spring Boot Starter Security
- Spring Boot Starter Validation


## Autor

- [@vitorwm](https://www.github.com/vitorwm)

