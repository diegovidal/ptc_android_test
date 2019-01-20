package dvidal.com.productschallenge.core.datasource.sharedpreferences

import android.content.SharedPreferences

/**
 * @author diegovidal on 19/01/19.
 */

class GeneralPreferencesManager(
        private val sharedPreferences: SharedPreferences
) {

    fun getCurrencySymbol(): String {

        return sharedPreferences.getString(CURRENCY_SYMBOL, "") ?: ""
    }

    fun saveCurrencySymbol(currencySymbol: String) {

        sharedPreferences.edit()
                ?.putString(CURRENCY_SYMBOL, currencySymbol)
                ?.apply()
    }

    fun getTotalProducts(): Int {

        return sharedPreferences.getInt(TOTAL_PRODUCTS, 0)
    }

    fun saveTotalProducts(totalProducts: Int) {

        sharedPreferences.edit()
                ?.putInt(TOTAL_PRODUCTS, totalProducts)
                ?.apply()
    }

    fun getCurrentPage(): Int {

        return sharedPreferences.getInt(CURRENT_PAGE, 0)
    }

    fun incrementCurrentPage(): Int {

        val nextPage = getCurrentPage() + 1

        sharedPreferences.edit()
                ?.putInt(CURRENT_PAGE, nextPage)
                ?.apply()

        return nextPage
    }

    fun clearCurrentPage() {

        sharedPreferences.edit()
                ?.putInt(CURRENT_PAGE, 0)
                ?.apply()
    }

    fun clear() {

        sharedPreferences.edit()
                .clear().apply()
    }

    companion object {

        private const val CURRENT_PAGE = "CURRENT_PAGE"
        private const val CURRENCY_SYMBOL = "CURRENCY_SYMBOL"
        private const val TOTAL_PRODUCTS = "TOTAL_PRODUCTS"
    }
}