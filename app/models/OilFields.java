package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import play.data.validation.Constraints;

import java.util.List;


@Entity
@Table(name = "Oil_Fields")
public class OilFields extends Model{

    @Id
    private Long id;

    @OneToMany(mappedBy="oilFields")
    private List<User> user;

    @Column
    @Constraints.Required
    private String oilFieldsName;

    @ManyToOne(optional=false)
    private Assets asset;

    @Column
    private Long bestMargin;

    @Column
    private String bestScenario;

    @OneToMany(mappedBy="oilFields")
    private List<Scenarios> scenarios;

    public void setOilField(String oilFieldsName,Long asset_id){
        this.oilFieldsName = oilFieldsName;
        Assets assets = Assets.findAssetById(asset_id);
        this.asset = assets;
        Ebean.save(this);
    }
}
