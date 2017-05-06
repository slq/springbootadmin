package com.esens.admin.activity;

import com.esens.admin.customer.Member;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "grupowe", name = "tab_grupa")
public class Group {

    @Id
    @Column(name = "id_grupa")
    private Long id;

    @Column(name = "identyfikator")
    private String name;

    @Column(name = "nazwa")
    private String description;

    @OneToMany(mappedBy = "group")
    private Set<Member> members = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Member> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Group{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
