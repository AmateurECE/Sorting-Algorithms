/**Sort.java
 * Implements common sorting algorithms
 * 
 * @author ethantwardy
 * Written by Ethan D. Twardy
 * Last edited on March 3, 2017
 * 
 * CS1122 - R02
 */
import java.util.ArrayList;
import java.util.Collections;


public class Sort implements SortInterface {

	@Override
	public void bubblesort(ArrayList<Integer> list, int lowindex,
			int highindex, boolean reversed) {
		if (!reversed) {
			boolean swapped;
			do {
				swapped = false;
				for (int i = 1; i < list.size(); i++) {
					if (list.get(i - 1) > list.get(i)) {
						Collections.swap(list, i - 1, i);
						swapped = true;
					}
				}
			} while (swapped);
		} else if (reversed) {
			boolean swapped;
			do {
				swapped = false;
				for (int i = 1; i < list.size(); i++) {
					if (list.get(i - 1) < list.get(i)) {
						Collections.swap(list, i - 1, i);
						swapped = true;
					}
				}
			} while (swapped);
		}
	}
	
	@Override
	public void insertionsort(ArrayList<Integer> list, int lowindex,
			int highindex, boolean reversed) {
		if (!reversed) {
			for (int i = 1; i < list.size(); i++) {
				for(int j = i ; j > 0 ; j--){
					if(list.get(j) < list.get(j - 1)){
						Collections.swap(list, j - 1, j);
					}
				}
			}
		} else if (reversed) {
			for (int i = 1; i < list.size(); i++) {
				for(int j = i ; j > 0 ; j--){
					if(list.get(j) > list.get(j - 1)){
						Collections.swap(list, j - 1, j);
					}
				}
			}
		}
	}

	@Override
	public void selectionsort(ArrayList<Integer> list, int lowindex,
			int highindex, boolean reversed) {
		if (!reversed) {
			for (int j = 0; j < list.size() - 1; j++) {
				int min = j;
				for (int i = j + 1; i < list.size(); i++) {
					if (list.get(i) < list.get(min)) {
						min = i;
					}
				}
				if (min != j) {
					Collections.swap(list, min, j);
				}
			}
		} else if (reversed) {
			for (int j = 0; j < list.size() - 1; j++) {
				int max = j;
				for (int i = j + 1; i < list.size(); i++) {
					if (list.get(i) > list.get(max)) {
						max = i;
					}
				}
				if (max != j) {
					Collections.swap(list, max, j);
				}
			}
		}
	}

	@Override
	public void shellsort(ArrayList<Integer> list, int lowindex, int highindex,
			boolean reversed) {
		if (!reversed) {
			int [] hValues = {701, 301, 132, 57, 23, 10, 4, 1};
			for (int h : hValues) {
				for (int i = h; i < list.size(); i++) {
					int temp = list.get(i);
					int j = 0;
					for (j = i; j >= h && list.get(j - h) > temp; j -= h) {
						list.set(j, list.get(j - h));
					}
					list.set(j, temp);
				}
			}
		} else if (reversed) {
			int [] hValues = {701, 301, 132, 57, 23, 10, 4, 1};
			for (int h : hValues) {
				for (int i = h; i < list.size(); i++) {
					int temp = list.get(i);
					int j = 0;
					for (j = i; j >= h && list.get(j - h) < temp; j -= h) {
						list.set(j, list.get(j - h));
					}
					list.set(j, temp);
				}
			}
		}
	}

	@Override
	public void quicksort(ArrayList<Integer> list, int lowindex, int highindex,
			boolean reversed) {
		quicksortHelper(list, lowindex, highindex - 1);
	}
	
	private void quicksortHelper(ArrayList<Integer> list, int lowindex, int highindex) {
		if (lowindex < highindex) {
			int p = partition(list, lowindex, highindex);
			quicksortHelper(list, lowindex, p - 1);
			quicksortHelper(list, p, highindex);
		}
	}
	
	private int partition(ArrayList<Integer> list, int lowindex, int highindex) {
		int pivot = list.get(highindex);
		int i = lowindex;
		for (int j = lowindex; j < highindex; j++) {
			if (list.get(j) < pivot) {
				i++;
				Collections.swap(list, i, j);
				System.out.println("Swap!");
			}
		}
		Collections.swap(list, i, highindex);
		System.out.println("Partition says list: " + list);
		return i + 1;
	}

	@Override
	public void mergesort(ArrayList<Integer> list, int lowindex, int highindex,
			boolean reversed) {
		mergeHelper(list);
	}
	
	private ArrayList<Integer> mergeHelper(ArrayList<Integer> list) {
		if (list.size() <= 1) {
			return list;
		}
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		int index = 0;
		for (Integer i : list) {
			if (index < (list.size() / 2)) {
				left.add(i);
			} else { right.add(i); }
			index++;
		}
		
		left = mergeHelper(left);
		right = mergeHelper(right);
		return mergeList(list, left, right);
	}
	
	private ArrayList<Integer> mergeList(ArrayList<Integer> list,
			ArrayList<Integer> left, ArrayList<Integer> right) {
		list.clear();
		while (left.size() != 0 && right.size() != 0) {
			if (left.get(0) >= right.get(0)) {
				list.add(left.remove(0));
			} else { list.add(right.remove(0)); }
		}
		while (left.size() != 0) {
			list.add(left.remove(0));
		}
		while (right.size() != 0) {
			list.add(right.remove(0));
		}
		return list;
	}

	@Override
	public void mysort(ArrayList<Integer> list, int lowindex, int highindex,
			boolean reversed) {
		
	}

}
