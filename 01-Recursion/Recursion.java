public class Recursion{

    public static String name(){
	return "Zhang, Steven";
    }

    public static double sqrt(double n){
	if( n < 0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n, 1);
    }

    private static double sqrtHelper(double n, double guess){
	double betterGuess = (n / guess + guess) / 2;
	if(closeEnough(guess, betterGuess)){
	    return betterGuess;
	}
	return sqrtHelper(n, betterGuess);
    }

	
    private static boolean closeEnough(double guess1, double guess2){
	if(guess1 - guess2 >= 0){
	    return ((guess1 - guess2) / guess1 <= .0000000001);
	}
	else return ((0 - (guess1 - guess2))/ guess1 <= .0000000001);
    }

    public static void main(String[]args){
	System.out.println(name());
	System.out.println(sqrt(100));
	System.out.println(sqrt(4));
	System.out.println(sqrt(7));
	System.out.println(sqrt(17));
	System.out.println(sqrt(57));
    }
}