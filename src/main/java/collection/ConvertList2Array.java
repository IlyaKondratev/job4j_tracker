package collection;

import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int cells) {
        int groups =  (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
//        int i = 0,j = 0;
//        for (Integer el : list) {
//            array[i][j] = list.get(i*cells + j);
//            i = (j == cells - 1) ? i + 1 : i;
//            j = (j == cells - 1) ? 0 : j + 1;
//        }
        for (int k = 0; k < list.size(); k++) {
            array[k / cells][k % cells] = list.get(k);
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 4);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}