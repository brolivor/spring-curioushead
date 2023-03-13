package com.curioushead.transformation.schema;

import com.curioushead.transformation.schema.csv.CSVRawViewSchemaMapper;

public class SchemaParserImpl implements SchemaParser {
    public String rawView = null;

    @Override
    public byte[] readRawProfile(String string) {
        try {
            if (!(this.rawView).isEmpty()) {
                if (this.rawView.contains("_csv")) {
                    CSVRawViewSchemaMapper rawViewSchemaMapper = new CSVRawViewSchemaMapper();
                    rawViewSchemaMapper.convertJsonToJavaClass("RawViewModel",
                            "com.curioushead.transformation.models",
                            string,
                            "/Users/madhur/IdeaProjects/spring-curioushead/transformation/src/main/java/");
                }
            }
        } catch (Exception e) {
            System.out.println("An exception has occurred: " + e);
        }
        return new byte[0];
    }
}
