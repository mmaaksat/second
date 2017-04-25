package models;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.data.validation.Constraints;

import javax.persistence.*;


@Entity
@Table(name = "oil_users")
public class OilUsers extends Model {

    public static Find<Long, OilUsers> find = new Find<Long, OilUsers>() {
    };

    @Id
    public Long id;

    @Column
    @Constraints.Required
    public String login;

    @Column
    public String password;

    //    public Long roleId;
    //  Enum is better to understand in coding, better guessing what was role with id 3
    @Enumerated(EnumType.STRING)
    public Role role = Role.OIL_ADMIN;

    @JsonBackReference
    @ManyToOne(optional = false)
    public OilField oilField;


    public enum Role {
        @EnumValue("1")
        OIL_ADMIN,
        @EnumValue("2")
        Oil_VIEW
    }

}
