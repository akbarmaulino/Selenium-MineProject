package com.mineproject;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
@Data
public class ResponseEmployee {
    /*
    {
        "name": "Akbar Maulino",
        "job": "Quality Assurance",
        "id": "8",
        "createdAt": "2025-07-16T06:19:31.606Z"
    }
     */


    // Implementation Deserialization
    @JsonProperty("id")
    public int id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("job")
    public String job;
    @JsonProperty("createdAt")
    public String createdAt;

    public ResponseEmployee(){
        
    }
}
