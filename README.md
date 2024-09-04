Teste de Desenvolvimento: Sistema de Manutenção de Equipamentos

Descrição do Projeto.

Você foi contratado para desenvolver um sistema de gerenciamento de manutenção de
equipamentos para uma indústria. O sistema será utilizado pelos usuários para registrar os
equipamentos do seu estoque, assim como a validade de tais equipamentos.
Requisitos do Sistema.

Sistema: Os técnicos devem ser capazes de adicionar, atualizar, deletar (CRUD) equipamentos ao sistema,
informando o nome, descrição, data de aquisição, valor e validade.
Funcionalidade: O sistema deve atender a todos os requisitos especificados.
Usabilidade: A interface do usuário deve ser intuitiva e fácil de usar.
Qualidade do Código: O código fonte do sistema deve ser limpo, bem documentado e seguir boas
práticas de programação.

Servidor de Banco de Dados: O Banco de Dados deve ser Postgres.

Servidor de Aplicação: A aplicação deve ser entregue para execução com Wildfly em modo standalone. Toda e qualquer
configuração necessária deve ser especificada no arquivo Readme do projeto.

Front-end JSF (JavaServer Faces): A interface de visualização da aplicação (camada View) deve ser implementada utilizando a
especificação JSF (JavaServer Faces) com Primefaces. Todos os campos devem ser devidamente
validados e exibir mensagens de erro amigáveis ao usuário em caso de preenchimento ausente
ou incorreto.

## Pré-requisitos
- **Java JDK 11**: Necessário para compilar e executar o projeto.
- **Maven 3.8.1 ou superior**: Usado para gerenciar as dependências e construir o projeto.
- **WildFly 29**: Servidor de aplicações para executar o projeto.
- **PostgreSQL 42.7.2**: Sistema de banco de dados usado para armazenar as informações.

Arquivos

-skeleton-war: para a aplicação Web

-skeleton-ejb: Gerenciamento da lógica

skeleton-ear: Utilizado para empacotar o WAR e o EJB

Importante inserir o codigo no terminal do arquivo: mvn clean install




## Instalação

## Configuração do Wildfly

Baixar e Iniciar o Wildfly, Necessario fazer o Deployment do Postgres 42.7.2 JAR, configurar ele como:

JNDI Name : java:/EquipamentosDS

postgresql-42.7.2.jar

jdbc:postgresql://localhost:5432/equipamentos_db

org.postgresql.Driver


## Configuração do Banco de Dados

### Banco de Dados PostgreSQL

O projeto utiliza o PostgreSQL como sistema de gerenciamento de banco de dados. Abaixo estão as etapas para configurar o banco de dados para o seu projeto:

1. **Instalar PostgreSQL**:
   - Baixe e instale o PostgreSQL a partir do site oficial: [PostgreSQL Downloads](https://www.postgresql.org/download/).

2. **Criar o Banco de Dados**:
   Após a instalação, crie um banco de dados para o projeto. Conecte-se ao PostgreSQL usando uma ferramenta como `psql` ou pgAdmin e execute o seguinte comando SQL para criar o banco de dados:
   ```sql
   CREATE DATABASE equipamentos_db;
   CREATE TABLE IF NOT EXISTS public.equipamentos
   (
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    descricao text COLLATE pg_catalog."default" NOT NULL,
    data_aquisicao date NOT NULL,
    validade date NOT NULL,
    valor numeric(10,2) NOT NULL,
    CONSTRAINT equipamentos_pkey PRIMARY KEY (id)
   )
ALTER TABLE IF EXISTS public.equipamentos
    OWNER to postgres;

O site se encontra em:

http://localhost:8080/skeleton/

Está sendo enviado dois arquivos, um no qual fiz sem o primefaces e outro ele, foram feitos dois pois o wildfly não estava conseguindo identifica-lo, em ambos, tanto a função adicionar e deletar estão funcionando corretamente, porem eu não consegui arrumar a de atualizar.

Não consegui fazer um CSS para eles, pois dei prioridade para resolver os problemas encontrados.
