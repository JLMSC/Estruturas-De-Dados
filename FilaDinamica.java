package workspace;

/**
 * Representa uma Fila Dinâmica.
 */
public class FilaDinamica {
    private Node $first;
    private Node $last;
    private int $counter;

    /**
     * Cria uma Fila Dinâmica.
     */
    public FilaDinamica() {
        $first = null;
        $last = null;
        $counter = 0;
    }

    /**
     * Adiciona um elemento na fila.
     * @param $value (Object) - Elemento a ser adicionado.
     */
    public void enqueue(Object $value) {
        Node $new = new Node($value);

        if ($first == null) {
            $first = $new;
        } else {
            $last.address = $new;
        }

        $last = $new;
        $counter++;
    }

    /**
     * Remove o elemento da primeira posição.
     */
    public void dequeue() {
        if ($first != null) {
            $first = $first.address;
            $counter--;
        }
    }

    /**
     * Verifica se a fila está vazia.
     * @return (Boolean) - True se estiver vazia, false caso contrário.
     */
    public boolean empty() {
        return $counter == 0;
    }

    /**
     * Acessa o elemento no início da fila.
     * @return (Object) - O elemento no início da fila.
     */
    public Object front() {
        return $first.data;
    }

    /**
     * Retorna o tamanho da fila.
     * @return (Integer) - O tamanho da fila.
     */
    public int size() {
        return $counter;
    }

    /**
     * Mostra os elementos da fila.
     */
    public void elements() {
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
    public boolean search(Object $value) {
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
    public void destroy() {
        $first = null;
        $last = null;
        $counter = 0;
    }

}
