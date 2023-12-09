//Copyright (c) 2023 g4share
package com.g4share.common;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class CyclicCounter {

    private final int maxValue;

    private final AtomicInteger counter = new AtomicInteger();

    public int incrementAndGet() {
        return counter.accumulateAndGet(1, (index, inc) -> ++index >= maxValue ? 0 : index);
    }
}