package composition;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

public class InstrumentedSet implements Set {

	private final Set mySet;
	private int addCount = 0;
	
	//default constructor
	public InstrumentedSet (){
		mySet = new HashSet();		
	}
	
	//constructor
	public InstrumentedSet(Set s) {this.mySet = s;}

	public boolean add(Object o) {
			addCount++;
			return mySet.add(o);
	}
	
	public boolean addAll(Collection c) {
			addCount += c.size();
			return mySet.addAll(c);
		}
	
	public int getAddCount() {return addCount;}

	@Override
	public void clear() {
		mySet.clear();
	}

	@Override
	public boolean contains(Object aSetObject) {
		return mySet.contains(aSetObject);
	}

	@Override
	public boolean containsAll(Collection sets) {
		return mySet.containsAll(sets);
	}

	@Override
	public boolean isEmpty() {
		return mySet.isEmpty();
	}

	@Override
	public Iterator iterator() {
		return mySet.iterator();
	}

	@Override
	public boolean remove(Object objToRemove) {
		return mySet.remove(objToRemove);
	}

	@Override
	public boolean removeAll(Collection objectCollectionToRemove) {
		return mySet.removeAll(objectCollectionToRemove);
	}

	@Override
	public boolean retainAll(Collection collToRetain) {
		return mySet.retainAll(collToRetain);
	}

	@Override
	public int size() {
		return mySet.size();
	}

	@Override
	public Object[] toArray() {
		return mySet.toArray();
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		return mySet.toArray(arg0);
	}

	
}
