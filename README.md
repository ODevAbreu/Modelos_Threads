Para entender como cada modelo de threads se comporta, comparamos o 1:1 e o N:M aumentando gradualmente o número de threads lógicas. No N:M, usamos um pool fixo de 10 threads reais, que executam todas as threads lógicas, mesmo quando chegamos a 1000. No 1:1, cada thread lógica vira uma thread real, aumentando o custo de gerenciamento conforme a quantidade cresce.
A tabela e o gráfico mostram como cada modelo reage à carga, evidenciando diferenças de desempenho e escalabilidade.
<img width="1580" height="979" alt="dados" src="https://github.com/user-attachments/assets/70af4de0-0a33-4471-9130-99b84757a52e" />
<img width="260" height="161" alt="tabela" src="https://github.com/user-attachments/assets/f5bdd440-67fa-49aa-9342-75528353d4db" />
O que descobrimos:
Nos testes, usamos um pool fixo de 10 threads no modelo N:M. Mesmo aumentando as threads lógicas (10, 100, 500 e 1000), o sistema continuou executando tudo nessas mesmas 10 threads reais.
Os resultados mostram que o N:M se mantém mais eficiente praticamente o tempo todo. Com 10 threads ele já apresenta melhor desempenho, e em 100 threads ocorre o único ponto de equilíbrio com o modelo 1:1. A partir daí, o 1:1 começa a sofrer com o custo de criar e gerenciar uma thread real para cada thread lógica, enquanto o N:M escala melhor reaproveitando o pool.
Em resumo: o modelo 1:1 não chega a ser mais vantajoso em nenhum momento nesses testes — apenas empata quando há cerca de 100 threads. Depois disso, o N:M se destaca por utilizar melhor os recursos do sistema.
