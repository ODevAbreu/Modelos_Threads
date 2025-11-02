Para entender como cada modelo de threads se comporta, comparamos o 1:1 e o N:M aumentando gradualmente o número de threads lógicas. No N:M, usamos um pool fixo de 10 threads reais, que executam todas as threads lógicas, mesmo quando chegamos a 1000. No 1:1, cada thread lógica vira uma thread real, aumentando o custo de gerenciamento conforme a quantidade cresce.
A tabela e o gráfico mostram como cada modelo reage à carga, evidenciando diferenças de desempenho e escalabilidade.
<img width="1580" height="979" alt="dados" src="https://github.com/user-attachments/assets/70af4de0-0a33-4471-9130-99b84757a52e" />
<img width="260" height="161" alt="tabela" src="https://github.com/user-attachments/assets/f5bdd440-67fa-49aa-9342-75528353d4db" />
O que descobrimos:
O modelo 1:1 não chega a ser mais vantajoso em nenhum momento nesses testes apenas empata quando há cerca de 100 threads. Depois disso, o N:M se destaca por utilizar melhor os recursos do sistema.
