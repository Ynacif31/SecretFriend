# SecretFriend

![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub language count](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/iuricode/README-template?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/iuricode/README-template?style=for-the-badge)

> Este é um sistema de sorteio de Amigo Secreto desenvolvido em Java usando Spring Boot, com base no padrão arquitetural DDD (Domain-Driven Design). Ele permite que os participantes sejam cadastrados e sorteados de forma aleatória, garantindo que ninguém seja seu próprio amigo secreto.

### Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas para as seguintes tarefas:

- [x] Implementar DTOs para encapsulamento de dados nas APIs.
- [x] Concluir todos services e controllers
- [ ] Serviço de envio de e-mails com notificações dos resultados do sorteio.
- [ ] Desenvolver uma interface gráfica ou integração com um frontend.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente de `<Java(21), Maven 3.9.9+ / h2, spring-boot-starter-web, spring-boot-starter-test, spring-boot-starter-data-jpa, lombok>`
- Você tem uma máquina `<Windows / Linux / Mac>`. Compativel com todos.
- Você leu `<guia / link / documentação_relacionada_ao_projeto>`.

## 🚀 Instalando <SecretFriend>

Para instalar o <SecrefFriend>, siga estas etapas:

Linux e macOS:

```
git clone https://github.com/seu-usuario/amigo-secreto.git
cd amigo-secreto
```

Windows:

```
git clone https://github.com/seu-usuario/amigo-secreto.git
cd amigo-secreto
```

## ☕ Usando <SecretFriend>

Para usar <SecretFriend>, siga estas etapas:
Listar Usuários

	•	Endpoint: GET /users
	•	Descrição: Retorna todos os participantes cadastrados.

 Inserir Participantes
 
 	•	Endpoint: POST /users
	•	Body: 
 	{
   		 "name": "Ygor",
   		 "email": "ygor@gmail.com"
	}
 Realizar Sorteio
 
 	•	Endpoint: POST /secret-friend
	•	Descrição: Retorna o sorteio com cada participante com seu amigo secreto


Console do H2

	•	URL: http://localhost:8080/h2-console
	•	JDBC URL: jdbc:h2:mem:testdb
	•	Username: sa
	•	Password: (deixe em branco)

 O projeto foi construído seguindo o padrão DDD (Domain-Driven Design), com a seguinte estrutura de pacotes:
 src/main/java/com/amigosecreto
│
├── application    -> Contém os serviços de aplicação
├── domain         -> Contém as entidades e interfaces de repositórios
├── infrastructure -> Implementações dos repositórios e configurações
└── presentation   -> Controladores REST
