package workspace;

/**
 * Representa uma tabela Hash com endereçamento Fechado.
 */
public class HashFechada {
    private final ListaDinamica[] $table;

    /**
     * Cria uma tabela Hash de tamanho definido.
     * @param $size (Integer) - Tamanho da tabela Hash / Quantidade de chaves a serem armazenadas.
     */
    HashFechada(int $size) {
        $table = new ListaDinamica[$size];

        for (int i = 0; i < $size; i++) {
            $table[i] = new ListaDinamica();
        }
    }

    /**
     * Retorna o endereço (não ocupado) do elemento na tabela Hash.
     * @param $value (Integer) - Elemento a ser pesquisado.
     * @return (Integer) - O Endereço onde o elemento vai ser armazenado.
     */
    int hashing(int $value) {
        return $value % $table.length;
    }

    /**
     * Adiciona um elemento à tabela Hash.
     * @param $value (Integer) - Elemento a ser adiciona à tabela Hash.
     */
    void add(int $value) {
        $table[hashing($value)].push(0, $value);
    }

    /**
     * Mostra os elementos da tabela Hash.
     */
    void show() {
        for (ListaDinamica listaDinamica : $table) {
            if (listaDinamica.size() == 0) {
                System.out.println("null");
            } else {
                listaDinamica.show();
            }
        }
    }

    /**
     * Verifica se o elemento existe na tabela Hash.
     * @param $value (Integer) - Elemento a ser pesquisado na tabela Hash.
     * @return (Integer) - Retorna a posição do elemento na tabela, -1 caso não encontrado.
     */
    int search(int $value) {
        int $index = hashing($value);
        return $table[$index].find($value);
    }

    /**
     * Remove um elemento da tabela Hash, não altera a posição dos elementos.
     * @param $value (Integer) - Elemento a ser removido.
     */
    void remove(int $value) {
        int $index = hashing($value);
        $table[$index] = new ListaDinamica();
    }
}
