# Cenários de teste

## Testes de Login

#### CT - Deve fazer login com sucesso

Dado que tenho um email e senha válidos
Quando envio uma requisição para a rota de login
Então devo receber um token de autenticação

#### CT - Deve retornar erro ao fazer login sem dados

Dados que nao tenho email e senha
Quando envio uma requisição para a rota de login
Então devo receber um erro

#### CT - Deve retornar erro ao fazer login sem preencher o campo email

Dados que tenho uma senha válida
E nao tenho um email
Quando envio uma requisição para a rota de login
Então devo receber um erro

#### CT - Deve retornar erro ao fazer login sem preencher o campo senha

Dados que tenho um email válido
E nao tenho uma senha
Quando envio uma requisição para a rota de login
Então devo receber um erro

#### CT - Deve retornar erro ao fazer login com dados inválidos

Dados que tenho um email e senha inválidos
Quando envio uma requisição para a rota de login
Então devo receber um erro

#### CT - Deve retornar erro ao fazer login com email valido e senha invalida

Dados que tenho um email válido
E tenho uma senha inválida
Quando envio uma requisição para a rota de login
Então devo receber um erro

## Testes de Usuário

### Criar Usuario

#### CT - Deve criar usuario com sucesso

Dado que estou autenticado como admin
E que tenho um json com os dados do usuario válidos
Quando o envio uma requisição para a rota de criar usuario
Então o usuario deve ser criado com sucesso

#### CT - Deve retornar erro ao tentar criar usuario sem nome

Dado que estou autenticado como admin
E tenho um json com os dados do usuario sem nome
Quando envio uma requisição para a rota de criar usuario
Então deve retornar erro

#### CT - Deve retornar erro ao tentar criar usuario sem cargo

Dado que estou autenticado como admin
E tenho um json com os dados do usuario sem cargo
Quando envio uma requisição para a rota de criar usuario
Então deve retornar erro

#### CT - Deve retornar erro ao tentar criar usuario com cargos vazio

Dado que estou autenticado como admin
E tenho um json com os dados do usuario com cargos vazio
Quando envio uma requisição para a rota de criar usuario
Então deve retornar erro

#### CT - Deve retornar erro ao tentar criar usuario sem email

Dado que estou autenticado como admin
E tenho um json com os dados do usuario sem email
Quando envio uma requisição para a rota de criar usuario
Então deve retornar erro

#### CT - Deve retornar erro ao tentar criar usuario com email duplicado

Dado que estou autenticado como admin
E tenho um json com os dados do usuario com email já existente no banco de dados
Quando envio uma requisição para a rota de criar usuario
Então deve retornar erro

#### CT - Deve retornar erro ao tentar criar usuario com email inválido

Dado que estou autenticado como admin
E tenho um json com os dados do usuario com email inválido
Quando envio uma requisição para a rota de criar usuario
Então deve retornar erro

#### CT - Deve retornar erro ao tentar criar usuario com cargo inválido

Dado que estou autenticado como admin
E tenho um json com os dados do usuario com cargo inválido
Quando envio uma requisição para a rota de criar usuario
Então deve retornar erro

#### CT - Deve retornar erro ao tentar criar usuario sem auth

Dado que nao estou autenticado
E tenho um json com os dados do usuario
Quando envio uma requisição para a rota de criar usuario
Então deve retornar erro

### Listar Usuarios

#### CT - Deve listar os usuarios de acordo com o schema

Dado que estou autenticado como admin
Quando envio uma requisição para a rota de listar todos usuarios
Então deve retornar um json de acordo com o schema

#### CT - Deve listar todos usuarios com sucesso

Dado que estou autenticado como admin
Quando envio uma requisição para a rota de listar todos usuarios
Então deve retornar sucesso

#### CT - Deve retornar erro ao tentar listar todos usuarios sem auth

Dado que nao estou autenticado
Quando envio uma requisição para a rota de listar todos usuarios
Então deve retornar erro

### Editar Status

#### CT - Deve mudar status com sucesso

Dado que estou autenticado como admin
E tenho um id de usuario valido
Quando envio uma requisição para a rota de mudar status
Então o status do usuario deve ser alterado com sucesso

#### CT - Deve retornar erro ao tentar mudar status com id inválido

