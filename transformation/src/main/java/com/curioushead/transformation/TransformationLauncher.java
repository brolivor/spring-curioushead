package com.curioushead.transformation;

import com.curioushead.transformation.objectFactory.SerializedSingleton;

public class TransformationLauncher {
    public static void main(String[] args) {
        SerializedSingleton serializedSingleton = SerializedSingleton.getInstance();
        serializedSingleton.setContext(args[0], args[1]);
    }
}
