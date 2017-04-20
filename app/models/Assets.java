package models;

import com.avaje.ebean.*;

import javax.persistence.*;

import com.avaje.ebean.Query;
import play.data.validation.Constraints;

import java.util.List;

import static com.avaje.ebean.Ebean.*;


@Entity
@Table(name = "Assets")
public class Assets extends Model{

    @Id
    private Long id;

    @Column
    @Constraints.Required
    private String name;

    @OneToMany(mappedBy="assets")
    private List<User> user;

    @OneToMany(mappedBy="asset")
    private List<OilFields> oilFields;

    public void setAsset(String name){
        this.name = name;
        Ebean.save(this);
    }

    public static Assets findAssetById(Long id){
        return Ebean.find(Assets.class, id);
    }

    public List getAssets(){
        return Ebean.find(Assets.class).findList();
    }



}