Dados que estou autenticado como admin
E tenho um id de usuario inválido
Quando envio uma requisição para a rota de mudar status
Então deve retornar erro

#### CT - Deve retornar erro ao tentar mudar status sem auth

Dado que nao estou autenticado
E que tenho um id de usuario valido
Quando envio uma requisição para a rota de mudar status
Então deve retornar erro

### Editar perfil

#### CT - Deve atualizar perfil com sucesso

Dado que estou autenticado como usuario
E tenho um json com os dados de perfil válidos
Quando envio uma requisição para a rota de atualizar perfil
Então deve retornar sucesso

#### CT - Deve retornar erro ao tentar atualizar perfil com senhas diferentes

Dado que estou autenticado como usuario
E tenho um json com os dados de perfil com novaSenha diferente da confirmacaoNovaSenha
Quando envio uma requisição para a rota de atualizar perfil
Então deve retornar erro

#### CT - Deve retornar erro ao tentar atualizar perfil sem senhaAtual

Dado que estou autenticado como usuario
E tenho um json com os dados de perfil sem senhaAtual
Quando envio uma requisição para a rota de atualizar perfil
Então deve retornar erro

#### CT - Deve retornar erro ao tentar atualizar perfil sem novaSenha

Dado que estou autenticado como usuario
E tenho um json com os dados de perfil sem novaSenha
Quando envio uma requisição para a rota de atualizar perfil
Então deve retornar erro

#### CT - Deve retornar erro ao tentar atualizar perfil sem auth

Dado que nao estou autenticado
E tenho um json com os dados de perfil
Quando envio uma requisição para a rota de mudar perfil
Então deve retornar erro

#### CT - Deve retornar erro ao tentar atualizar perfil sem confirmacaoNovaSenha

Dado que estou autenticado como usuario
E tenho um json com os dados de perfil sem confirmacaoNovaSenha
Quando envio uma requisição para a rota de atualizar perfil
Então deve retornar erro

#### CT - Deve retornar erro ao tentar atualizar perfil sem nome

Dado que estou autenticado como usuario
E tenho um json com os dados de perfil sem nome
Quando envio uma requisição para a rota de atualizar perfil
Então deve retornar erro

### Editar Cadastro

#### CT - Deve atualizar cadastro com sucesso

Dado que estou autenticado como admin
E tenho um json com os dados do usuario válidos
Quando envio uma requisição para a rota de atualizar cadastro
Então deve retornar sucesso

#### CT - Deve retornar erro ao atualizar cadastro sem cargos

Dado que estou autenticado como admin
E tenho um json com os dados do usuario sem cargos
Quando envio uma requisição para a rota de atualizar cadastro
Então deve retornar erro

#### CT - Deve retornar erro ao atualizar cadastro sem nome

Dado que estou autenticado como admin
E tenho um json com os dados do usuario sem nome
Quando envio uma requisição para a rota de atualizar cadastro
Então deve retornar erro

#### CT - Deve retornar erro ao atualizar cadastro com cargo vazio

Dado que estou autenticado como admin
E tenho um json com os dados do usuario com cargo vazio
Quando envio uma requisição para a rota de atualizar cadastro
Então deve retornar erro

#### CT - Deve retornar erro ao atualizar cadastro com id inválido

Dado que estou autenticado como admin
E tenho um json com os dados do usuario com id inválido
Quando envio uma requisição para a rota de atualizar cadastro
Então deve retornar erro

#### CT - Deve retornar erro ao atualizar cadastro com cargos inválidos

Dado que estou autenticado como admin
E tenho um json com os dados do usuario com cargos inválidos
Quando envio uma requisição para a rota de atualizar cadastro
Então deve retornar erro

#### CT - Deve retornar erro ao atualizar cadastro sem auth

Dado que nao estou autenticado
E tenho um json com os dados do usuario
Quando envio uma requisição para a rota de atualizar cadastro
Então deve retornar erro

### Deletar Usuário

#### CT - Deve deletar usuario com sucesso

Dado que estou autenticado como admin
E tenho um id de usuario valido
Quando envio uma requisição para a rota de deletar usuario
Então o usuario deve ser deletado com sucesso

#### CT - Deve retornar erro ao tentar deletar usuario com id inválido

