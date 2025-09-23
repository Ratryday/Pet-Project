package pet.project.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class ListCollections {

    private final Logger log = Logger.getLogger(ListCollections.class.getName());

    public void arrayListFilling(Integer listSize) {
        List<Integer> arrayList = new ArrayList<>();
        fillList(arrayList, listSize);
        log.info("ArrayList size: " + arrayList.size());
        arrayList.clear();
    }

    public void linkedListFilling(Integer listSize) {
        List<Integer> linkedList = new LinkedList<>();
        fillList(linkedList, listSize);
        log.info("LinkedList size: " + linkedList.size());
        linkedList.clear();
    }

    public void listGetObject(List<Integer> list, Integer index) {
        Integer obj = list.get(index);
    }

    public void iterateList(List<Integer> list) {
        for (int i = 0; i <= list.size() - 1; i++) {
            Integer obg = list.get(i);
            list.set(i, ++obg);
        }
    }

    public void fillList(List<Integer> list, Integer listSize) {
        for (int i = 0; i < listSize; i++) {
            list.add(i);
        }
    }

}
