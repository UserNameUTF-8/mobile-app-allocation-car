package org.recherche.app_allocation_gestion_part.models

data class CarResponse(
    val color_car: String,
    val id_car: Int,
    val identifyer_car: String,
    val is_active_car: Int,
    val is_allocated_car: Int,
    val is_mapped_car: Int,
    val model: String,
    val price_k_dinar: Double
)