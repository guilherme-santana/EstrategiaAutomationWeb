<div align="center"><h1>Projeto de Teste Automação web 🖥️</h1></div>


### ✒️ Introdução
Projeto de teste automatizado em plataforma web.

### 🧪 Executar Testes
- pré-requisito
  - Gradle instalado
  
- Acesse a pasta raiz do projeto e execute o comando "gradle :test --tests "runner.TestRunner""
- Para ter acesso ao relatório de execução, basta acessar ${basedir}/target/cucumber-reports/index.html

### 🛠️ Ferramentas Utilizadas
 - Cucumber-java 1.2.5
 - Cucumber-junit 1.2.5
 - Selenium 3.141.59
 - Java 8
 - Gradle 6.8
### 🧔 Responsáveis pelo projeto
Guilherme Santana

### Estrutura do projeto

![alt text](https://github.com/guilherme-santana/EstrategiaAutomationWeb/blob/master/struct/estrutura.png)

 - Pacote core
    - Foi centralizado todas as constantes do projeto, tais como URL, PATH_CHROME_DRIVER, TIMEOUT e etc.
      ![alt text](https://github.com/guilherme-santana/EstrategiaAutomationWeb/blob/master/struct/core.png)
 
 - Pacote pages
    - Camada onde todos os elementos estão mapeados separados por página.
    
 - Pacote runner
    - Executor central dos testes e também configurações de suítes de teste, plugins e reports.
 
 - Pacote steps
    - Camada que possui classes que interpretam os passos descritos nos arquivos .feature e inicializam a automação. 
 
 - Pacote resources
    - Centraliza todos os arquivos .feature do projeto.


