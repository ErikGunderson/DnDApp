package com.gundersonstudios.dndstatstracker.model;

import com.gundersonstudios.dndstatstracker.HealthFragment;
import com.gundersonstudios.dndstatstracker.base.IConvertibleVariable;

import java.util.HashMap;

/**
 * A repository for holding an instance of all classes in the project, so that dependencies can be
 * resolved from anywhere in the app
 */
public class DependencyRepository {

    private static HashMap<Class, Class> singletonMap = new HashMap();

    /**
     * Construct the dependency repository
     */
    public DependencyRepository() {
        //not a real singleton addition, here for reference
        addSingleton(HealthFragment.class, IConvertibleVariable.class);
    }

    private void addSingleton(Class classToAdd, Class interfaceToAdd) {
        singletonMap.put(interfaceToAdd, classToAdd);
    }

    public static Class resolveDependency(Class key) {
        return singletonMap.get(key);
    }
}
