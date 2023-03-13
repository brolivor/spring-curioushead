package com.curioushead.transformation.schema.csv;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;

@JsonIgnoreProperties
public class CSVRawViewSchemaMapper {
    JCodeModel jcodeModel = new JCodeModel();

    GenerationConfig config = new DefaultGenerationConfig() {
        @Override
        public boolean isGenerateBuilders() {
            return true;
        }

        @Override
        public SourceType getSourceType() {
            return SourceType.JSON;
        }
    };

    public void convertJsonToJavaClass(String javaClassName, String packageName, String payload, String outputJavaClassDirectory) throws IOException {

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config),
                new SchemaStore()), new SchemaGenerator());
        mapper.generate(jcodeModel, javaClassName, packageName, payload);

        jcodeModel.build(new File(outputJavaClassDirectory));
    }
}
