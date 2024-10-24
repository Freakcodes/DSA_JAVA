public class Heap{
     int heapSize;
    int heap[];
    int capacity;

    Heap(int arr[])
    {
        heap=arr;
        heapSize=arr.length;
        capacity=arr.length;

    }
    public void swap(int i,int j)
    {
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }
    public void heapify(int index)
    {
        int largest=index;
        int leftChildIndex=2*index+1;
        int rightChildIndex=2*index+2;
        if(leftChildIndex<heapSize && heap[leftChildIndex]>heap[largest])
        {
            largest=leftChildIndex;
        }
        if(rightChildIndex<heapSize && heap[rightChildIndex]>heap[largest])
        {
            largest=rightChildIndex;
        }
        if(largest!=index)
        {
            swap(index,largest);
            heapify(largest);
        }

    }
    public int extractMax()
    {
        if(heapSize==0){
            System.out.println("No elements in the heap");
            return -1;
        }
        int max=heap[0];
        heap[0]=heap[heapSize-1];
        heapSize--;
        heapify(0);
        return max;
    }
    public void extractMaxAndStore()
    {
        if(heapSize==0){
            System.out.println("No elements in the heap");
            return ;
        }
        int max=heap[0];
        heap[0]=heap[heapSize-1];
        heap[heapSize-1]=max;
        heapSize--;
        heapify(0);
        
    }
    public void buildHeap()
    {
        //N/2 to N-1;
        //The reason to do so is we dont heapify the leaf node...
        //0 to (N/2-1)
        for(int index=heapSize/2-1;index>=0;index--)
        {
            heapify(index);
        }
    }
    public void printTree()
    {
        for (int i = 0; i < heapSize; i++) {
            if(i!=heapSize-1){
                System.out.print(heap[i]+", ");
            }else{
                System.out.print(heap[i]);
            }
            
        }
        System.out.println();
    }
    public int[] heapSort()
    {
        //First step is to build heap and second step is to extract the maximum element and store...
        buildHeap();
        int size=heapSize;
        for (int i = 0; i < size; i++) {
            extractMaxAndStore();
        }
        return heap;
    }

    public void increaseKey(int index, int newValue)
    {
        if(index<0 || index>=heapSize ||heap[index]>=newValue)
        {
            System.out.println("Wrong Operation");
            return;
        }
        heap[index]=newValue;
        
        while(index>0 && heap[index]>heap[(int)(Math.ceil(index/2.0)-1)])
        {
            swap(index,(int)(Math.ceil(index/2.0)-1));
            index=(int)(Math.ceil(index/2.0)-1);
        }
    }
    
    public void increaseCapacity()
    {
        capacity*=2;
        int newHeap[]=new int[capacity];
        for(int i=0;i<heapSize;i++)
        {
            newHeap[i]=heap[i];

        }
        heap=newHeap;
    }
    public void push(int value)
    {
        if(heapSize+1>=capacity)
        {
            increaseCapacity();
        }
        heapSize+=1;
        heap[heapSize-1]=value;
        int index=heapSize-1;
        //root of the index is found by the formula ceil_value(index/2-1)...
        while(index>0 && heap[index]>heap[(int)(Math.ceil(index/2.0)-1)])
        {
            swap(index,(int)(Math.ceil(index/2.0)-1));
            index=(int)(Math.ceil(index/2.0)-1);
        }

    }
    public static void main(String[] args) {
        int arr[]={10,5,20,6,11};
        Heap heap=new Heap(arr);
        heap.buildHeap();
        heap.printTree();
        heap.increaseKey(4, 15);
        // System.out.println("The max element--> "+heap.extractMax());
        heap.printTree();
        heap.push(23);

        int []sort=heap.heapSort();
        for (int i = 0; i <sort.length; i++) {
            if(i!=sort.length-1){
                System.out.print(sort[i]+", ");
            }else{
                System.out.print(sort[i]);
            }
            
        }
        System.out.println();
        //Time complexity for heapify is: O(logn)
        //Time complexity for build heap is: O(n)
        //Time complexity for extractMax is:O(1)+O(logn);
        //Time complexity for insertion is :O(logn);
        
    }
}