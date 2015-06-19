package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBackedBag<T> implements Bag<T> {

    private final Map<T, List<T>> data = new HashMap<T, List<T>>();

    @Override
    public void add(final T element) {
        List<T> targetList = data.get(element);
        if (null == targetList) {
            targetList = new ArrayList<>();
            data.put(element, targetList);
        }
        targetList.add(element);
    }

    @Override
    public void remove(final T element) {
        final List<T> targetList = data.get(element);
        if (null == targetList) {
            return;
        }
        targetList.remove(element);
        if (targetList.isEmpty()) {
            data.remove(element);
        }
    }

    @Override
    public T find(final T element) {
        if (data.containsKey(element)) {
            return element;
        }
        return null;
    }

    @Override
    public Collection<T> findAll(final T element) {
        if (data.containsKey(element)) {
            return data.get(element);
        }
        return Collections.emptyList();
    }

}
