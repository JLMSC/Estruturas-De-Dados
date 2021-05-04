package workspace;

/**
 * Representa uma Fila de Prioridade que utiliza a estrutura Heap.
 */
public class FilaPrioridadeHeap {
    private Node[] $data;
    private int $length;

    /**
     * Cria uma Fila de Prioridade de tamanho definido.
     * @param $size (Integer) - Tamanho da fila.
     */
    FilaPrioridadeHeap(int $size) {
        $data = new Node[$size];
        $length = 0;
    }

    /**
     * Mostra o elemento no topo da fila.
     * @return (Node) - O elemento no topo da fila.
     */
    Node front() {
        if (size()) throw new RuntimeException("Empty Heap");
        else return $data[0];
    }

    /**
     * Verifica se a fila está vazia.
     * @return (Boolean) - True se estiver vazia, false caso contrário.
     */
    boolean size() {
        return $length == 0;
    }

    /**
     * Adiciona um elemento, com prioridade, na fila.
     * @param $value (Object) - Elemento a ser adicionado.
     * @param $priority (Integer) - Prioridade do elemento.
     */
    void enqueue(Object $value, int $priority) {
        if ($length == $data.length) {
            throw new RuntimeException("Heap is full.");
        } else {
            $data[$length] = new Node($value, $priority);
            $length++;
            up($length - 1);
        }
    }

    /**
     * Organiza o Heap da fila.
     * @param $index (Integer) - Posição do elemento.
     */
    void up(int $index) {
        int $mainIndex;
        Node $temp;

        if ($index != 0) {
            $mainIndex = ($index - 1) / 2;

            if ($data[$mainIndex].priority > $data[$index].priority) {
                $temp = $data[$mainIndex];
                $data[$mainIndex] = $data[$index];
                $data[$index] = $temp;
                up($mainIndex);
            }
        }
    }

    /**
     * Remove o elemento da fila.
     */
    void dequeue() {
        if (size()) throw new RuntimeException("Empty Heap");
        else {
            $data[0] = $data[$length - 1];
            $length--;
            if ($length > 0) down(0);
        }
    }

    /**
     * Organiza o Heap da fila.
     * @param $index (Integer) - Posição do elemento.
     */
    void down(int $index) {
        int $firstNodeIndex, $secondNodeIndex, $minIndex;
        Node $temp;

        $firstNodeIndex = 2 * $index + 1;
        $secondNodeIndex = 2 * $index + 2;

        // TODO: Arrumar as comparações (100, 105).
        //       Elementos de mesma prioridade (Não são organizados de forma correta).
        if ($secondNodeIndex >= $length) {
            if ($firstNodeIndex >= $length) return;
            else $minIndex = $firstNodeIndex;
        } else {
            if ($data[$firstNodeIndex].priority > $data[$secondNodeIndex].priority) {
                $minIndex = $firstNodeIndex;
            } else $minIndex = $secondNodeIndex;
        }

        if ($data[$index].priority >= $data[$minIndex].priority) {
            $temp = $data[$minIndex];
            $data[$minIndex] = $data[$index];
            $data[$index] = $temp;
            down($minIndex);
        }
    }

    /**
     * Mostra os elementos do Heap.
     */
    void elements() {
        for (int i = 0; i < $length; i++) {
            System.out.print($data[i].data + " (" + $data[i].priority + ") ");
        }
        System.out.println();
    }
}
