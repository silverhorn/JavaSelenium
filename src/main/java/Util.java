
class Calculation
{

    //Here is the place for Classes and methods useful for any page

    public static int Addition(String expression)
    {
        String[] expressionSplit = expression.split("\\s",0);
        int firstNumber = Integer.valueOf(expressionSplit[0]);
        System.out.println("First number is: " + firstNumber);
        int secondNumber = Integer.valueOf(expressionSplit[expressionSplit.length - 1]);
        System.out.println("First number is: " + secondNumber);
        return firstNumber + secondNumber;
    }
}

