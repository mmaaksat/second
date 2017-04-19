package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import javax.persistence.*;
import play.data.validation.Constraints;

import java.util.List;


@Entity
@Table(name = "Oil_Fields")
public class OilFields extends Model{

    @Id
    private Long id;

    @Column
    @Constraints.Required
    private String oilFieldsName;

    @Column
    private Long assetsId;

    @Column
    private Long bestMargin;

    @Column
    private String bestScenario;

    @ManyToOne(optional=false)
    private User user;
}
