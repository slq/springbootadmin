package com.esens.admin.customer;

import com.esens.admin.activity.Group;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_uczestnik", schema = "grupowe")
public class Member {

    @Id
    @Column(name = "id_uczestnik")
    private Long id;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "id_grupa")
    private Group group;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Member{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", group=").append(group);
        sb.append('}');
        return sb.toString();
    }
}
