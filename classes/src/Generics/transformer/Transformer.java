package Generics.transformer;

public interface Transformer<T, R> {
    R transform(T value);
}