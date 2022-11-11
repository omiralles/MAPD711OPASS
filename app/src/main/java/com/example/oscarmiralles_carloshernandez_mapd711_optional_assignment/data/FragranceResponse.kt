package com.example.oscarmiralles_carloshernandez_mapd711_optional_assignment.data

/**
 * Object to store the data received from the service.
 */
data class FragranceResponse(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: Array<String>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FragranceResponse

        if (!images.contentEquals(other.images)) return false

        return true
    }

    override fun hashCode(): Int {
        return images.contentHashCode()
    }

}
