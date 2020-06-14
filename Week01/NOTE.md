学习笔记
### Priority Queue
用一个数组来表示树状结构。每个节点可以由两个子节点。如果父节点在数组中的序列为`i`，那么其子节点的序列分别为`2i+1`和`2i+2`。

如果需要通过子节点回找父节点，可以通过以下公式找到父节点在数组的序列：`(i-1)/2`，其中`i`是子节点在数组中的序列号。

当一个新值放到该数组末尾时，`SiftUp`会将该值向上拱到它正确的位置，那时它将比父节点大，比子节点都小。

JDK 1.8中对于`SiftUp`的代码实现如下。
```java
public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {
    //...

    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
    //...
}
```

### Skip List
目前尚在消化中。对于新值插入时，其`level`高度可以通过随机获取，而获取的随机值甚至可以比最优化高度高出很多，同时并不影响search效率。

关于这一点，还是不太明白。