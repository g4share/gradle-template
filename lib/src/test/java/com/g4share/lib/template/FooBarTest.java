//Copyright (c) 2023 g4share
package com.g4share.lib.template;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FooBarTest {

    private static Stream<Arguments> fooBarSArgs() {
        final String FOO_BAR_MESSAGE_35 = """
                1
                2
                3
                4
                Foo
                6
                Bar
                8
                9
                Foo
                11
                12
                13
                Bar
                Foo
                16
                17
                18
                19
                Foo
                Bar
                22
                23
                24
                Foo
                26
                27
                Bar
                29
                Foo
                31
                32
                33
                34
                FooBar
                """;

        return Stream.of(
                arguments(-1, ""),
                arguments(0, ""),
                arguments(35, FOO_BAR_MESSAGE_35)
        );
    }

    @ParameterizedTest
    @MethodSource({"fooBarSArgs"})
    void testFooBar(final int maxValue, String expectedMessage) {
        final FooBar fooBar = new FooBar(maxValue);
        final StringBuilder actualMessages = new StringBuilder();

        fooBar.doIt(actualMessages::append);

        assertEquals(expectedMessage, actualMessages.toString());
    }
}