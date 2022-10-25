package ManualLinkedList;

public class ChristianHolderTest {

	public static void main(String[] args) {

		Node testHead = new Node('H', null);
		ChristianHolder test = new ChristianHolder(testHead);

		test.add('E');
		test.add('L');
		test.add('L');
		test.add('O');

		test.printHolder();

		System.out.println("Size of the holder is: " + test.getSize());


	}

}
