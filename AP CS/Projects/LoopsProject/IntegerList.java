public class IntegerList {
    int[] list; // The list values.
    private int listSize; // The size of the list.
    
    // Create a list of the given size.
    public IntegerList(int size) {
        listSize = 1;
        while(listSize < size) {
            listSize *= 2;
        }
        list = new int[listSize];
        for(int i=0;i<list.length;i++) {
            list[i] = 0;
        }
    }

    // Fill array with integers between 1 and 100, inclusive.
    public void randomize() {
    for (int i=0; i<list.length; i++)
        list[i] = (int)(Math.random() * 100) + 1;
    }

    // Print array elements with indexes.
    public void print() {
    for (int i=0; i<list.length; i++)
        System.out.println(i + ":\t" + list[i]);
    }
    
    // Insert a new item and increase the size if needed.
    public void increaseSize() {
    }
    
    // Double the list size and move the old things over.
    private void doubleListSize() {
        listSize *= 2;
        int[] newList = new int[listSize];
        for(int i=0;i<list.length;i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
}
