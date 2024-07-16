import android.content.Context
import android.graphics.BitmapFactory
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class MyAdapter(
    private val context: Context,
    private val imageResources: List<Int>
) : BaseAdapter() {

    override fun getCount(): Int {
        return imageResources.size
    }

    override fun getItem(position: Int): Any {
        return imageResources[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = ImageView(context)

        // 通过 BitmapFactory 加载图片并设置到 ImageView
        val options = BitmapFactory.Options()
        options.inSampleSize = 4 // 例如设置缩小尺寸为原来的 1/2
        val bitmap = BitmapFactory.decodeResource(context.resources, imageResources[position], options)
        imageView.setImageBitmap(bitmap)

        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return imageView
    }
}
