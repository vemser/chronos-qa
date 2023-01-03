#language:pt
@Test
Funcionalidade: Etapa
  Contexto: É posssível ver, cadastrar, editar e excluir etapas no sistema
    @whip
    Cenario: Deve criar uma etapa com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E preencha o nome da etapa com um nome valido
      E preencha a ordem da etapa com uma ordem valida
      Quando clico em enviar etapa
      Entao devo ver um toast de sucesso de criar etapa
    @whip
    Cenario: Deve retornar erro ao tentar criar uma etapa sem nome
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E preencha a ordem da etapa com uma ordem valida
      Quando clico em enviar etapa
      Entao devo ver uma mensagem de erro no nome da etapa
    @whip
    Cenario: Deve retornar erro ao tentar criar uma etapa sem ordem
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E preencha o nome da etapa com um nome valido
      Quando clico em enviar etapa
      Entao devo ver uma mensagem de erro na ordem da etapa
    @whip
    Cenario: Deve editar uma etapa com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em editar etapa
      E preencha o nome da etapa com um nome valido
      E preencha a ordem da etapa com uma ordem valida
      Quando clico em enviar etapa
      Entao devo ver um toast de sucesso de editar etapa
    @whip
    Cenario: Deve retornar erro ao tentar editar uma etapa sem nome
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em editar etapa
      E limpe o nome da etapa
      Quando clico em enviar etapa
      Entao devo ver uma mensagem de erro no nome da etapa
    @whip
    Cenario: Deve retornar erro ao tentar editar uma etapa sem ordem
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique no botao de detalhes da edicao
      E clique no botao de adicionar etapa
      E crie uma etapa valida
      E clique em editar etapa
      E limpe a ordem da etapa
      Quando clico em enviar etapa
      Entao devo ver uma mensagem de erro na ordem da etapa
