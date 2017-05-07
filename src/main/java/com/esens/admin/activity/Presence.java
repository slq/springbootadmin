package com.esens.admin.activity;

import com.esens.admin.client.Client;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_obecnosc", schema = "klient")
public class Presence {

    @Id
    @Column(name = "id_obecnosc")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_alok_poj_zaj_cykl")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name="id_klient")
    private Client client;

    public Long getId() {
        return id;
    }

    public Activity getActivity() {
        return activity;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Presence{");
        sb.append("id=").append(id);
        sb.append(", activity=").append(activity);
        sb.append(", client=").append(client);
        sb.append('}');
        return sb.toString();
    }
}
