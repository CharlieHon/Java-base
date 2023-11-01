package list_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        String[] names = {"Hello", "Charlie", "World", "Test", "Bruce", "Peace",
                            "Love", "John", "Kill", "Like"};
        for (String name : names) {
            list.add(name);
        }
        list.add(2, "HspEdu");
        System.out.println(list.get(5));
        list.remove(5);
        list.set(7, "Haha");
        Iterator<Object> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
