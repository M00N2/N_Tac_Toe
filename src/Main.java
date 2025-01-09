import java.util.Scanner;

public class Main
    {
    public static void main(String[] args)
        {
        int currPlayer = 0;

        char[] players = playerInput();//passing players from playerInput to use them in playerAlgorithm
        char[][] boardSize = boardSize();//making board size available in main
        printboard(boardSize);//prints initial board
        for (int i = 1; i <= Math.pow(boardSize.length, 2); i++)//need to make is to this is the conditions to continue the game
            {
            char currentPlayer = playerAlgorithm(players[0], players[1], currPlayer);// putting players into playerAlgorithm
            currPlayer ^= 1;//how the players switch from X & O
            valuePlacement(boardSize, currentPlayer);// function that allows players to place values
            boolean game = gameAlgorithm(boardSize, currentPlayer);// gameAlgo that has win conditions
            if (game)
                {
                System.out.print("game over, " + currentPlayer + " wins!");
                break;
                }
            }
        }

    public static char[] playerInput()
        {
        Scanner scanner = new Scanner(System.in);
        char playerinput;
        char player1 = ' ';
        char player2 = ' ';
        System.out.print("Player 1 enter your shape(X or O): ");
        playerinput = Character.toUpperCase(scanner.next().charAt(0));// getting input from user

        while (playerinput != 'X' && playerinput != 'O')// if not certain chacter then ask again
            {
            System.out.print("That is an invalid option try again (X or O): ");
            playerinput = Character.toUpperCase(scanner.next().charAt(0));
            scanner.nextLine();//clearing buffer
            }
        if (playerinput == 'X')// cond. that makes X player 1
            {
            player1 = 'X';
            player2 = 'O';
            System.out.println("player 1 : " + player1 + "\nplayer 2 : " + player2);
            } else if (playerinput == 'O')// cond. that makes O player 1
            {
            player1 = 'O';
            player2 = 'X';
            System.out.println("player 1 : " + player1 + "\nplayer 2 : " + player2);
            }
        return new char[]{player1, player2};// returns players in an array
        }

    public static char[][] boardSize()//declares board size and builds board
    {
    Scanner scanner = new Scanner(System.in);
    int boardSize;
    System.out.print("Enter Board Size (between 3 & 9): ");
    boardSize = scanner.nextInt();
    while ((boardSize < 3) || (boardSize > 9))
        {
        System.out.print("Invalid amount please enter a number (between 3 & 9): ");
        boardSize = scanner.nextInt();
        }

    char[][] spaces = new char[boardSize][boardSize];// giving the array the size the user gave
    for (int i = 0; i < spaces.length; i++)
        {
        for (int j = 0; j < spaces[i].length; j++)
            {
            spaces[i][j] = '_';//telling the array that these spots are filled with this char
            }
        }
    return spaces;
    }

    public static void printboard(char[][] board)// prints the board that that is made up of chars
    {
    System.out.print("  ");//space to line the nums with columns
    for (int i = 0; i < board.length; i++)//for loop to give the row number labels
        {
        System.out.print(i + 1 + " ");// placing numbers i column
        }
    System.out.print("\n");// \n for setting up the board itself

    for (int i = 0; i < board.length; i++)// doing y movement(up & down)
        {
        System.out.print((i + 1) + " ");// printing the numbers for the rows
        for (int j = 0; j < board[i].length; j++)// doing x movement(side to side)
            {
            System.out.print(board[i][j] + " ");// game board printing chars of array
            }
        System.out.println();// ending and moving to next row of board
        }
    }

    public static void valuePlacement(char[][] board, char currPlayer)
        {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter where you want to put your peice (↔, ↕): ");
        String userInput = scanner.nextLine();// asking for row & col

        String[] parts = userInput.split(" "); // Split based on " "(space)
        int col = Integer.parseInt(parts[0].trim()) - 1; // grabs first value found
        int row = Integer.parseInt(parts[1].trim()) - 1;
        if (board[col][row] == '_')
            {
            board[col][row] = currPlayer;
            printboard(board);
            } else System.out.println("That stop is taken");
        }

    public static char playerAlgorithm(char player0, char player1, int currentPlayer)
        {
        char currentPlayerShape = ' ';// will hold X or O (depending on whos turn)
        currentPlayerShape = (currentPlayer == 0) ? player0 : player1;// If currentPlayer equals 1, assign player1's shape to currentPlayerShape; otherwise, assign player2's shape.
        currentPlayer = (currentPlayer == 0) ? 1 : 0;//if curplayer = 0; player 1 goes || else player 0 goes
        return currentPlayerShape;// returns player to main to be used
        }

    public static boolean gameAlgorithm(char[][] board, char currentPlayer)
        {
        for (int i = 0; i < board.length; i++)//(up & down)
            {
            int verticalCount = 0;
            int horizontalCount = 0;
            // placing variable here resets it every time they go thru loop
            for (int j = 0; j < board[i].length; j++)//(side to side)
                {
                if (board[i][j] == currentPlayer) horizontalCount++;// checking rows
                if (board[j][i] == currentPlayer) verticalCount++;// checking columns
                }
            int diagonalCount = 0;
            int revDiagonalCount = 0;
            for (int j = 0; j < board[i].length; j++)
                {
                if (board[j][j] == currentPlayer) diagonalCount++;// checking diagonals
                if (board[j][board[i].length - 1 - j] == currentPlayer) revDiagonalCount++;
                }// [board[i].length - 1 starts us at the bottom right -1(so we dont go over the index)


            if (horizontalCount == board[i].length || verticalCount == board[i].length || diagonalCount == board[i].length || revDiagonalCount == board[i].length)// if enough pieces are found then win cond. is met
                {
                return true;
                }
            }
        return false;
        }
    }