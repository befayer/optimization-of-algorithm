import java.util.*;

public class Main {

    public static void main(String[] args) {
        //поменять значения местами
        /*int a = 5;
        int b = 7;
        int temp = a;
        a = b;
        b = temp;*/

        //без temp
        /*int a = 5;
        int b = 7;
        a += b;
        b = a - b;
        a -= b;*/
        int[] arr2 = new int[]{1,2,2,3,4,56,7,2};
        int[] arr1 = new int[]{1,2,3,56};
        System.out.println(Arrays.toString(m(arr1, arr2)));
    }

    //set --> mySet
    // класс MySet

    public static int[] m(int[] arr1, int[] arr2){
        if (arr1.length > arr2.length) return m(arr2, arr1);
        Set<Integer> set = new HashSet<>();
        for(int i: arr1){
            set.add(i);
        }
        int idx = 0;
        int[] a = new int[arr1.length];
        for (int i: arr2){
            if (set.contains(i)){
                a[idx] = i;
            }
        }
        return Arrays.copyOf(a, idx);
    }
}
