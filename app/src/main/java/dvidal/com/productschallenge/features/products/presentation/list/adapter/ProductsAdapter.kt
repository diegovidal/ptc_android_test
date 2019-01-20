package dvidal.com.productschallenge.features.products.presentation.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dvidal.com.productschallenge.R
import dvidal.com.productschallenge.features.products.presentation.ProductView
import kotlinx.android.synthetic.main.recycler_item_product.view.*
import java.util.*
import javax.inject.Inject

/**
 * @author diegovidal on 16/06/2018.
 */
class ProductsAdapter @Inject constructor()
    : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private var listener: ProductViewListener? = null

    private var completeData: MutableList<ProductView> = mutableListOf()
    private var currentData: MutableList<ProductView> = mutableListOf()

    fun updateData(list: List<ProductView>) {

        val diffResultComplete = DiffUtil.calculateDiff(ProductsDiffCallback(completeData, list))
        val diffResultCurrent = DiffUtil.calculateDiff(ProductsDiffCallback(currentData, list))
        diffResultComplete.dispatchUpdatesTo(this)
        diffResultCurrent.dispatchUpdatesTo(this)

        completeData.clear()
        currentData.clear()
        completeData.addAll(list)
        currentData.addAll(list)
        notifyDataSetChanged()
    }

    fun searchFor(text: String) {

        currentData.clear()
        currentData.addAll(completeData.filter {
            it.name.contains(text, true) || it.brand.contains(text, true) || text.isEmpty()
        }).also {
            notifyDataSetChanged()
        }
    }

    fun configureListener(l: ProductViewListener) {
        listener = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_product, parent, false)

        return ProductViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return currentData.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = currentData[position]
        holder.bind(product)

        holder.itemView.setOnClickListener {
            listener?.onProductClicked(product)
        }
    }

    fun onDestroy() {

        currentData.clear()
        listener = null
    }

    inner class ProductViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        fun bind(productView: ProductView) {

            val context = itemView.context

            with(itemView) {

                Glide.with(context)
                        .load(productView.image)
                        .apply(RequestOptions.noTransformation())
                        .into(iv_product)

                tv_product_brand.text = productView.brand
                tv_product_name.text = productView.name
                tv_product_special_price.text = productView.specialPrice.toString()
                tv_product_price.text = productView.price.toString()
                rb_product.rating = productView.rating?.toFloat() ?: 0f
            }
        }
    }

    interface ProductViewListener {

        fun onProductClicked(productView: ProductView)
    }
}