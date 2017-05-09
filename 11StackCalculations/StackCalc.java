import java.util.Stack;

public class StackCalc{

    public static Double eval(String s){
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();

	for(String token : tokens){
	    if(isOp(token)){
		Double b = values.pop();
		Double a = values.pop();
		values.push(apply(token, a, b));
	    }
	    else{
		values.push(Double.parseDouble(token));
	    }
	}
	return values.pop();
    }

    private static boolean isOp(String s){
	return s.equals("+") ||
	       s.equals("-") ||
	       s.equals("*") ||
	       s.equals("/") ||
	       s.equals("%"); 
    }

    private static double apply(String op, double d1, double d2){
	if(op.equals("+")){
	    return d1 + d2;
	}
	if(op.equals("-")){
	    return d1 - d2;
	}
	if(op.equals("*")){
	    return d1 * d2;
	}
	if(op.equals("/")){
	    return d1 / d2;
	}
	return d1 % d2;

    }
    public static void main(String[] args) {
	System.out.println(StackCalc.eval("10 2 +"));//12.0
	System.out.println(StackCalc.eval("10 2 -"));//8.0
	System.out.println(StackCalc.eval("10 2.0 +"));//12.0
	System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//893.0
	System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
