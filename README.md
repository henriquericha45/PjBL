# PjBL

## Exercício Paralelismo Distribuído: Multiplicador Paralelo de Matrizes

Construa uma aplicação distribuída que multiplique duas matrizes Am,k e Bk,n e
produza uma matriz Cm,n como resultado. Os valores dos elementos das matrizes
A e B devem ser números reais (double) lidos de dois arquivos, um para cada
matriz. Depois do processamento que calcula os elementos da matriz C, esses
devem ser armazenados em um novo arquivo. (Os arquivos podem ser do tipo
txt ou do tipo csv.)

A aplicação deve explorar o potencial de paralelismo da plataforma distribuída a
fim de gerar os resultados em menor tempo. Para fins deste exercício, deve-se
assumir que a plataforma é uma rede composta por 5 computadores, sendo um
responsável por coordenar o processamento e os demais responsáveis por
realizar os cálculos. Na aplicação, há dois tipos de processos, a saber:

  • **Coordenador**: responsável por orquestrar todo o trabalho da aplicação
  
  • **Calculador**: responsável por calcular parte da matriz C
  
Em cada computador, há somente um processo da aplicação em execução.
Assim, um computador executa o Coordenador, enquanto os demais executam
o Calculador (4 instâncias).

O Coordenador realiza os seguintes passos:

1. carrega as matrizes A e B (a partir dos dados dos arquivos
previamente gerados)
2. aloca espaço em memória para armazenar a matriz C
3. faz a divisão do trabalho de cálculo da matriz C, determinando os
intervalos da matriz C que cada Calculador deverá resolver, de
forma que cada Calculador calcule aproximadamente a mesma
quantidade de elementos da matriz C
4. envia mensagem para cada Calculador contendo a matriz A, a matriz
B e os índices que determinam o intervalo a ser calculado (linha
inicial, linha final, coluna inicial e coluna final)
5. aguarda as mensagens com a resposta (parte calculada da matriz C)
de cada Calculador, fazendo o preenchimento da matriz C
6. gera o arquivo correspondente à matriz C

A aplicação deve ser executada para matrizes A e B que possuam, no mínimo,
400 linhas e 400 colunas. Deve-se notar que essas matrizes não precisam ser
quadradas.
A comunicação entre Coordenador e Calculador deve ser implementada por
meio do protocolo TCP ou do protocolo UDP.
A aplicação deve ser implementada, se possível, em uma plataforma, de fato,
distribuída. Mas, também pode ser implementada num único computador, desde
que haja 5 processos em execução: uma instância de Coordenador e quatro
instâncias de Calculador.
