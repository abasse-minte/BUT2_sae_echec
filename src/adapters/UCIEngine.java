package src.adapters;

import src.useCases.Api;

import java.util.Scanner;

/**
 * Adaptateur UCI (compatible cutechess)
 * Point d'entrée du programme
 */
public class UCIEngine {

    private final Api api;

    public UCIEngine() {
        this.api = new Api();
    }

    public static void main(String[] args) {
        new UCIEngine().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            handle(command);
        }
    }

    private void handle(String command) {

        if (command.equals("uci")) {
            System.out.println("id name MyChessEngine");
            System.out.println("id author Student");
            System.out.println("uciok");
        }

        else if (command.equals("isready")) {
            System.out.println("readyok");
        }

        else if (command.equals("ucinewgame")) {
            api.newGame();
        }

        else if (command.startsWith("position")) {
            handlePosition(command);
        }

        else if (command.equals("go")) {
            // moteur minimal : pas de recherche
            System.out.println("bestmove 0000");
        }

        else if (command.equals("quit")) {
            System.exit(0);
        }
    }

    private void handlePosition(String command) {

        api.newGame();

        if (!command.contains("moves")) {
            return;
        }

        String[] parts = command.split("moves");
        String[] moves = parts[1].trim().split(" ");

        for (String move : moves) {
            boolean ok = api.playMove(move);
            if (!ok) {
                // UCI : on ignore simplement les coups illégaux
                break;
            }
        }
    }
}
