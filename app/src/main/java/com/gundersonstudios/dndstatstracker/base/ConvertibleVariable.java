package com.gundersonstudios.dndstatstracker.base;

public class ConvertibleVariable<T> implements IConvertibleVariable {
    private T mVariable;
    private String mName;

    public ConvertibleVariable(T variable, String name) {
        mVariable = variable;
        mName = name;
    }

    @Override
    public void convertToString(StringBuilder builder) {
        String formattedString = mName + ":" + mVariable + "\n";
        builder.append(formattedString);
    }

    @Override
    public void convertFromString(String source) {
        String[] vars = source.split(":");
        mName = vars[0];
        mVariable = convert(vars[1]);
    }

    @Override
    public T getVariable() {
        return mVariable;
    }


    @Override
    @SuppressWarnings("unchecked")
    public void setVariable(Object variable) {
        mVariable = (T) variable;
    }

    @SuppressWarnings("unchecked")
    private T convert(String convertString) {
        T variable;
        Class<?> clazz = (Class<?>) getClass().getTypeParameters()[0].getBounds()[0];

        if (clazz.isAssignableFrom(String.class)) {
            variable = (T) convertString;
        } else if (clazz.isAssignableFrom(Integer.class)) {
            variable = (T) Integer.valueOf(convertString);
        } else if (clazz.isAssignableFrom(Boolean.class)) {
            variable = (T) Integer.valueOf(convertString);
        } else if (clazz.isAssignableFrom(Double.class)) {
            variable = (T) Integer.valueOf(convertString);
        } else {
            throw new IllegalArgumentException("No type found for convert");
        }

        return variable;
    }
}
