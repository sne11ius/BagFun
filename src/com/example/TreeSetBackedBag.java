package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * This is probably bullshit, because of wrong use of hashCode, but should work
 * for simple examples.
 *
 * @param <T>
 */
public class TreeSetBackedBag<T extends Comparable<T>> implements Bag<T> {

    private final class HashCodeComparator<X> implements Comparator<X> {
        @Override
        public int compare(final X o1, final X o2) {
            return o1.hashCode() - o2.hashCode();
        }
    }

    private static final class ElementContainer<T> {

        final List<T> data = new ArrayList<>();

        public ElementContainer(final T element) {
            data.add(element);
        }

        @Override
        public int hashCode() {
            if (data.isEmpty()) {
                return 0;
            }
            return data.get(0).hashCode();
        }
    }

    final TreeSet<ElementContainer<T>> data = new TreeSet<>(new HashCodeComparator<>());

    @Override
    public void add(final T element) {
        final ElementContainer<T> container = new ElementContainer<>(element);
        if (data.contains(container)) {
            data.tailSet(container, true).iterator().next().data.add(element);
        } else {
            data.add(container);
        }
    }

    @Override
    public void remove(final T element) {
        final ElementContainer<T> container = new ElementContainer<>(element);
        if (data.contains(container)) {
            final ElementContainer<T> existingContainer = data.tailSet(container, true).iterator().next();
            existingContainer.data.remove(0);
            if (existingContainer.data.isEmpty()) {
                data.remove(existingContainer);
            }
        }
    }

    @Override
    public T find(final T element) {
        final ElementContainer<T> container = new ElementContainer<>(element);
        if (data.contains(container)) {
            return element;
        }
        return null;
    }

    @Override
    public Collection<T> findAll(final T element) {
        final ElementContainer<T> container = new ElementContainer<>(element);
        if (data.contains(container)) {
            return data.tailSet(container, true).iterator().next().data;
        }
        return Collections.emptyList();
    }

}
