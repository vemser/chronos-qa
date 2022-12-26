# Cenários de teste

## Testes de Login

#### CT - Deve fazer login como instrutor com sucesso
Dado que estou na página de login
Quando preencho o campo email no login com email de instrutor valido
E preencho o campo senha no login com senha valida 
Quando clico no botão de fazer login
Então devo ser redirecionado para a página de instrutor

#### CT - Deve fazer login como gestor com sucesso
Dado que estou na página de login
Quando preencho o campo email no login com email de gestor valido
E preencho o campo senha no login com senha valida
Quando clico no botão de fazer login
Então devo ser redirecionado para a página de gestor

#### CT - Deve fazer login como admin com sucesso
Dado que estou na página de login
Quando preencho o campo email no login com email de admin valido
E preencho o campo senha no login com senha valida
Quando clico no botão de fazer login
Então devo ser redirecionado para a página de admin

#### CT - Deve fazer login com senha pequena inválido
Dado que estou na página de login
Quando preencho o campo email no login com email valido
E preencho o campo senha no login com senha pequena
Quando clico no botão de fazer login
Então devo ver uma mensagem de erro na senha do login

#### CT - Deve fazer login com email inválido
Dado que estou na página de login
Quando preencho o campo email no login com email inválido
E preencho o campo senha no login com senha valida
Quando clico no botão de fazer login
Então devo ver uma mensagem de erro no email do login

#### CT - Deve falhar fazer login sem preencher o campo senha
Dado que estou na página de login
Quando preencho o campo email no login com email valido
Quando clico no botão de fazer login
Então devo ver uma mensagem de erro na senha do login

#### CT - Deve falhar fazer login sem preencher o campo email
Dado que estou na página de login
Quando preencho o campo senha com senha valida
Quando clico no botão de fazer login
Então devo ver uma mensagem de erro no email do login

#### CT - Deve falhar fazer login sem Dado
Dado que estou na página de login
Quando clico no botão de fazer login
Então devo ver uma mensagem de erro no email do login
Então devo ver uma mensagem de erro na senha do login

#### CT - Deve falhar fazer login com Dado inválidos
Dado que estou na página de login
Quando preencho o campo email no login com email inválido
E preencho o campo senha no login com senha inválida
Quando clico no botão de fazer login
Então devo ver uma mensagem de erro de autorização

## Testes de Colaborador

### Criar Colaborador

#### CT - Deve criar um colaborador com sucesso
Dado que esteja logado como admin
E entre na página de colaboradores
E clique no botão de criar colaborador
E preencho o campo nome do colaborador com um nome válido
E preencho o campo email do colaborador com um email válido
E seleciono um cargo do colaborador
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de sucesso de criação de colaborador

#### CT - Deve criar um colaborador com mais de um cargo
Dado que esteja logado como admin
E entre na página de colaboradores
E clique no botão de criar colaborador
E preencho o campo nome do colaborador com um nome válido
E preencho o campo email do colaborador com um email válido
E seleciono mais de um cargo do colaborador
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de sucesso de criação de colaborador

#### CT - Deve retornar erro ao tentar criar um colaborador sem nome
Dado que esteja logado como admin
E entre na página de colaboradores
E clique no botão de criar colaborador
E preencho o campo email do colaborador com um email válido
E seleciono um cargo do colaborador
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de erro no nome do colaborador

#### CT - Deve retornar erro ao tentar criar um colaborador sem email
Dado que esteja logado como admin
E entre na página de colaboradores
E clique no botão de criar colaborador
E preencho o campo nome do colaborador com um nome válido
E seleciono um cargo do colaborador
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de erro no email do colaborador

#### CT - Deve retornar erro ao tentar criar um colaborador sem cargo
Dado que esteja logado como admin
E entre na página de colaboradores
E clique no botão de criar colaborador
E preencho o campo nome do colaborador com um nome válido
E preencho o campo email do colaborador com um email válido
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de erro no cargo do colaborador

