package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleSetOfListsBackedBag<T> implements Bag<T> {

    private final Set<List<T>> data = new HashSet<List<T>>();

    @Override
    public void add(final T element) {
        for (final List<T> list : data) {
            if (list.contains(element)) {
                list.add(element);
                return;
            }
        }
        data.add(new ArrayList<T>(Arrays.asList(element)));
    }

    @Override
    public void remove(final T element) {
        for (final List<T> list : data) {
            if (list.contains(element)) {
                list.remove(element);
                if (list.isEmpty()) {
                    data.remove(list);
                }
            }
        }
    }

    @Override
    public T find(final T element) {
        for (final List<T> list : data) {
            if (list.contains(element)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public Collection<T> findAll(final T element) {
        for (final List<T> list : data) {
            if (list.contains(element)) {
                return list;
            }
        }
        return Collections.emptyList();
    }

}
