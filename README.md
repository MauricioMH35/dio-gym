# DIO GYM
PRIJETO GYM PARA DIGITAL INNOVATION ONE

De acordo com o projeto de serviço de API para uma academia que deve entregar por meio da Application Programming Interface (API), consumíveis em Json. Foi desenvolvido a aplicação a seguir.
Contendo registro de Alunos que frequentam tal academia, assim como o registro de avaliações físicas que o aluno sera submetido.

## OBJEDO O PROJETO
Deverá ser clonado o repositório do projeto na sua máquina para conseguir visualiza-lo.
```
cd "coloque_aqui_o_caminho_do_diretório_onde_deseja_clonar_esse_repositorio"
git clone https://github.com/MauricioMH35/dio-gym.git
```

Para conseguir rodar o projeto na sua máquina será necessário que tenha o gradle instalado, que pode ser seguido a forma de como se instalar o gradle no [link](https://gradle.org/install/)
```
sdk install gradle 7.4.2

# OU SE ESTIVER USANDO LINUX

brew install gradle
```

E para rodar a aplicação após ter clonado o repositório e possuir o gradle instalado na máquina. Você deverá estar no diretório `(../dio-gym/)` clonado do GitHub e executar o seguindo comando:
```
./gradlew bootRun
```

## ROTAS
### Método: CREATE [Criar Aluno/Estudante]
```
http://127.0.0.1:8080/v1/api/students
```

### Método: FIND ALL [Encontrar Todos]
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

### Método: FIND BY ID [ENCONTRAR ALUNO USANDO SEU ID]
```
http://127.0.0.1:8080/v1/api/students/1

METHOD: GET
PATH VARIABLE: 1
```

### Método: FIND BY CPF [ENCONTRAR ALUNO USANDO SEU CPF]
```
http://127.0.0.1:8080/v1/api/students/document?cpf=12345678932

METHOD: GET
REQUEST PARAM: 
    KEY: cpf
    VALUE: 12345678932
```

### Método: FIND BY NAME CONTAINS [ENCONTRAT ALUNOS QUE CONTÉM O NOME] 
```
http://127.0.0.1:8080/v1/api/students/name?contains=Sampaio

METHOD: GET
REQUEST PARAM:
    KEY: contains
    VALUE: Sampaio
```

### Método: FIND BY LOCAL [ENCONTRAR ALUNOS QUE SÃO DO LOCAL]
```
http://127.0.0.1:8080/v1/api/students/local?neighborhood=Itaquera

METHOD: GET
REQUEST PARAM: 
    KEY: neighborhood
    VALUE: Itaquera
```

### Método: FIND BY BIRTH DATE BETWEEN [ENCONTRAR ALUNOS QUE NASCERAM ENTRE AS DATAS]
```
http://127.0.0.1:8080/v1/api/students/birth?start=1980-01-01&end=2000-01-01

METHOD: GET
REQUEST PARAMS: 
    REQUEST PARAM:
        KEY: start
        VALUE: 1980-01-01
    REQUEST PARAM:
        KEY: end
        VALUE: 2000-01-01
```

### Método: FIND BY REGISTRATION BETWEEN [ENCONTRAR ALUNOS REGISTRADOS ENTRE DATAS]
```
http://127.0.0.1:8080/v1/api/students/registration?start=2022-01-01&end=2022-05-30

METHOD: GET
REQUEST PARAMS:
    REQUEST PARAM:
        KEY: start
        VALUE: 2022-01-01
    REQUEST PARAM:
        KEY: end
        VALUE: 2022-05-30
```

### Método: UPDATE BY ID [ATUALIZA DADOS DO ALUNOS USANDO SEU ID]
```
http://127.0.0.1:8080/v1/api/students/1

METHOD: PUT
PATH VARIABLE: 1
REQUEST BODY: JSON API STUDENT ENTITY
```
JSON API STUDENT ENTITY
```json
{
    "name": "Vanessa Sampaio de Santana",
    "neighborhood": "Vila Leopodina",
    "birthDate": "1990-05-11"
}
```

### Método: UPDATE BY DOCUMENT [ATUALIZA DADOS DO ALUNO USANDO SEU CPF]
```
http://127.0.0.1:8080/v1/api/students/document?cpf=12345678932

METHOD: PUT
REQUEST PARAM:
    KEY: cpf
    VALUE: 12345678932
REQUEST BODY: JSON API STUDENT ENTITY
```
JSON API STUDENT ENTITY
```json
{
    "name": "Vanessa Sampaio de Nascimento",
    "neighborhood": "Vila Leopodina",
    "birthDate": "1990-05-11"
}
```

### Método: DELETE BY ID [REMOVE ALUNO USANDO SEU ID]
```
http://127.0.0.1:8080/v1/api/students/1

METHOD: DELETE
PATH VARIABLE: 1
```

### Método: DELETE BY DOCUMENT [REMOVE ALUNO USANDO SEU CPF]
```
http://127.0.0.1:8080/v1/api/students/document?cpf=12345678932

METHOD: DELETE
REQEUST PARAM:
    KEY: cpf
    VALUE: 12345678932
```

### Método: CREATE [CRIA AVALIAÇÃO]
```
http://127.0.0.1:8080/v1/api/assessments

METHOD: POST
REQUEST BODY: JSON API ASSESSMENT ENTITY
```
JSON API ASSESSMENT ENTITY
```json
{
    "student": { "id": 1 }, 
    "evaluationDate": "2022-05-15",
    "weight": 85.32,
    "height": 1.80
}
```

### Método: FIND ALL [ENCONTRA TOTAS AS AVALIAÇÕES]
```
http://127.0.0.1:8080/v1/api/assessments/

METHOD: GET
```

### Método: FIND BY ID [ENCONTRA AVALIAÇÃO USANDO O ID]
```
http://127.0.0.1:8080/v1/api/assessments/1

METHOD: GET
PATH VARIABLE: 1
```

### Método: FIND BY EVALUATION DATE [ENCONTRA AVALIAÇÃO USANDO DATA DE AVALIAÇÃO]
```
http://127.0.0.1:8080/v1/api/assessments/?evaluation=2022-05-15

METHOD: GET
REQUEST PARAM:
    KEY: evaluation
    VALUE: 2022-05-15
```

### Método: FIND BY EVALUATION DATE BETWEEN [ENCONTRA AVALIAÇÕES ENTRE DATAS]
```
http://127.0.0.1:8080/v1/api/assessments/evaluation/between?start=2022-01-01&end=2022-05-31

METHOD: GET
REQUEST PARAMS:
    REQUEST PARAM:
        KEY: start
        VALUE: 2022-01-01
    REQUEST PARAM:
        KEY: end
        VALUE: 2022-05-31
```

### Método: FIND BY WEIGHT [ENCONTRAR AVALIAÇÕES QUE POSSUAM ALUNOS DE PESO]
```
http://127.0.0.1:8080/v1/api/assessments/weight?weight=85.32

METHOD: GET
REQUEST PARAM:
    KEY: weight
    VALUE: 85.32
```

### Método: FIND BY WEIGHT BETWEEN [ENCONTRAT AVALIAÇÕES QUE POSSUAM ALUNOS ENTRE PESOS]
```
http://127.0.0.1:8080/v1/api/assessments/weight/between?start=60.0&end=100.0

METHOD: GET
REQUEST PARAMS:
    REQUEST PARAM:
        KEY: start
        VALUE: 60.0
    REQUEST PARAM:
        KEY: end
        VALUE: 100.0
```

### Método: FIND BY HEIGHT [ENCONTRA AVALIAÇÕES QUE POSSUAM ALUNOS COM ALTURA]
```
http://127.0.0.1:8080/v1/api/assessments/height?height=1.8

METHOD: GET
REQUEST PARAM:
    KEY: height
    VALUE: 1.8
```

### Método: FIND BY HEIGHT BETWEEN [ENCONTRA AVALIAÇÕES QUE POSSUAM ALUNOS ENTRE ALTURAS]
```
http://127.0.0.1:8080/v1/api/assessments/height/beteween?start=1.5&end=2

METHOD: GET
REQUEST PARAMS:
    REQUEST PARAM: 
        KEY: start
        VALUE: 1.5
    REQUEST PARAM:
        KEY: end
        VALUE: 2
```

### Método: UPDATE BY ID [ATUALIZA AVALIAÇÃO USANDO ID]
```
http://127.0.0.1:8080/v1/api/assessments/1

METHOD: PUT
PATH VARIABLE: 1
```

### Método: DELETE BY ID [REMOVE AVALIAÇÃO USANDO ID]
```
http://127.0.0.1:8080/v1/api/assessments/2

METHOD: DELETE
PATH VARIABLE: 1
```

<br />
<hr />
📅 2022.05.15 - 🧑‍💻 MAURICIO MITYO HIDANI 