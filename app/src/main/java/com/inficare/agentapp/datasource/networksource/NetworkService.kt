package com.inficare.agentapp.datasource.networksource

import com.inficare.agentapp.datasource.networksource.responsemodels.*
import io.reactivex.Observable
import retrofit2.http.*

interface NetworkService {

    @GET("/api/common/catalogue")
    fun getCatalogue(
        @Query("catalogue_type") catalogType: String,
        @Query("additional_field1") addField1: String = "",
        @Query("additional_field2") addField2: String = "",
        @Query("additional_field3") addField3: String = "",
        @Query("language") language: String = "en"
    ): Observable<Response<List<CatalogueItem>>>

    @FormUrlEncoded
    @POST("/member")
    fun getCustomerDetails(
        @Field("Customerid") customerId: String
    ): Observable<Response<MemberInfo>>

}