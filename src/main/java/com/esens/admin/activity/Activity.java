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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Activity{");
        sb.append("id=").append(id);
        sb.append(", hall=").append(hall);
        sb.append('}');
        return sb.toString();
    }
}
