# DIO GYM
PRIJETO GYM PARA DIGITAL INNOVATION ONE

De acordo com o projeto de serviço de API para uma academia que deve entregar por meio da Application Programming Interface (API), consumíveis em Json. Foi desenvolvido a aplicação a seguir.

## Rotas
* Método: CREATE [Criar Aluno/Estudante]
```
http://127.0.0.1:8080/v1/api/students
```

* Método: FIND ALL [Encontrar Todos]
```
http://127.0.0.1:8080/v1/api/students

METHOD: POST
REQUEST BODY: JSON API STUDENT ENTITY
```
JSON API STUDENT ENTITY
```json
{
    "name": "Vanessa Sampaio",
    "cpf": "123.456.789-32",
    "neighborhood": "Itaquera",
    "birthDate": "1990-05-11"
}
```

* Método: FIND BY ID [ENCONTRAR ALUNO USANDO SEU ID]
````
http://127.0.0.1:8080/v1/api/students/1

METHOD: GET
PATH VARIABLE: 1
````

* Método: FIND BY CPF [ENCONTRAR ALUNO USANDO SEU CPF]
```
http://127.0.0.1:8080/v1/api/students/document?cpf=12345678932

METHOD: GET
REQUEST PARAM: 
    KEY: cpf
    VALUE: 12345678932
```

* Método: FIND BY NAME CONTAINS [ENCONTRAT ALUNOS QUE CONTÉM O NOME] 
```
http://127.0.0.1:8080/v1/api/students/name?contains=Sampaio

METHOD: GET
REQUEST PARAM:
    KEY: contains
    VALUE: Sampaio
```

* Método: FIND BY LOCAL [ENCONTRAR ALUNOS QUE SÃO DO LOCAL]
```
http://127.0.0.1:8080/v1/api/students/local?neighborhood=Itaquera

METHOD: GET
REQUEST PARAM: 
    KEY: neighborhood
    VALUE: Itaquera
```

* Método: FIND BY BIRTH DATE BETWEEN [ENCONTRAR ALUNOS QUE NASCERAM ENTRE AS DATAS]
````
http://127.0.0.1:8080/v1/api/students/birth?start=1980-01-01&end=2000-01-01

METHOD: GET
REQUEST PARAMS: 
    REQUEST PARAM:
        KEY: start
        VALUE: 1980-01-01
    REQUEST PARAM:
        KEY: end
        VALUE: 2000-01-01
````

* Método: UPDATE BY ID [ATUALIZA DADOS DO ALUNOS USANDO SEU ID]
````
ttp://127.0.0.1:8080/v1/api/students/1

METHOD: PUT
PATH VARIABLE: 1
REQUEST BODY: JSON API STUDENT ENTITY
````
JSON API STUDENT ENTITY
````json
{
    "name": "Vanessa Sampaio de Santana",
    "neighborhood": "Vila Leopodina",
    "birthDate": "1990-05-11"
}
````

* Método: UPDATE BY DOCUMENT [ATUALIZA DADOS DO ALUNO USANDO SEU CPF]
````
http://127.0.0.1:8080/v1/api/students/document?cpf=12345678932

METHOD: PUT
REQUEST PARAM:
    KEY: cpf
    VALUE: 12345678932
REQUEST BODY: JSON API STUDENT ENTITY
````
JSON API STUDENT ENTITY
````json
{
    "name": "Vanessa Sampaio de Nascimento",
    "neighborhood": "Vila Leopodina",
    "birthDate": "1990-05-11"
}
````

* Método: DELETE BY ID [REMOVE ALUNO USANDO SEU ID]
````
http://127.0.0.1:8080/v1/api/students/1

METHOD: DELETE
PATH VARIABLE: 1
````

* Método: DELETE BY DOCUMENT [REMOVE ALUNO USANDO SEU CPF]
````
http://127.0.0.1:8080/v1/api/students/document?cpf=12345678932

METHOD: DELETE
REQEUST PARAM:
    KEY: cpf
    VALUE: 12345678932
````
2022.05.15 - MAURICIO MITYO HIDANI