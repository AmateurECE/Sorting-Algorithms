import java.util.ArrayList;

public interface SortInterface {
	
    public void bubblesort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed);
    
    public void insertionsort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed);
    
    public void selectionsort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed);
    
    public void shellsort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed);
    
    public void quicksort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed);
    
    public void mergesort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed);
    
    public void mysort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed);
    
}