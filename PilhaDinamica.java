package workspace;

/**
 * Representa uma Pilha Dinâmica simplesmente encadeada.
 */
public class PilhaDinamica {
    private Node $first;
    private Node $last;
    private int $counter;

    /**
     * Cria a pilha.
     */
    public PilhaDinamica() {
        $first = null;
        $last = null;
        $counter = 0;
    }

    /**
     * Adiciona uma elemento na pilha.
     * @param $value (Object) - Elemento a ser adicionado na pilha.
     */
    public void push(Object $value) {
        Node $new = new Node($value);
        $counter++;

        if ($first == null) {
            $first = $new;
        } else {
            $last.address = $new;
        }
        $last = $new;
    }

    /**
     * Remove o elemento no final da pilha.
     */
    public void pop() {
        if ($first != null) {
            Node $aux = $first;
            $counter--;

            while ($aux.address.address != null) {
                $aux = $aux.address;
            }
            $aux.address = null;
            $last = $aux;
        }
    }

    /**
     * Retorna quantos elementos tem a pilha.
     * @return (Integer) - A quantidade de elementos da pilha.
     */
    public int size() {
        return $counter;
    }

    /**
     * Procura por um determinado elemento na pilha.
     * @param $value (Object) - Elemento a ser procurado na pilha.
     * @return (Boolean) - true se estiver na pilha, false caso contrário.
     */
    public boolean search(Object $value) {
        Node $aux = $first;

        while ($aux != null) {
            if ($aux.data.equals($value)) {
                return true;
            }
            $aux = $aux.address;
        }
        return false;
    }

    /**
     * Mostra todos os elementos da pilha.
     */
    public void show() {
        Node $aux = $first;

        while ($aux != null) {
            System.out.println($aux.data + " ");
            $aux = $aux.address;
        }
        System.out.println();
    }

    /**
     * Verifica se a pilha está vazia ou não.
     * @return (Boolena) - true se estiver vazia, false caso contrário.
     */
    public boolean empty() {
        return $counter == 0;
    }

    /**
     * Retorna o topo da pilha.
     * @return (Object) - O elemento do topo da pilha.
     */
    public Object peek() {
        return $last.data;
    }
}