Dado que estou autenticado como admin
E tenho um id de usuario inválido
Quando envio uma requisição para a rota de deletar usuario
Então deve retornar erro

#### CT - Deve retornar erro ao tentar deletar usuario sem auth

Dado que nao estou autenticado
E tenho um id de usuario valido
Quando envio uma requisição para a rota de deletar usuario
Então deve retornar erro

## Testes de Edição

### Criar Edição

#### CT - Deve criar uma edição com sucesso

Dado que estou autenticado como gestor
E tenho um json com os dados da edição válidos
Quando envio uma requisição para a rota de criar edição
Então deve retornar sucesso

#### CT - Deve retornar erro ao criar uma edição sem dataFinal

Dado que estou autenticado como gestor
E tenho um json com os dados da edição sem dataFinal
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição sem dataInicial

Dado que estou autenticado como gestor
E tenho um json com os dados da edição sem dataInicial
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição sem nome

Dado que estou autenticado como gestor
E tenho um json com os dados da edição sem nome
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição com dataFinal com tipo inválido

Dado que estou autenticado como gestor
E tenho um json com os dados da edição com dataFinal com tipo inválido
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição com dataFinal igual a dataInicial

Dado que estou autenticado como gestor
E tenho um json com os dados da edição com dataFinal igual a dataInicial
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição com dataFinal menor que dataInicial

Dado que estou autenticado como gestor
E tenho um json com os dados da edição com dataFinal menor que dataInicial
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição com dataFinal no formato inválido

Dado que estou autenticado como gestor
E tenho um json com os dados da edição com dataFinal no formato inválido
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição com dataInicial com tipo inválido

Dado que estou autenticado como gestor
E tenho um json com os dados da edição com dataInicial com tipo inválido
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição com dataInicial no formato inválido

Dado que estou autenticado como gestor
E tenho um json com os dados da edição com dataInicial no formato inválido
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma edição sem auth

Dado que nao estou autenticado
E tenho um json com os dados da edição válidos
Quando envio uma requisição para a rota de criar edição
Então deve retornar erro

### Listar Edições

#### CT - Deve listar as edições de acordo com o schema

Dado que estou autenticado como gestor
Quando envio uma requisição para a rota de listar edições
Então deve um json de acordo com o schema

#### CT - Deve listar edições com sucesso

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar edições
Então deve retornar sucesso

#### CT - Deve retornar erro ao listar edições sem Auth

Dados que nao estou autenticado
Quando envio uma requisição para a rota de listar edições
Então deve retornar erro

### Listar Calendário

#### CT - Deve listar calendario da edição com sucesso

Dados que estou autenticado como gestor
E tenho um id de uma edição
Quando envio uma requisição para a rota de listar calendario da edição
Então deve retornar sucesso

#### CT - Deve listar calendario geral da edição com sucesso

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar calendario geral da edição
Então deve retornar sucesso

#### CT - Deve retornar erro ao listar calendario geral da edição sem auth

Dados que nao estou autenticado
Quando envio uma requisição para a rota de listar calendario geral da edição
Então deve retornar erro

### Editar Edição

#### CT - Deve editar uma edição com sucesso

Dados que estou autenticado como gestor
E tenho um json com os dados da edição válidos
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar sucesso

#### CT - Deve retornar erro ao editar uma edição sem dataInicial

Dados que estou autenticado como gestor
E tenho um json com os dados da edição sem dataInicial
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição sem dataFinal

Dados que estou autenticado como gestor
E tenho um json com os dados da edição sem dataFinal
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição sem nome

Dados que estou autenticado como gestor
E tenho um json com os dados da edição sem nome
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição com data final tipo inválido

Dados que estou autenticado como gestor
E tenho um json com os dados da edição cuja dataFinal tem tipo inválido
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição com data inicial tipo inválido

Dados que estou autenticado como gestor
E tenho um json com os dados da edição cuja dataInicial tem tipo inválido
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição com dataFinal igual a dataInicial

Dados que estou autenticado como gestor
E tenho um json com os dados da edição cuja dataFinal é igual a dataInicial
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição com dataFinal menor que dataInicial

Dados que estou autenticado como gestor
E tenho um json com os dados da edição cuja dataFinal é menor que dataInicial
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição com dataFinal no formato Inválido

