/**SortTest.java
 * Test methods for testing the Sort.java class
 * 
 * @author ethantwardy
 * Written by Ethan D. Twardy
 * Last edited on March 3, 2017
 * 
 * CS1122 - R02
 */
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.junit.Test;


public class SortTest {
	
	private String [] implemented = {
			"bubblesort", 
			"insertionsort",
			"selectionsort",
			"shellsort",
			"mergesort",
			"quicksort"
			};
	
	/**
	 * Test to see if the method has been implemented ey
	 * @param s
	 * @return boolean = if method is implemented
	 */
	private boolean isImplemented(String s) {
		for (String i : implemented) {
			if (i.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * The standard helper method for testing the sorting algorithms.
	 * This method is called in every test.
	 * @param listcopy - An already sorted copy of the list
	 * @param list - the list
	 * @param low - the low index for sorting (usually 0)
	 * @param high - the high index for sorting (usually list.size())
	 * @param reverse - true if sorting in reverse order
	 */
	private void testAlgorithms(ArrayList<Integer> listcopy, ArrayList<Integer> list,
			int low, int high, boolean reverse) {
		
		Sort sort = new Sort();
		for (Method m : SortInterface.class.getDeclaredMethods()) {
			if (!isImplemented(m.getName())) { continue; }
			try {
				System.out.println("Testing method: " + m.getName());
				m.invoke(sort, list, low, high, reverse);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			Iterator<Integer> intIter = list.iterator();
			for (Integer i : listcopy) {
				if (!i.equals(intIter.next())) {
					System.out.println(m.getName());
					System.out.println(list + "\n" + listcopy);
					fail("Sort error at Method " + m.getName());
				}
			}
		}
	}
	
	/**
	 * Tests an empty list
	 */
	@Test
	public void testEmpty() {
		Sort sort = new Sort();
		for (Method m : SortInterface.class.getDeclaredMethods()) {
			try {
				m.invoke(sort, new ArrayList<Integer>(), 0, 0, false);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Tests a list with one element
	 */
	@Test
	public void testOne() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		int add = (int)(Math.random() * 10) + 1;
		list.add(add); listcopy.add(add);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}
	
	/**
	 * Tests a list with two elements
	 */
	@Test
	public void testTwo() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		list.add(3); listcopy.add(3);
		list.add(2); listcopy.add(2);
		listcopy.sort(null);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}
	
	/**
	 * Tests a list with three elements
	 */
	@Test
	public void testThree() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		list.add(3); listcopy.add(3);
		list.add(2); listcopy.add(2);
		list.add(1); listcopy.add(1);
		listcopy.sort(null);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}
	
	@Test
	public void testHundred() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			int a = (int)(Math.random() * 10) + 1;
			list.add(a); listcopy.add(a);
		}
		listcopy.sort(null);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}
	
	/**
	 * Tests an already sorted list
	 */
	@Test
	public void testSorted() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int a = (int)(Math.random() * 10) + 1;
			list.add(a); listcopy.add(a);
		}
		list.sort(null); listcopy.sort(null);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}
	
	/**
	 * Tests a list sorted in reverse order
	 */
	@Test
	public void testReverse() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int a = (int)(Math.random() * 10) + 1;
			list.add(a); listcopy.add(a);
		}
		list.sort(Collections.reverseOrder()); listcopy.sort(null);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}
	
	/**
	 * Tests a list with a prime number of elements
	 */
	public void testPrime() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			int a = (int)(Math.random() * 10) + 1;
			list.add(a); listcopy.add(a);
		}
		listcopy.sort(null);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}
	
	/**
	 * Tests a list using different values for lowindex and highindex
	 */
	@Test
	public void differentRange() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int a = (int)(Math.random() * 10) + 1;
			list.add(a); listcopy.add(a);
		}
		listcopy.sort(null);
		testAlgorithms(listcopy, list, 1, list.size() - 3, false);
	}
	
	/**
	 * Tests a list that is to be sorted in reverse order
	 */
	@Test
	public void testDescending() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int a = (int)(Math.random() * 10) + 1;
			list.add(a); listcopy.add(a);
		}
		listcopy.sort(Collections.reverseOrder());
		testAlgorithms(listcopy, list, 0, list.size(), true);
	}
	
	/**
	 * Standard test. Tests a list with ten random elements
	 */
	@Test
	public void standardTest() {
		int [] items = {3, 6, 2, 8, 9, 3, 4, 8, 8, 9};
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		for (int i = 0; i < items.length; i++) {
			list.add(items[i]); listcopy.add(items[i]);
		}
		listcopy.sort(null);
		System.out.println("Sort says items: " + list);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}
	
	/**
	 * Huge Test. Tests a list with 500,000 elements
	 */
	@Test
	public void testHuge() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listcopy = new ArrayList<Integer>();
		for (int i = 0; i < 500000; i++) {
			int a = (int)(Math.random() * 10) + 1;
			list.add(a); listcopy.add(a);
		}
		listcopy.sort(null);
		testAlgorithms(listcopy, list, 0, list.size(), false);
	}

}
