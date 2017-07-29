package com.example.extreme_piash.androidbasic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by piash on 7/29/17.
 */

public class BaseModel {
    @SerializedName("Categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("Subcategories")
    @Expose
    private List<Subcategory> subcategories = null;
    @SerializedName("SubSubcategories")
    @Expose
    private List<SubSubcategory> subSubcategories = null;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public List<SubSubcategory> getSubSubcategories() {
        return subSubcategories;
    }

    public void setSubSubcategories(List<SubSubcategory> subSubcategories) {
        this.subSubcategories = subSubcategories;
    }

}
