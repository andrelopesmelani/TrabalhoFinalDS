# Sistema de Controle de uma Fabrica

## Informações Gerais sobre o Projeto

Este é um sistema de controle de produção desenvolvido para gerenciar eficientemente os processos de uma fábrica. O sistema abrange diversas funcionalidades essenciais para o controle e monitoramento de produtos, ordens de produção, funcionários e estoques.

### Objetivos
- Automatizar e otimizar o fluxo de produção.
- Assegurar um gerenciamento eficiente de recursos e informações.
- Fornecer suporte para a tomada de decisões com base em dados precisos.

### Funcionalidades Principais
- Cadastro e gerenciamento de produtos.
- Emissão e controle de ordens de produção.
- Gestão de funcionários envolvidos na produção.
- Monitoramento de estoques de produtos e matérias-primas.

## Informações sobre as Classes e suas Relações
### Classes do Projeto
#### Produto
- Atributos: Nome, Descrição, Preço
- Descrição: Representa os produtos fabricados na produção.
#### OrdemProducao
- Atributos: Produto, Quantidade
- Descrição: Representa as ordens de produção para fabricar produtos.
#### Funcionario
- Atributos: Nome, Cargo
- Descrição: Representa os funcionários que trabalham na produção.
#### Estoque
- Atributos: Produto, Quantidade
- Descrição: Representa o estoque de produtos e matérias-primas.
## Relações entre as Classes
- Associação: OrdemProducao está associada a Produto pois cada ordem de produção se refere a um produto específico.
- Composição: Estoque é composto de Produto pois o estoque contém produtos ou matérias-primas.
## Como Executar o Projeto
### Pré-requisitos
- JDK 11+
- Maven 3.6+
### Passos para Execução
- Clone o repositório:

#### Copiar código
- git clone https://github.com/andrelopesmelani/TrabalhoFinalDS.git
  cd TrabalhoFinalDS
  
#### Compile e execute o projeto usando Maven:

mvn clean install
- mvn exec:java -Dexec.mainClass="com.seuusuario.sistemacontroleproducao.Main"

## Uso do ChatGPT
### O ChatGPT foi utilizado para:
- Auxiliar na definição e estruturação das classes e suas relações.
- Prover sugestões e aprimoramentos para a documentação do projeto.
- Ajudar na criação de exemplos de código e explicações técnicas.

### Por que o ChatGPT foi Utilizado?
- Para obter insights e sugestões rápidas sobre melhores práticas de desenvolvimento.
- Para garantir clareza e consistência na documentação e na arquitetura do projeto.
- Para acelerar o processo de desenvolvimento, fornecendo exemplos e explicações detalhadas.

## Referências e Recursos
- Documentação do Java: https://docs.oracle.com/en/java/
- Maven: https://maven.apache.org/
- pring Framework Documentation: https://spring.io/projects/spring-framework
- 
### Agradecemos a todos os recursos e ferramentas que contribuíram para o desenvolvimento deste projeto.
