package com.gundersonstudios.dndstatstracker.model;

import java.util.HashMap;

/**
 * A repository for holding an instance of all classes in the project, so that dependencies can be
 * resolved from anywhere in the app
 */
public class DependencyRepository {

    private static HashMap<Class, Object> singletonMap = new HashMap<Class, Object>();

    /**
     * Construct the dependency repository
     */
    public DependencyRepository() {
    }

    public static void initDependencyRepository() {
        addSingleton(CoreModel.class, new CoreModel());
    }

    private static void addSingleton(Class classToAdd, Object objectToAdd) {
        singletonMap.put(classToAdd, objectToAdd);
    }

    public static Object resolveDependency(Class key) {
        return singletonMap.get(key);
    }
}
