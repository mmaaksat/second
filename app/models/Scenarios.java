package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import javax.persistence.*;
import play.data.validation.Constraints;

import java.util.List;


@Entity
@Table(name = "Scenarios")
public class Scenarios extends Model{

    @Id
    private Long id;

    @Column
    @Constraints.Required
    private String number;

    @Column
    private Long oilFieldsId;

    @Column
    private Long tax;

    @Column
    private Long cost;

    @Column
    private Long moneyFromBank;

    @Column
    private Long duration;

    @Column
    private Long inflation;

    @Column
    private Long startYear;

    @Column
    private Long endYear;

    @Column
    private String scenarioMargin;
}

