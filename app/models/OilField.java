package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "oil_fields")
public class OilField extends Model {

    public static Find<Long, OilField> find = new Find<Long, OilField>() {
    };

    @Id
    public Long id;

    @OneToMany(mappedBy = "oilField")
    public List<User> user;

    @Column
    @Constraints.Required
    public String oilFieldsName;

    @ManyToOne(optional = false)
    public Asset asset;

    @Column
    public Long bestMargin;

    @Column
    public String bestScenario;

    @OneToMany(mappedBy = "oilField")
    public List<Scenario> scenarios;

}
