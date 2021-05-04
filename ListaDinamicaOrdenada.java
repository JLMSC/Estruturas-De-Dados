package workspace;

/**
 * Representa uma Lista Dinâmica Ordenada.
 */
public class ListaDinamicaOrdenada {
    private Node _first_attribute;
    private Node _second_attribute;

    /**
     * Cria uma Linked List.
     */
    public ListaDinamicaOrdenada() {
        _first_attribute = null;
        _second_attribute = null;
    }

    /**
     * Adiciona um elemento na lista.
     * @param _value (Object) - Elemento a ser adicionado na lista.
     */
    void push(Object _value) {
        Node _temp;
        Node _node = new Node(_value);

        if (_first_attribute == null) {
            _first_attribute = _node;
            _second_attribute = _node;
        }

        if (_node.data.toString().compareTo(_first_attribute.data.toString()) < 0) {
            _temp = _first_attribute;
            _first_attribute = _node;
            _node.address = _temp;
        }

        else if (_node.data.toString().compareTo(_second_attribute.data.toString()) > 0) {
            if (this.size() == 1) {
                _first_attribute.address = _node;
            } else {
                _second_attribute.address = _node;
            }
            _second_attribute = _node;
        }
        else {
            Node _indicator = _first_attribute;

            while (_indicator != null) {
                if (_node.data.toString().compareTo(_indicator.data.toString()) < 0) {

                    Node $temp = _indicator;
                    Node $indicator = _first_attribute;
                    while ($indicator.address != null) {
                        if ($indicator.address == $temp) {
                            $indicator.address = _node;
                            _node.address = _indicator;
                            break;
                        }
                        $indicator = $indicator.address;
                    }
                    break;
                }

                _indicator = _indicator.address;
            }
        }

    }

    /**
     * Retorna o tamanho da lista.
     * @return (Integer) - O tamanho da lista.
     */
    int size() {
        int counter = 0;
        Node _indicator = _first_attribute;

        while (_indicator != null) {
            _indicator = _indicator.address;
            counter++;
        }

        return counter;
    }

    /**
     * Verifica se o elemento existe na lista.
     * @param _value (Object) - Elemento a ser pesquisado.
     * @return (Boolean) - True se estiver na lista, false caso contrário.
     */
    boolean contains(Object _value) {
        Node _indicator = _first_attribute;

        while (_indicator != null) {
            if (_indicator.data.equals(_value)) {
                return true;
            }

            _indicator = _indicator.address;
        }

        return false;
    }

    /**
     * Remove o último elemento da lista.
     */
    void remove() {
        int counter = 0;
        Node _indicator = _first_attribute;

        while (counter < this.size() - 1) {
            counter++;
            _indicator = _indicator.address;
        }

        _indicator.address = null;
        _second_attribute = _indicator;
    }

    /**
     * Remove um elemento, na lista, em uma determinada posição.
     * @param _index (Integer) - Posição a ser removida da lista.
     */
    void remove(int _index) {
        int counter = 0;
        Node _indicator = _first_attribute;

        while (counter < _index) {

            if (_indicator.address == null) return;

            if (counter == _index - 1) {
                _indicator.address = _indicator.address.address;
            }

            counter++;
            _indicator = _indicator.address;
        }
    }

    /**
     * Remove a primeira ocorrência, de um elemento, na lista.
     * @param _value (Object) - Elemento a ser removido.
     */
    void removeItem(Object _value) {
        int counter = 0;
        Node _indicator = _first_attribute;

        while (!_indicator.data.equals(_value)) {
            counter++;
            _indicator = _indicator.address;
        }

        this.remove(counter);
    }

    /**
     * Procura por um elemento na lista e retorna sua posição.
     * @param _value (Object) - Elemento a ser pesquisado.
     * @return (Integer) - A posição do elemento se encontrado, -1 caso contrário.
     */
    int find(Object _value) {
        int counter = 0;
        Node _indicator = _first_attribute;

        while (_indicator != null) {
            if (_indicator.data.equals(_value)) return counter;

            _indicator = _indicator.address;
            counter++;
        }
        return -1;
    }

    /**
     * Mostra o elemento em uma determinada posição
     * @param _position (Integer) - Posição a ser pesquisada.
     * @return (Object) - O Elemento naquela posição.
     */
    Object index(int _position) {
        int counter = 0;
        Node _indicator = _first_attribute;

        while (counter < _position) {
            if (_indicator == null) return -1;

            _indicator = _indicator.address;
            counter++;
        }

        return _indicator.data;
    }

    /**
     * Mostra os elementos da lista.
     */
    void show() {
        String result = "";
        Node _indicator = _first_attribute;

        while (_indicator != null) {
            result = result.concat(String.format("%s ", _indicator.data));
            _indicator = _indicator.address;
        }

        System.out.println(result.substring(0, result.length() - 1));
    }

    /**
     * Limpa a lista.
     */
    void clear() {
        _first_attribute = null;
        _second_attribute = null;
    }
}

