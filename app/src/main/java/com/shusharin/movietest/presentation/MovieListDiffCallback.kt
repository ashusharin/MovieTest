package com.shusharin.movietest.presentation

import androidx.recyclerview.widget.DiffUtil
import com.shusharin.movietest.domain.Movie

class MovieListDiffCallback(
    private val oldList: List<Movie>,
    private val newList: List<Movie>,
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }
    // Один и тот же объект?
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val olditem =oldList[oldItemPosition]
        val newitem =newList[newItemPosition]
        return olditem.name == newitem.name
    }
    // Если один и тот же поля одинаковые?
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val olditem =oldList[oldItemPosition]
        val newitem =newList[newItemPosition]
        return  olditem == newitem
    }
}