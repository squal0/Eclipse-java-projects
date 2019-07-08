/**
 * 
 */
package novice;

/**
 * @author Home
 *
 */
public class FindMissing {

	/**
	 * @param args
	 * @return 
	 */
	//functions finds the missing number when given 2 arrays
	public static int findMissing( int[] ary1, int[] ary2){
		int missing = 0;
		
		if((ary1.length & ary2.length) == 0){
			return 0;
		}
		if(ary1.equals(ary2)){
			return 0;
		}
		for(int num = 0; num < ary2.length; num++){
			if(contains(ary1, ary2[num])){
				missing = ary2[num];
			}
		}
		return missing;
		}
	
	public static boolean contains(int[] arr, int item) {
	      for (int n : arr) {
	         if (item == n) {
	            return true;
	         }
	      }
	      return false;
	   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //calling the above static methods
		int [] array1 = {23, 45, 12, 677};
		int [] array2 = {45, 23, 677, 12};
		
		System.out.println(findMissing(array1, array2));
		
	}
}
