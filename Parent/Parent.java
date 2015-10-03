package Parent;
public class Parent {
	// I added a private field to see for myself that the child has no direct access. 
	private int abc;
	protected int protect;
	public Parent() {
		abc = 66;
		protect = 888;
	}
	// If there are to be private fields public getter and setter methods need to be in parent
	// if children are to be able to access them directly. They cannot be in child because there
	// is no visibility of private fields of the parent. 
	public int getter() {
		return abc;
	}
	public void setter(int abc) {
		this.abc = abc;
	}

}
