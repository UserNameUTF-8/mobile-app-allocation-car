package org.recherche.app_allocation_gestion_part.models

data class HistoryResponse(
    val get_date: String,
    val id_car: Int,
    val id_history: Int,
    val id_user: Int,
    val is_active: Boolean,
    val is_dup: Boolean,
    val price_: Double,
    val ret_date: String
)