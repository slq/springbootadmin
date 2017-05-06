package com.esens.admin.activity;

import com.esens.admin.facility.Hall;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_alokacja_pojedyncza", schema = "indywidualne")
public class Activity implements Serializable {

    @Id
    @Column(name = "id_alokacja_pojedyncza")
    private Long id;

    @Column(name = "data_alok")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Hall hall;

    @ManyToOne
    @JoinColumn(name = "apzc_id_grupa")
    private Group group;

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
