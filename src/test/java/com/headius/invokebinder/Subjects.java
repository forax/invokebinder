package com.headius.invokebinder;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;

/**
 * Created by headius on 1/25/14.
 */
public class Subjects {
    private static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

    public static final Signature StringIntegerIntegerIntegerString = Signature
            .returning(String.class)
            .appendArg("a", String.class)
            .appendArg("b1", Integer.class)
            .appendArg("b2", Integer.class)
            .appendArg("b3", Integer.class)
            .appendArg("c", String.class);

    public static final MethodHandle StringIntegersString = Binder
                    .from(String.class, String.class, Integer[].class, String.class)
                    .invokeStaticQuiet(LOOKUP, Subjects.class, "stringIntegersString");

    public static String stringIntegersString(String a, Integer[] bs, String c) {
        return Arrays.deepToString(new Object[]{a, bs, c});
    }
}
