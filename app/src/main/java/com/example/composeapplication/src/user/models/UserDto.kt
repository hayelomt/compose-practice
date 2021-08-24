package com.example.composeapplication.src.user.models

import com.example.composeapplication.shared.network.Mappable
import com.google.gson.annotations.SerializedName
import com.example.composeapplication.shared.network.NetworkResponse

data class UserDto(
    @SerializedName("address")
    val address: Address?,
    @SerializedName("company")
    val company: Company?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("website")
    val website: String?
): Mappable<User> {

    override fun mapToModel():User = User(
                id = id ?: 0,
                name = name ?: "",
                email = email ?: "",
                username = username ?: "",
            )

    private fun isValid() = id != null

    data class Address(
        @SerializedName("city")
        val city: String?,
        @SerializedName("geo")
        val geo: Geo?,
        @SerializedName("street")
        val street: String?,
        @SerializedName("suite")
        val suite: String?,
        @SerializedName("zipcode")
        val zipcode: String?
    ) {
        data class Geo(
            @SerializedName("lat")
            val lat: String?,
            @SerializedName("lng")
            val lng: String?
        )
    }

    data class Company(
        @SerializedName("bs")
        val bs: String?,
        @SerializedName("catchPhrase")
        val catchPhrase: String?,
        @SerializedName("name")
        val name: String?
    )
}