Dados que estou autenticado como gestor
E tenho um json com os dados da edição cuja dataFinal está no formato inválido
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição com dataInicial no formato inválido

Dados que estou autenticado como gestor
E tenho um json com os dados da edição cuja dataInicial está no formato inválido
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição com id inválido

Dados que estou autenticado como gestor
E tenho um json com os dados da edição válidos
E tenho um id de edição inválido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

#### CT - Deve retornar erro ao editar uma edição sem auth

Dados que não estou autenticado
E tenho um json com os dados da edição válidos
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar edição
Então deve retornar erro

### Editar Status Edição

#### CT - Deve alterar o status de uma edição com sucesso

Dados que estou autenticado como gestor
E tenho um json com os dados da edição válidos
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar status edição
Então deve retornar sucesso

#### CT - Deve retornar erro ao tentar alterar status de uma edição com id inválido

Dados que estou autenticado como gestor
E tenho um json com os dados da edição válidos
E tenho um id de edição inválido
Quando envio uma requisição para a rota de editar status edição
Então deve retornar erro

#### CT - Deve retornar erro ao alterar status de uma edição sem auth

Dados que não estou autenticado
E tenho um json com os dados da edição válidos
E tenho um id de edição válido
Quando envio uma requisição para a rota de editar status edição
Então deve retornar erro

### Clonar Edição

#### CT - Deve clonar uma edição com sucesso

Dados que estou autenticado como gestor
E tenho um json com os dados da edição válidos
E tenho um id de edição válido
Quando envio uma requisição para a rota de clonar edição
Então deve retornar sucesso

#### CT - Deve retornar erro ao tentar clonar uma edição com id inexistente

Dados que estou autenticado como gestor
E tenho um json com os dados da edição válidos
E tenho um id de edição inexistente
Quando envio uma requisição para a rota de clonar edição
Então deve retornar erro

#### CT - Deve retornar erro ao tentar clonar uma edição sem auth

Dados que não estou autenticado
E tenho um json com os dados da edição válidos
E tenho um id de edição válido
Quando envio uma requisição para a rota de clonar edição
Então deve retornar erro

### Deletar Edição

#### CT - Deve deletar uma edição com sucesso

Dados que estou autenticado como gestor
E tenho um id de edição válido
Quando envio uma requisição para a rota de deletar edição
Então deve retornar sucesso

#### CT - Deve retornar erro ao deletar uma edição inexistente

Dados que estou autenticado como gestor
E tenho um id de edição inexistente
Quando envio uma requisição para a rota de deletar edição
Então deve retornar erro

#### CT - Deve retornar erro ao deletar uma edição sem auth

Dados que não estou autenticado
E tenho um id de edição válido
Quando envio uma requisição para a rota de deletar edição
Então deve retornar erro

## Teste de Etapa

### Criar Etapa

#### CT - Deve criar etapa com sucesso

Dados que estou autenticado como gestor
E tenho um id de edição válido
E tenho um json com os dados da etapa válidos
Quando envio uma requisição para a rota de criar etapa
Então deve retornar sucesso

#### CT - Deve retornar erro ao criar etapa sem nome

Dados que estou autenticado como gestor
E tenho um id de edição válido
E tenho um json com os dados da etapa sem nome
Quando envio uma requisição para a rota de criar etapa
Então deve retornar erro

#### CT - Deve retornar erro ao criar etapa sem ordem de execução

Dados que estou autenticado como gestor
E tenho um id de edição válido
E tenho um json com os dados da etapa sem ordemExecucao
Quando envio uma requisição para a rota de criar etapa
Então deve retornar erro

#### CT - Deve retornar erro ao criar etapa sem auth

Dados que não estou autenticado
E tenho um id de edição válido
E tenho um json com os dados da etapa válidos
Quando envio uma requisição para a rota de criar etapa
Então deve retornar erro

### Listar Etapa

#### CT - Deve listar etapas com sucesso

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar etapas
Então deve retornar sucesso

#### CT - Deve listar etapa por id com sucesso

Dados que estou autenticado como gestor
E tenho um id de edição válido
Quando envio uma requisição para a rota de listar etapa por id
Então deve retornar sucesso

#### CT - Deve retornar erro ao ao listar etapa por id inexistente

