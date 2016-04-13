package ch.csbe.ad.datastructure;

/**
 * The <code>MyStack</code> interface represents a last-in-first-out
 * (LIFO) stack of objects. 
 * @author  Enrico Buchs
 * @since   JDK1.8
 * @version 1
 */
public interface MyStack<E> {

	/**
     * Pushes an item onto the top of this stack. 
     * 
     * @param   item   the item to be pushed onto this stack.
     * @return  the <code>item</code> argument.
     */
	public E push(E elem);
	
	/**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack (the last item object).
     */
	public E pop();
	
}
