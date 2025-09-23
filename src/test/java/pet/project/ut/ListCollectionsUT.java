package pet.project.ut;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pet.project.collections.ListCollections;
import pet.project.collections.MyListImpl;
import pet.project.common.TimeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListCollectionsUT {

    private final ListCollections listCollections;

    public ListCollectionsUT() {
        listCollections = new ListCollections();
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 1000000, 10000000})
    void listTimeFillingTest(Integer listSize) {
        TimeUtils.calculateMethodTimeWork(() -> listCollections.arrayListFilling(listSize));

        TimeUtils.calculateMethodTimeWork(() -> listCollections.linkedListFilling(listSize));
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 1000000, 10000000})
    void listTimeObjectManipulationTest(Integer listSize) {
        List<Integer> arrayList = new ArrayList<>();
        listCollections.fillList(arrayList, listSize);
        TimeUtils.calculateMethodTimeWork(() -> listCollections.listGetObject(arrayList, listSize / 2));

        List<Integer> linkedList = new LinkedList<>();
        listCollections.fillList(linkedList, listSize);
        TimeUtils.calculateMethodTimeWork(() -> listCollections.listGetObject(linkedList, listSize / 2));
    }

    @ParameterizedTest
    @ValueSource(ints = {100000, 1000000, 10000000})
    void iterateListTimeTest(Integer listSize) {
        List<Integer> arrayList = new ArrayList<>();
        listCollections.fillList(arrayList, listSize);
        TimeUtils.calculateMethodTimeWork(() -> listCollections.iterateList(arrayList));

        List<Integer> linkedList = new LinkedList<>();
        listCollections.fillList(linkedList, listSize);
        TimeUtils.calculateMethodTimeWork(() -> listCollections.iterateList(linkedList));
    }

    @Test
    void myArrayListImplTest() {
        MyListImpl<Integer> myListImpl = new MyListImpl<>();
        myListImpl.add(1);
        myListImpl.add(null);
        myListImpl.add(3);

        Assertions.assertEquals(3, myListImpl.size());


        Assertions.assertEquals(1, myListImpl.indexOf(null));
    }
}
