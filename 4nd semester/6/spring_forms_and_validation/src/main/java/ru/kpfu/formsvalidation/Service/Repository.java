package ru.kpfu.formsvalidation.Service;

public interface Repository<T> {
    T create(T t);
    T read(T t);
    void update(T t);
    void delete(T t);
}
