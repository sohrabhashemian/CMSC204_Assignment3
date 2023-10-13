//Sohrab Hashemian

import java.util.*;

public class BasicDoubleLinkedList<T> implements Iterable<T>
{
	/*
	 * Variables
	 */
	public Node head;
	public Node tail;
	public int size;

	/*
	 * First inner class
	 */
	public class Node
	{
		/*
		 * Variables
		 */
		public T data;
		public Node next;
		public Node prev;

		/*
		 * First inner constructor
		 */
		public Node(T data , Node next , Node prev)
		{
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	/*
	 * Second inner class
	 */
	public class DoubleLinkedListIterator implements ListIterator<T>
	{
		/*
		 * Variables
		 */
		private Node current;
		private Node last;
		
		/*
		 * Second inner constructor
		 */
		public DoubleLinkedListIterator()
		{
			current = head;
			last = null;
		}
		
		/*
		 * Implemented from ListIterator (for the iterator method)
		 */
		@Override
		public boolean hasNext()
		{
			if (current == null)
			{
				return false;
			}
			return true;
		}
		
		/*
		 * Implemented from ListIterator (for the iterator method)
		 */
		@Override
		public boolean hasPrevious()
		{
			if (last == null)
			{
				return false;
			}
			return true;
		}
		
		/*
		 * Implemented from ListIterator (for the iterator method)
		 */
		@Override
		public T next() throws NoSuchElementException
		{
			if(hasNext())
			{
				T data = current.data;
				last = current;
				current = current.next;
				if ( hasNext() )
				{
					current.prev = last;
				}
				return data;	
			}
			else
			{
				throw new NoSuchElementException();	
			}
		}
		
		/*
		 * Implemented from ListIterator (for the iterator method)
		 */
		@Override
		public T previous() throws NoSuchElementException
		{
			if ( hasPrevious() )
			{
				current = last;
				last = current.prev;
				T data = current.data;
				return data;
			}
			else
			{
				throw new NoSuchElementException();
			}
		}

		/*
		 * all other methods can throw the UnsupportedOperationException
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		/*
		 * all other methods can throw the UnsupportedOperationException
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		/*
		 * all other methods can throw the UnsupportedOperationException
		 */
		@Override
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		/*
		 * all other methods can throw the UnsupportedOperationException
		 */
		@Override
		public void set(T e)  throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		/*
		 * all other methods can throw the UnsupportedOperationException
		 */
		@Override
		public void add(T e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
			
	}
	
	/**
	 * Constructor to set to initialize head, tail and size to null, null and 0
	 */
	public BasicDoubleLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Returns the number of nodes in the list. Notice: Do not traverse the list to compute the size. This method just returns the value of the instance variable you use to keep track of size.
	 * @return the size of the linked list
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Adds an element to the end of the list and updated the size of the list. DO NOT use iterators to implement this method.
	 * @param data - the data to be added to the list
	 */
	public void addToEnd(T data)
	{
		Node q = new Node(data, null, tail);
		
		if (tail != null)
		{
			tail.next = q;
		}
		tail = q;
		
		if (head == null)
		{
			head = q;
		}
		size++;
	}
	
	/**
	 * Adds element to the front of the list and updated the size of the list. Do not use iterators to implement this method.
	 * @param data - the data to be added to the list
	 */
	public void addToFront (T data)
	{
		Node q = new Node(data , head , null);
		
		if (head != null)
		{
			head.prev = q;
		}
		head = q;
		
		if (tail == null)
		{
			tail = q;
		}
		size++;
	}

	/**
	 * Returns but does not remove the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getFirst()
	{
		if(head.data == null)
		{
			return null;
		}
		return head.data;
	}
	
	/**
	 * Returns but does not remove the last element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getLast()
	{
		if(tail.data == null)
		{
			return null;
		}
		return tail.data;
	}
	
	/**
	 * This method returns an object of the DoubleLinkedListIterator. (the inner class that implements java's ListIterator interface)
	 * @return a ListIterator object
	 */
	@Override
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Removes the first instance of the targetData from the list. Notice that you must remove the elements by performing a single traversal over the list. You may not use any of the other retrieval methods associated with the class in order to complete the removal process. You must use the provided comparator (do not use equals) to find those elements that match the target. Do not implement this method using iterators.
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the targetData or null
	 */
	public BasicDoubleLinkedList.Node remove(T targetData, Comparator<T> comparator)
	{
		Node current = head;
		Node prev = null;
		
		while (current != null)
		{
			if (comparator.compare(current.data, targetData) == 0)
			{
				if(current == head)
				{
					current = head.next;
					head = head.next;
				}
				else if (current == tail)
				{
					current = null;
					tail = prev;
					prev.next = null;
				}
				else
				{
					prev.next = current.next;
					current = current.next;
				}
				size--;
			}
			else
			{
				prev = current;
				current = current.next;
			}
		}
		return current;
	}
	
	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveFirstElement()
	{
		Node temp = head;
		
		if(size == 0)
		{
			return null;
		}
		
		size--;
		head = head.next;
		head.prev = null;
		
		return temp.data;
	}
	
	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null. Do not implement implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveLastElement()
	{
		Node current = head;
		Node prev = null;
		
		if (size == 0)
		{
			return null;
		}
		size --;
		
		while (current != null)
		{
			if (current.equals(tail))
			{
				tail = prev;
				break;
			}
			prev = current;
			current = current.next;
		}
		
		return current.data;
	}
	
	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return an arraylist of the items in the list
	 */
	public ArrayList <T> toArrayList()
	{
		ArrayList<T> array = new ArrayList<T>();
		ListIterator<T> iterator = new DoubleLinkedListIterator();
		while(iterator.hasNext())
		{
			array.add(iterator.next());
		}
			return array;
	}
}