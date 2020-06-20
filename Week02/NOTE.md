学习笔记

### HashMap 总结

与教科书中介绍的Map结构相比，Java实现的HashMap在解决Hash碰撞方面做了如下优化。当碰撞发生时，有相同Hash值的value会被存放到bin的linkedList中。如果linkedList中存放的value超过8个，那么这些value会改为用red-black tree来存放，以加快搜索速度。

### 二叉树遍历代码
```python
def preorder(self, root):
    if root:
        self.traverse_path.append(root.val)
        self.preorder(root.left)
        self.preorder(root.right)

def inorder(self, root):
    if root:
        self.inorder(root.left)
        self.traverse_path.append(root.val)
        self.inorder(root.right)

def postorder(self, root):
    if root:
        self.postorder(root.left)
        self.postorder(root.right)
        self.traverse_path.append(root.val)

```

### 关于递归的空间复杂度的计算
不太清楚应该怎么计算。

### 关于PriorityQueue中的grow机制
```java
public class PriorityQueue<E> {
    //...
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
    //...
}
```
这里的`newCapacity`值大于64时，每次增长相当于乘以3/2。如果一直增长，有可能比`Integer.MAX_VALUE`还要大，那时其结果会变成负值（按位的头比特，也就是记录正负号的比特，会变成1，即负值）。
如果这种情况出现，源码似乎无法捕捉到这个异常。这时该怎么处理？

做了一下实验，看来我对位运算还是不太了解。因数值增长过大而变成负值的数，当它减去`MAX_ARRAY_SIZE`时，会再次变为正数。
举个例子，如果我们让newCapacity为65，然后让它不断增大，结果它会增大到-1904654097，这个数字减去`MAX_ARRAY_SIZE`，结果为242829560，是正数。然后，依据源码，这时会运行hugeCapacity算出新的capacity。
这里忘了数字加减法其实用的是位运算。