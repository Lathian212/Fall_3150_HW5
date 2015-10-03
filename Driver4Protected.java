import Child.Child;
public class Driver4Protected {

	public static void main(String[] args) {
		Child child = new Child();
		System.out.println("Getting protected variable in Parent through invocation of getter method " +
				" in Child:  child.protectParent()= "+child.protectParent());

	}

}
