package workspace;

/**
 * Representa um Heap Mínimo.
 */
class HeapMin {
    private int[] $data;
    private int $length;

    /**
     * Cria um Heap Mínimo de tamanho definido.
     * @param $size (Integer) - O tamanho do Heap.
     */
    HeapMin(int $size) {
        $data = new int[$size];
        $length = 0;
    }

    /**
     * Mostra o menor elemento do Heap.
     * @return (Integer) - O menor elemento do Heap.
     */
    int min() {
        if (empty()) throw new RuntimeException("Empty Heap.");
        else return $data[0];
    }

    /**
     * Verifica se o Heap está vazio.
     * @return (Boolean) - True se estiver vazio, false caso contrário.
     */
    boolean empty() {
        return $length == 0;
    }

    /**
     * Insere um elemento no Heap.
     * @param $value (Integer) - Elemento a ser adicionado no Heap.
     */
    void insert(int $value) {
        if ($length == $data.length)
            throw new RuntimeException("Heap is full.");
        else {
            $data[$length] = $value;
            $length++;
            up($length - 1);
        }
    }

    /**
     * Organiza os elementos de acordo com a formação do Heap Mínimo
     * @param $index (Integer) - Posição do elemento.
     */
    private void up(int $index) {
        int $mainIndex, $temp;

        if ($index != 0) {
            $mainIndex = ($index - 1) / 2;

            if ($data[$mainIndex] > $data[$index]) {
                $temp = $data[$mainIndex];
                $data[$mainIndex] = $data[$index];
                $data[$index] = $temp;
                up($mainIndex);
            }
        }
    }

    /**
     * Remove o elemento no topo do Heap.
     */
    void remove() {
        if (empty()) throw new RuntimeException("Empty Heap.");
        else {
            $data[0] = $data[$length - 1];
            $length--;
            if ($length > 0) down(0);
        }
    }

    /**
     * Organiza os elementos de acordo com a formação do Heap Mínimo.
     * @param $index (Integer) - Posição do elemento.
     */
    private void down(int $index) {
        int $firstNodeIndex, $secondNodeIndex, $minIndex, $temp;

        $firstNodeIndex = 2 * $index + 1;
        $secondNodeIndex = 2 * $index + 2;

        if ($secondNodeIndex >= $length) {
            if ($firstNodeIndex >= $length) return;
            else $minIndex = $firstNodeIndex;
        } else {
            if ($data[$firstNodeIndex] <= $data[$secondNodeIndex]) {
                $minIndex = $firstNodeIndex;
            } else $minIndex = $secondNodeIndex;
        }

        if ($data[$index] > $data[$minIndex]) {
            $temp = $data[$minIndex];
            $data[$minIndex] = $data[$index];
            $data[$index] = $temp;
            down($minIndex);
        }
    }

    /**
     * Mostra os elementos do Heap.
     */
    void show() {
        for (int i = 0; i < $length; i++) {
            System.out.print($data[i] + " ");
        }
        System.out.println();
    }
}