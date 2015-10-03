/**
 * 
 * @author Lathian: Jonathan Kwiat
 * MonteCarlo Estimate of PI
 * I found the discussion at http://www.eveandersson.com/pi/monte-carlo-circle
 * very helpful in understanding and solving this problem.
 * 
 * Imagine the right quadrant of a circle of radius R that has a square drawn over
 * it whose side is length R. The area of the circle = PI * R^2, the area of just the
 * right quadrant is PI*R^2/4 and the area of the Square = R^2. 
 * 
 * ANS to: "The ratio of the area of the top right quadrant of the circle to the square that
 *  covers it would be...?" is PI/4
 *  
 *  Since all dots will fall in the sqaure M/N = PI/4, where N is the total number of
 *  points (4,000,000,000) and M is the number that falls in the quarter circle. Rearranging
 *  this gives.
 *  
 *  PI = (M *4)/N
 *
 */
import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;
public class MonteCarloPI {
	final static double EPSILON = 1E-14;
	final static int R =10_000;

	public static void main(String[] args) {
		//Using Random class so can get values 0 to 10 inclusive
		Random random = new Random();
		//API says this IntStream will be effectively unlimited.
		//Ranges from inclusive 0 to exclusive 1001
		IntStream intStream = random.ints(8_000_000_000L, 0, (R+1));
		Iterator<Integer> intGetter = intStream.iterator();
		
		long mCircle =0;
		long nTotal = 0;
		long outSquare = 0;
		System.out.println("Starting Monte Carlo estimate of PI with an R of: " + R +
				" and 4 billion points.");
		while (intGetter.hasNext()) {
			//Below test from distance formula whether inside circle or not
			if ((int) Math.pow(intGetter.next(), 2) + (int) Math.pow(intGetter.next(), 2) 
				<= (int) Math.pow(R, 2)) {
					mCircle++;
				}
			else {
				outSquare++;
			}
			nTotal++;
			/*
			if (nTotal%100_000_000 == 0){
				System.out.println("Working...");
			}
			*/
		}
		System.out.println("M The total number of points falling in the circle = " + mCircle);
		System.out.println("The total number of points falling just in the square = " + outSquare);
		System.out.println("N, the total number of points = " + nTotal);
		System.out.println("A monte carlo estimate of PI = (M*4)/N = " + ((double)mCircle*4/nTotal));
		System.out.println("Actual value of PI= " + Math.PI);
	}

}
