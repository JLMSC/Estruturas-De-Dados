package workspace;

/**
 * Representa uma Fila de Prioridade (Lista Dinâmica Não-Ordenada).
 */
public class FilaPrioridadeNaoOrdenada {
    private Node $first;
    private Node $last;
    private int $counter;
    // O maior nivel de pioridade.
    private int $max_priority = 2;

    /**
     * Cria uma Fila de Prioridade Não Ordenada.
     */
    FilaPrioridadeNaoOrdenada() {
        $first = null;
        $last = null;
        $counter = 0;
    }

    /**
     * Adiciona um elemento, com prioridade, na fila.
     * @param $value (Object) - Elemento a ser adicionado.
     * @param $priority (Integer) - Prioridade do elemento.
     */
    void enqueue(Object $value, int $priority) {
        Node $new = new Node($value, $priority);

        if ($first == null) $first = $new;
        else {
            $last.address = $new;
            $new.last_address = $last;
        }

        $last = $new;
        $counter++;
    }

    /**
     * Remove o elemento de maior prioridade (topo da fila).
     */
    void dequeue() {
        if ($first != null) {
            Node $aux = this.front();

            if ($aux.last_address != null) {
                $aux.last_address.address = $aux.address;
            } else {
                $first = $aux.address;
            }

            if ($aux.address != null) {
                $aux.address.last_address = $aux.last_address;
            } else {
                $last = $aux.last_address;
            }

            $counter--;
        }
    }

    /**
     * Verifica se a fila está vazia.
     * @return (Boolean) - True se estiver vazia, false caso contrário.
     */
    boolean empty() {
        return $counter == 0;
    }

    /**
     * Retorna o elemento de maior prioridade da fila.
     * @return (Node) - O elemento de maior prioridade.
     */
    Node front() {
        if ($first != null) {
            for (int $priority_level = 0; $priority_level <= $max_priority; $priority_level++) {
                Node $aux = $first;

                while ($aux != null) {
                    if ($aux.priority == $priority_level) {
                        return $aux;
                    }
                    $aux = $aux.address;
                }
            }
        }
        // TODO: Tratar o caso de lista vazia, caso seja solicitado o this.front()
        return null;
    }

    /**
     * Retorna o tamanho da fila.
     * @return (Integer) - O tamanho da fila.
     */
    int size() {
        return $counter;
    }

    /**
     * Mostra os elementos da fila.
     */
    void elements() {
        String $result = "";
        Node $indicator = $first;

        while ($indicator != null) {
            $result = $result.concat(String.format("%s ", $indicator.data));
            $indicator = $indicator.address;
        }

        System.out.println($result.substring(0, $result.length() - 1));
    }

    /**
     * Verifica se o elemento existe na fila.
     * @param $value (Object) - Elemento a ser pesquisado.
     * @return (Boolean) - True se estiver na fila, false caso contrário.
     */
    boolean search(Object $value) {
        Node $aux = $first;

        while ($aux != null) {
            if ($aux.data.equals($value)) return true;
            $aux = $aux.address;
        }
        return false;
    }

    /**
     * Limpa a fila.
     */
    void destroy() {
        $first = null;
        $last = null;
        $counter = 0;
    }
}