#### CT - Deve retornar erro ao tentar criar um colaborador com email inválido
Dado que esteja logado como admin
E entre na página de colaboradores
E clique no botão de criar colaborador
E preencho o campo nome do colaborador com um nome colaborador válido
E preencho o campo email do colaborador com um email de colaborador inválido
E seleciono um cargo do colaborador
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de erro no email do colaborador

### Editar Colaborador


#### CT - Deve editar um colaborador com sucesso
Dado que esteja logado como admin
E entre na página de colaboradores
E crie um colaborador válido
E clique no botão de editar um colaborador
E preencho o campo nome do colaborador com um nome válido
E preencho o campo email do colaborador com um email válido
E seleciono um cargo do colaborador
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de sucesso de edição de colaborador

#### CT - Deve retornar erro ao tentar editar um colaborador sem cargo
Dado que esteja logado como admin
E entre na página de colaboradores
E crie um colaborador válido
E clique no botão de editar um colaborador
E preencho o campo nome do colaborador com um nome válido 
E preencho o campo email do colaborador com um email válido
E limpo os campos de cargo do colaborador
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de erro no cargo do colaborador

#### CT - Deve retornar erro ao tentar editar um colaborador sem nome
Dado que esteja logado como admin
E entre na página de colaboradores
E crie um colaborador válido
E clique no botão de editar um colaborador
E limpo o campo de nome do colaborador
E preencho o campo email do colaborador com um email válido
E seleciono um cargo do colaborador
Quando clico no botão de enviar colaborador
Então devo ver uma mensagem de erro no nome do colaborador

### Alterar status do colaborador

#### CT - Deve mudar o status de um colaborador com sucesso
Dado que esteja logado como admin
E entre na página de colaboradores
E crie um colaborador válido
E clique no botão de mudar status do colaborador
Então devo ver uma mensagem de sucesso de mudança de status do colaborador

## Teste de edição

### Criar edição

#### CT - Deve criar uma edição com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E clique no botão de criar edição
E preencho o campo nome da edição com um nome válido
E preencho o campo data inicial da edição com uma data válida
E preencho o campo data final da edição com uma data válida
Quando clico no botão de enviar edição
Então devo ver uma mensagem de sucesso de criação de edição

#### CT - Deve retornar erro ao tentar criar uma edição sem nome
Dado que esteja logado como gestor
E entre na página de edições
E clique no botão de criar edição
E preencho o campo data inicial da edição com uma data válida
E preencho o campo data final da edição com uma data válida
Quando clico no botão de enviar edição
Então devo ver uma mensagem de erro no nome da edição

#### CT - Deve retornar erro ao tentar criar uma edição sem data inicial
Dado que esteja logado como gestor
E entre na página de edições
E clique no botão de criar edição
E preencho o campo nome da edição com um nome válido
E preencho o campo data final da edição com uma data válida
Quando clico no botão de enviar edição
Então devo ver uma mensagem de erro na data inicial da edição

#### CT - Deve retornar erro ao tentar criar uma edição sem data final
Dado que esteja logado como gestor
E entre na página de edições
E clique no botão de criar edição
E preencho o campo nome da edição com um nome válido
E preencho o campo data inicial da edição com uma data válida
Quando clico no botão de enviar edição
Então devo ver uma mensagem de erro na data final da edição

#### CT - Deve retornar erro ao tentar criar uma edição com data inicial inválida
Dado que esteja logado como gestor
E entre na página de edições
E clique no botão de criar edição
E preencho o campo nome da edição com um nome válido
E preencho o campo data inicial da edição com uma data inválida
E preencho o campo data final da edição com uma data válida
Quando clico no botão de enviar edição
Então devo ver uma mensagem de erro na data inicial da edição

