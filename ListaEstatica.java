package workspace;

/**
 * Representa uma Lista Estática.
 */
public class ListaEstatica {
    private Object[] _vector;
    private int _last_index_push;

    /**
     * Cria uma lista de tamanho fixo.
     */
    ListaEstatica() {
        _vector = new Object[10];
        _last_index_push = 0;
    }

    /**
     * Cria uma lista de tamanho definido.
     * @param _size (Integer) - O tamanho da lista.
     */
    ListaEstatica(int _size) {
        _vector = new Object[_size];
        _last_index_push = 0;
    }

    /**
     * Adiciona um elemento no final da lista.
     * @param _value (Object) - Elemento a ser adicionado.
     * @throws Exception Lançado se a linha estier cheia.
     */
    void push(Object _value) throws Exception {
        if (_last_index_push > this.size()) {
            throw new Exception("Array Index Out of Bounds.");
        } else {
            _vector[_last_index_push] = _value;
            _last_index_push++;
        }
    }

    /**
     * Adiciona um elemento na lista, em uma determinada posição.
     * @param _index (Integer) - A posição em que o elemento vai ser adicionado.
     * @param _value (Object) - O elemento a ser adicionado.
     * @throws Exception Lançado se a posição for inválida ou a lista estiver cheia.
     */
    void push(int _index, Object _value) throws Exception {
        if (_last_index_push > this.size()) {
            throw new Exception("Array Index Out of Bounds.");
        }

        if (_index > _last_index_push) {
            throw new Exception("Invalid Index: " + _index);
        }

        for (int i = _last_index_push; i > _index; i--) {
            _vector[i] = _vector[i - 1];
        }
        _vector[_index] = _value;
        _last_index_push++;
    }

    /**
     * Retorna o tamanho da lista.
     * @return (Integer) - O tamanho da lista.
     */
    int size() {
        return this._last_index_push;
    }

    /**
     * Verifica se o elemento está contido na lista.
     * @param _value (Object) - O elemento a ser pesquisado.
     * @return (Boolean) - True se estiver na lista, false caso contrário.
     */
    boolean contains(Object _value) {
        if (this.find(_value) != -1) return true;
        else return false;
    }

    /**
     * Remove o último elemento da lista.
     * @throws Exception Lançado se não existir elementos na lista.
     */
    void remove() throws Exception {
        if (_last_index_push < 0) {
            throw new Exception("Array Index Out of Bounds.");
        }
        _last_index_push--;
    }

    /**
     * Remove um elemento da lista, em uma determinada posição.
     * @param _index (Integer) - Posição em que o elemento vai ser removido.
     * @throws Exception Lançado se a lista estiver vazia ou a posição seja maior que a lista.
     */
    void remove(int _index) throws Exception {
        if (_last_index_push < 0 || _index < 0) {
            throw new Exception("Array Index Out of Bounds.");
        }

        if (_index >= _last_index_push) {
            throw new Exception("Invalid Index: " + _index);
        }

        for (int i = _index; i < _last_index_push - 1; i++) {
            _vector[i] = _vector[i + 1];
        }
        _last_index_push--;
    }

    /**
     * Remove a primeira ocorrência de um determinado elemento da lista.
     * @param _value (Object) - Elemento a ser pesquisado e removido.
     * @throws Exception Lançado se não existir elementos na lista.
     */
    void removeItem(Object _value) throws Exception {
        this.remove(this.find(_value));
    }

    /**
     * Procura por um elemento na lista.
     * @param _value (Object) - Elemento a ser procurado.
     * @return (Integer) - A posição do elemento se encontrado ou -1 caso contrário.
     */
    int find(Object _value) {
        for (int i = 0; i < _last_index_push; i++) {
            if (_vector[i].equals(_value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retorna o elemento em uma determinada posição.
     * @param _position (Integer) - Posição da lista em que o elemento vai ser retornado.
     * @return (Object) - O elemento na posição ou null caso contrário.
     * @throws Exception Lançado se a posição não existir.
     */
    Object index(int _position) throws Exception {
        if (_position < _last_index_push) return _vector[_position];
        else return null;
    }

    /**
     * Mostra os elementos da lista.
     */
    void show() {
        for (int i = 0; i < _last_index_push; i++) {
            System.out.print(_vector[i] + " ");
        }
        System.out.println();
    }

    /**
     * Limpa os elementos da lista.
     */
    void clear() {
        for (int i = 0; i < _last_index_push; i++) {
            _vector[i] = 0;
        }
        _last_index_push = 0;
    }
}
