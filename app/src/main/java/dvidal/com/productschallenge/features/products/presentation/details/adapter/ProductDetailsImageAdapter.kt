package dvidal.com.productschallenge.features.products.presentation.details.adapter

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dvidal.com.productschallenge.R
import kotlinx.android.synthetic.main.pager_item_product_details_image.view.*
import javax.inject.Inject


/**
 * @author diegovidal on 20/01/19.
 */
class ProductDetailsImageAdapter @Inject constructor(

) : PagerAdapter() {

    private var data: MutableList<String> = mutableListOf()

    fun updateData(list: List<String>) {

        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val context = container.context
        val inflater = LayoutInflater.from(context)

        val layout = inflater.inflate(R.layout.pager_item_product_details_image, container, false)
        container.addView(layout)

        Glide.with(context)
                .load(data[position])
                .apply(RequestOptions.noTransformation())
                .into(layout.iv_product)

        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "image_title"
    }

}