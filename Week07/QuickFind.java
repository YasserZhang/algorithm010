
public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    public void validate(int p) {
        if (p < 0 || p >= id.length) throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
    }

    public bollean conntected(int p, int q) {
        validate(p);
        validate(q);
        if (id[p] == id[q]) return true;
        return false;
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        if (id[p] == id[q]) return;
        for (int i = 0; i < id.length; ++i) {
            if (id[i] = id[p]) id[i] = id[q];
        }
        count--;
    }
}