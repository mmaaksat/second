package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import javax.persistence.*;
import play.data.validation.Constraints;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")
public class User extends Model{

    @Id
    private Long id;

    @Column
    @Constraints.Required
    private String login;

    @Column
    private String password;

    @Column
    private Long roleId;

    @ManyToOne(optional=false)
    private OilFields oilFields;

    @ManyToOne(optional=false)
    private Assets assets;

    /*public User(String login, String password, Long roleId, int oilFields, int assets){
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.oilFields = oilFields;
        this.assets = assets;
        Ebean.save(this);
    }*/

}
