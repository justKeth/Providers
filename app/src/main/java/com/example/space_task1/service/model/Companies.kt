package com.example.space_task1.service.model

data class Companies(
    val name: String?=null,
    val parentId: Int?=null,
    val order: Int?=null,
    val picture: Picture?=null,
    val companyId: Int?=null,
    val keywords: String?=null,
    val needsAuthorization: Boolean?=null,
    val popularity: Int?=null,
    val paymentCount: Int?=null,
    val priority: Int?=null
)