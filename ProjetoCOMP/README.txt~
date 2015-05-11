**TÍTULO DO PROJECTO: D3FDG2DOT

**GRUPO: TURMA 1 - GRUPO 14



NOME1: Catarina Cerqueira Terra, NR1: 200908703)

NOME2: João Miguel da Rocha Ribeiro, NR2: 201100772)

NOME3: José Salgado Magalhães Taveira Gomes, NR3: 201005306)

NOME4: Marco António Lopes Pinto, NR4: 201100706)



** SUMÁRIO:

O nosso projecto consiste numa ferramenta que lê código no formato JSON que representa um grafo 
de forças a ser usado em D3 e com output no formato DOT

Para ser executado basta apenas correr os seguintes comandos

Podemos correr o programa de duas maneiras diferentes:

- A primeira é onde o utilizador insere ele próprio o código através da linha de comandos.
- A segunda é onde o utilizador escolhe um ficheiro para carregar o código.



**ANÁLISE SINTÁTICA:

O código inserido no nosso programa tem que ter necessariamente uma estrutura semelhante à
estrutura do exemplo que se encontra em baixo. É necessário:

- (done)Abrir chavetas ({) no início do código bem como fechar no fim do memso (}).
- (done)Cada elemento segue a estrutura: "nomeElemento":[{elemento1},{elemento1},...,{elementoFinal}] 
, sendo que os elementos nodes e links estão separados por vírgulas.
- (done)O primeiro elemento deve ter como nome "nodes" e o segundo ""links"
- (done)Cada elemento do "nodes" deve seguir a seguinte estrutura:  {"name":"nomeDoElemento","group":idOfGroup}
- (done)Cada elemento do "links" deve seguir a seguinte estrutura:  {"source":idOfSourceNode,"target":idOfTargetNode,"value":valueOfTheLink}


Exemplo:
{
  "nodes":[
    {"name":"Myriel","group":1},
    {"name":"Napoleon","group":1},
    {"name":"Mlle.Baptistine","group":1},
    {"name":"Mme.Magloire","group":2}
  ],
  "links":[
    {"source":0,"target":1,"value":1},
    {"source":1,"target":2,"value":1},
    {"source":2,"target":0,"value":1},
    {"source":1,"target":3,"value":1}
  ] 
}



**ANÁLISE SEMÂNTICA:

O nosso programa está limitado pelas seguintes restrições semânticas:

Nodes:
    (done) Um nome só pode estar associado a um nó.

Links:
    (done) Não podem existir ligações do nó X para o nó X.
    (done) Ids de source e target têm que existir
    (done) Não podem existir ligações repetidas
    (done) Não podem existir ligações invertidas

Grafo:
    (done) Todos os nós têm de estar na mesma rede, ou seja de qualquer 
           nó, posso ir para qualquer nó.
				
				
				
				
**REPRESENTAÇÃO INTERMÉDIA :

TODO



**TESTES: 

Temos 8 TXT'S de Teste divididos em TXT'S que vão passar nos testes (certo.txt e certoGrande.txt), 
TXT's com erros sintáticos (sintaticoX.txt) e TXT's com erros semánticos (semanticoX.txt)