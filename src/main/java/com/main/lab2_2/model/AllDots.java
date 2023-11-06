package com.main.lab2_2.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedList;

public class AllDots {
    public LinkedList<Dot> list;
    
    public AllDots() {
        this.list = new LinkedList<>();
    }
    public AllDots(LinkedList<Dot> list) {
        this.list = list;
    }
    
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        return json;
    }
}
