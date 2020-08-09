学习笔记

#### Rabin-Karp 算法
```
//Java
public final static int D = 256;
public final static int Q = 9997;

static int RabinKarpSerach(String txt, String pat) {
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int patHash = 0, txtHash = 0;

    for (i = 0; i < M; i++) {
        patHash = (D * patHash + pat.charAt(i)) % Q;
        txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }

    int highestPow = 1;  // pow(256, M-1)
    for (i = 0; i < M - 1; i++) 
        highestPow = (highestPow * D) % Q;

    for (i = 0; i <= N - M; i++) { // 枚举起点
        if (patHash == txtHash) {
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == M)
                return i;
        }
        if (i < N - M) {
            txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
            if (txtHash < 0)
                txtHash += Q;
        }
    }

    return -1;
}

```

```Python
   class Solution:
       def strStr(self, haystack: str, needle: str) -> int:
           d = 256
           q = 9997
           n = len(haystack)
           m = len(needle)
           h = pow(d,m-1)%q
           p = 0
           t = 0
           if m > n:
               return -1
           for i in range(m): # preprocessing
               p = (d*p+ord(needle[i]))%q
               t = (d*t+ord(haystack[i]))%q
           for s in range(n-m+1): # note the +1
               if p == t: # check character by character
                   match = True
                   for i in range(m):
                       if needle[i] != haystack[s+i]:
                           match = False
                           break
                   if match:
                       return s
               if s < n-m:
                   t = (t-h*ord(haystack[s]))%q
                   t = (t*d+ord(haystack[s+m]))%q
                   t = (t+q)%q
           return -1


```