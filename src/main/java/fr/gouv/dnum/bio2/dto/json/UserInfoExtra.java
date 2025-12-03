package fr.gouv.dnum.bio2.dto.json;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserInfoExtra {

    private UserInfo userInfo;
    private Map<String, String> extras;

    public UserInfoExtra() {
        this.extras = new HashMap<>();
    }

}