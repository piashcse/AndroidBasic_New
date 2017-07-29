package com.example.extreme_piash.androidbasic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by piash on 7/29/17.
 */

public class Category {
    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("CategoryName")
    @Expose
    private String categoryName;
    @SerializedName("CategoryNameInEnglish")
    @Expose
    private String categoryNameInEnglish;
    @SerializedName("CategoryShowOrder")
    @Expose
    private Integer categoryShowOrder;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryNameInEnglish() {
        return categoryNameInEnglish;
    }

    public void setCategoryNameInEnglish(String categoryNameInEnglish) {
        this.categoryNameInEnglish = categoryNameInEnglish;
    }

    public Integer getCategoryShowOrder() {
        return categoryShowOrder;
    }

    public void setCategoryShowOrder(Integer categoryShowOrder) {
        this.categoryShowOrder = categoryShowOrder;
    }
}
