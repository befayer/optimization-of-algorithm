package org.example;

public class MySet<T> {
    private final T[] values;
    private final int[] indexes;
    private int i = 0;

    public MySet(int n) {
        values = (T[]) new Object[n];
        indexes = new int[n];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = -1;
        }
    }

    public void add(T value) {
        int idx = Math.abs((Integer)value) % values.length;
        addRec(value, idx);
    }

    private void addRec(T value, int idx) {
        if (values[idx] == null) values[idx] = value;
        else if (!values[idx].equals(value)) {
            if (indexes[idx] != -1) addRec(value, indexes[idx]);
            else {
                while(values[i] != null) {
                    ++i;
                }
                values[i] = value;
                indexes[idx] = i;
            }
        }

    }

    public boolean contains(T value) {
        int idx = Math.abs((Integer)value) % values.length;
        return containsRec(value, idx);
    }

    private boolean containsRec(T value, int idx) {
        if (values[idx] != null) {
            if (values[idx].equals(value)) return true;
            if (indexes[idx] != -1) return containsRec(value, indexes[idx]);
        }
        return false;
    }
}
