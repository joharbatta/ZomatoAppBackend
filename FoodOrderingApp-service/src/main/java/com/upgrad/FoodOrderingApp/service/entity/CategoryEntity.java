package com.upgrad.FoodOrderingApp.service.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name="category")
@NamedQueries({
        @NamedQuery(name = "allCategories", query = "select c from CategoryEntity c ORDER BY c.category_name ASC"),
        @NamedQuery(name = "categoryById", query = "select c from CategoryEntity c where c.uuid=:catuuid")
})
public class CategoryEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID")
    @Size(max = 200)
    private String uuid;

    @Column(name = "CATEGORY_NAME")
    @Size(max = 255)
    private String category_name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemEntity> item = new ArrayList<ItemEntity>();


    public List<ItemEntity> getItem() {
        return item;
    }

    public void setItem(List<ItemEntity> item) {
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public static Comparator<CategoryEntity> CatNameComparator = new Comparator<CategoryEntity>() {

        public int compare(CategoryEntity c1, CategoryEntity c2) {
            String CatName1 = c1.getCategory_name().toUpperCase();
            String CatName2 = c2.getCategory_name().toUpperCase();

            //ascending order
            return CatName1.compareTo(CatName2);
        }};

}
