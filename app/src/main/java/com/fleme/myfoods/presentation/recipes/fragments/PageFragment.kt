package com.fleme.myfoods.presentation.recipes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fleme.myfoods.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment: Fragment() {

    private var data: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        data = arguments?.getString(DATA_KEY) ?: ""
        fillFields(data)
    }

    private fun fillFields(data: String) {
        loadImage(data)
    }

    private fun loadImage(url: String) {
        Picasso.get()
            .load(url)
            .into(image_page)
    }

    fun getData() = data

    companion object {
        private const val DATA_KEY = "DATA_KEY"
        fun newInstance(data: String): PageFragment{
            val args = Bundle()
            args.putString(DATA_KEY, data)
            val fragment = PageFragment()
            fragment.arguments = args
            return fragment
        }
    }
}