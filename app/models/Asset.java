package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "asset")
public class Asset extends Model {

    public static Find<Long, Asset> find = new Find<Long, Asset>() {};

    @Id
    public Long id;

    @Column
    @Constraints.Required
    public String name;

    @JsonBackReference
    @JsonIgnoreProperties("asset")
    @OneToMany(mappedBy = "asset")
    public List<AssetsUser> assetsUsers;

    @JsonBackReference
    @OneToMany(mappedBy = "asset")
    public List<OilField> oilFields;
}
