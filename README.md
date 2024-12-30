 Crie um projeto java web usando JSP e Servlet usando o Apache Maven e neste
as bibliotecas necessárias para a aplicação funcionar.
2) Adicione a seu projeto o Bootstrap e Jquery.
3) Crie uma página JSP inicial do projeto e nesta página inclua uma página JSP que
será um menu tipo nave, no qual o usuário poderá ser direcionado a um novo
produto e a listagem dos produtos cadastrados.
4) Crie uma classe Java com o nome Produto, ela deverá ter os atributos abaixo:
- descrição - tipo String;
- categoria - tipo String;
- preço de custo - tipo double;
- preço de venda - tipo double
- quantidade - tipo integer;
- data Entrada - tipo Date.
Obs: obrigatório a implementação da classe com estes atributos e tipos é
necessário os métodos getters e setters.
5) Crie uma página JSP que será o formulário de cadastro dos produtos e deverá ter
todos os campos da classe Produto criada no item 4.
6) Crie o Controlador (Servlet para receber a requisição do formulários e chamar as
classes de acesso ao banco de dados (DAO) )
7) Após gravar mostre uma mensagem no formulário de inserção de produto
informando que foi gravado com sucesso
8) Crie as classes DAO necessárias para acesso ao banco de dados PostgreSQL e
execução da query de inserção no banco de dados 
9) Crie no PostgreSQL um banco de dados e neste uma tabela para inserir os
produtos informados no formulário do item 5 
10)Crie uma página JSP para listar os produtos inseridos no banco de dados
11)Crie o Controlador (Servlet para consultar no banco de dados e retornar uma lista
de produtos e chamar as classes de acesso ao banco de dados (DAO))
12)Na listagem do item 9, implemente um botão que permita o usuário excluir um
produto inserido 
13)Implemente a exclusão no controlador do item 11
Obs: Lembre-se dos seguintes arquivos:
- context.xml (configuração do pool de conexão)
- web.xml (configuração da página inicial do projeto e do pool de conexão)
