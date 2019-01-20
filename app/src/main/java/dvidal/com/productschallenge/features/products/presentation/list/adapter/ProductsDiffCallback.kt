package dvidal.com.productschallenge.features.products.presentation.list.adapter

import androidx.recyclerview.widget.DiffUtil
import dvidal.com.productschallenge.features.products.presentation.ProductView

/**
 * @author diegovidal on 15/06/2018.
 */
internal class ProductsDiffCallback(private val oldList: List<ProductView>,
                                    private val newList: List<ProductView>)
    : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].sku == newList[newItemPosition].sku
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}