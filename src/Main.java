
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer m, n, min;
        ArrayList<ArrayList<Integer>> massBefor = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> massAfter = new ArrayList<ArrayList<Integer>>();
        Set<Integer> columnsToDelete = new HashSet<Integer>();

        System.out.println("Enter number of ROWS m = ");
        m = sc.nextInt();//Считываем первое число

        System.out.println("Enter number of COLUMNS n = ");
        n = sc.nextInt();//Считываем второе число

        min = Integer.MAX_VALUE;

        for (Integer i = 0; i < m; i++) {
            massBefor.add(new ArrayList<Integer>());
            for (Integer j = 0; j < n; j++) {
                System.out.print("mass[" + i + "][" + j + "] = ");
                massBefor.get(i).add(sc.nextInt());
                if (massBefor.get(i).get(j) < min) {
                    min = massBefor.get(i).get(j);
                    columnsToDelete.clear();
                    columnsToDelete.add(j);
                } else if (massBefor.get(i).get(j) == min) {
                    columnsToDelete.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            massAfter.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                if (columnsToDelete.contains(j)) continue;
                massAfter.get(i).add(massBefor.get(i).get(j));
            }
        }

        System.out.println("Matrix before remove : " + massBefor);
        System.out.println("Minimal value = " + min);
        System.out.println("Columns that will be removed  " + columnsToDelete);
        System.out.println("Matrix after remove :  " + massAfter);
    }
}
