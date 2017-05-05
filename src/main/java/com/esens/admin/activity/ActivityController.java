package com.esens.admin.activity;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityController {

    @Autowired
    private ActivityRepository repository;

    @RequestMapping("/activity")
    public String allActivities(Map<String, Object> model) {
        model.put("activities", repository.findOne(86613L));
        return "activities";
    }
}
