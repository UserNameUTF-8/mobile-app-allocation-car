package org.recherche.app_allocation_gestion_part.models

data class AdminResponse(
    val authority: Int,
    val created_at: String,
    val email_admin: String,
    val id_admin: Int,
    val ip_admin: String,
    val is_active: Boolean,
    val name_admin: String,
    val password_admin: String,
    val updated_at: String
)
