public class Main
    {
    public static void main(String[] args)
        {
// Initialize a 1D array with 5 elements
        char[] array = new char[5];

// Fill the array with '_' characters
        for (int i = 0; i < array.length; i++)
            {
            array[i] = '_';
            }

        // Set the last value to '1'
        array[array.length - 1] = '_';

// Print the array
        boolean allTheSame = true;
        for (int i = 0; i < array.length; i++)
            {
            if (array[i] != '_')
                {
                allTheSame = false;
                break;
                }
            }
        if (allTheSame)
            {
            System.out.print("pure");
            } else
            {
            System.out.print("not pure");
            }

        }
    }