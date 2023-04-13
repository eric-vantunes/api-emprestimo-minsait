# API de Cadastro de Clientes e Empréstimos

Esta é uma API desenvolvida em Java 8 com o framework Spring Boot e banco de dados H2, que permite o cadastro, consulta, atualização e exclusão de clientes, assim como o cadastro, consulta e exclusão de empréstimos. A API possui validações de CPF, telefone, endereço e rendimento mensal dos clientes, assim como cálculos automáticos do valor final dos empréstimos de acordo com o relacionamento do cliente.

## Configuração do Ambiente

<li>Java 8</li>
<li>Maven 3.9.0</li>
<li>Spring Boot 2.5.0</li>
<li>H2 Database</>

## Instruções de Uso
  
### Clone o repositório para o seu ambiente local:
```
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```
### Acesse o diretório do projeto:
```
cd nome-do-repositorio
```
### Compile e execute a aplicação utilizando o Maven:
```
mvn spring-boot:run
```
### A API estará disponível em http://localhost:8080.
  
## Endpoints da API
  
### Cadastro de Clientes
```
POST /clientes: Adiciona um cliente na base de dados.
GET /clientes: Obtém os dados de todos os clientes cadastrados.
GET /clientes/{cpf}: Obtém os dados de um cliente da base de dados pelo CPF fornecido na URI.
DELETE /clientes/{cpf}: Apaga um cliente da base de dados pelo CPF fornecido na URI.
PUT /clientes/{cpf}: Atualiza os dados de um cliente na base de dados pelo CPF fornecido na URI.
```
### Cadastro de Empréstimos
```
POST /clientes/{cpf}/emprestimos: Adiciona um empréstimo para o cliente na base de dados.
DELETE /clientes/{cpf}/emprestimos/{id}: Apaga os dados de um empréstimo da base de dados pelo ID fornecido na URI.
GET /clientes/{cpf}/emprestimos/{id}: Retorna os dados de um empréstimo da base de dados pelo ID fornecido na URI.
GET /clientes/{cpf}/emprestimos: Obtém a lista de empréstimos do cliente.
```
