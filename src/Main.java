public class Main {
    public static void main(String[] args) {

        ListaCircular<String> minhaListaCircular = new ListaCircular<>();

        minhaListaCircular.add(0, "c0");
        System.out.println(minhaListaCircular);

        minhaListaCircular.remove(0);
        System.out.println(minhaListaCircular);

        minhaListaCircular.add("c1");
        System.out.println(minhaListaCircular);

        minhaListaCircular.add("c2");
        minhaListaCircular.add("c3");

        System.out.println(minhaListaCircular);
        System.out.println("---------------------------------------------");

        for(int i = 0; i < 10; i++) {
            System.out.println(minhaListaCircular.get(i));
        }

        minhaListaCircular.add(0, "c99");
        System.out.println(minhaListaCircular);

        for(int i = 0; i < 20; i++) {
            System.out.println(minhaListaCircular.get(i));
        }

        System.out.println("---------------------------------------------");

        System.out.println(minhaListaCircular.get(2));
        minhaListaCircular.remove(2);
        System.out.println(minhaListaCircular);
    }
}