package composition;

import java.util.Collection;
import java.util.HashSet;
/**
 * The InstrumentedHashSet counts the number of attempted element 
 * @author raunak
 *
 */
public class InstrumentedHashSet extends HashSet{

	private int addCount = 0;
	//constructor
	
	public InstrumentedHashSet(){
		super();
	}
	
	public InstrumentedHashSet(Collection c) {
		super (c);
	}
	
	public InstrumentedHashSet(int initCap, float loadFactor)
	{
		super (initCap, loadFactor);		
		
	}
	
	@Override
	public boolean add(Object o) {
		addCount++;
		return super.add(o);
	}
	
	// what assumption have we made 
	@Override
	public boolean addAll(Collection c) {
		addCount += c.size();
		return super.addAll(c);
	}
	public int getAddCount() {
		return addCount;
	}
}
