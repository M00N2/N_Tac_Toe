import java.util.Scanner;

public class Main
    {
    public static void main(String[] args)
        {

        char[] players = playerInput();//passing players from playerInput to use them in playerAlgorithm
        int boardSize = boardSize();
        playerAlgorithm(players[0], players[1]);// putting players into playerAlgorithm
        //valuePlacement();
        }

    public static char[] playerInput()
        {
        Scanner scanner = new Scanner(System.in);
        char playerinput;
        char player1 = ' ';
        char player2 = ' ';
        System.out.print("Player 1 enter your shape(X or O): ");
        playerinput = Character.toUpperCase(scanner.next().charAt(0));

        while (playerinput != 'X' && playerinput != 'O')
            {
            System.out.print("That is an invalid option try again (X or O): ");
            playerinput = Character.toUpperCase(scanner.next().charAt(0));
            scanner.nextLine();//clearing buffer
            }
        if (playerinput == 'X')
            {
            player1 = 'X';
            player2 = 'O';
            System.out.println("player 1 : " + player1 + "\nplayer 2 : " + player2);
            } else if (playerinput == 'O')
            {
            player1 = 'O';
            player2 = 'X';
            System.out.println("player 1 : " + player1 + "\nplayer 2 : " + player2);
            }
        return new char[]{player1, player2};
        //playerAlgorithm(player1, player2);
        }

    public static int boardSize()//declares board size and builds board
    {
    Scanner scanner = new Scanner(System.in);
    int boardSize;
    System.out.print("Enter Board Size (between 3 & 10): ");
    boardSize = scanner.nextInt();
    while ((boardSize < 3) || (boardSize > 10))
        {
        System.out.print("Invalid amount please enter a number (between 3 & 10): ");
        boardSize = scanner.nextInt();
        }
    char[][] spaces = new char[boardSize][boardSize];// giving the array the size the user gave
    System.out.print("  ");//space to line the nums with columns
    for (int i = 1; i <= spaces.length; i++)//for loop to give the row number labels  ~~~~~~~~~~~~~~~~~ TOP ROW # LABEL ~~~~~~~~~~~~~~~~~
        {
        System.out.print(i + " ");// placing numbers i column
        }
    System.out.print("\n");// \n for setting up the board itself


    for (int i = 1; i <= spaces.length; i++)// doing y movement(up & down)
        {
        System.out.print(i + " ");// printing the numbers for the rows
        for (int j = 2; j <= spaces.length; j++)// doing x momvent(side to side)
            {
            System.out.print('_' + " ");
            }
        System.out.println('_' + "");//ending and moving to next row of board(change output if confused)
        }

    return boardSize;
    }

    public static void valuePlacement()
        {
        System.out.print("it is currently");
        }

    public static void playerAlgorithm(char player1, char player2)
        {

        int currentPlayer = 1;

        for (int i = 1; i <= 10; i++)// MAKE SURE TO CHANGE THE 10 TO THE BOARD SIZE
            {
            char currentPlayerShape = (currentPlayer == 1) ? player1 : player2;// "? player1 : player2" condensed else if statement || if currPlayer = 1 - player 1 goes, else currPlayer = 2 - player 2 goes

            System.out.println("Current Player: " + currentPlayer + " (" + currentPlayerShape + ")");

            currentPlayer = (currentPlayer == 1) ? 2 : 1;//if curplayer = 1; player 2 goes || else player 1 goes

            }

        }
    }