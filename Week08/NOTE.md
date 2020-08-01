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
