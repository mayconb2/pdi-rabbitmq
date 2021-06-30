# PDI-MAYCON

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/mayconb2/pdi-rabbitmq/blob/main/LICENSE)

## Sobre o projeto

Este projeto faz parte do meu PDI sugerido pelo meu Tech Lead Yuji Negoro. Consiste em criar uma aplicação que usa Java com Spring e aplicação dos conceitos de fila utilizando RabbitMQ. 

Até o momento, foram criados 3 aplicações: 

1) um producer, que gera uma mensagem e encaminha pra uma fila do RabbitMQ;
2) um consumer, que lê a mensagem da fila e grava em uma collection no MongoDB;
3) um front end simples em REACT.

## Como rodar a aplicação

Para rodar esta aplicação você precisa ter o Java 11 instalado na sua máquina, o Docker (que irá rodar uma imagem do RabbitMQ) e o Yarn para rodar o frontend.

### Passo a Passo

Primeiramente, você deve fazer o clone deste projeto.

```bash
# clonar repositório
git clone https://github.com/mayconb2/pdi-rabbitmq

```

Logo após, acessar o diretório do frontend e instalar todas as dependências, conforme os seguintes comandos:

```bash
# entrar na pasta do projeto frontend
cd frontend

# instalar dependências
yarn install

# executar o projeto
yarn start
```

Após o comando start, a aplicação frontend irá subir na porta 3000.

![front](https://user-images.githubusercontent.com/40521982/123977171-24760180-d995-11eb-9215-0ff93cace497.PNG)


Para subir a imagem do RabbitMQ, na raiz do projeto, você rodar o docker-compose a partir do seguinte comando:

```bash
# subindo imagem docker do RabbitMQ
docker-compose up
```

Será feito o download de uma imagem do RabbitMQ (caso já não tenha locamente) e irá subir na porta 5762. A inteface web do RabbitMQ pode ser acessado através da url http://localhost:15672. Para realizar login, basta colocar "guest" tanto em username quanto password.

![rabbitmq](https://user-images.githubusercontent.com/40521982/123977083-132cf500-d995-11eb-9b4e-a3713e68bd0a.PNG)


Após o frontend e o RabbitMQ estarem rodando localmente, já é possível abrir as duas aplicações feitas em Java com Spring, na sua IDE de preferência.

OBS: a aplicação pdi-consumer espera algumas variáveis de ambiente para poder se conectar no Mongo. Eu optei por utilizar o MongoDB Atlhas em um cluster privado. Para utilizar seu próprio Mongo você deve criar um arquivo env.properties na raiz do projeto pdi-consumer com as seguintes informações:

```bash
# variáveis de ambiente do MongoDB
MONGO_USER=<SEU_USUARIO_MONGO>
MONGO_PWD=<SUA_SENHA>
MONGO_DATABASE=<SEU_DATABASE>
```
## Utilizando a Aplicação

Até o momento, a aplicação é muitosimples. Há apenas dois inputs de texto e um botão de enviar. As informações preenchidas (usuário e mensagem) são gravadas no MongoDB. Primeiro, o producer encaminha o payload para exchenge especificada no projeto. Esse, por sua vez, encaminha para fila correta. Após a mensagem estar na fila, a aplicação consumer lê o payload e grava no MongoDB.


## Próximos passos

Em breve, numa segunda fase do PDI, irei implementar um chat em tempo real para ler e exibir as mensagens gravadas no mongo. Possivelmente será utilizado WebSocket.
