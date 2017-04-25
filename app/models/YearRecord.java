package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.data.validation.Constraints;

import javax.persistence.*;


@Entity
@Table(name = "year_records")
public class YearRecord extends Model {

    @Id
    public Long id;

    public static Find<Long, YearRecord> find = new Find<Long, YearRecord>() {
    };

    @Column
    @Constraints.Required
    public Long year;

    @JsonBackReference
    @ManyToOne(optional = false)
    public Scenario scenario;

    @Column
    public Long creditPayments, fieldDevelopmentCost, yearCosts, oilSold, oilPrice, startYear, income, yearMargins;


}

