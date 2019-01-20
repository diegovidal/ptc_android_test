package dvidal.com.productschallenge.features.splash.data.remote

import com.squareup.moshi.Json

/**
 * @author diegovidal on 19/01/19.
 */

class RemoteConfigResponse(
        val success: String,
        val session: Session,
        val metadata: Metadata
)

class Session(
        
    val id: String = "",
    val expire: String? = null,
    @Json(name = "YII_CSRF_TOKEN") val token: String? = ""
)

class Metadata(
        val currency: Currency,
        val languages: List<Language>,
        val support: Support
)

class Currency (
        
    val iso: String = "",
    @Json(name = "currency_symbol") val currencySymbol: String = "",
    val position: Int = 0,
    val decimals: Int = 0,
    @Json(name = "thousands_sep") val thousandsSep: String = "",
    @Json(name = "decimals_sep") val decimalsSep: String = ""
)

class Language (
        
    val code: String = "",
    val name: String = "",
    val default: Boolean = false
)

class Support (
        
    val phone_number: String = "",
    @Json(name = "call_to_order_enabled") val callToOrderEnabled: Boolean = false,
    @Json(name = "cs_email") val csEmail: String = ""
)