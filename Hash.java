package workspace;

// TODO : Transformar o $table em Object[]

/**
 * Representa uma tabela Hash.
 */
public class Hash {
    private final Integer[] $table;

    /**
     * Cria uma tabela Hash de tamanho definido.
     * @param $size (Integer) - Tamanho da tabela Hash.
     */
    Hash(int $size) {
        $table = new Integer[$size];
    }

    /**
     * Retorna o endereço (não ocupado) do elemento na tabela Hash.
     * @param $value (Integer) - Elemento a ser pesquisado.
     * @return (Integer) - O Endereço onde o elemento vai ser armazenado.
     */
    int hashing(int $value) {
        int $hash = $value % $table.length;
        int $index = $hash;

        // Tratamento de colisão: Tentativa linear.
        int i = 1;
        while ($table[$index] != null) {
            $index = ($hash + i) % $table.length;
            i++;
        }

        return $index;
    }

    /**
     * Adiciona um elemento à tabela Hash.
     * @param $value (Integer) - Elemento a ser adiciona à tabela Hash.
     */
    void add(int $value) {
        int $index = hashing($value);
        $table[$index] = $value;
    }

    /**
     * Mostra os elementos da tabela Hash.
     */
    void show() {
        String $elements = "";
        for (Object value : $table) {
            $elements = $elements.concat(value + ", ");
        }
        System.out.println($elements.substring(0, $elements.length() - 2));
    }

    /**
     * Verifica se o elemento existe na tabela Hash através da tentativa quadrática.
     * @param $value (Integer) - Elemento a ser pesquisado na tabela Hash.
     * @return (Integer) - Retorna a posição do elemento na tabela, -1 caso não encontrado.
     */
    int search(int $value) {
        int $index = $value % $table.length;

        // Tratamento de colisão: Tentativa quadrática.
        int i = 1;
        while ($table[$index] != null) {
            if ($table[$index] == $value) return $index;
            $index = ($index + i) % $table.length;
            i++;
        }

        return -1;
    }

    /**
     * Remove um elemento da tabela Hash, não altera a posição dos elementos.
     * @param $value (Integer) - Elemento a ser removido.
     */
    void remove(int $value) {
        int $index = search($value);
        if ($index != -1) {
            $table[$index] = null;
        }
    }
}
