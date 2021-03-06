public class Recursion{

    public static String name(){
	return "Zhang, Steven";
    }

    public static double sqrt(double n){
	if( n < 0){
	    throw new IllegalArgumentException();
	}
	if( n == 0){
	    return n;
	}
	return sqrtH(n, 1);
    }

    private static double sqrtH(double n, double guess){
	double betterGuess = (n / guess + guess) / 2;
	if(closeEnough1(guess, betterGuess)){
	    return betterGuess;
	}

        return sqrtH(n, betterGuess);
    }

	
    private static boolean closeEnough1(double guess1, double guess2){
	if(guess1 - guess2 >= 0){
	    return ((guess1 - guess2) / guess1 <= .0000000001);
	}
	else return ((0 - (guess1 - guess2))/ guess1 <= .0000000001);
    }

    public static void main(String[]args){
    	System.out.println(name());
    	System.out.println(sqrt(1.0));
    	System.out.println(Math.sqrt(7.0));
    	System.out.println(sqrt(2.0));
   	System.out.println(sqrt(4.0));
    	System.out.println(sqrt(7.0));
    	System.out.println(sqrt(100.0));
    }
}
