package com.company;

// Tasks to Do
// Give player choice to go first or last
// Intelligent AI
// Choice of easy or hard AI
//
import java.util.*;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> playerPosition2 = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args) {
//        Empty Board and prints after
        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Scanner inputNumPlayers = new Scanner(System.in);
        int numPlayers = 0;

        while (numPlayers != 1 && numPlayers != 2) {
            System.out.println("Enter the number of players (1 or 2): ");
            try {
                numPlayers = inputNumPlayers.nextInt();
                if (numPlayers < 1 || numPlayers > 2) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter 1 or 2");
                inputNumPlayers.nextLine();
            }
        }

        if (numPlayers == 1) {
            Scanner inputName = new Scanner(System.in);
            String playerName = "";

            while (playerName.equals("")) {
                System.out.println("Enter your name: ");
                playerName = inputName.nextLine();
                // Check if name contains only letters
                if (!playerName.matches("[a-zA-Z]+")) {
                    System.out.println("Name must contain only letters. Please try again.");
                    playerName = "";
                }
            }
            Scanner inputSymbol = new Scanner(System.in);
            char playerSymbol = 'X';
            char cpuSymbol = 'O';

            while (true) {
                System.out.println("Do you want to be X or O?");
                String symbolInput = inputSymbol.nextLine();
                if (symbolInput.equalsIgnoreCase("X")) {
                    playerSymbol = 'X';
                    cpuSymbol = 'O';
                    break;
                } else if (symbolInput.equalsIgnoreCase("O")) {
                    playerSymbol = 'O';
                    cpuSymbol = 'X';
                    break;
                } else {
                    System.out.println("Invalid input, please choose X or O");
                }
            }

            System.out.println("Player is " + playerSymbol + ",Cpu is " + cpuSymbol);


            Scanner inputFirst = new Scanner(System.in);
            int first = 0;
            while (true) {
                System.out.println("Do you want to go first or last? Enter 1 for first or 2 for last.");
                first = inputFirst.nextInt();
                if (first == 1 || first == 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 1 for first or 2 for last.");
                }
            }

            if (first == 1) {
                System.out.println("You will go first.");
                printBoard(board);
                while (true) {
                    Scanner inputPlacement = new Scanner(System.in);
                    System.out.println("Enter placement of your symbol (1-9): ");
//            Player inputPlacement / player position
                    int playerPosition = inputPlacement.nextInt();
                    while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
                        System.out.println("Position taken! Enter another position");
                        playerPosition = inputPlacement.nextInt();
                    }
//            Displays who have won
                    String result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
//            Places the symbol in the player position inputPlacement
                    placeSymbol(board, playerPosition, "player", playerSymbol, cpuSymbol);
                    Random rand = new Random();
                    int cpuPosition = rand.nextInt(9) + 1;
                    while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
                        cpuPosition = rand.nextInt(9) + 1;
                    }
                    placeSymbol(board, cpuPosition, "cpu", playerSymbol, cpuSymbol);
                    printBoard(board);
                    System.out.println("Player position at " + playerPosition);
                    System.out.println("Cpu position at " + cpuPosition);

                    result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
                }
            } else {
                System.out.println("You will go second.");
                while (true) {
                    Random rand = new Random();
                    int cpuPosition = rand.nextInt(9) + 1;
                    while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
                        cpuPosition = rand.nextInt(9) + 1;
                    }
                    placeSymbol(board, cpuPosition, "cpu", playerSymbol, cpuSymbol);
                    printBoard(board);
                    System.out.println("Cpu position at " + cpuPosition);
                    String result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
                    Scanner inputPlacement = new Scanner(System.in);
                    System.out.println("Enter placement of your symbol (1-9): ");
//            Player inputPlacement / player position
                    int playerPosition = inputPlacement.nextInt();
                    while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
                        System.out.println("Position taken! Enter another position");
                        playerPosition = inputPlacement.nextInt();
                    }
//            Displays who have won
                    result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
