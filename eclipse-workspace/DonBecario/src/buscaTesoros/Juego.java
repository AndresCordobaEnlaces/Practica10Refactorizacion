package buscaTesoros;

import java.util.Random;
import java.util.Scanner;

public class Juego {

	private static final int TAMAÑO = 5;
	private static final int NUM_TESOROS = 5;
	private static final int MAX_INTENTOS = 7;

	private static final String SIMBOLO_TESORO = " O ";
	private static final String SIMBOLO_VISITADA = " X ";
	private static final String SIMBOLO_VACIA = " - ";

	private Casilla[][] tablero;
	private int intentos;
	private int tesorosEncontrados;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Iniciando juego...");

		Juego juego = new Juego();
		juego.tablero = new Casilla[TAMAÑO][TAMAÑO];
		juego.intentos = 0;
		juego.tesorosEncontrados = 0;
		juego.limpiarTablero();
		juego.ponerTesoros();

		while (juego.intentos < MAX_INTENTOS && juego.tesorosEncontrados < NUM_TESOROS) {
			System.out.println("Introduce fila:");
			int f = sc.nextInt();
			System.out.println("Introduce columna:");
			int c = sc.nextInt();

			if (f < 0 || f >= TAMAÑO || c < 0 || c >= TAMAÑO) {
				System.out.println("Esa casilla no existe, prueba otra vez.");
				continue;
			}

			juego.verificarCasilla(f, c);
			juego.intentos++;
			juego.imprimirTablero();
		}

		if (juego.tesorosEncontrados == NUM_TESOROS) {
			System.out.println("Has ganado");
		} else {
			System.out.println("Has perdido");
		}

		sc.close();
	}

	private void limpiarTablero() {
		for (int i = 0; i < TAMAÑO; i++) {
			for (int j = 0; j < TAMAÑO; j++) {
				tablero[i][j] = new Casilla();
			}
		}
	}

	private void ponerTesoros() {
		Random r = new Random();
		int colocados = 0;
		while (colocados < NUM_TESOROS) {
			int f = r.nextInt(TAMAÑO);
			int c = r.nextInt(TAMAÑO);
			if (!tablero[f][c].isTesoro()) {
				tablero[f][c].setTesoro(true);
				colocados++;
			}
		}
	}

	private void verificarCasilla(int f, int c) {
		if (tablero[f][c].isTesoro()) {
			System.out.println("Tesoro encontrado!");
			tesorosEncontrados++;
		} else {
			System.out.println("Nada aqui...");
		}
		tablero[f][c].setVisitada(true);
	}

	private void imprimirTablero() {
		for (int i = 0; i < TAMAÑO; i++) {
			for (int j = 0; j < TAMAÑO; j++) {
				if (!tablero[i][j].isVisitada()) {
					System.out.print(SIMBOLO_VACIA);
				} else if (tablero[i][j].isTesoro()) {
					System.out.print(SIMBOLO_TESORO);
				} else {
					System.out.print(SIMBOLO_VISITADA);
				}
			}
			System.out.println();
		}
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

	public int getIntentos() {
		return intentos;
	}

	public int getTesorosEncontrados() {
		return tesorosEncontrados;
	}
}