Dados que estou autenticado como gestor
E tenho um id de edição inválido
Quando envio uma requisição para a rota de listar etapa por id
Então deve retornar erro

#### CT - Deve retornar erro ao ao listar etapa por id sem autenticação

Dados que não estou autenticado
E tenho um id de edição válido
Quando envio uma requisição para a rota de listar etapa por id
Então deve retornar erro

#### CT - Deve retornar erro ao ao listar etapas sem Auth

Dados que não estou autenticado
Quando envio uma requisição para a rota de listar etapas
Então deve retornar erro

#### CT - Deve listar as etapas de acordo com o schema

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar etapas
Então deve retornar as etapas de acordo com o schema

### Editar Etapa

#### CT - Deve editar uma etapa com sucesso

Dados que estou autenticado como gestor
E tenho um id de etapa válido
E tenho um json com os dados da etapa válidos
Quando envio uma requisição para a rota de editar etapa
Então deve retornar sucesso

#### CT - Deve retornar erro ao ao editar uma etapa com id inválido

Dados que estou autenticado como gestor
E tenho um id de etapa inválido
E tenho um json com os dados da etapa válidos
Quando envio uma requisição para a rota de editar etapa
Então deve retornar erro

#### CT - Deve retornar erro ao ao editar uma etapa sem nome

Dados que estou autenticado como gestor
E tenho um id de etapa válido
E tenho um json com os dados da etapa sem nome
Quando envio uma requisição para a rota de editar etapa
Então deve retornar erro

#### CT - Deve retornar erro ao ao editar uma etapa sem ordemExecucao

Dados que estou autenticado como gestor
E tenho um id de etapa válido
E tenho um json com os dados da etapa sem ordemExecucao
Quando envio uma requisição para a rota de editar etapa
Então deve retornar erro

#### CT - Deve retornar erro ao ao editar uma etapa sem Auth

Dados que não estou autenticado
E tenho um id de etapa válido
E tenho um json com os dados da etapa válidos
Quando envio uma requisição para a rota de editar etapa
Então deve retornar erro

### Deletar Etapa

#### CT - Deve deletar etapa com sucesso

Dados que estou autenticado como gestor
E tenho um id de etapa válido
Quando envio uma requisição para a rota de deletar etapa
Então deve retornar sucesso

#### CT - Deve retornar erro ao ao deletar etapa inexistente

Dados que estou autenticado como gestor
E tenho um id de etapa inválido
Quando envio uma requisição para a rota de deletar etapa
Então deve retornar erro

#### CT - Deve retornar erro ao ao deletar etapa sem Auth

Dados que não estou autenticado
E tenho um id de etapa válido
Quando envio uma requisição para a rota de deletar etapa
Então deve retornar erro

## Testes Processo

### Criar Processo

#### CT - Deve criar um novo processo com sucesso

Dados que estou autenticado como gestor
E tenho um id de etapa válido
E tenho um json com os dados do processo válidos
Quando envio uma requisição para a rota de criar processo
Então deve retornar sucesso

#### CT - Deve retornar erro ao ao tentar criar um processo com idEtapa inexistente

Dados que estou autenticado como gestor
E tenho um id de etapa inválido
E tenho um json com os dados do processo válidos
Quando envio uma requisição para a rota de criar processo
Então deve retornar erro

#### CT - Deve retornar erro ao tentar criar um novo processo sem nome

Dados que estou autenticado como gestor
E tenho um id de etapa válido
E tenho um json com os dados do processo sem nome
Quando envio uma requisição para a rota de criar processo
Então deve retornar erro

#### CT - Deve retornar erro ao criar um novo processo sem dias uteis

Dados que estou autenticado como gestor
E tenho um json com os dados do processo sem diasUteis
E tenho um id de etapa válido
Quando envio uma requisição para a rota de criar processo
Então deve retornar erro

#### CT - Deve retornar erro ao criar um novo processo sem duracaoProcesso

Dados que estou autenticado como gestor
E tenho um id de etapa válido
E tenho um json com os dados do processo sem duracaoProcesso
Quando envio uma requisição para a rota de criar processo
Então deve retornar erro

#### CT - Deve retornar erro ao criar um novo processo sem auth

