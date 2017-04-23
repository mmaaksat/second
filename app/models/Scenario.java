package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "scenarios")
public class Scenario extends Model {

    public static Find<Long, Scenario> find = new Find<Long, Scenario>() {
    };

    @Id
    public Long id;

    @Column
    @Constraints.Required
    public String number;

    @ManyToOne(optional = false)
    public OilField oilField;

    @Column
    public Long tax, cost, moneyFromBank, duration, inflation, startYear, endYear;

    @Column
    public String scenarioMargin;

    @JsonBackReference
    @OneToMany(mappedBy = "scenario")
    public List<YearRecord> yearRecords;
}

