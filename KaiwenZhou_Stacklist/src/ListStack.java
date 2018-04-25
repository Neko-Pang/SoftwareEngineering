import java.util.ArrayList;

/**
 * 
 */

/**
 * ListStack: using a ArrayList to implement a stack
 * 
 * @version 0.2
 * @author Kaiwen Zhou
 * 
 */

public class ListStack<E>
{
	private ArrayList<E> stack;
	private int stackTop = -1;

	public ListStack()
	{
		stack = new ArrayList<>();
	}

	/**
	 * the basic push method of stack
	 * 
	 * @param element
	 */
	public void push(E element)
	{
		++stackTop;
		stack.add(stackTop, element);
	}

	/**
	 * the basic pop method of stack
	 */
	public E pop()
	{
		E result = stack.get(stackTop);
		stack.remove(stackTop);
		--stackTop;
		return result;
	}

	/**
	 * using the listIterator to print out the whole stack
	 */
	public void printStack()
	{
		int tempPointer = stackTop;
		for (; tempPointer >= 0; tempPointer--)
		{
			System.out.println(stack.get(tempPointer));
		}
	}

	/**
	 * to show the size of stack
	 * 
	 * @return stack.size()
	 */
	public int size()
	{
		return stack.size();
	}
}
