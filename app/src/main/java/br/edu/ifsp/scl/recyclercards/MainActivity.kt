package br.edu.ifsp.scl.recyclercards

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.annotation.DimenRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.run {
            adapter = Adapter(Item.mockItems)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(ItemOffsetDecoration(context, R.dimen.item_offset))
            setHasFixedSize(true)
        }
    }

    class ItemOffsetDecoration(context: Context, @DimenRes itemOffset: Int) : ItemDecoration() {
        private val itemOffset: Int = context.resources.getDimensionPixelSize(itemOffset)

        override fun getItemOffsets(outRect: Rect, view: View,
                                    parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)

            val itemCount = state.itemCount
            val position = parent.getChildViewHolder(view).adapterPosition
            val isLastItem = position == itemCount.dec()
            val bottomItemOffset = if (isLastItem) itemOffset else 0
            outRect.set(itemOffset, itemOffset, itemOffset, bottomItemOffset)
        }
    }
}