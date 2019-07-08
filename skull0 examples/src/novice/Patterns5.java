/**
 * Uses nested for loop to print patterns
 */
package novice;

/**
 * @author Home
 *
 */
public class Patterns5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
		    for (int j = 1; j <= i; j++) {
		        System.out.print("*");
		    }
		    System.out.println();
		}
		System.out.println("-----------------------------");
		
		for (int a = 10; a >= 1; a--) {
			
			for( int b = 1; b <= a; b++){
				System.out.print("*");
			}
		System.out.println();
		}
		System.out.println("-----------------------------");
		
		for(int k = 10; k >= 1; k--){
			for(int l = 1; l <= k; l++){
				System.out.print(' ');
			}
			for(int m = 10; m >= k; m--){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-----------------------------");
		
		for (int n = 1; n <= 10; n++) {
			for( int o = 1; o <= n; o++){
				System.out.print(' ');
			}
			for(int p = 10; p >= n; p--){
				System.out.print("*");
			}
		System.out.println();
		}
		System.out.println("Pyramid:");
		System.out.println("-----------------------------");
		
		for (int i = 1; i <= 10; i++) {
            for (int s = 10; s > i; s--) {
                System.out.print(' ');
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 1; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= 10; i++) {
            for (int s = 1; s < i; s++) {
                System.out.print(' ');
            }
            for (int j = 10; j > i; j--) {
                System.out.print("*");
            }
            for (int j = 10; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

	}


