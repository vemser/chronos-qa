#language:pt
@Test
Funcionalidade: Processo
  Contexto: É posssível ver, cadastrar, editar e excluir processos no sistema
    @whip
    Cenario: Deve criar um processo com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E preencha um nome de processo valido
      E preencha uma area envovlvida
      E preencha um responsavel
      E preencha uma duracao de processo
      E preencha dias uteis de processo
      E preencha ordem de processo
      Quando clico em enviar processo
      Entao devo ver um toast de sucesso de criacao de processo
    @whip
    Cenario: Deve criar um processo critico com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E preencha um nome de processo valido
      E preencha uma area envovlvida
      E preencha um responsavel
      E preencha uma duracao de processo
      E preencha dias uteis de processo
      E preencha ordem de processo
      E marque a opcao de processo critico
      Quando clico em enviar processo
      Entao devo ver um toast de sucesso de criacao de processo
    #@whip
    Cenario: Deve retornar erro ao criar um processo sem area envolvida
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E preencha um nome valido
      E preencha um responsavel
      E preencha uma duracao de processo
      E preencha dias uteis valido
      E preencha ordem valida
      Quando clico em enviar processo
      Entao devo ver um toast de erro sobre a area envolvida
    # @whip
    Cenario: Deve retornar erro ao criar um processo sem responsável
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E preencha um nome valido
      E preencha uma area envovlvida
      E preencha uma duracao de processo
      E preencha dias uteis valido
      E preencha ordem valida
      Quando clico em enviar processo
      Entao devo ver um toast de erro sobre o responsável
    #@whip
    Cenario: Deve retornar erro ao criar um processo sem nome
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E preencha uma area envovlvida
      E preencha um responsavel
      E preencha uma duracao de processo
      E preencha dias uteis valido
      E preencha ordem valida
      Quando clico em enviar processo
      Entao devo ver uma mensagem de erro no nome do processo
    #@whip
    Cenario: Deve retornar erro ao criar um processo sem duracao
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E preencha um nome valido
      E preencha uma area envovlvida
      E preencha um responsavel
      E preencha dias uteis valido
      E preencha ordem valida
      Quando clico em enviar processo
      Entao devo ver uma mensagem de erro na duracao do processo
    #@whip
    Cenario: Deve retornar erro ao criar um processo sem dias uteis
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E preencha um nome valido
      E preencha uma area envovlvida
      E preencha um responsavel
      E preencha uma duracao de processo
      E preencha ordem valida
      Quando clico em enviar processo
      Entao devo ver uma mensagem de erro nos dias uteis do processo
    #@whip
    Cenario: Deve retornar erro ao criar um processo sem ordem
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E preencha um nome valido
      E preencha uma area envovlvida
      E preencha um responsavel
      E preencha uma duracao de processo
      E preencha dias uteis valido
      Quando clico em enviar processo
      Entao devo ver uma mensagem de erro nos dias uteis do processo
    @whip
    Cenario: Deve editar um processo com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em criar processo
      E crie um processo valido
      E clique no botao de editar processo
      E preencha um nome de processo valido
      E preencha uma duracao de processo
      E preencha dias uteis de processo
      E preencha ordem de processo
      Quando clico em enviar processo
      Entao devo ver uma mensagem de sucesso de edicao de processo0