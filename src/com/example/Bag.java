package com.example;

import java.util.Collection;

public interface Bag<T> {

    // add(x), remove(x), find(x) (retrieve), and findAll(x) (retrieve all
    // duplicates). ﻿

    void add(T element);

    void remove(T element);

    T find(T element);

    Collection<T> findAll(T element);

}
