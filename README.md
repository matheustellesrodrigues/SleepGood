# SleepGood
Uma API de controle de Reserva de Hotel.


## Endpoints

- Reserva
    - [Listar Todas](#listar-todas)
    - [Detalhar](#detalhar-reserva)
    - [Cadastrar](#cadastrar-reserva)
    - [Apagar](#apagar-reserva)
    - [Editar](#editar-reserva)

- Movimentações

---

### Listar Todas

`GET` /reserva

Retorna um array com todas as pessoas cadastradas.

**Exemplo de Resposta** 

```js
[
    {
        "id": 1,
        "nome": "Daniel Alvez De Souza",
        "cpf": "18746877654",
        "checkin": "28/02/2024"
        "numeroQuarto": 181
        "checkout": "29/02/2024",
        "icone": "Cliente"
    }
]
```

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|200|Dados retornados com sucesso

---

### Detalhar Reserva

`GET` /reserva/{id}

Retornar os dados da reserva com o `id` informado.

**Exemplo de Resposta** 

```js

    {
        "id": 2,
        "nome": "Matheus De Castro Telles Rodrigues",
        "cpf": "23546879654",
        "numeroQuarto": 157,
        "checkin": "15/01/2024",
        "checkout": "31/01/2024",
        "icone": "Cliente"
    }

```

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|200|Dados retornados com sucesso
|404| Id da reserva não encontrado

___


### Cadastrar Reserva

`POST` /reserva

Insere uma nova reserva.

**Corpo da Requisição** 

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|Um nome curto para a reserva
|icone|string|❌|O nome do ícone conforme Material Icons
|cpf|string|✅|Um cpf para realizar a reserva
|numeroQuarto|integer|✅|O numero do quarto do cliente
|checkin|date|✅|A data de checkin 
|checkout|date|✅|A data de checkout




**Exemplo de Resposta** 

```js
{
        "id": 3,
        "nome": "Henry Ribeiro Komatsu",
        "cpf": "58249847658",
        "numeroQuarto": 349,
        "checkin": "21/01/2024", 
        "checkout": "29/02/2024",
        "icone": "Cliente"
}
```

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|201|reserva criada com sucesso
|400|Erro de validação - verifique o corpo da requisição

---

### Apagar Reserva

`DELETE` /reserva/{id}

Apaga a reserva com o `id` informado.

**Códigos de Status** 

| código | descrição |
|--------|-----------|
|204|lista apagada com sucesso
|404|Id da reserva não encontrado

___

### Editar Reserva

`PUT` /reserva/{id}

Atualiza os dados da reserva com o `id` informado.

**Corpo da Requisição** 

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅|Um nome curto para a reserva
|icone|string|❌|O nome do ícone conforme Material Icons
|cpf|string|✅|Um cpf para realizar a reserva
|numeroQuarto|integer|✅|O numero do quarto do cliente
|checkin|date|✅|A data de checkin 
|checkout|date|✅|A data de checkout



```js
{
        
        "nome": "Henry Ribeiro Komatsu",
        "cpf": "58249847658",
        "numeroQuarto": 890,
        "checkin": "21/01/2024", 
        "checkout": "29/02/2024",
        "icone": "Cliente"
}
```

**Exemplo de Resposta** 

```js
{
        "id": 3,
        "nome": "Henry Ribeiro Komatsu",
        "cpf": "58249847658",
        "numeroQuarto": 890,
        "checkin": "21/01/2024", 
        "checkout": "29/02/2024",
        "icone": "Cliente"
}
```

**Códigos de Status** 


 |200| Lista atualizada com sucesso
 |400| A validação falhou - verifique o corpo da requisição
 |404| Id da reserva não encontrado

