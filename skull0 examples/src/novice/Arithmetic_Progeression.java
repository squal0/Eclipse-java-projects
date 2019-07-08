/**
 * 
 */
package novice;

/**
 * @author Home
 *
 */
public class Arithmetic_Progeression {

	/**
	 * @param args
	 * @return 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//program takes a number array and checks to see
		//if the array is an arithmetic progression or a geometric progression
		int [] numSeq = new int[] {2,4,6,8,10,45};
		System.out.print(arith_geo(numSeq));
		
	}
	public static String arith_geo(int [] numarray){
		if(numarray.length == 0 ){
			return null;
		}
		
		double diff = numarray[1] - numarray[0];
		
		boolean aSeq = true;
		boolean gSeq = true;
		int index  = 2;
		
		while( index < numarray.length - 1){
			if (numarray[index + 1] - numarray[index] != diff){
				aSeq = false;
			}
			index += 1;
		}
		for (int i = 0; i < numarray.length - 2; i++){
			if (numarray[i] * numarray[i + 2] != (numarray[i + 1] ^ 2)){
				gSeq = false;
			}
		}
		for (int i = 0; i < numarray.length - 1; i++){
			if (numarray[i] == 0 && numarray[i + 1] != 0){
				gSeq = false;
			}
		}
		if( aSeq == true){
			return "Arithmetic";
		}
		else if(gSeq == true){
			return "Geometric";
		}
		else{
			return "-1";
		}
	}

}
