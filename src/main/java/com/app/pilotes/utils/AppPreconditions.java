package com.app.pilotes.utils;

import com.app.pilotes.exceptions.ApplicationExceptions;

import java.util.List;
import java.util.Objects;

import static com.app.pilotes.enums.MessagesConsts.*;


public final class AppPreconditions {

    public static <T> List<T> checkNotNullOrEmptyList(final List<T> t) {
        List<T> checked = Objects.requireNonNull(t);
        if (checked.size() == 0) throw new ApplicationExceptions(LIST_EMPTY);
        return checked;
    }

    public static <T> T checkNotNullOrEmpty(final T t) {
        if (t == null)
            throw new ApplicationExceptions(ITS_NULL);
        return t;
    }


}
