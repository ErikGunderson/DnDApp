package com.gundersonstudios.dndstatstracker.base;

/**
 * Unused
 * @param <T>
 */
public interface IConvertibleVariable<T> {
    void convertToString(StringBuilder builder);

    void convertFromString(String source);

    T getVariable();

    void setVariable(T variable);
}
