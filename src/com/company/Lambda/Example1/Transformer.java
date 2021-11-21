package com.company.Lambda.Example1;

public interface Transformer<T, S> {
    T transform(S v);
}
