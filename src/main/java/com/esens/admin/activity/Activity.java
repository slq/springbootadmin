package com.esens.admin.activity;

import com.esens.admin.facility.Hall;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import static com.esens.admin.activity.Participant.aParticipant;

@Entity
@Table(name = "tab_alokacja_pojedyncza", schema = "indywidualne")
public class Activity implements Serializable {

    @Id
    @Column(name = "id_alokacja_pojedyncza")
    private Long id;

    @Column(name = "data_alok")
    private Date date;

    @Column(name = "id_poczatek")
    private int beginning;

    @Column(name = "id_koniec")
    private int end;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "apzc_id_grupa")
    private Group group;

    @OneToMany(mappedBy = "activity")
    private Set<Presence> presence = new HashSet<>();

    public static Activity anActivityOn(LocalDate date) {
        Activity activity = new Activity();
        activity.date = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return activity;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Hall getHall() {
        return hall;
    }

    public Group getGroup() {
        return group;
    }

    public String getBeginning() {
        return quaterToString(beginning);
    }

    public String getEnd() {
        return quaterToString(end);
    }

    private String quaterToString(int quater) {
        int hour = quater / 4;
        int minute = 15 * (quater % 4);

        return String.format("%d:%d", hour, minute);
    }

    public Set<Presence> getPresence() {
        return presence;
    }

    public Set<Participant> getParticipants() {
        Set<Participant> result = new HashSet<>();
        getGroup().getMembers().stream()
                .forEach(member -> result.add(aParticipant(member.getName(), member.getLastName())));

        getPresence().stream()
                .forEach(p -> result.add(aParticipant(p.getClient().getName(), p.getClient().getLastName())));

        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Activity{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", hall=").append(hall);
        sb.append(", group=").append(group);
        sb.append('}');
        return sb.toString();
    }
}
