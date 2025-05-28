package com.back;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
    private final String cmd;
    private final Map<String, String> param;

    Rq(String input) {
        String[] tok = input.split("\\?");
        this.cmd = tok[0];
        String query = tok.length > 1 ? tok[1].trim() : "";
        param = Arrays.stream(query.split("&"))
                .map(para -> para.split("=", 2))
                .filter(bits -> bits.length == 2 && !bits[0].trim().isEmpty() && !bits[1].trim().isEmpty())
                .collect(Collectors.toMap(
                        bits -> bits[0].trim(),
                        bits -> bits[1].trim()
                ));
    }

    public String getCmd() {
        return cmd;
    }

    public String getParam(String key) {
        return param.get(key);
    }
}
