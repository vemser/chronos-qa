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