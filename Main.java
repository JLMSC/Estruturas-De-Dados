package workspace;

public class Main {
    public static void main(String[] args) throws Exception {
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        arvore.add(7);
        arvore.add(5);
        arvore.add(12);
        arvore.add(2);
        arvore.add(6);
        arvore.add(9);
        arvore.add(21);
        arvore.add(19);
        arvore.add(25);

        arvore.show();

        System.out.println();

        arvore.remove(12);
        arvore.show();
    }
}
