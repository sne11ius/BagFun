package com.example;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This one does not actually store multiple instances of added objects. As for
 * when this will or will not work, read about the importance of javas "equals"
 * method ;)
 *
 * @param <T>
 *            The type of elements to store.
 */
public class FakedBag<T> implements Bag<T> {

    final Map<T, Integer> elementCounts = new HashMap<T, Integer>();

    @Override
    public void add(final T element) {
        if (elementCounts.containsKey(element)) {
            elementCounts.put(element, 1 + elementCounts.get(element));
        } else {
            elementCounts.put(element, 1);
        }
    }

    @Override
    public void remove(final T element) {
        if (elementCounts.containsKey(element)) {
            final int newValue = elementCounts.get(element) - 1;
            if (0 == newValue) {
                elementCounts.remove(element);
            } else {
                elementCounts.put(element, newValue);
            }
        }
    }

    @Override
    public T find(final T element) {
        if (elementCounts.containsKey(element)) {
            return element;
        }
        return null;
    }

    @Override
    public Collection<T> findAll(final T element) {
        final Integer count = elementCounts.get(element);
        if (null != count) {
            return Collections.nCopies(count, element);
        }
        return Collections.emptyList();
    }

}
