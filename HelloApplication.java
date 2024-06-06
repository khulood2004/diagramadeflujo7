package com.example.cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HelloApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        List<String> baraja = new ArrayList<>();
        for (String palo : palos) {
            for (String valor : valores) {
                baraja.add(valor + " de " + palo);
            }
        }

        Collections.shuffle(baraja);
        int numJugadores = 4;
        List<List<String>> manos = repartirCartas(baraja, numJugadores);

        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Jugador " + (i + 1) + ": " + manos.get(i));
        }
    }

    public static List<List<String>> repartirCartas(List<String> baraja, int numJugadores) {
        List<List<String>> manos = new ArrayList<>();
        int cartasPorJugador = baraja.size() / numJugadores;

        for (int i = 0; i < numJugadores; i++) {
            manos.add(new ArrayList<>(baraja.subList(i * cartasPorJugador, (i + 1) * cartasPorJugador)));
        }

        return manos;
    }
}


