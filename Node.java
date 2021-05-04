package workspace;

/**
 * Representa uma Nó.
 */
public class Node {
    public Object data;
    public Node address;
    public Node last_address;
    public int priority;

    /**
     * Representa um Nó.
     * @param data (Object) - O valor do elemento.
     */
    public Node(Object data) {
        this.data = data;
        this.address = null;
    }

    /**
     * Representa um Nó com prioridade.
     * @param data (Object) - O valor do elemento.
     * @param priority (Integer) - O nível de prioridade do elemento.
     */
    public Node(Object data, int priority) {
        this.data = data;
        this.priority = priority;
        this.address = null;
        this.last_address = null;
    }
}
