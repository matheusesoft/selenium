#language:pt
@Reserva
Funcionalidade: Cenário 1 - Reservar 1 ticket

  @CT01
  Esquema do Cenário: Reservar ticket
    Dado que o "<site>" esta aberto
    Quando informar o usuario "<userName>"
    E informar a senha "<password>"
    E clicar no botao entrar
    Entao a tela Flight Finder e exibida
    Quando selecionar a cidade de origem "<cidadeOrigem>"
    E selecionar a cidade de destino "<cidadeDestino>"
    E selecionar data maior que data corrente
    E selecionar a Class
    E selecionar Passengers "<passageiro>"
    E clicar no botao continue finder
    Entao a tela com opcao de voo e exibida
    Quando selecionar o voo ida "<vooOut>" e voo volta "<vooIn>" 
    E clicar no botao continue reserve
    Entao a tela Book a Flight e exibida
    E as opcoes selecionadas anteriormente sao exibidas corretamente
    Quando informar first name "<firstName>"
    E informar last name "<lastName>"
    E preencher numero do cartao "<nroCartao>"
    E preencher o nome do passageiro "<passageiroNome>"
    E clicar em secure purchase
    Entao a ordem e gerada

    Exemplos: 
      | site                            | userName | password | cidadeOrigem | cidadeDestino | passageiro	| vooOut 									| vooIn 									| firstName | lastName  | nroCartao | passageiroNome |
      | http://www.newtours.demoaut.com | mercury  | mercury  | Paris        | London        | 1					| Pangea Airlines 362	| Blue Skies Airlines 631 | TesteNome | sobreNome |     99999 | TesteNome      |
      
      
