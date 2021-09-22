# Lista de Exercicios Semana 05 - Banco Digital

### Diferenças entre var, let e const:

- Declarações **var** têm escopo global ou função, enquanto **let** e **const** têm escopo de bloco (tudo entre chaves **{}** é um bloco). Os três são içados até o topo de seu escopo. Mas enquanto as variáveis **​​var** são inicializadas com undefined, as variáveis **​​let** e **const** não são inicializadas, portanto, se você tentar usar uma variável let antes da declaração, obterá um Erro de Referência.

- Variáveis ​​**var** podem ser atualizadas e declaradas novamente dentro de seu escopo. As variáveis ​​**let** podem ser atualizadas, mas não declaradas novamente no mesmo escopo, entretanto podem ser declaradas em escopos diferentes com o mesmo nome. Variáveis **​​const** não podem ser atualizadas nem declaradas novamente.

- Enquanto **var** e **let** podem ser declarados sem serem inicializados, **const** deve ser inicializado durante a declaração.

### Classes, atributos e métodos

Na programação orientada a objetos, uma **classe** é um projeto (blueprint) para a criação de **objetos** (uma estrutura de dados específica), fornecendo valores iniciais para o **estado** (variáveis ​​ou atributos de membro) e implementações de **comportamento** (funções ou métodos de membro).

Os **atributos** de membro da classe são os dados armazenados dentro dos campos do objeto, enquanto os **métodos** de membro da classe são as funções que denotam o comportamento dos objetos.
