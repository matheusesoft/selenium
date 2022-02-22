#language:pt
@LER_JSON
Funcionalidade: Ler JSON Albuns

  @CT01
  Cenario: Ler JSON Albuns
    Dado que o "https://jsonplaceholder.typicode.com/" esta aberto
    Quando abrir menu Guide
    Quando abrir link Albums Photos
    Entao validar retorno do item de id 6
     #| title                                   | url                                    | thumbnailUrl                           |
      | accusamus ea aliquid et amet sequi nemo | https://via.placeholder.com/600/56a8c2 | https://via.placeholder.com/150/56a8c2 |
