package com.esens.admin.facility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_sala", schema = "indywidualne")
public class Hall {

    @Id
    @Column(name = "id_sala")
    private Long id;

    @Column(name = "nazwa_skrocona")
    private String name;

    @Column(name = "nazwa")
    private String description;

    @ManyToOne
    @JoinColumn(name= "id_budynek")
    private Location location;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Hall{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}
