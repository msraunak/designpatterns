package composition;

import java.util.Arrays;

public class InstrumentedSetClient {

	public static void main(String[] args) {
		InstrumentedSet  mySet = new InstrumentedSet();
		mySet.addAll(
				  Arrays.asList(new String[] 	{"Snap","Crackle","Pop"})
				);
		System.out.println( mySet.getAddCount() );
	}

}
