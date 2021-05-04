package workspace;

/**
 * Representa uma Pilha Estática.
 */
public class PilhaEstatica {
    private Object[] $list;
    private int $counter;

    /**
     * Cria uma pilha de tamanho 10.
     */
    public PilhaEstatica() {
        $list = new Object[10];
        $counter = 0;
    }

    /**
     * Cria uma pilha de tamanho definido
     * @param $size (Integer) - O tamanho da pilha.
     */
    public PilhaEstatica(int $size) {
        $list = new Object[$size];
        $counter = 0;
    }

    /**
     * Adiciona o elemento no final da pilha.
     * Aumenta o tamanho da pilha pela metade caso esteja cheia.
     * @param $value (Object) - Elemento a ser adicionado.
     */
    public void push(Object $value) {
        if ($counter >= $list.length) {
            Object[] $aux = new Object[(int) ($list.length * 1.5)];
            for (int i = 0; i < $list.length; i++) {
                $aux[i] = $list[i];
            }
            $list = $aux;
        }
        $list[$counter] = $value;
        $counter++;
    }

    /**
     * Remove do final da lista.
     * @throws Exception Lançado se a pilha estiver cheia.
     */
    public void pop() throws Exception {
        if ($counter > 0) {
            $counter--;
        } else {
            throw new Exception("A pilha está cheia.");
        }
    }

    /**
     * Retorna o tamanho da pilha.
     * @return (Integer) - O tamanho da pilha.
     */
    public int size() {
        return $counter;
    }

    /**
     * Mostra se o item existe ou não.
     * @param $value (Object) - Elemento a ser procurado.
     * @return (Boolena) - True se existe, false caso contrário.
     */
    public boolean search(Object $value) {
        for (int i = 0; i < $counter; i++) {
            if ($list[i].equals($value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mostra se a pilha está vazia.
     * @return (Boolean) - True se vazia, false caso contrário.
     */
    public boolean empty() {
        return $counter == 0;
    }

    /**
     * Retorna o elemento do topo da pilha.
     * @return (Object) - O elemento do topo da pilha.
     */
    public Object peek() {
        return $list[$counter - 1];
    }

    /**
     * Mostra os elementos da pilha.
     */
    public void show() {
        for (Object i : $list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
