package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import javax.persistence.*;
import play.data.validation.Constraints;

import java.util.List;


@Entity
@Table(name = "Year_Records")
public class YearRecords extends Model{

    @Id
    private Long id;

    @Column
    @Constraints.Required
    private Long year;

    @Column
    private Long scenarioId;

    @Column
    private Long creditPayments;

    @Column
    private Long fieldDevelopmentCost;

    @Column
    private Long yearCosts;

    @Column
    private Long oilSold;

    @Column
    private Long oilPrice;

    @Column
    private Long startYear;

    @Column
    private Long income;

    @Column
    private Long yearMargins;



}

