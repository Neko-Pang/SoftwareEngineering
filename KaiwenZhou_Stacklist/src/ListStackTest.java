/**
 * 
 */

/**
 * ListStackTest: to test the ListStack
 * 
 * @author Kaiwen Zhou
 * @version 0.1
 *
 */
public class ListStackTest
{

	/**
	 * main function class
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ListStack<Object> stackA = new ListStack<Object>();
		stackA.push("Hello");
		stackA.push("It's me.");
		stackA.push(3.58);
		stackA.push(66666);

		stackA.printStack();
		System.out.println("Going to pop out");
		for (; stackA.size() > 0;)
		{
			System.out.println(stackA.pop());
		}

	}

}
