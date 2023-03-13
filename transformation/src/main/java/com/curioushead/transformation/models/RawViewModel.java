
package com.curioushead.transformation.models;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "delimiter",
    "schema_type",
    "column_1",
    "column_2"
})
@Generated("jsonschema2pojo")
public class RawViewModel {

    @JsonProperty("delimiter")
    private String delimiter;
    @JsonProperty("schema_type")
    private String schemaType;
    @JsonProperty("column_1")
    private String column1;
    @JsonProperty("column_2")
    private String column2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("delimiter")
    public String getDelimiter() {
        return delimiter;
    }

    @JsonProperty("delimiter")
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public RawViewModel withDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    @JsonProperty("schema_type")
    public String getSchemaType() {
        return schemaType;
    }

    @JsonProperty("schema_type")
    public void setSchemaType(String schemaType) {
        this.schemaType = schemaType;
    }

    public RawViewModel withSchemaType(String schemaType) {
        this.schemaType = schemaType;
        return this;
    }

    @JsonProperty("column_1")
    public String getColumn1() {
        return column1;
    }

    @JsonProperty("column_1")
    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public RawViewModel withColumn1(String column1) {
        this.column1 = column1;
        return this;
    }

    @JsonProperty("column_2")
    public String getColumn2() {
        return column2;
    }

    @JsonProperty("column_2")
    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public RawViewModel withColumn2(String column2) {
        this.column2 = column2;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public RawViewModel withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RawViewModel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("delimiter");
        sb.append('=');
        sb.append(((this.delimiter == null)?"<null>":this.delimiter));
        sb.append(',');
        sb.append("schemaType");
        sb.append('=');
        sb.append(((this.schemaType == null)?"<null>":this.schemaType));
        sb.append(',');
        sb.append("column1");
        sb.append('=');
        sb.append(((this.column1 == null)?"<null>":this.column1));
        sb.append(',');
        sb.append("column2");
        sb.append('=');
        sb.append(((this.column2 == null)?"<null>":this.column2));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.schemaType == null)? 0 :this.schemaType.hashCode()));
        result = ((result* 31)+((this.column1 == null)? 0 :this.column1 .hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.delimiter == null)? 0 :this.delimiter.hashCode()));
        result = ((result* 31)+((this.column2 == null)? 0 :this.column2 .hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RawViewModel) == false) {
            return false;
        }
        RawViewModel rhs = ((RawViewModel) other);
        return ((((((this.schemaType == rhs.schemaType)||((this.schemaType!= null)&&this.schemaType.equals(rhs.schemaType)))&&((this.column1 == rhs.column1)||((this.column1 != null)&&this.column1 .equals(rhs.column1))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.delimiter == rhs.delimiter)||((this.delimiter!= null)&&this.delimiter.equals(rhs.delimiter))))&&((this.column2 == rhs.column2)||((this.column2 != null)&&this.column2 .equals(rhs.column2))));
    }

}
