package com.esens.admin.activity;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import static com.esens.admin.activity.Activity.anActivityBy;
import static com.esens.admin.activity.Activity.anActivityOn;
import static java.time.Month.APRIL;
import static java.util.stream.Collectors.toList;
import static org.springframework.data.domain.ExampleMatcher.matching;

@Controller
public class ActivityController {

    public static final ExampleMatcher MATCHER = matching().withIgnorePaths("beginning", "end");
    @Autowired
    private ActivityRepository repository;

    @ModelAttribute("clientPresence")
    public ClientPresence getClientPresence() {
        return new ClientPresence();
    }

    @GetMapping("/activity")
    public String allActivities(Map<String, Object> model) {
        model.put("activities", getAllActivities());
        return "activities";
    }

    @GetMapping("/activity/{id}")
    public String members(Map<String, Object> model, @PathVariable Long id) {
        model.put("activities", getAllActivities());
        model.put("participants", getParticipantsOf(id));
        return "activities";
    }

    private List<Activity> getAllActivities() {
        Activity activity = anActivityOn(LocalDate.of(2017, APRIL, 13));
        Example<Activity> activityExample = Example.of(activity, MATCHER);

        return repository.findAll(activityExample, new Sort("beginning"));
    }

    private Collection<Participant> getParticipantsOf(Long activityId) {
        Activity activity = anActivityBy(repository.findOne(activityId).getWeeklyId());
        Example<Activity> activityExample = Example.of(activity, MATCHER);

        return repository.findAll(activityExample).stream()
                .flatMap(a -> a.getParticipants().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(map -> map.getValue() > 1)
                .map(Map.Entry::getKey)
                .sorted((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()))
                .collect(toList());
    }

    @PostMapping("/activity")
    public String savePresence(@ModelAttribute ClientPresence clientPresence) {

        return "activities";
    }
}
