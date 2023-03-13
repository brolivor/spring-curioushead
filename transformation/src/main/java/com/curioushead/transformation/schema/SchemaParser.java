package com.curioushead.transformation.schema;

import com.curioushead.transformation.schema.csv.CSVRawViewSchemaMapper;

public class SchemaParser {
    private static final String PACKAGE_NAME = "com.curioushead.transformation.models";
    private static final String RAW_MODEL_NAME = "RawViewModel";

    public static void readRawProfile(String profileName, String classOutputPath) {
        try {
            if (!(profileName).isEmpty()) {
                if (profileName.contains("_csv")) {
                    CSVRawViewSchemaMapper rawViewSchemaMapper = new CSVRawViewSchemaMapper();
                    rawViewSchemaMapper.convertJsonToJavaClass(RAW_MODEL_NAME,
                            PACKAGE_NAME,
                            profileName,
                            classOutputPath
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("An exception has occurred: " + e);
        }
    }

}
