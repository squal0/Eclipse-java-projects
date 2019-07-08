/**
 * Calculates the value of pie from a given infinite series
 */
package exercises;

/**
 * @author Home
 *
 */
public class PieCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double pi = 4.0;
		double d;
		double sign = -1.0;
		
		System.out.printf("%s%20s\n","term","Value of Pi");
		for (int n = 3; n <= 200000; n++){
			if( n % 2 == 1){
				d = 4.0/n;
				pi += (sign * d);
				sign=- sign;
			}
			System.out.printf("%4d%,20.5f\n",n-2, pi);
		}
	}
}

//final double tolerance = Double.MIN_VALUE; // or some other small number
//double pi = 0.0;
//double denominator= 1.0;

//while (true) {
//final double oldValue = pi;
// pi += (4.0 / denominator);
// if (Math.abs(pi - oldValue) <= tolerance) {
//   break;
// }
// denominator = -1.0 * (denominator + 2.0);
//}

/* If you want more digits in your answer, use the BigDecimal class instead of doubles. */ 