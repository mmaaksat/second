package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "oil_fields")
public class OilField extends Model {

    public static Find<Long, OilField> find = new Find<Long, OilField>() {
    };

    @Id
    public Long id;

    @Column(name = "oil_fields_name")
    @Constraints.Required
    public String oilFieldsName;

    @JsonBackReference
    @ManyToOne(optional = false)
    public Asset asset;

    @Column
    public Long bestMargin;

    @Column
    public String bestScenario;

    @JsonBackReference
    @OneToMany(mappedBy = "oilField")
    public List<Scenario> scenario;

    @JsonBackReference
    @OneToMany(mappedBy = "oilField")
    public List<OilUsers> oilUsers;


    public void creatOilField( String oilFieldsName, Asset asset){
        this.oilFieldsName = oilFieldsName;
        this.asset = asset;
        this.save();
    }
    public void editOilField(Long id, String oilFieldsName, Asset asset){
        OilField oilField = OilField.find.where().eq("id",id).findUnique();
        oilField.oilFieldsName = oilFieldsName;
        oilField.asset = asset;
        oilField.save();
    }
    public void deleteOilField(Long id){
        OilField oilField = OilField.find.where().eq("id",id).findUnique();
        oilField.delete();
    }


}
