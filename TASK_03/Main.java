package TASK_03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Consumer;

public class Main {

    private HashMap<Integer, Integer> hashMap1;
    private HashMap<Integer, Integer> hashMap2;
    private Integer[] numbrers;

    public Main() {
        hashMap1 = new HashMap<>();
        hashMap2 = new HashMap<>();
        numbrers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 10, 11};
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.countCycle();
        main.countStream();
    }

    public void countCycle() {
        Integer amount;
        for (Integer i : numbrers) {
            amount = hashMap1.get(i);
            if (amount == null) {
                amount = 0;
            }
            hashMap1.put(i, amount + 1);
        }

        System.out.println(hashMap1);
    }

    public void countStream() {
        Consumer<Integer> consumer = new Consumer<Integer>() {
            Integer amount;

            @Override
            public void accept(Integer i) {
                amount = hashMap2.get(i);
                if (amount == null) {
                    amount = 0;
                }
                hashMap2.put(i, amount + 1);
            }
        };
        Arrays.stream(numbrers).forEach(consumer);

        System.out.println(hashMap2);
    }

}
