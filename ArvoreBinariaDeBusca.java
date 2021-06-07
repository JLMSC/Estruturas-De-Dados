package workspace;

public class ArvoreBinariaDeBusca {
    /*
    Terminologia :.
        Raiz : Nó sem pai.
        Nó interno : Nó com pelo menos um filho.
        Nó externo (ou folha) : Nó sem filhos.
        Ancestrais de um nó : pais, avós, bisavós etc.
        Descendentes de um nó : filhos, netos, bisnetos etc.
        Profundidade (ou nível) de um nó : número de ancestrais.
        Altura de uma árvore : profundidade máxima dentre os nós.
        Subárvore : árvore que consiste em um nó e seus descendentes.
     */
    private Node source;

    /**
     * Inicializa a raiz da árvore.
     */
    public ArvoreBinariaDeBusca() {
        source = null;
    }

    /**
     * Adiciona um elemento à árvore.
     * @param element (Object) - Elemento a ser adicionado.
     */
    public void add(Object element) {
        if (this.empty()) source = new Node(element);
        else this.add(element, source);
    }

    /**
     * Adiciona um elemento à raiz.
     * @param element (Object) - Elemento a ser adicionado.
     * @param src (Node) - Raiz onde o elemento vai ser adicionado.
     */
    private void add(Object element, Node src) {
        if (element.toString().compareTo(src.data.toString()) < 0) { // Lado Esquerdo.
            if (src.left_child == null) {
                src.left_child = new Node(element, src);
            } else {
                this.add(element, src.left_child);
            }
        } else if (element.toString().compareTo(src.data.toString()) > 0) { // Lado Direito.
            if (src.right_child == null) {
                src.right_child = new Node(element, src);
            } else {
                this.add(element, src.right_child);
            }
        }
    }

    /**
     * Remove um elemento da árvore.
     * @param element (Object) - Elemento a ser removido.
     */
    public void remove(Object element) {
        if (!this.empty()) {
            remove(element, source);
        }
    }

    /**
     * Remove um elemento a partir da raiz.
     * @param element (Object) - Elemento a ser removido.
     * @param src (Node) - Raiz de onde vai ser removido.
     */
    private void remove(Object element, Node src) {
        if (element == src.data) {
            if (src.left_child == null && src.right_child == null) { // Não tem filho.
                if (src == src.main_source.left_child) { // Filho Esquerdo
                    src.main_source.left_child = null;
                } else { // Filho Direito
                    src.main_source.right_child = null;
                }
            } else if (src.left_child != null && src.right_child == null) { // Só Filho Esquerdo.
                if (src == src.main_source.left_child) { // Filho Esquerdo
                    src.main_source.left_child = src.left_child;
                } else { // Filho Direito
                    src.main_source.right_child = src.left_child;
                }
            } else if (src.left_child == null && src.right_child != null) { // Só Filho Direito
                if (src == src.main_source.left_child) { // Filho Esquerdo
                    src.main_source.left_child = src.right_child;
                } else { // Filho Direito
                    src.main_source.right_child = src.right_child;
                }
            } else if (src.left_child != null && src.right_child != null) { // Dois Filhos
                src.data = this.min(src.right_child);
                this.remove(src.data, src.right_child);
            }
        } else if (element.toString().compareTo(src.data.toString()) < 0) { // Lado Esquerdo.
            if (src.left_child != null) {
                this.remove(element, src.left_child);
            }
        } else if (element.toString().compareTo(src.data.toString()) > 0) { // Lado Direito.
            if (src.right_child != null) {
                this.remove(element, src.right_child);
            }
        }
    }

    /**
     * Percorre a árvore e retorna o menor elemento da raiz.
     * @param src (Node) - Raiz a ser percorrida.
     * @return (Object) - O valor do elemento.
     */

    public Object min(Node src) {
        if (src.left_child == null) {
            return src.data;
        } else {
            return min(src.left_child);
        }
    }

    /**
     * Verifica se a árvore está vazia.
     * @return (Boolean) - True se vazio, false caso contrário.
     */
    public boolean empty() {
        return source == null;
    }

    /**
     * Procura por um determinado elemento da árvore.
     * @param element (Object) - Elemento a ser procurado.
     * @return (Boolean) - True se existir na árvore, False caso contrário.
     */
    public boolean search(Object element) {
        if (this.empty()) return false;
        else return this.search(element, source);
    }

    /**
     * Pesquisa um elemento na raiz.
     * @param element (Object) - Elemento a ser pesquisado.
     * @param src (Node) - Raiz onde o elemento vai ser pesquisado.
     * @return (Boolean) - True se existir na árvore, False caso contrário.
     */
    private boolean search(Object element, Node src) {
        if (element == src.data) {
            return true;
        } else if (element.toString().compareTo(src.data.toString()) < 0) { // Lado Esquerdo.
            if (src.left_child == null) {
                return false;
            } else {
                return this.search(element, src.left_child);
            }
        } else if (element.toString().compareTo(src.data.toString()) > 0) { // Lado Direito.
            if (src.right_child == null) {
                return false;
            } else {
                return this.search(element, src.right_child);
            }
        }
        return false;
    }

    /**
     * Mostra todos os elementos da árvore.
     */
    public void show() {
        // Tipos de Percurso :. Pré-Ordem, Em Ordem, Pós-Ordem.
        this.show(source);
    }

//    /** Pré-Ordem
//     * Mostra todos os elementos da árvore.
//     * @param src (Node) - Raiz do percurso atual da árvore.
//     */
//    public void show(Node src) {
//        System.out.print(src.data + " ");
//
//        if (src.left_child != null) {
//            this.show(src.left_child);
//        }
//
//        if (src.right_child != null) {
//            this.show(src.right_child);
//        }
//    }

//    /** Em Ordem
//     * Mostra todos os elementos da árvore.
//     * @param src (Node) - Raiz do percurso atual da árvore.
//     */
//    public void show(Node src) {
//        if (src.left_child != null) {
//            this.show(src.left_child);
//        }
//
//        System.out.print(src.data + " ");
//
//        if (src.right_child != null) {
//            this.show(src.right_child);
//        }
//
//    }

    /** Pós-Ordem
     * Mostra todos os elementos da árvore.
     * @param src (Node) - Raiz do percurso atual da árvore.
     */
    public void show(Node src) {
        if (src.left_child != null) {
            this.show(src.left_child);
        }

        if (src.right_child != null) {
            this.show(src.right_child);
        }

        System.out.print(src.data + " ");
    }
}
