/**
 * 
 */
package novice;

/**
 * @author Home
 *
 */
public class FindMaxMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {2,45,677,33,344,67,33,78,6,33,446,4478,7444};
		int [] large_small = findMaxMin(nums);
		
		for (int num : large_small){
			System.out.println(num);
		}
		}

	public static int [] findMaxMin(int [] num_list){
		int len = num_list.length;
		int [] large_small = new int [2];
		int smallest = 0;
		int largest = 0;
		
		for (int num : num_list ){
			smallest = num;
			for (int small : num_list){
				if ( small < smallest){
					smallest = small;
				}
			}
			
		}
		for (int num : num_list){
			if(num > largest){
				largest = num;
			}
		}
		
		if(largest == smallest){
			large_small[0] = len;
			return large_small;
		}
		
		large_small[0] = smallest;
		large_small[1] = largest;
		return large_small;
		
	}
}
