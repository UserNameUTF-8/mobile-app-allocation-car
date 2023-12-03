package org.recherche.app_allocation_gestion_part.models

data class UserResponse(
    val created_at: String,
    val email_user: String,
    val id_user: Int,
    val ip_user: String,
    val is_active: Boolean,
    val is_banned: Boolean,
    val name_user: String,
    val password_user: String,
    val points: Int,
    val updated_at: String
)

