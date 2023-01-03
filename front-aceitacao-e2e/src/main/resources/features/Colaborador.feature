#language:pt
  //@Test
  Funcionalidade: Colaboradores
    Contexto: É posssível ver, cadastrar, editar e excluir colaboradores do sistema
      @whip
      Cenario: Deve cadastrar um colaborador com sucesso
        Dado que esteja logado
        E entre na pagina de colaboradores
        E clique no botao de criar colaborador
        E preencho o campo login do colaborador com um login valido
        E seleciono um cargo do colaborador
        Quando clico no botao de enviar colaborador
        Entao devo ver um toast de sucesso de criacao de colaborador
      @whip
      Cenario: Deve cadastrar um colaborador com mais de um cargo
        Dado que esteja logado
        E entre na pagina de colaboradores
        E clique no botao de criar colaborador
        E preencho o campo login do colaborador com um login valido
        E seleciono mais de um cargo do colaborador
        Quando clico no botao de enviar colaborador
        Entao devo ver um toast de sucesso de criacao de colaborador
      @whip
      Cenario: Deve retornar erro ao tentar criar um colaborador sem login
        Dado que esteja logado
        E entre na pagina de colaboradores
        E clique no botao de criar colaborador
        E seleciono um cargo do colaborador
        Quando clico no botão de enviar colaborador
        Entao devo ver uma mensagem de erro no login do colaborador
      @whip
      Cenario: Deve retornar erro ao tentar criar um colaborador sem cargo
        Dado que esteja logado
        E entre na pagina de colaboradores
        E clique no botao de criar colaborador
        E preencho o campo login do colaborador com um login valido
        Quando clico no botão de enviar colaborador
        Entao devo ver um toast de erro no cargo do colaborador
      @whip
      Cenario: Deve editar cargos do colaborador com sucesso
        Dado que esteja logado
        E entre na pagina de colaboradores
        E clique no botao de criar colaborador
        E crie um colaborador valido
        E clique no botao de editar colaborador
        E altere seu cargo
        Quando clico no botao de enviar colaborador
        Entao devo ver um toast de sucesso de edicao de colaborador
      @whip
      Cenario: Deve retornar erro ao tentar editar cargo com cargos limpos
        Dado que esteja logado
        E entre na pagina de colaboradores
        E clique no botao de criar colaborador
        E crie um colaborador valido
        E clique no botao de editar colaborador
        E limpe os cargos
        Quando clico no botao de enviar colaborador
        Entao devo ver um toast de erro de edicao de colaborador
      @whip
      Cenario: Deve excluir um colaborador com sucesso
        Dado que esteja logado
        E entre na pagina de colaboradores
        E clique no botao de criar colaborador
        E crie um colaborador valido
        Quando clico no botao de excluir colaborador
        Entao devo ver um toast de sucesso de excluir colaborador