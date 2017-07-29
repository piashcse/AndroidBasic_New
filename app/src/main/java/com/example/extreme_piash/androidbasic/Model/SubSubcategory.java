package com.example.extreme_piash.androidbasic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by piash on 7/29/17.
 */

public class SubSubcategory {

    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("SubCategoryId")
    @Expose
    private Integer subCategoryId;
    @SerializedName("SubSubCategoryId")
    @Expose
    private Integer subSubCategoryId;
    @SerializedName("SubSubCategoryName")
    @Expose
    private String subSubCategoryName;
    @SerializedName("SubSubCategoryNameInEnglish")
    @Expose
    private String subSubCategoryNameInEnglish;
    @SerializedName("SubSubCategoryShowOrder")
    @Expose
    private Integer subSubCategoryShowOrder;

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

    public Integer getSubSubCategoryId() {
        return subSubCategoryId;
    }

    public void setSubSubCategoryId(Integer subSubCategoryId) {
        this.subSubCategoryId = subSubCategoryId;
    }

    public String getSubSubCategoryName() {
        return subSubCategoryName;
    }

    public void setSubSubCategoryName(String subSubCategoryName) {
        this.subSubCategoryName = subSubCategoryName;
    }

    public String getSubSubCategoryNameInEnglish() {
        return subSubCategoryNameInEnglish;
    }

    public void setSubSubCategoryNameInEnglish(String subSubCategoryNameInEnglish) {
        this.subSubCategoryNameInEnglish = subSubCategoryNameInEnglish;
    }

    public Integer getSubSubCategoryShowOrder() {
        return subSubCategoryShowOrder;
    }

    public void setSubSubCategoryShowOrder(Integer subSubCategoryShowOrder) {
        this.subSubCategoryShowOrder = subSubCategoryShowOrder;
    }

}
