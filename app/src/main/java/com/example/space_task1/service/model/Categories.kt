package com.example.space_task1.service.model

data class Categories(
    val name: String?= null,
    val parentId: Int?= null,
    val order: Int?= null,
    val picture: Picture?=null,
    val categoryId: Int?=null,
    val subCategory: MutableList<Categories>?=null,
    val companyIds: MutableList<Int>?=null
){


    fun getContact(){
        getContact()
    }
}