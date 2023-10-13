//Sohrab Hashemian

import java.util.*;

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T>
{
	Comparator<T> comparator = null;
	
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param compareableObject - Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject)
	{
		comparator = compareableObject;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list. Notice we can insert the same element several times. Your implementation must traverse the list only once in order to perform the insertion. Do not implement this method using iterators. Notice that you don't need to call any of the super class methods in order to implement this method.
	 * @param data - the data to be added to the list
	 */
	public void add(T data)
	{
		Node q = new Node(data , null , null);
		Node next;
		Node prev;
		
		if (head == null)
		{
			head = new Node (data , null , null);
			tail = head;
		}
		else
		{
			if (comparator.compare( data , (T)head.data) <= 0 )
			{
				q.next = head;
				head = q;
			}
			else if (comparator.compare( data , (T)tail.data) >= 0 )
			{
				tail.next = q;
				tail = q;
			}
			else
			{
				next = head.next;
				prev = head;
				
				while (comparator.compare( data , (T)next.data ) > 0)
				{
					prev = next;
					next = next.next;
				}
				prev.next = q;
				q.next = next;
			}
		}
		size++;
	}
	
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @param data - the data for the Node within the linked list
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @param data - the data for the Node within the linked list
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	@Override
	public void addToFront(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @return an iterator positioned at the head of the list
	 */
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @param data - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the data or null
	 */
	public BasicDoubleLinkedList.Node remove​(T data, Comparator<T> comparator)
	{
		Node previous = null;
		Node current = head;
		
		while(current != null)
		{
			if(comparator.compare((T) current.data, data) == 0)
			{
				size--;
				
				if(previous != null)
				{
					previous.next = current.next;
				}
				else
				{
					head = current.next;
				}
				
				if(current == tail)
				{
					tail = previous;
				}
			}
			
			previous = current;
			current = current.next;
		}
		return current;
	}
}