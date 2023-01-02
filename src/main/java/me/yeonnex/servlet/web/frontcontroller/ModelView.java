package me.yeonnex.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ModelView {
    private final Map<String, Object> model = new HashMap<>();
    private String viewName;

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

}
