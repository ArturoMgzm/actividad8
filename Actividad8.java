import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Clase Card
    contiene la información de la carta, esta no puede ser alterada por metodos externos
*/
class Card{
    //atributos que solo pueden ser accedidos por la clase misma
    private String palo;
    private String color;
    private String valor;

    //constructor, requiere el palo (con el cual infiere el color) y el valor
    public Card(String palo, String valor){
        this.palo = palo;
        //infiere el color basado en las reglas tradicionales de poker
        if(palo == "corazones" || palo == "diamantes"){
            this.color = "rojo";
        }
        else{
            this.color = "negro";
        }
        this.valor = valor;
    }

    //funcion que imprime el valor de una carta de acuerdo a la especificacion de los requerimientos
    public void imprimirCarta(){
        System.out.println(palo + ", " + color + ", " + valor);
    }

}


/*
Clase Deck
    Simula un mazo de cartas usando un ArrayList, adicionalmente utiliza numeros aleatorios en varios de sus metodos
*/
class Deck{
    //atributos que solo pueden ser accedidos directamente desde la clase
    private ArrayList<Card> cardDeck;
    private int remainingCards;

    //constructor, manda a llamar a un metodo que inicia el mazo con 52 carta distribuidas aleatoriamente
    //se utilizo el metodo para no reescribir la funcion de "shuffle" dos veces, la funcionalidad distinta es minima
    public Deck(){
        this.shuffleBaseCards();
    }

    //head
    //trae el primer valor del maso y lo expulsa del mazo
    //si no hay cartas en el mazo notifica al usuario
    public void head(){
        if(remainingCards > 0){
            this.cardDeck.get(0).imprimirCarta();
            this.cardDeck.remove(0);
            this.remainingCards--;
            System.out.println("Quedan " + this.remainingCards);
        }
        else{
            System.out.println("Ya no hay cartas en el Deck");
        }
    }

    //printDeck
    // funcion que imprime todas las cartas que quedan en el mazo, se imprimen en el orden que esten
    public void printDeck(){
        for(int x = 0; x < this.remainingCards; x++){
            this.cardDeck.get(x).imprimirCarta();
        }
    }

    //shuffleBaseCards
    //Funcion que se utiliza tanto en el constructor como en shuffle
    //inicia el mazo con las 52 cartas en orden
    //posteriormente procede a intercambiar dos cartas aleatorias de posicion, este proceso se repite 5000 veces
    public void shuffleBaseCards(){
        this.cardDeck = new ArrayList<>();
        this.cardDeck.add(new Card("tréboles","A"));
        this.cardDeck.add(new Card("tréboles","2"));
        this.cardDeck.add(new Card("tréboles","3"));
        this.cardDeck.add(new Card("tréboles","4"));
        this.cardDeck.add(new Card("tréboles","5"));
        this.cardDeck.add(new Card("tréboles","6"));
        this.cardDeck.add(new Card("tréboles","7"));
        this.cardDeck.add(new Card("tréboles","8"));
        this.cardDeck.add(new Card("tréboles","9"));
        this.cardDeck.add(new Card("tréboles","10"));
        this.cardDeck.add(new Card("tréboles","J"));
        this.cardDeck.add(new Card("tréboles","Q"));
        this.cardDeck.add(new Card("tréboles","K"));
        this.cardDeck.add(new Card("corazones","A"));
        this.cardDeck.add(new Card("corazones","2"));
        this.cardDeck.add(new Card("corazones","3"));
        this.cardDeck.add(new Card("corazones","4"));
        this.cardDeck.add(new Card("corazones","5"));
        this.cardDeck.add(new Card("corazones","6"));
        this.cardDeck.add(new Card("corazones","7"));
        this.cardDeck.add(new Card("corazones","8"));
        this.cardDeck.add(new Card("corazones","9"));
        this.cardDeck.add(new Card("corazones","10"));
        this.cardDeck.add(new Card("corazones","J"));
        this.cardDeck.add(new Card("corazones","Q"));
        this.cardDeck.add(new Card("corazones","K"));
        this.cardDeck.add(new Card("picas","A"));
        this.cardDeck.add(new Card("picas","2"));
        this.cardDeck.add(new Card("picas","3"));
        this.cardDeck.add(new Card("picas","4"));
        this.cardDeck.add(new Card("picas","5"));
        this.cardDeck.add(new Card("picas","6"));
        this.cardDeck.add(new Card("picas","7"));
        this.cardDeck.add(new Card("picas","8"));
        this.cardDeck.add(new Card("picas","9"));
        this.cardDeck.add(new Card("picas","10"));
        this.cardDeck.add(new Card("picas","J"));
        this.cardDeck.add(new Card("picas","Q"));
        this.cardDeck.add(new Card("picas","K"));
        this.cardDeck.add(new Card("diamantes","A"));
        this.cardDeck.add(new Card("diamantes","2"));
        this.cardDeck.add(new Card("diamantes","3"));
        this.cardDeck.add(new Card("diamantes","4"));
        this.cardDeck.add(new Card("diamantes","5"));
        this.cardDeck.add(new Card("diamantes","6"));
        this.cardDeck.add(new Card("diamantes","7"));
        this.cardDeck.add(new Card("diamantes","8"));
        this.cardDeck.add(new Card("diamantes","9"));
        this.cardDeck.add(new Card("diamantes","10"));
        this.cardDeck.add(new Card("diamantes","J"));
        this.cardDeck.add(new Card("diamantes","Q"));
        this.cardDeck.add(new Card("diamantes","K"));
        this.remainingCards = 52;
        //declara variables de apoyo
        Card temp;
        Random randomNumbers = new Random();
        int original, shuffled;
        //ciclo que hace 5000 movimientos de cartas aleatorias para barajear el mazo
        for(int x = 0; x < 5000; x++){
            //dos cartas en lugares aleatorios distintos se seleccionan
            original = randomNumbers.nextInt(52);
            shuffled = randomNumbers.nextInt(52);
            //se intercambian de lugar
            temp = this.cardDeck.get(original);
            this.cardDeck.set(original, this.cardDeck.get(shuffled));
            this.cardDeck.set(shuffled, temp);

        }
    }

