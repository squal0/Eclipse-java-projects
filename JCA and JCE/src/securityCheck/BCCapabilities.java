/**
 * 
 */
package securityCheck;

/**
 * @author Squalo
 *provides a list of the provider capabilities
 */
import java.security.Security;
import java.security.Provider;
import java.util.Iterator;
public class BCCapabilities {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Provider provider  = Security.getProvider("BC");
Iterator<Object> it  = provider.keySet().iterator();

while (it.hasNext()){
	String entry = (String) it.next();
	if(entry.startsWith("Alg.Alias.")){
		entry  = entry.substring("Alg.Alias".length());
	}
	String factoryClass  = entry.substring(0, entry.indexOf('.'));
	String name = entry.substring(factoryClass.length() + 1);
	System.out.println(factoryClass + ": " + name);
}
	}

}
