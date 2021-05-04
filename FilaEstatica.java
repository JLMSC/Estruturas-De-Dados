package workspace;

/**
 * Representa uma Fila Estática Circular.
 */
public class FilaEstatica {
    private Object[] $vector;
    private int $first;
    private int $last;

    /**
     * Cria uma fila estática de tamanho fixo.
     */
    public FilaEstatica() {
        $vector = new Object[10];
        $first = 0;
        $last = -1;
    }

    /**
     * Cria uma fila estática de tamanho definido.
     * @param $size (Integer) - O tamanho da fila.
     */
    public FilaEstatica(int $size) {
        $vector = new Object[$size];
        $first = 0;
        $last = -1;
    }

    /**
     * Adiciona um elemento no final da fila.
     * @param $value (Object) - Elemento a ser adicionado.
     */
    public void enqueue(Object $value) {
        if (this.size() < $vector.length){
            $last++;

            if ($last == $vector.length) {
                $last = 0;
            }

            $vector[$last] = $value;
        }
    }

    /**
     * Remove um elemento do início da fila.
     */
    public void dequeue() {
        if (this.size() > 0) {
            $first++;
        } else {
            System.out.println("Fila vazia.");
        }
    }

    /**
     * Verifica se o elemento existe na fila.
     * @param $value (Object) - Elemento a ser pesquisado;
     * @return (Boolean) - True se estiver na lista, false caso contrário.
     */
    public boolean search(Object $value) {
        for (int i = $first; i <= $last; i++) {
            if ($vector[i].equals($value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se a fila está vazia.
     * @return (Boolean) - True se estiver vazia, false caso contrário.
     */
    public boolean empty() {
        return this.size() == 0;
    }

    /**
     * Retorna o elemento do topo da fila.
     * @return (Object) - O elemento do topo da fila.
     */
    public Object front() {
        return $vector[$first];
    }

    /**
     * Retorna o tamanho da fila.
     * @return (Integer) - O tamanho da fila.
     */
    public int size() {
        if ($last >= $first) {
            return ($last - $first) + 1;
        } else {
            if ($last != -1) {
                return $vector.length + (($last - $first) + 1);
            } else {
                return 0;
            }
        }
    }

    /**
     * Mostra os elementos da fila.
     */
    public void elements() {
        if ($last >= $first) {
            for (int i = $first; i <= $last; i++) {
                System.out.print($vector[i] + " ");
            }
        } else {
            for (int i = $first; i < $vector.length; i++) {
                System.out.print($vector[i] + " ");
            }
            for (int i = 0; i <= $last; i++) {
                System.out.print($vector[i] + " ");
            }
        }
        System.out.println();
    }
}
