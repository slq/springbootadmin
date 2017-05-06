package com.esens.admin.activity;

import java.time.LocalDate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import static com.esens.admin.activity.Activity.anActivityOn;
import static java.time.Month.APRIL;

@Controller
public class ActivityController {

    @Autowired
    private ActivityRepository repository;

    @RequestMapping("/activity")
    public String allActivities(Map<String, Object> model) {
        Activity activity = anActivityOn(LocalDate.of(2017, APRIL, 12));
        Example<Activity> matcher = Example.of(activity);

        model.put("activities", repository.findAll(matcher));
        return "activities";
    }
}
