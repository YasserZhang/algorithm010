
public class BinaryHeap {
    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    public BinaryHeap(int capacity) {
        heapSize = 0;
        heap = new int(capacity + 1);
        Arrays.fill(heap, -1);
    }

    private int parent(int i) {
        return (i-1) / d;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    public void insert(int x) {
        if (isFull()) {
            throw new NoSuchElementException("Heap is full, No space to insert new element");
        }
        heap[heapSize] = x;
        heapSize ++;
        heapifyUp(heapSize - 1);
    }

    public int delete(int x) {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty, No element to delete");
        }
        int maxElement = heap[x];
        heap[x] = heap[heapSize-1];
        heapSize --;
        heapifyDown(x);
        return maxElement;
    }

    private void heapifyUp(int i) {
        int insertValue = heap[i];
        while (i > 0 && insertValue > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = insertValue;
    }

    private void heapifyDown(int x) {
        int temp = heap[x];
        int child;
        while(kthChild(x, 1) < heapSize) {
            child = maxChild(x);
            if (temp >= heap[child]) {
                break;
            }
            heap[x] = heap[child];
            x = child;
        }
        heap[x] = temp;
    }

    private int maxChild(int i) {
        int leftChild = d * i + 1;
        int rightChild = d * i + 2;
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

}