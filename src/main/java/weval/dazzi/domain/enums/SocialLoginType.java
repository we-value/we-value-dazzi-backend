package weval.dazzi.domain.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Arrays;

public enum SocialLoginType {
    KAKAO("카카오"),
    NAVER("네이버"),
    INSTAGRAM("인스타그램"),
    APPLE("애플");

    private final String value;

    SocialLoginType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ObjectNode toJson() {
        ObjectNode node = new ObjectMapper().createObjectNode();
        Arrays.stream(SocialLoginType.values()).forEach(type -> node.put(type.name(), type.getValue()));
        return node;
    }
}