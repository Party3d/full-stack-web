# Full Stack Application: Angular + Spring Boot + PostgreSQL

Este repositório contém uma aplicação web full-stack com:

- **Frontend**: Angular
- **Backend**: Java Spring Boot
- **Banco de Dados**: PostgreSQL
- **Orquestração**: Docker Compose

## Estrutura do Projeto

```
📁 frontend/             # Aplicação Angular
📁 backend/              # Aplicação Spring Boot
📁 docker-compose.yml    # Orquestração dos serviços
```

## Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## Como Executar

1. **Clone o repositório**

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

2. **Suba os containers com Docker Compose**

```bash
docker compose up --build
```

O comando irá:

- Construir o frontend Angular
- Construir e empacotar o backend Spring Boot com Maven
- Iniciar o banco de dados PostgreSQL
- Esperar o banco iniciar antes de rodar o backend

3. **Acessar os serviços**

- Frontend: http://localhost:4200
- Backend (API REST): http://localhost:8080
- PostgreSQL: disponível na porta 5432 (credenciais definidas no `docker-compose.yml`)

## Credenciais do Banco de Dados

- **Usuário**: `seuusuario`
- **Senha**: `suasenha`
- **Banco**: `seubanco`

## Scripts Utilizados

- `wait-for-db.sh`: script para aguardar o banco PostgreSQL ficar disponível antes de iniciar o backend.

## Comandos Úteis

### Remover volumes não utilizados

```bash
docker volume prune
```

### Remover todos os volumes (inclusive usados)

```bash
docker stop $(docker ps -aq)
docker rm $(docker ps -aq)
docker volume rm $(docker volume ls -q)
```

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).