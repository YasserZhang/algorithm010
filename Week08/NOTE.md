学习笔记

#### 位运算
1. 将x最右边的n位清零; x&(~0<<n)
2. 获取x的第n位值（0或1）:(x>>n)&1
3. 获取x的第n位的幂值：x&(1<<n)
4. 仅将第n位设为1：x|(1<<n)
5. 仅将第n位设为0：x&(~(1<<n))
6. 将x最高位至第n位（含）清零：x&((1<<n)-1)
7. X&~X取得0
有疑问：
清零最低位的1: x = x&(x-1) //不光最低位清零，甚至会全清零，比如x=8  
**其实这里理解有误，最低位的1指的是排在最右面的1，这样就对了。**
-----------------------

得到最低位的1：x = x&-x //-x只改变sign的标记，并不会对数值本身产生变化，所以结果只会是x的正值  

解释：
```
        int a = 7;
        int b = (a & -a);
        System.out.println(prettify(Integer.toBinaryString(a)));
        System.out.println(prettify(Integer.toBinaryString(-a)));
        System.out.println(prettify(Integer.toBinaryString(b)));

output：
0000 0000 - 0000 0000 -- 0000 0000 - 0000 0111
1111 1111 - 1111 1111 -- 1111 1111 - 1111 1001
0000 0000 - 0000 0000 -- 0000 0000 - 0000 0001
```

#### QuickSort

```java

public class QuickSort {
    public static void quickSort(int[] array, int start, int end) {
        if (end <= start) return;
        int pivot = partition(array, start, end);
        quickStart(array, start, pivot-1);
        quickStart(array, pivot+1, end);
}
    public static void partition(int[] array, int start, int end) {
        int pivot = end;
        int counter = start;
        for (int i = start; i < end; ++i) {
            if (array[i] <= array[pivot]) {
                int temp = array[counter];
                array[counter++] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
}

}
```

generic version
```java
public class QuickSort {

    public static <T> void quickSort(T[] array, int start, int end, Comparator<T> comparator) {
        if (end <= start) return;
        int pivot = partition(array, start, end, comparator);
        quickSort(array, start, pivot-1, comparator);
        quickSort(array, pivot+1, end, comparator);
}
    private static int partition(T[] array, int start, int end, Comparator<T> comparator) {
        int pivot = end;
        int counter = start;
        for (int i = start; i < end; ++i) {
            if (comparator.compare(array[i], array[pivot]) < 0) {
                T temp = array[counter];
                array[counter++] = array[i];
                array[i] = temp;
            }
        }
        T temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
}
    private static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static void main(String[] args) {
        Pair[] pairs = new Pair[5];
        pairs[0] = new Pair(9,0);
        pairs[1] = new Pair(1,5);
        pairs[2] = new Pair(-2,8);
        pairs[3] = new Pair(10,-3);
        pairs[4] = new Pair(3,-6);
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.a - o2.a;
            }
        };
        quickSort(pairs, 0, pairs.length-1, comparator);
        Arrays.asList(pairs).forEach(System.out::println);
    }
}
```

#### Merge Sort
```java
public class MergeSort {

    public static void mergeSort(int[] array, int start, int end) {
        if (end <= start) return;
        int mid = (start + end) >> 1;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);
        merge(array, start, mid, end);
}

    public static void merge(int[] array, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];
        while ( i <= mid && j <= end) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        
        while (i <= mid) temp[k++] = array[i++];
        while (j <= end) temp[k++] = array[j++];
        
        System.arraycopy(temp, 0, array, start, temp.length);
}
}
```

generic merge sort

```java

public class MergeSort {
    public static <T> void mergeSort(T[] array, int start, int end, Comparator<T> comparator) {
        if (end <= start) return;
        int mid = (start + end) >> 1;
        mergeSort(array, start, mid, comparator);
        mergeSort(array, mid+1, end, comparator);
        merge(array, start, mid, end, comparator);
}

    private static <T> void merge(T[] array, int start, int mid, int end, Comparator<T> comparator) {
        int i = start, j = mid+1, k = 0;
        T[] temp = (T[]) new Object[right - left + 1];
        while ( i <= mid && j <= end) {
            temp[k++] = comparator.compare(array[i], array[j]) <= 0 ? array[i++] : array[j++];
        }
        while (i <= mid) temp[k++] = array[i++];
        while (j <= end) temp[k++] = array[j++];
        System.arraycopy(temp, 0, array, start, temp.length);
    }

    private static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static void main(String[] args) {
        //List<Integer>[] lists = new List[5];
        //lists[0] = new ArrayList<>();
        //lists[0].add("hello");
        Pair[] pairs = new Pair[10];
        pairs[0] = new Pair(9,0);
        pairs[1] = new Pair(1,5);
        pairs[2] = new Pair(-2,8);
        pairs[3] = new Pair(10,-3);
        pairs[4] = new Pair(3,-6);
        pairs[5] = new Pair(3,-6);
        pairs[6] = new Pair(13,-6);
        pairs[7] = new Pair(3,-6);
        pairs[8] = new Pair(3,-6);
        pairs[9] = new Pair(3,-6);
        Comparator<Pair> comparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.a - o2.a;
            }
        };
        mergeSort(pairs, 0, pairs.length-1, comparator);
        Arrays.asList(pairs).forEach(System.out::println);
    }


}





```
