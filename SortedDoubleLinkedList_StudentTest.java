//Sohrab Hashemian

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedList_StudentTest {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Color> sortedLinkedColor;
	StringComparator comparator;
	DoubleComparator comparatorD;
	ColorComparator comparatorColor;
	
	public Color a=new Color("Orange", "Secondary");
	public Color b=new Color("Red", "Primary");
	public Color c=new Color("Purple", "Secondary");
	public Color d=new Color("Yellow", "Primary");
	public Color e=new Color("Blue", "Primary");
	public Color f=new Color("Green", "Secondary");
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorColor = new ColorComparator();
		sortedLinkedColor = new SortedDoubleLinkedList<Color>(comparatorColor);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorColor = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedColor = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedColor.add(a);
		sortedLinkedColor.add(b);
		sortedLinkedColor.add(c);
		sortedLinkedColor.add(d);
		ListIterator<Color> iterator = sortedLinkedColor.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulColorPrevious() {
		sortedLinkedColor.add(e);
		sortedLinkedColor.add(c);
		sortedLinkedColor.add(b);
		sortedLinkedColor.add(d);
		ListIterator<Color> iterator = sortedLinkedColor.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(d, iterator.previous());
		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add((Double)8.0);
		sortedLinkedDouble.add((Double)6.0);
		sortedLinkedDouble.add((Double)1.0);
		sortedLinkedDouble.add((Double)2.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)1.0, iterator.next());
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)6.0, iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add((Double)5.0);
		sortedLinkedDouble.add((Double)10.0);
		sortedLinkedDouble.add((Double)8.0);
		sortedLinkedDouble.add((Double)2.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)5.0, iterator.next());
		assertEquals((Double)8.0, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals((Double)8.0, iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedColor.add(e);
		sortedLinkedColor.add(c);
		sortedLinkedColor.add(b);
		sortedLinkedColor.add(d);
		ListIterator<Color> iterator = sortedLinkedColor.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		try{
			iterator.next();
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedColor.add(e);
		sortedLinkedColor.add(c);
		sortedLinkedColor.add(b);
		sortedLinkedColor.add(d);
		ListIterator<Color> iterator = sortedLinkedColor.iterator();
		
		try{
			iterator.remove();
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
	public void testAddColor() {
		sortedLinkedColor.add(a);
		sortedLinkedColor.add(b);
		sortedLinkedColor.add(c);
		assertEquals(a, sortedLinkedColor.getFirst());
		assertEquals(b, sortedLinkedColor.getLast());
		sortedLinkedColor.add(d);
		sortedLinkedColor.add(e);
		assertEquals(e, sortedLinkedColor.getFirst());
		assertEquals(d, sortedLinkedColor.getLast());
		assertEquals(d,sortedLinkedColor.retrieveLastElement());
		assertEquals(b, sortedLinkedColor.getLast());
	}

	@Test
	public void testRemoveFirstColor() {
		sortedLinkedColor.add(b);
		sortedLinkedColor.add(c);
		assertEquals(c, sortedLinkedColor.getFirst());
		assertEquals(b, sortedLinkedColor.getLast());
		sortedLinkedColor.add(a);
		assertEquals(a, sortedLinkedColor.getFirst());
		sortedLinkedColor.remove(a, comparatorColor);
		assertEquals(c, sortedLinkedColor.getFirst());
	}
	
	@Test
	public void testRemoveEndColor() {
		sortedLinkedColor.add(b);
		sortedLinkedColor.add(f);
		assertEquals(f, sortedLinkedColor.getFirst());
		assertEquals(b, sortedLinkedColor.getLast());
		sortedLinkedColor.add(d);
		assertEquals(d, sortedLinkedColor.getLast());
		sortedLinkedColor.remove(d, comparatorColor);
		assertEquals(b, sortedLinkedColor.getLast());
	}

	@Test
	public void testRemoveMiddleColor() {
		sortedLinkedColor.add(a);
		sortedLinkedColor.add(b);
		assertEquals(a, sortedLinkedColor.getFirst());
		assertEquals(b, sortedLinkedColor.getLast());
		sortedLinkedColor.add(f);
		assertEquals(f, sortedLinkedColor.getFirst());
		assertEquals(b, sortedLinkedColor.getLast());
		assertEquals(3,sortedLinkedColor.getSize());
		sortedLinkedColor.remove(a, comparatorColor);
		assertEquals(f, sortedLinkedColor.getFirst());
		assertEquals(b, sortedLinkedColor.getLast());
		assertEquals(2,sortedLinkedColor.getSize());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class ColorComparator implements Comparator<Color>
	{

		@Override
		public int compare(Color arg0, Color arg1) {
			return arg0.getShade().compareTo(arg1.getShade());
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
