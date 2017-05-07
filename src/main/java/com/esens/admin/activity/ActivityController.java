package com.esens.admin.activity;


import java.time.LocalDate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
        Activity activity = anActivityOn(LocalDate.of(2017, APRIL, 13));
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("beginning", "end");
        Example<Activity> activityExample = Example.of(activity, matcher);

        model.put("activities", repository.findAll(activityExample));
        model.put("participants", repository.findOne(87727L).getParticipants());
        model.put("members", repository.findOne(87727L).getGroup().getMembers());
        return "activities";
    }
}
