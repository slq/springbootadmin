package com.esens.admin.facility;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "indywidualne", name = "tab_budynek")
public class Location implements Serializable {

    @Id
    @Column(name = "id_budynek")
    private Long id;

    @Column(name = "adres")
    private String address;

    @OneToMany(mappedBy = "location")
    private Set<Hall> halls = new HashSet<>();

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Location{");
        sb.append("id=").append(id);
        sb.append(", address='").append(address).append('\'');
//        sb.append(", halls=").append(halls);
        sb.append('}');
        return sb.toString();
    }
}