#### CT - Deve retornar erro ao tentar criar uma edição com data final igual a data inicial
Dado que esteja logado como gestor
E entre na página de edições
E clique no botão de criar edição
E preencho o campo nome da edição com um nome válido
E preencho o campo data inicial da edição com uma data válida
E preencho o campo data final da edição com uma data igual a data inicial
Quando clico no botão de enviar edição
Então devo ver uma mensagem de erro na data final da edição

### Editar edição

#### CT - Deve editar uma edição com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E clique no botão de editar uma edição
E preencho o campo nome da edição com um nome válido
E preencho o campo data inicial da edição com uma data válida
E preencho o campo data final da edição com uma data válida
Quando clico no botão de enviar edição
Então devo ver uma mensagem de sucesso de edição de edição

#### CT - Deve retornar erro ao tentar editar uma edição sem nome
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E clique no botão de editar uma edição
E limpo o campo de nome da edição
E preencho o campo data inicial da edição com uma data válida
E preencho o campo data final da edição com uma data válida
Quando clico no botão de enviar edição
Então devo ver uma mensagem de erro no nome da edição

#### CT - Deve retornar erro ao tentar editar uma edição sem data inicial
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E clique no botão de editar uma edição
E preencho o campo nome da edição com um nome válido
E limpo o campo de data inicial da edição
E preencho o campo data final da edição com uma data válida
Quando clico no botão de enviar edição
Então devo ver uma mensagem de erro na data inicial da edição

#### CT - Deve retornar erro ao tentar editar uma edição sem data final
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E clique no botão de editar uma edição
E preencho o campo nome da edição com um nome válido
E preencho o campo data inicial da edição com uma data válida
E limpo o campo de data final da edição
Quando clico no botão de enviar edição
Então devo ver uma mensagem de erro na data final da edição

#### CT - Deve editar o status de uma edição com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E clique no botão de editar uma edição
E preencho o campo status da edição com um status válido
Quando clico no botão de enviar edição
Então devo ver uma mensagem de sucesso de alterar status da edição

#### CT - Deve clonar uma edição com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E clique no botão de clonar uma edição
Então devo ver uma mensagem de sucesso de clonar edição

## Testes de Etapa

### Criar etapa

#### CT - Deve criar uma etapa com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E clique no botão de criar etapa
E preencho o campo nome da etapa com um nome válido
E preencho o campo ordem da etapa com uma ordem válida
Quando clico no botão de enviar etapa
Então devo ver uma mensagem de sucesso de criar etapa

#### CT - Deve retornar erro ao tentar criar uma etapa sem nome
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E clique no botão de criar etapa
E preencho o campo ordem da etapa com uma ordem válida
Quando clico no botão de enviar etapa
Então devo ver uma mensagem de erro no nome da etapa

#### CT - Deve editar uma etapa com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E crie uma etapa válida
E clique no botão de editar uma etapa
E preencho o campo nome da etapa com um nome válido
E preencho o campo ordem da etapa com uma ordem válida
Quando clico no botão de enviar etapa
Então devo ver uma mensagem de sucesso de editar etapa
 
#### CT - Deve retornar erro ao tentar editar uma etapa sem nome
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E crie uma etapa válida
E clique no botão de editar uma etapa
E preencho o campo ordem da etapa com uma ordem válida
E limpo o campo de nome da etapa
Quando clico no botão de enviar etapa
Então devo ver uma mensagem de erro no nome da etapa

#### CT - Deve excluir uma etapa com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E crie uma etapa válida
E clique no botão de excluir uma etapa
Então devo ver uma mensagem de sucesso de excluir etapa

## Teste de Processo

### Criar processo

#### CT - Deve criar um processo com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E crie uma etapa válida
E clique no botão de criar processo
E preencho o campo nome do processo com um nome válido
E preencha o campo de área envolvida com uma area válida
E preencha o campo de responsável com um responsável válido
E preencha o campo de duração do processo com uma duração válida
E preencha o campo de dias úteis do processo com uma quantidade de dias válida
E preencha o campo de ordem com uma ordem válida
Quando clico no botão de enviar processo
Então devo ver uma mensagem de sucesso de criar processo

