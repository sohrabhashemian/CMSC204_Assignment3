//Sohrab Hashemian

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_StudentTest {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Color> linkedColor;
	StringComparator comparator;
	DoubleComparator comparatorD;
	ColorComparator comparatorColor;
	
	public Color a=new Color("Red", "Primary");
	public Color b=new Color("Orange", "Secondary");
	public Color c=new Color("Yellow", "Primary");
	public Color d=new Color("Green", "Secondary");
	public Color e=new Color("Blue", "Primary");
	public Color f=new Color("Purple", "Secondary");

	public ArrayList<Color> fill = new ArrayList<Color>();
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("1234");
		linkedString.addToEnd("zxcv");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(16.67);
		linkedDouble.addToEnd(99.99);
		comparatorD = new DoubleComparator();
		
		linkedColor= new BasicDoubleLinkedList<Color>();
		linkedColor.addToEnd(b);
		linkedColor.addToEnd(c);
		comparatorColor = new ColorComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedColor = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedColor.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("zxcv", linkedString.getLast());
		linkedString.addToEnd("qwer");
		assertEquals("qwer", linkedString.getLast());
		
		assertEquals(c,linkedColor.getLast());
		linkedColor.addToEnd(d);
		assertEquals(d,linkedColor.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("1234", linkedString.getFirst());
		linkedString.addToFront("5678");
		assertEquals("5678", linkedString.getFirst());
		
		assertEquals(b,linkedColor.getFirst());
		linkedColor.addToFront(a);
		assertEquals(a,linkedColor.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("1234", linkedString.getFirst());
		linkedString.addToFront("90");
		assertEquals("90", linkedString.getFirst());
		
		assertEquals(b,linkedColor.getFirst());
		linkedColor.addToFront(a);
		assertEquals(a,linkedColor.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("zxcv", linkedString.getLast());
		linkedString.addToEnd("90");
		assertEquals("90", linkedString.getLast());
		
		assertEquals(c,linkedColor.getLast());
		linkedColor.addToEnd(d);
		assertEquals(d,linkedColor.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Color> list;
		linkedColor.addToFront(a);
		linkedColor.addToEnd(d);
		list = linkedColor.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(d,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront("5678");
		linkedString.addToEnd("90");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("5678", iterator.next());
		assertEquals("1234", iterator.next());
		assertEquals("zxcv", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("90", iterator.next());
		
		linkedColor.addToFront(a);
		linkedColor.addToEnd(d);
		ListIterator<Color> iteratorColor = linkedColor.iterator();
		assertEquals(true, iteratorColor.hasNext());
		assertEquals(a, iteratorColor.next());
		assertEquals(b, iteratorColor.next());
		assertEquals(c, iteratorColor.next());
		assertEquals(true, iteratorColor.hasNext());
		assertEquals(d, iteratorColor.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedColor.addToFront(a);
		linkedColor.addToEnd(d);
		ListIterator<Color> iteratorColor = linkedColor.iterator();
		assertEquals(true, iteratorColor.hasNext());
		assertEquals(a, iteratorColor.next());
		assertEquals(b, iteratorColor.next());
		assertEquals(c, iteratorColor.next());
		assertEquals(d, iteratorColor.next());
		assertEquals(true, iteratorColor.hasPrevious());
		assertEquals(d, iteratorColor.previous());
		assertEquals(c, iteratorColor.previous());
		assertEquals(b, iteratorColor.previous());
		assertEquals(a, iteratorColor.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedColor.addToFront(a);
		linkedColor.addToEnd(d);
		ListIterator<Color> iteratorColor = linkedColor.iterator();		
		assertEquals(true, iteratorColor.hasNext());
		assertEquals(a, iteratorColor.next());
		assertEquals(b, iteratorColor.next());
		assertEquals(c, iteratorColor.next());
		assertEquals(true, iteratorColor.hasNext());
		assertEquals(d, iteratorColor.next());
		
		try{
			//no more elements in list
			iteratorColor.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedColor.addToFront(a);
		linkedColor.addToEnd(d);
		ListIterator<Color> iteratorColor = linkedColor.iterator();		
		assertEquals(true, iteratorColor.hasNext());
		assertEquals(a, iteratorColor.next());
		assertEquals(b, iteratorColor.next());
		assertEquals(c, iteratorColor.next());
		assertEquals(d, iteratorColor.next());
		assertEquals(true, iteratorColor.hasPrevious());
		assertEquals(d, iteratorColor.previous());
		assertEquals(c, iteratorColor.previous());
		assertEquals(b, iteratorColor.previous());
		assertEquals(a, iteratorColor.previous());
		
		try{
			//no more elements in list
			iteratorColor.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedColor.addToFront(a);
		linkedColor.addToEnd(d);
		ListIterator<Color> iteratorColor = linkedColor.iterator();		
		assertEquals(true, iteratorColor.hasNext());
		assertEquals(a, iteratorColor.next());
		assertEquals(b, iteratorColor.next());
		assertEquals(c, iteratorColor.next());
		assertEquals(true, iteratorColor.hasNext());
		assertEquals(d, iteratorColor.next());
		
		try{
			//remove is not supported for the iterator
			iteratorColor.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(b, linkedColor.getFirst());
		assertEquals(c, linkedColor.getLast());
		linkedColor.addToFront(a);
		assertEquals(a, linkedColor.getFirst());
		linkedColor.remove(a, comparatorColor);
		assertEquals(b, linkedColor.getFirst());
		//remove from the end of the list
		linkedColor.addToEnd(d);
		assertEquals(d, linkedColor.getLast());
		linkedColor.remove(d, comparatorColor);
		assertEquals(c, linkedColor.getLast());
		//remove from middle of list
		linkedColor.addToFront(a);
		assertEquals(a, linkedColor.getFirst());
		assertEquals(c, linkedColor.getLast());
		linkedColor.remove(b, comparatorColor);
		assertEquals(a, linkedColor.getFirst());
		assertEquals(c, linkedColor.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(b, linkedColor.getFirst());
		linkedColor.addToFront(a);
		assertEquals(a, linkedColor.getFirst());
		assertEquals(a, linkedColor.retrieveFirstElement());
		assertEquals(b,linkedColor.getFirst());
		assertEquals(b, linkedColor.retrieveFirstElement());
		assertEquals(c,linkedColor.getFirst());
		
		assertEquals("1234", linkedString.getFirst());
		linkedString.addToFront("90");
		assertEquals("90", linkedString.getFirst());
		assertEquals("90", linkedString.retrieveFirstElement());
		assertEquals("1234",linkedString.getFirst());
		assertEquals("1234", linkedString.retrieveFirstElement());
		assertEquals("zxcv",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedColor.getLast());
		linkedColor.addToEnd(d);
		assertEquals(d, linkedColor.getLast());
		assertEquals(d, linkedColor.retrieveLastElement());
		assertEquals(c,linkedColor.getLast());
		
		assertEquals("zxcv", linkedString.getLast());
		linkedString.addToEnd("90");
		assertEquals("90", linkedString.getLast());
		assertEquals("90", linkedString.retrieveLastElement());
		assertEquals("zxcv",linkedString.getLast());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class ColorComparator implements Comparator<Color>
	{

		@Override
		public int compare(Color arg0, Color arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Color{
		String shade;
		String trait;
		
		public Color(String shade, String trait){
			this.shade = shade;
			this.trait = trait;
		}
		
		public String getShade(){
			return shade;
		}
		public String getTrait(){
			return trait;
		}
		
		public String toString() {
			return (getShade()+" "+getTrait());
		}
	}
}
