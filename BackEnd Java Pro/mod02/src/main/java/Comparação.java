/*
Comparação:
Solução Recursiva Simples: A recursão recalcula os mesmos valores várias vezes, levando a uma explosão exponencial no número de chamadas. Isso faz com que o tempo de execução cresça exponencialmente conforme o valor de n aumenta.

Solução com Programação Dinâmica: Ao armazenar os resultados intermediários, evitamos recomputações desnecessárias. A complexidade de tempo é O(n), o que é significativamente mais eficiente. Em grandes valores de n, a diferença de desempenho entre essas duas abordagens é enorme.

Por que a Programação Dinâmica é Melhor?
A programação dinâmica é melhor porque elimina a redundância nas chamadas recursivas, evitando cálculos repetidos. Ao calcular cada valor da série de Fibonacci apenas uma vez e armazená-lo para reutilização futura, conseguimos melhorar drasticamente a eficiência da solução.

Menor número de chamadas: A solução recursiva faz o mesmo cálculo várias vezes, enquanto a programação dinâmica calcula cada valor uma única vez.
Complexidade linear: Ao transformar o problema de exponencial (O(2^n)) para linear (O(n)), a programação dinâmica permite que valores muito maiores de n sejam calculados de forma prática.