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

    fun getCurrentPage(): Int {

        return sharedPreferences.getInt(CURRENT_PAGE, 1)
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
                ?.putInt(CURRENT_PAGE, 1)
                ?.apply()
    }

    fun clear() {

        sharedPreferences.edit()
                .clear().apply()
    }

    companion object {

        private const val CURRENT_PAGE = "CURRENT_PAGE"
        private const val CURRENCY_SYMBOL = "CURRENCY_SYMBOL"
    }
}