Dados que não estou autenticado
E tenho um id de etapa válido
E tenho um json com os dados do processo válidos
Quando envio uma requisição para a rota de criar processo
Então deve retornar erro

### Listar Processos

#### CT - Deve listar os processos de acordo com o schema

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar processos
Então deve retornar os processos de acordo com o schema

### Deletar Processo

#### CT - Deve deletar um processo com sucesso

Dados que estou autenticado como gestor
E tenho um id de processo válido
Quando envio uma requisição para a rota de deletar processo
Então deve retornar sucesso

#### CT - Deve retornar erro ao ao deletar um processo sem auth

Dados que não estou autenticado
E tenho um id de processo válido
Quando envio uma requisição para a rota de deletar processo
Então deve retornar erro

## Testes Dia Não Útil

### Criar Dia Não Útil

#### CT - Deve criar um dia não útil com sucesso

Dados que estou autenticado como gestor
E tenho um json com os dados do dia não útil válido
Quando envio uma requisição para a rota de criar dia não útil
Então deve retornar sucesso

#### CT - Deve criar um dia não útil com data inicial igual a data final com sucesso

Dados que estou autenticado como gestor
E tenho um json com os dados do dia não útil contendo dataFinal igual a dataInicial
Quando envio uma requisição para a rota de criar dia não útil
Então deve retornar sucesso

#### CT - Deve retornar erro ao criar um dia não útil sem data inicial

Dados que estou autenticado como gestor
E tenho um json com os dados do dia não útil sem dataInicial
Quando envio uma requisição para a rota de criar dia não útil
Então deve retornar erro

#### CT - Deve retornar erro ao criar um dia não útil sem descrição

Dados que estou autenticado como gestor
E tenho um json com os dados do dia não útil sem descricao
Quando envio uma requisição para a rota de criar dia não útil
Então deve retornar erro

### Listar Dias Não Úteis

#### CT - Deve listar todos os dias não úteis com sucesso

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar dias não úteis
Então deve retornar sucesso

#### CT - Deve listar os dias não úteis de acordo com o schema

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar dias não úteis
Então deve retornar os dias não úteis de acordo com o schema

#### CT - Deve retornar erro ao listar todos os dias não úteis sem auth

Dados que não estou autenticado
Quando envio uma requisição para a rota de listar dias não úteis
Então deve retornar erro

### Editar Dia Não Útil

#### CT - Deve editar um dia não útil com sucesso

Dados que estou autenticado como gestor
E tenho um id de dia não útil válido
E tenho um json com os dados do dia não útil válido
Quando envio uma requisição para a rota de editar dia não útil
Então deve retornar sucesso

#### CT - Deve editar um dia não útil com data inicial igual a data final com sucesso

Dados que estou autenticado como gestor
E tenho um id de dia não útil válido
E tenho um json com os dados do dia não útil contendo dataFinal igual a dataInicial
Quando envio uma requisição para a rota de editar dia não útil
Então deve retornar sucesso

#### CT - Deve retornar erro ao tentar editar um dia não útil com id inválido

Dados que estou autenticado como gestor
E tenho um id de dia não útil inválido
E tenho um json com os dados do dia não útil válido
Quando envio uma requisição para a rota de editar dia não útil
Então deve retornar erro

#### CT - Deve retornar erro ao tentar editar um dia não útil com sem descrição

Dados que estou autenticado como gestor
E tenho um id de dia não útil válido
E tenho um json com os dados do dia não útil sem descricao
Quando envio uma requisição para a rota de editar dia não útil
Então deve retornar erro

#### CT - Deve retornar erro ao tentar editar um dia não útil sem data inicial

Dados que estou autenticado como gestor
E tenho um id de dia não útil válido
E tenho um json com os dados do dia não útil sem dataInicial
Quando envio uma requisição para a rota de editar dia não útil
Então deve retornar erro

### Deletar Dia Não Útil

#### CT - Deve deletar um dia não útil com sucesso

Dados que estou autenticado como gestor
E tenho um id de dia não útil válido
Quando envio uma requisição para a rota de deletar dia não útil
Então deve retornar sucesso

#### CT - Deve retornar erro ao tentar deletar um dia não útil com id inválido

