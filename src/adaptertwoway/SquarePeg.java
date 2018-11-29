package adaptertwoway;

public class SquarePeg implements ISquarePeg {

	@Override
	public void insertSquare(String msg) {
		System.out.println("SquarePeg: insertSquare(): " + msg );
	}

}
