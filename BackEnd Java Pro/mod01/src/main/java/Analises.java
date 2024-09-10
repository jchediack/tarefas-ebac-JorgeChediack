/*
Aqui estão as análises de complexidade assintótica de tempo e espaço para as estruturas de dados de **Pilha**, **Fila** e **Lista Encadeada** com base nas implementações fornecidas.

### 1. **Pilha**

A pilha foi implementada utilizando uma lista encadeada, portanto as operações seguem essa estrutura.

#### Complexidade de Tempo:

        - **push()**:

        - O elemento é adicionado ao topo da pilha. Em uma lista encadeada, isso ocorre de forma direta, sem necessidade de percorrer os elementos.

 - **Tempo**: O(1) (constante).



        - **pop()**:

        - O elemento do topo da pilha é removido e retornado. Novamente, essa operação é direta.

        - **Tempo**: O(1) (constante).

        #### Complexidade de Espaço:

        - **push()**:

        - Cada chamada de `push()` adiciona um novo nó à pilha, então o espaço utilizado cresce linearmente com o número de elementos.

        - **Espaço**: O(n), onde n é o número de elementos armazenados.

        - **pop()**:

        - A remoção de elementos não afeta a complexidade espacial, pois estamos apenas desalocando a memória.

        - **Espaço**: O(n), onde n é o número de elementos armazenados.

        ### 2. **Fila**

A fila foi implementada utilizando uma lista encadeada ou um objeto `LinkedList` nativo.

#### Complexidade de Tempo:

        - **enqueue()**:

        - O elemento é adicionado ao fim da fila. Em uma lista encadeada, isso requer percorrer os elementos até encontrar o último.

        - **Tempo**: O(1), uma vez que usamos o método `add()` da `LinkedList`, que é otimizado.

- **dequeue()**:

        - O primeiro elemento da fila é removido. Como o `LinkedList` mantém uma referência ao primeiro elemento, a operação de remoção é constante.

 - **Tempo**: O(1).

        - **rear()**:

        - O método retorna o último elemento da fila. O `LinkedList` nativamente mantém uma referência ao final, então essa operação é direta.

 - **Tempo**: O(1).

        - **front()**:

        - O método retorna o primeiro elemento da fila. Como a `LinkedList` armazena uma referência ao primeiro elemento, isso é feito em tempo constante.

 - **Tempo**: O(1).

        #### Complexidade de Espaço:

        - **enqueue()**:

        - Cada chamada de `enqueue()` adiciona um novo nó à fila, então o espaço utilizado cresce linearmente com o número de elementos.

        - **Espaço**: O(n), onde n é o número de elementos armazenados.

        - **dequeue()**, **rear()**, **front()**:

        - Nenhuma dessas operações altera a quantidade de memória utilizada, apenas acessam ou removem elementos.

 - **Espaço**: O(n), onde n é o número de elementos armazenados.

        ### 3. **Lista Encadeada**

        #### Complexidade de Tempo:

        - **push()**:

        - O método adiciona um nó ao final da lista, o que requer percorrer todos os elementos até o fim.

 - **Tempo**: O(n), onde n é o número de elementos na lista.

        - **pop()**:

        - O método remove o nó do final da lista, exigindo percorrer todos os elementos até o penúltimo.

 - **Tempo**: O(n).

        - **insert(int index, Node node)**:

        - O método insere um nó na posição indicada, o que requer percorrer a lista até o índice dado.

 - **Tempo**: O(n), onde n é o número de elementos até o índice.

        - **remove(int index)**:

        - O método remove o nó na posição indicada, o que também requer percorrer a lista até o índice.

 - **Tempo**: O(n), onde n é o número de elementos até o índice.

        - **elementAt(int index)**:

        - O método retorna o elemento no índice especificado, o que exige percorrer a lista até esse índice.

        - **Tempo**: O(n), onde n é o índice.

        #### Complexidade de Espaço:

        - **push()**, **pop()**, **insert()**, **remove()**, **elementAt()**:

        - A complexidade de espaço é O(n), onde n é o número total de nós na lista, pois cada operação apenas manipula os nós já alocados ou desalocados.

        - **Espaço**: O(n).