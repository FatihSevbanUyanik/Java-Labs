import java.util.Scanner;

public class Lab07b
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner( System.in );

        // variables
        Stack stack;

        // program code

        // heading
        System.out.println( "*****STACK GAME*****" );
        System.out.println( "********************\n" );
        stack = new Stack();

        // requesting and reading a phrase from the user.
        System.out.print( "Please enter a phrase : " );
        String phrase = scanner.nextLine();

        for ( int i = 0 ; i < phrase.length() ; i++ )
        {
            // if char is a digit pushing it to stack.
            if ( Character.isDigit( phrase.charAt(i) ) )
                stack.push( phrase.charAt(i) + "" );

            else // if char is an operator
            {
                // getting the values in the stack.
                int secondNumber = Integer.parseInt( stack.pop() );
                int firstNumber  = Integer.parseInt( stack.pop() );

                // making calculations
                if ( phrase.charAt(i) == '+' )
                    stack.push( ( firstNumber + secondNumber ) + "" );

                else if ( phrase.charAt(i) == '-' )
                    stack.push( ( firstNumber - secondNumber ) + "" );

                else if ( phrase.charAt(i) == '*' )
                    stack.push( ( firstNumber * secondNumber ) + "" );

                else if ( phrase.charAt(i) == '/' )
                    stack.push( ( firstNumber / secondNumber ) + "" );
            }
        }

        // printing result.
        System.out.println( "RESULT : " + stack.pop() );
    }
}