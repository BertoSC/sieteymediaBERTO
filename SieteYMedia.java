package sieteymedia;
import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {
    Baraja baraja;
    Carta[] cartasJugador;
    Carta[] cartasBanca;
    double valor;
    public SieteYMedia() {
        baraja = new Baraja();
        baraja.barajar();
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    
    }
  
    

    /*se simplifican los turnos para facilitar los println en InterfaceConsola,
     de modo que es esa clase la que se encarga de realizar las órdenes a 
     SieteyMedia e imprimir los mensajes necesarios en función de estos resultados
    */
    void turnoJugador() {
             Carta c = baraja.darCartas(1)[0];
            
            insertarCartaEnArray(cartasJugador, c);
            valor = valorCartas(cartasJugador);
            
            }
    
     
   
    void turnoBanca() {
        
        while (valorCartas(cartasBanca) < valorCartas(cartasJugador)) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
        
    }
    
    /*se usan para interactuar con InterfaceConsola, 
    comprueba que el jugador o la banca no se pasan y devuelve true o false*/
    boolean comprobar(){
        double valorCartasJugador = valorCartas(cartasJugador);
        if (valorCartasJugador > 7.5) {
            return true;
        } else {
            return false;
        }
    }
    
    boolean comprobarB(){
        double valorCartasBanca = valorCartas(cartasBanca);
        if (valorCartasBanca > 7.5) {
            return true;
        } else {
            return false;
        }

    }
    

    /*calcula el valor de las cartas */
    double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int val;
        int i = 0;
        while (cartas[i] != null) {
            val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val;
            i++;
        }

        return total;
    }

     /*inserta las cartas en el array en cada turno */ 

    void insertarCartaEnArray(Carta[] cartas, Carta c) {
        // inserta al final detectando el primer null
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;

    }

    

}
