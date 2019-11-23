package br.edu.ifsp.scl.recyclercards

import androidx.annotation.DrawableRes
import java.text.DateFormat
import java.util.*

data class Item(@DrawableRes val image: Int, val title: String, val description: String) {

    companion object {
        val mockItems: List<Item> by lazy {
            val date = DateFormat.getDateInstance(DateFormat.LONG).format(Date())
            val time = DateFormat.getTimeInstance(DateFormat.SHORT).format(Date())

            List(10) {
                with(it.inc()) {
                    Item(
                        R.drawable.ic_launcher_background,
                        "Item nº $this",
                        "ID: ${UUID.randomUUID()}\n\nCriado às $time de $date"
                    )
                }
            }
        }
    }
}