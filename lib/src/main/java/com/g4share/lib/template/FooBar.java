//Copyright (c) 2023 g4share
package com.g4share.lib.template;

import com.g4share.common.CyclicCounter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class FooBar {
    private static final Logger logger = LoggerFactory.getLogger(FooBar.class);

    private final int lines;

    private static final int FOO_NUMBER = 5;
    private static final int BAR_NUMBER = 7;

    public FooBar() {
        this.lines = 200;
    }

    public void doIt(final Consumer<String> fooBarLogger) {
        final CyclicCounter fooCounter = new CyclicCounter(FOO_NUMBER);
        final CyclicCounter barCounter = new CyclicCounter(BAR_NUMBER);

        for (int i = 1; i <= lines; i++) {
            String fooBarMessage =
                    check(() -> fooCounter.incrementAndGet() == 0, "Foo") +
                    check(() -> barCounter.incrementAndGet() == 0, "Bar");

            if (fooBarMessage.equals("")) {
                fooBarMessage = String.valueOf(i);
            }

            fooBarMessage += "\n";
            fooBarLogger.accept(fooBarMessage);

            logger.debug("{}:{}", i, fooBarMessage);
        }
    }

    private String check(BooleanSupplier checker, String messagePart) {
        return checker.getAsBoolean() ? messagePart : "";
    }
}
