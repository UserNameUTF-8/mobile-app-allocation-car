package org.recherche.app_allocation_gestion_part.models

data class UserUpdate(
    val id_user: Int,
    val is_banned: Boolean,
    val name_user: String,
    val points: Int
)