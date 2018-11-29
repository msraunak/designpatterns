package composition;

import java.util.Arrays;

public class InstrumentedHashSetClient {

	public static void main(String[] args) {
		InstrumentedHashSet  s = new InstrumentedHashSet();
		s.addAll(
				  Arrays.asList(
						  new String[] 	{"Snap","Crackle","Pop"})
				);
		System.out.println( s.getAddCount() );
	}

}
