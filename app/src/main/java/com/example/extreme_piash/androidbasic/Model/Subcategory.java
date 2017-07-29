package com.example.extreme_piash.androidbasic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by piash on 7/29/17.
 */

public class Subcategory {
    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("SubCategoryId")
    @Expose
    private Integer subCategoryId;
    @SerializedName("SubCategoryName")
    @Expose
    private String subCategoryName;
    @SerializedName("SubCategoryNameInEnglish")
    @Expose
    private String subCategoryNameInEnglish;
    @SerializedName("SubCategoryShowOrder")
    @Expose
    private Integer subCategoryShowOrder;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryNameInEnglish() {
        return subCategoryNameInEnglish;
    }

    public void setSubCategoryNameInEnglish(String subCategoryNameInEnglish) {
        this.subCategoryNameInEnglish = subCategoryNameInEnglish;
    }

    public Integer getSubCategoryShowOrder() {
        return subCategoryShowOrder;
    }

    public void setSubCategoryShowOrder(Integer subCategoryShowOrder) {
        this.subCategoryShowOrder = subCategoryShowOrder;
    }
}
