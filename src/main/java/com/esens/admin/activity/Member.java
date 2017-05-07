package com.esens.admin.activity;

import com.esens.admin.client.Client;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.util.StringUtils;

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

    @OneToOne
    @JoinColumn(name = "id_klient")
    private Client client;

    public Long getId() {
        return id;
    }

    public String getName() {
        if(!StringUtils.isEmpty(name)){
            return name;
        }

        if(client != null){
            return client.getName();
        }

        return null;
    }

    public String getLastName() {
        if(!StringUtils.isEmpty(lastName)){
            return lastName;
        }

        if(client != null){
            return client.getLastName();
        }

        return null;
    }

    public Group getGroup() {
        return group;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Member{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", group=").append(group);
        sb.append(", client=").append(client);
        sb.append('}');
        return sb.toString();
    }
}
