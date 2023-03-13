package com.curioushead.transformation.objectFactory;

import com.curioushead.transformation.schema.SchemaParser;

import java.io.Serial;
import java.io.Serializable;

public class SerializedSingleton implements Serializable {

    @Serial
    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton() {
    }

    public void setContext(String profileName, String classOutputPath) {
        SchemaParser.readRawProfile(profileName, classOutputPath);
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}