//            Places the symbol in the player position inputPlacement
                    placeSymbol(board, playerPosition, "player", playerSymbol, cpuSymbol);
                    printBoard(board);
                    System.out.println("Player position at " + playerPosition);

                    result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }

                }
            }
        }
        else{
            Scanner inputName = new Scanner(System.in);
            Scanner inputName2 = new Scanner(System.in);
            String playerName = "";
            String playerName2 = "";

            while (playerName.equals("")) {
                System.out.println("First player enter your name: ");
                playerName = inputName.nextLine();
                // Check if name contains only letters
                if (!playerName.matches("[a-zA-Z]+")) {
                    System.out.println("Name must contain only letters. Please try again.");
                    playerName = "";
                }
            }
            while (playerName2.equals("")) {
                System.out.println("Second player enter your name: ");
                playerName2 = inputName2.nextLine();
                // Check if name contains only letters
                if (!playerName2.matches("[a-zA-Z]+")) {
                    System.out.println("Name must contain only letters. Please try again.");
                    playerName2 = "";
                }
            }
            Scanner inputSymbol = new Scanner(System.in);
            char playerSymbol = 'X';
            char playerSymbol2 = 'O';

            while (true) {
                System.out.println("Do you want to be X or O?");
                String symbolInput = inputSymbol.nextLine();
                if (symbolInput.equalsIgnoreCase("X")) {
                    playerSymbol = 'X';
                    playerSymbol2 = 'O';
                    break;
                } else if (symbolInput.equalsIgnoreCase("O")) {
                    playerSymbol = 'O';
                    playerSymbol2 = 'X';
                    break;
                } else {
                    System.out.println("Invalid input, please choose X or O");
                }
            }

            System.out.println("Player 1 is " + playerSymbol + ",Player 2 is " + playerSymbol2);


            Scanner inputFirst = new Scanner(System.in);
            int first = 0;
            while (true) {
                System.out.println("Do you want to go first or last? Enter 1 for first or 2 for last.");
                first = inputFirst.nextInt();
                if (first == 1 || first == 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 1 for first or 2 for last.");
                }
            }

            if (first == 1) {
                System.out.println("You will go first.");
                printBoard(board);
                while (true) {
                    Scanner inputPlacement = new Scanner(System.in);
                    System.out.println("Enter placement of your symbol (1-9): ");
//            Player inputPlacement / player position
                    int playerPosition = inputPlacement.nextInt();
                    while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
                        System.out.println("Position taken! Enter another position");
                        playerPosition = inputPlacement.nextInt();
                    }
//            Displays who have won
                    String result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
//            Places the symbol in the player position inputPlacement
                    placeSymbol(board, playerPosition, "player", playerSymbol, playerSymbol2);
                    Random rand = new Random();
                    int cpuPosition = rand.nextInt(9) + 1;
                    while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
                        cpuPosition = rand.nextInt(9) + 1;
                    }
                    placeSymbol(board, cpuPosition, "cpu", playerSymbol, playerSymbol2);
                    printBoard(board);
                    System.out.println("Player position at " + playerPosition);
                    System.out.println("Cpu position at " + cpuPosition);

                    result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
                }
            } else {
                System.out.println("You will go second.");
                while (true) {
                    Random rand = new Random();
                    int cpuPosition = rand.nextInt(9) + 1;
                    while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
                        cpuPosition = rand.nextInt(9) + 1;
                    }
                    placeSymbol(board, cpuPosition, "cpu", playerSymbol, playerSymbol2);
                    printBoard(board);
                    System.out.println("Cpu position at " + cpuPosition);
                    String result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
                    Scanner inputPlacement = new Scanner(System.in);
                    System.out.println("Enter placement of your symbol (1-9): ");
//            Player inputPlacement / player position
                    int playerPosition = inputPlacement.nextInt();
                    while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
                        System.out.println("Position taken! Enter another position");
                        playerPosition = inputPlacement.nextInt();
                    }
//            Displays who have won
                    result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }
//            Places the symbol in the player position inputPlacement
                    placeSymbol(board, playerPosition, "player", playerSymbol, playerSymbol2);
                    printBoard(board);
                    System.out.println("Player position at " + playerPosition);

                    result = checkWinner(playerName);
                    if (result.length() > 0) {
                        System.out.println(result);
                        break;
                    }

                }
            }
        }
    }

    // Prints board
    public static void printBoard(char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }
//
//    --------------------------------- Need to edit to let player choose to be X or O
//
    public static void placeSymbol(char[][] board, int position, String user, char playerSymbol, char cpuSymbol){
        char symbol = user.equals("player") ? playerSymbol : cpuSymbol;
        if(user.equals("player")){
            symbol = playerSymbol;
            playerPositions.add(position);
        }else if(user.equals("cpu")){
            symbol = cpuSymbol;
            cpuPositions.add(position);
        }
        switch(position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
        }
    }
//    Checks winner if winner has one of the winning conditions
    public static String checkWinner(String playerName){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);

        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(cross1);
        win.add(cross2);


        for(List l : win){
            if(playerPositions.containsAll(l)){
                return playerName +",You have won!";
            }else if(cpuPositions.containsAll(l)){
                return "Cpu has won!";
            }else if(playerPositions.size() + cpuPositions.size() == 9 ){
                return "Draw";
            }
        }
        return "";
    }
}
