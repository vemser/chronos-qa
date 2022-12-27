#language:pt
  @Test
  Funcionalidade: Login
    Contexto: O usuário deve fazer login após informar email ou username e senha válidos
      @whip
        Cenario: Login utilizando email com sucesso
          Dado que eu estou na página de login
          E preencho campo login na pagina de login com email dbc valido
          E preencho campo senha na pagina de login com senha valida
          Quando eu clico no botao de fazer login
          Entao deve redirecionar para aplicacao
      @whip
        Cenario: Login utilizando username com sucesso
          Dado que eu estou na página de login
          E preencho campo login na pagina de login com username valido
          E preencho campo senha na pagina de login com senha valida
          Quando eu clico no botao de fazer login
          Entao deve redirecionar para aplicacao
      @whip
        Cenario: Login com senha invalida
          Dado que eu estou na página de login
          E preencho campo login na pagina de login com email dbc valido
          E preencho campo senha na pagina de login com senha invalida
          Quando eu clico no botao de fazer login
          Entao deve exibir mensagem de erro de autorizacao
      @whip
        Cenario: Login com email e senha inexistentes
          Dado que eu estou na página de login
          E preencho campo login na pagina de login com email dbc invalido
          E preencho campo senha na pagina de login com senha invalida
          Quando eu clico no botao de fazer login
          Entao deve exibir mensagem de erro de autorizacao
      @whip
        Cenario: Login com email e senha em branco
          Dado que eu estou na página de login
          Quando eu clico no botao de fazer login
          Entao deve exibir mensagem de erro de login
          Entao deve exibir mensagem de erro de senha
      @whip
        Cenario: Login com email em branco
          Dado que eu estou na página de login
          E preencho campo senha na pagina de login com senha valida
          Quando eu clico no botao de fazer login
          Entao deve exibir mensagem de erro de login
      @whip

      Cenario: Login com email fora do padrao dbccompany
        Dado que eu estou na página de login
        E preencho campo login na pagina de login com email nao pertencente a dbc
        E preencho campo senha na pagina de login com senha invalida
        Quando eu clico no botao de fazer login
        Entao deve exibir mensagem de erro de login