    //shuffle
    //utiliza el metodo shuffleBaseCards para reiniciar el mazo y barajearlo
    //difiere del constructor en que este avisa al usuario que se mezcló el mazo
    public void shuffle(){
        this.shuffleBaseCards();
        System.out.println("Se mezcló el Deck");
    }

    //shuffleRemaining
    //Mezcla las cartas que permanecen en el mazo
    //utiliza la misma logica que shuffle() pero limitandose a su tamaño actual
    //tambien realiza 5000 movimientos
    public void shuffleRemaining(){
        Card temp;
        Random randomNumbers = new Random();
        int original, shuffled;
        //por 5000 iteraciones
        for(int x = 0; x < 5000; x++){
            //escoge dos cartas al azar dentro del mazo actual
            original = randomNumbers.nextInt(this.remainingCards);
            shuffled = randomNumbers.nextInt(this.remainingCards);
            //las intercambia
            temp = this.cardDeck.get(original);
            this.cardDeck.set(original, this.cardDeck.get(shuffled));
            this.cardDeck.set(shuffled, temp);

        }
        System.out.println("Se mezcló el Deck");
    }

    //hand
    //remueve 5 cartas del mazo y las muestra al usuario
    //notifica al usuario si falla debido a falta de cartas disponibles
    public void hand(){
        if(remainingCards >= 5){
            //siempre se utiliza la posicion 0 dado que se van removiendo tras cada impresion
            this.cardDeck.get(0).imprimirCarta();
            this.cardDeck.remove(0);
            this.cardDeck.get(0).imprimirCarta();
            this.cardDeck.remove(0);
            this.cardDeck.get(0).imprimirCarta();
            this.cardDeck.remove(0);
            this.cardDeck.get(0).imprimirCarta();
            this.cardDeck.remove(0);
            this.cardDeck.get(0).imprimirCarta();
            this.cardDeck.remove(0);
            this.remainingCards-= 5;
            System.out.println("Quedan " + this.remainingCards);
        }
        else{
            System.out.println("No hay suficientes cartas en el Deck");
        }
    }

    //pick
    //calcula un numero al azar y muestra la carta en dicha posicion
    //posteriormente remueve la carta del mazo
    //notifica al usuario si falla dado que el mazo esta vacio
    public void pick(){
        if(remainingCards > 0){
            //busca un numero al azar dentro del rango de cartas disponibles
            Random randomNumbers = new Random();
            int card = randomNumbers.nextInt(this.remainingCards);
            //muestra la carta
            this.cardDeck.get(card).imprimirCarta();
            //elimina la carta del mazo
            this.cardDeck.remove(card);
            this.remainingCards--;
            System.out.println("Quedan " + this.remainingCards);
        }
        else{
            System.out.println("Ya no hay cartas en el Deck");
        }
    }
}

public class Actividad8 {

    /*
    showMenu
    Requiere un Deck como parametro para poder mandar llamar los metodos correspondientes
    Metodo que pide al usuario un numero y llama un metodo asociado
    Utiliza recursion para mostrar el menu otra vez hasta que el usuario desee salir
    */
    public static void showMenu(Deck mazo){
        int opcion = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nBienvenido a Poker!\nSelecciona una opción:\n1 Mezclar deck\n2 Sacar una carta\n3 Carta al azar\n4 Generar una mano de 5 cartas\n0 Salir\n");
        try {
            opcion = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch(opcion){
            case 0:
                return;
            case 1:
                mazo.shuffle();
                break;
            case 2:
                mazo.head();
                break;
            case 3:
                mazo.pick();
                break;
            case 4:
                mazo.hand();
                break;
            default:
                System.out.println("Opción no valida, por favor inserte un numero del 0 al 4");
                break;
        }
        showMenu(mazo);
    }
    //main
    public static void main(String args[]) {
        //construccion del mazo
        Deck mazo = new Deck();
        showMenu(mazo);
    }
}
