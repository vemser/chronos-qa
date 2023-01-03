#language:pt
@Test
Funcionalidade: Edicão
  Contexto: É posssível ver, cadastrar, editar e excluir edições no sistema
    @whip
    Cenario: Deve criar uma edição com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E preencho o nome da edicao com um nome valido
      E preencho a data inicial da edicao com uma data valida
      Quando clico em enviar edicao
      Entao devo ver um toast de sucesso de criacao de edicao
    @whip
    Cenario: Deve retornar erro ao tentar criar uma edição sem data inicial
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E preencho o nome da edicao com um nome valido
      Quando clico em enviar edicao
      Entao devo ver uma mensagem de erro na data inicial da edicao
    @whip
    Cenario: Deve retornar erro ao tentar criar uma edição sem nome
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E preencho a data inicial da edicao com uma data valida
      Quando clico em enviar edicao
      Entao devo ver uma mensagem de erro no nome da edicao
    @whip
    Cenario: Deve clonar uma edição com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      Quando clico em clonar edicao
      Entao devo ver um toast de sucesso de clonar edicao
    @whip
    Cenario: Deve editar o status de uma edição com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      Quando clico em alterar status da edicao
      Entao devo ver um toast de sucesso de alterar status da edicao
    @whip
    Cenario: Deve editar uma edição com sucesso
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique em editar edicao
      E preencho o nome da edicao com um nome valido
      E preencho a data inicial da edicao com uma data valida
      Quando clico em enviar edicao
      Entao devo ver um toast de sucesso de edicao de edicao
    @whip
    Cenario: Deve retornar erro ao tentar editar uma edição sem nome
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique em editar edicao
      E limpe o campo de nome da edicao
      Quando clico em enviar edicao
      Entao devo ver uma mensagem de erro no nome da edicao
    @whip
    Cenario: Deve retornar erro ao tentar editar uma edição sem data inicial
      Dado que esteja logado
      E entre na pagina de edicoes
      E clique no botao de criar edicao
      E crie uma edicao valida
      E clique em editar edicao
      E limpe o campo de data inicial da edicao
      Quando clico em enviar edicao
      Entao devo ver uma mensagem de erro na data inicial da edicao