Dados que estou autenticado como gestor
E tenho um id de dia não útil inválido
Quando envio uma requisição para a rota de deletar dia não útil
Então deve retornar erro

#### CT - Deve retornar erro ao tentar deletar um dia não útil sem auth

Dados que não estou autenticado
E tenho um id de dia não útil válido
Quando envio uma requisição para a rota de deletar dia não útil
Então deve retornar erro

## Testes Responsável

### Criar Responsável

#### CT - Deve criar um responsável com sucesso

Dados que estou autenticado como gestor
E tenho um json com os dados do responsável válido
Quando envio uma requisição para a rota de criar responsável
Então deve retornar sucesso

#### CT - Deve retornar um erro criar um responsável sem nome

Dados que estou autenticado como gestor
E tenho um json com os dados do responsável sem nome
Quando envio uma requisição para a rota de criar responsável
Então deve retornar erro

#### CT - Deve retornar erro ao criar um responsável sem Auth

Dados que não estou autenticado
E tenho um json com os dados do responsável válido
Quando envio uma requisição para a rota de criar responsável
Então deve retornar erro

### Listar Responsáveis

#### CT - Deve listar todos os responsáveis com sucesso

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar responsáveis
Então deve retornar sucesso

#### CT - Deve listar os responsáveis de acordo com o schema

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar responsáveis
Então deve retornar os responsáveis de acordo com o schema

#### CT - Deve falhar listar todos os responsáveis sem Auth

Dados que não estou autenticado
Quando envio uma requisição para a rota de listar responsáveis
Então deve retornar erro

### Deletar Responsável

#### CT - Deve deletar um responsável com sucesso

Dados que estou autenticado como gestor
E tenho um id de responsável válido
Quando envio uma requisição para a rota de deletar responsável
Então deve retornar sucesso

#### CT - Deve falhar deletar um responsável com id inválido

Dados que estou autenticado como gestor
E tenho um id de responsável inválido
Quando envio uma requisição para a rota de deletar responsável
Então deve retornar erro

#### CT - Deve falhar deletar um responsável sem Auth

Dados que não estou autenticado
E tenho um id de responsável válido
Quando envio uma requisição para a rota de deletar responsável
Então deve retornar erro

## Testes Área Envolvida

### Criar Área Envolvida

#### CT - Deve criar uma área envolvida com sucesso

Dados que estou autenticado como gestor
E tenho um json com os dados da área envolvida válida
Quando envio uma requisição para a rota de criar área envolvida
Então deve retornar sucesso

#### CT - Deve retornar erro ao criar uma área envolvida sem nome

Dados que estou autenticado como gestor
E tenho um json com os dados da área envolvida sem nome
Quando envio uma requisição para a rota de criar área envolvida
Então deve retornar erro

#### CT - Deve retornar erro ao criar uma área envolvida sem auth

Dados que não estou autenticado
E tenho um json com os dados da área envolvida válida
Quando envio uma requisição para a rota de criar área envolvida
Então deve retornar erro

### Listar Áreas Envolvidas

#### CT - Deve listar todas as áreas envolvidas com sucesso

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar áreas envolvidas
Então deve retornar sucesso

#### CT - Deve listar as áreas envolvidas de acordo com o schema

Dados que estou autenticado como gestor
Quando envio uma requisição para a rota de listar áreas envolvidas
Então deve retornar as áreas envolvidas de acordo com o schema

#### CT - Deve retornar erro ao listar todas as áreas envolvidas sem auth

Dados que não estou autenticado
Quando envio uma requisição para a rota de listar áreas envolvidas
Então deve retornar erro

### Deletar Área Envolvida

#### CT - Deve deletar uma área envolvida com sucesso

Dados que estou autenticado como gestor
E tenho um id de área envolvida válido
Quando envio uma requisição para a rota de deletar área envolvida
Então deve retornar sucesso

#### CT - Deve retornar erro ao deletar uma área envolvida com id inválido

Dados que estou autenticado como gestor
E tenho um id de área envolvida inválido
Quando envio uma requisição para a rota de deletar área envolvida
Então deve retornar erro

#### CT - Deve retornar erro ao deletar uma área envolvida sem auth

Dados que não estou autenticado
E tenho um id de área envolvida válido
Quando envio uma requisição para a rota de deletar área envolvida
Então deve retornar erro
