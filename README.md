# Desafio Sicredi

## Como executar o aplicativo?

Para executar o aplicativo, baixe o arquivo apk no link
[clique aqui para baixar o aplicativo ](https://github.com/patriciojdutra/DesafioSicredi/blob/master/app-desafio-sicredi.apk?raw=true)
 e instale em seu smartphone.

## Objetivo

* Criar uma aplicativo que consuma uma REST API e exiba uma listagem de eventos;
* Cada item da lista deve permitir acesso à detalhes do evento;
* No detalhe do evento é importante exibir suas informações e opções de check-in e compartilhamento.

## Requisitos mínimos

* App deve compilar sem a necessidade de nenhum ajuste após ser clonado
* Suporte à API 19 e funcionar com a API 29
* Código deve ser escrito em Kotlin
      
[Clique aqui para saber mais sobre o desafio.](https://github.com/WoopSicredi/jobs/issues/1)
      
      
## Resultado das telas

#### Carregando os dados iniciais.
![jpg](https://github.com/patriciojdutra/DesafioSicredi/blob/master/Screenshot_20210125-164349_Desafio%20Sicredi.jpg)

#### Detalhe do evento.
![jpg](https://github.com/patriciojdutra/DesafioSicredi/blob/master/Screenshot_20210125-164308_Desafio%20Sicredi.jpg)

#### Fazendo check-in.
![jpg](https://github.com/patriciojdutra/DesafioSicredi/blob/master/Screenshot_20210125-164323_Desafio%20Sicredi.jpg)

## Tecnologias e Frameworks

* Kotlin
* Arquitetura MVVM
  * ViewModel
  * LiveData
* Retrofit
* RecyclerView
* Picasso
* Json
* Animação

# Perguntas que devem ser respondidas

**Explicação breve do porquê das escolhas de frameworks e arquitetura?**
Por ser um projeto pequeno, a arquitetura não é algo que teria um impacto significativo no projeto, achei interessante implementar a arquitetura MVVM pois é uma arquitetura que tras diversas vantagens para o desenvolvimento android.
Para consumir os dados da api, optei por usar retrofit, pois é uma das mais poderosas e populares bibliotecas de HTTP Client para Android.