#### CT - Deve criar um processo com novo responsável e nova area envolvida com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E crie uma etapa válida
E clique no botão de criar processo
E preencho o campo nome do processo com um nome válido
E preencha o campo de área envolvida com uma area válida
E preencha o campo de responsável com um responsável válido
E preencha o campo de duração do processo com uma duração válida
E preencha o campo de dias úteis do processo com uma quantidade de dias válida
E preencha o campo de ordem com uma ordem válida
Quando clico no botão de enviar processo
Então devo ver uma mensagem de sucesso de criar processo

#### CT - Deve editar processo com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E crie uma etapa válida
E crie um processo válido
E clique no botão de editar um processo
E preencho o campo nome do processo com um nome válido
E preencha o campo de área envolvida com uma area válida
E preencha o campo de responsável com um responsável válido
Quando clico no botão de enviar processo
Então devo ver uma mensagem de sucesso de editar processo

#### CT - Deve deletar processo com sucesso
Dado que esteja logado como gestor
E entre na página de edições
E crie uma edição válida
E abra os detalhes da edição
E crie uma etapa válida
E crie um processo válido
E clique no botão de deletar um processo
Então devo ver uma mensagem de sucesso de deletar processo

## Testes Período Não Útil

### Criar período não útil

#### CT - Deve criar um período não útil com sucesso
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E clique em criar período não útil
E preencho o campo descrição com uma descrição válida
E preencho o campo data inicial com uma data válida
E preencho o campo data final com uma data válida
E seleciono o campo de repetição anual
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de sucesso de criar período não útil


#### CT - Deve criar um período não útil sem repetição anual com sucesso
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E clique em criar período não útil
E preencho o campo descrição com uma descrição válida
E preencho o campo data inicial com uma data válida
E preencho o campo data final com uma data válida
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de sucesso de criar período não útil

#### CT - Deve criar um período não útil sem data final com sucesso
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E clique em criar período não útil
E preencho o campo descrição com uma descrição válida
E preencho o campo data inicial com uma data válida
E seleciono o campo de repetição anual
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de sucesso de criar período não útil

#### CT - Deve retornar erro ao tentar criar um período não útil sem descrição
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E clique em criar período não útil
E preencho o campo data inicial com uma data válida
E preencho o campo data final com uma data válida
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de erro da descrição de período não útil

#### CT - Deve retornar erro ao tentar criar um período não útil sem data inicial
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E clique em criar período não útil
E preencho o campo descrição com uma descrição válida
E preencho o campo data final com uma data válida
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de erro da data inicial de período não útil

#### CT - Deve retornar erro ao tentar criar um período não útil com data inicial maior que a data final
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E clique em criar período não útil
E preencho o campo descrição com uma descrição válida
E preencho o campo data inicial com uma data válida
E preencho o campo data final com uma data menor que a data inicial
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de erro da criação de período não útil

### Editar período não útil

#### CT - Deve editar a descricão de um período não útil com sucesso
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E crie um período não útil válido
E clique no botão de editar um período não útil
E preencho o campo descrição com uma descrição válida
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de sucesso de editar período não útil

#### CT - Deve editar a data final de um período não útil com sucesso
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E crie um período não útil válido
E clique no botão de editar um período não útil
E preencho o campo data final com uma data válida
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de sucesso de editar período não útil

#### CT - Deve editar a data de um período não útil com sucesso
Dado que esteja logado como gestor
E entre na página de períodos não úteis
E crie um período não útil válido
E clique no botão de editar um período não útil
E preencho o campo data inicial com uma data válida
E preencho o campo data final com uma data válida
Quando clico no botão de enviar período não útil
Então devo ver uma mensagem de sucesso de editar período não útil