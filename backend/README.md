### MY EXPENSES

Projeto para gerenciar minhas finaças!

# A FAZER:
- [x] criar projeto
- [x] planejar sistema
- [x] construir entidades
  - [x] controle de usuário (CRUD)
    - [x]  Auth JWT
  - [x] criar centro de custo (CRUD)
    - [x] todo centro de custo tem que estar vinculado a um usuario
  - [x] criar titulos (CRUD) - DEBITO e CREDITO
    - [x] todo titulo deve estar vinculado a um usuario
    - [x] todo titulo deve estar vinculado 1 ou 'N' centro de custos
  - [x] criar um fluxo endpoint de fluxo de caixa
    - [x] obter o total a pagar
    - [x] obter o total a receber
    - [x] obter saldo
    - [x] lista de titulos (a pagar, a receber)
    - [x] filtro por periodo de vencimento


# stack

- Java 17
- Spring Boot 3
- Spring Security
- JWT
- Postgresql
- Model Mapper

# futuras implementações

- [ ] testes de unidade ? 
- [ ] testes de integração ? 
- [ ] testes end to end ? 
- [ ] subir numa cloud ? 
- [ ] documentar (swagger)

# infra
- [x] docker
- [ ] pipeline ? 
- [ ] ci/cd ? 
- [ ] aws ?