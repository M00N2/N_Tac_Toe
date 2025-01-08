import java.util.Scanner;

public class Main
    {
    public static void main(String[] args)
        {
        int currPlayer = 0;

        char[] players = playerInput();//passing players from playerInput to use them in playerAlgorithm
        char[][] boardSize = boardSize();
        printboard(boardSize);//prints initial board
        //char currentPlayer = playerAlgorithm(players[0], players[1]);// putting players into playerAlgorithm
        for (int i = 1; i <= Math.pow(boardSize.length, 2); i++)//need to make is to this is the conditions to continue the game
            {
            // need to make so that the playing character changes from x -> o (vica versa)
            char currentPlayer = playerAlgorithm(players[0], players[1], currPlayer);// putting players into playerAlgorithm
            currPlayer ^= 1;
            valuePlacement(boardSize, currentPlayer);
           boolean game = gameAlgorithm(boardSize);

            if(game == true)
            {
            System.out.print("game over");
            break;
            }
            }
        }

    //  ~~~~~~~~~~~~~~~~~~~~~~ no need to mess with for now ~~~~~~~~~~~~~~~~~~~~~~
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
        return new char[]{player1, player2};// returns players in an array
        }

    //  ~~~~~~~~~~~~~~~~~~~~~~ no need to mess with for now ~~~~~~~~~~~~~~~~~~~~~~
    public static char[][] boardSize()//declares board size and builds board
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
        for (int i = 0; i < spaces.length; i++)
            {
            for (int j = 0; j < spaces[i].length; j++)
                {
                spaces[i][j] = '_';//telling the array that these spots are filled with this chacter
                }
            }


        //do a for loop here to the size of the board
        //valuePlacement();//value placement here after board size is made
        return spaces;
        }

    //  ~~~~~~~~~~~~~~~~~~~~~~ no need to mess with for now ~~~~~~~~~~~~~~~~~~~~~~
    public static void printboard(char[][] board)// prints the board that that is made up of chars
        {
        System.out.print("  ");//space to line the nums with columns
        for (int i = 0; i < board.length; i++)//for loop to give the row number labels  ~~~~~~~~~~~~~~~~~ TOP ROW # LABEL ~~~~~~~~~~~~~~~~~
            {
            System.out.print(i + 1 + " ");// placing numbers i column
            }
        System.out.print("\n");// \n for setting up the board itself

        for (int i = 0; i < board.length; i++)// doing y movement(up & down)
            {
            System.out.print((i + 1) + " ");// printing the numbers for the rows
            for (int j = 0; j < board[i].length; j++)// doing x momvent(side to side)
                {
                System.out.print(board[i][j] + " ");//game board is using array characters
                }
            System.out.println();//ending and moving to next row of board(change output if confused)
            }
        }

    //  ~~~~~~~~~~~~~~~~~~~~~~ no need to mess with for now ~~~~~~~~~~~~~~~~~~~~~~
    public static char[][] valuePlacement(char[][] board, char currPlayer)
        {
        Scanner scanner = new Scanner(System.in);
        // ask player where they want to place their piece
        System.out.print("Enter where you want to put your peice (↔, ↕): ");// make sure the directions are correct for inputs
        String userInput = scanner.nextLine();//has to be string to get the split

        String[] parts = userInput.split(" "); // Split based on comma Split only works on Strings
        // comma acts as a splitter making so that a border is defined
        int col = Integer.parseInt(parts[0].trim()) - 1; // Adjust for 0-based indexing parsing string for first number
        int row = Integer.parseInt(parts[1].trim()) - 1; // Adjust for 0-based indexing
        //needs to go to gameboard and check if valid move and place @ index location
        // have to access the boards array
        if (board[row][col] == '_')
            {
            board[row][col] = currPlayer;
            printboard(board);
            //need to send the current player shape to update the board to include colation

            } else
            {
            System.out.println("That stop is taken");
            }

        // check if a valid location
        // if valid location place piece
        //go back to player algorithm
        //repeat till board is full or win condition(haven't done win condition yet)
        return null;
        }

    //  ~~~~~~~~~~~~~~~~~~~~~~ no need to mess with for now ~~~~~~~~~~~~~~~~~~~~~~
    public static char playerAlgorithm(char player0, char player1, int currentPlayer)
        {
        char currentPlayerShape = ' ';//will hold X or O (depending on whos turn)
        currentPlayerShape = (currentPlayer == 0) ? player0 : player1;// If currentPlayer equals 1, assign player1's shape to currentPlayerShape; otherwise, assign player2's shape.
        currentPlayer = (currentPlayer == 0) ? 1 : 0;//if curplayer = 0; player 1 goes || else player 0 goes
        return currentPlayerShape;
        }

    public static boolean gameOver(int[][] boardSize)
        {//if true game stops or if max turns reached
        boolean gameOver = false;
        int playerMoves = 0;
        if (playerMoves == (Math.pow(boardSize.length, 2)))//checking if player moves are = to ammount of spaces on board
            {

            } else
            {

            playerMoves++;//if game over condition not met then playerMoves++ to indicate a peice on the board
            }
        return gameOver;
        }

    public static boolean gameAlgorithm(char[][] board)
        {
        //need to check thru array horizontally(easiest?)
        //need to go thru the board horizontally and check if entire row is X or O if then that chacter is winner
        boolean win = false;
        int numOfX = 0;
        int numOfO = 0;
        for (int i = 0; i < board.length; i++)//(up & down)
            {
            for (int j = 0; j < board[i].length; j++)//(side to side)
                {
                if (board[i][j] == 'X')
                    {
                    numOfX++;
                    }
                if (board[i][j] == 'O')
                    {
                    numOfO++;
                    }
                }
            if (numOfX == board[i].length)
                {
                win = true;
                }


            //need to check thru array vertically
            //need to check thru array diagonally (going to be the hardest)

            }
        return win;
        }
    }