public class IntegerList {
    int[] list; // The list values.
    private int numFilled;
    private int listSize; // The size of the list.
    
    // Create a list of the given size.
    public IntegerList(int size) {
        numFilled = size;
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
    for (int i = 0; i < numFilled; i++)
        list[i] = (int)(Math.random() * 100) + 1;
    }

    // Print array elements with indexes.
    public void print() {
        System.out.println("Array:");
        for (int i = 0; i < list.length; i++)
            System.out.println(i + ":\t" + list[i]);
        System.out.println("\nnumFilled: " + numFilled);
        System.out.println("listSize: " + listSize);
    }
    
    // Insert a new item and increase the size if needed.
    public void addElement(int item) {
        if(numFilled + 1 > listSize) {
            doubleListSize();
        }
        list[numFilled] = item;
        numFilled++;
    }
    
    // Remove the first occurence of a value.
    public void removeFirst(int item) {
        boolean found = false;
        for (int i = 0; i < numFilled; i++) {
            if (found)
                list[i-1] = list[i];
            if (list[i] == item)
                found = true;
        }
        if (found) {
            list[numFilled - 1] = 0;
            numFilled--;
        }
    }
    
    // Remove all occurences of a value.
    public void removeAll(int item) {
        int offset = 0;
        for (int i = 0; i < numFilled; i++) {
            if (list[i] == item)
                offset++;
            else
                list[i-offset] = list[i];
        }
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
