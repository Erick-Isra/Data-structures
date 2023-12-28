public class Prueba{

  public static void main(String[] args){
    Pila<Integer> pila = new Pila<>();

        try {
            System.out.println("La pila está vacía: " + pila.esVacia());
            pila.apilar(1);
            pila.apilar(2);
            pila.apilar(3);
            System.out.println("La cima de la pila es: " + pila.darElementoCima());
            System.out.println("La pila está vacía: " + pila.esVacia());
            System.out.println("La longitud de la pila es: " + pila.darLongitud());

            pila.desapilar();
            System.out.println("Desapilado un elemento.");
            System.out.println("La cima de la pila es: " + pila.darElementoCima());
            System.out.println("La longitud de la pila es: " + pila.darLongitud());
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}
