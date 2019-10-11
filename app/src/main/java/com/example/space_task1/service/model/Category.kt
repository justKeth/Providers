package com.example.space_task1.service.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val name: String?= null,
    val parentId: Int?= null,
    val order: Int?= null,
    val picture: Picture?=null,
    val categoryId: Int?=null,
    val subCategory: MutableList<Category>?=null,
    val companyIds: MutableList<Int>?=null
): Parcelable{


    fun getContact(){
        getContact()
    }
}