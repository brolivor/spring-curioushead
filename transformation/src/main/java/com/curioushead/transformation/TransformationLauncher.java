package com.curioushead.transformation;

import com.curioushead.transformation.objectFactory.SerializedSingleton;
import com.curioushead.transformation.schema.SchemaParserImpl;

public class TransformationLauncher {
    public static void main(String[] args) {
        SerializedSingleton serializedSingleton = SerializedSingleton.getInstance();
        serializedSingleton.setContext(args[0]);
        SchemaParserImpl schemaParserImpl = new SchemaParserImpl();
    }
}
