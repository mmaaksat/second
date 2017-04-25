package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.data.validation.Constraints;

import javax.persistence.*;


@Entity
@Table(name = "assets_users")
public class AssetsUser extends Model {

    public static Find<Long, AssetsUser> find = new Find<Long, AssetsUser>() {
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
    public Role role = Role.ASSET_ADMIN;


    @JsonBackReference
    @ManyToOne(optional = false)
    public Asset asset;



    public enum Role {
        @EnumValue("1")
        ASSET_ADMIN,
        @EnumValue("2")
        ASSET_VIEW,
    }

}
