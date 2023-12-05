package org.recherche.app_allocation_gestion_part.models

data class HistoryRequest(
    val get_date: String,
    val id_car: Int,
    val id_user: Int,
    val is_dup: Boolean,
    val price_: Int,
    val ret_date: String
)