package com.fleme.myfoods.presentation.recipes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.fleme.myfoods.R
import com.fleme.myfoods.model.Recipe
import com.fleme.myfoods.presentation.recipes.adapter.DemoCollectionAdapter
import com.fleme.myfoods.presentation.recipes.adapter.DemoCollectionAdapter2
import com.fleme.myfoods.presentation.recipes.custom.CustomPager
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_collection_demo.*
import kotlinx.android.synthetic.main.fragment_food_recipes.*
import kotlinx.android.synthetic.main.fragment_two_pager.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FoodRecipesFragment : Fragment(), FoodRecipesContract.View {

    private val presenter: FoodRecipesContract.Presenter by inject { parametersOf(this) }

    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var demoCollectionAdapter2: DemoCollectionAdapter2
    // private lateinit var viewPager: ViewPager2
//    private var viewPager1: CustomPager? = null
//    private var viewPager2: CustomPager? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        presenter.loadRecipes()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two_pager, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = listOf("https://veja.abril.com.br/wp-content/uploads/2020/06/EaQvroQXYAE2dDC.jpg",
            "https://exame.com/wp-content/uploads/2020/09/GettyImages-1186384593-1.jpg",
            "https://s2.glbimg.com/NnvAv9R8504MMtSzbvwZ4HQm6sk=/0x0:1076x693/984x0/smart/filters:strip_icc()" +
                    "/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2020/3/d/" +
                    "LNUPlTQryd8xPLQHiK4A/playstation-5.jpg")

        val listBackground = listOf("", "", "")

        demoCollectionAdapter = DemoCollectionAdapter(childFragmentManager, list)
        demoCollectionAdapter2 = DemoCollectionAdapter2(childFragmentManager, list)
//        viewPager = view.findViewById(R.id.pager)

//        viewPager1 = view.findViewById(R.id.pager1)
//        viewPager2 = view.findViewById(R.id.pager2)
//
//        viewPager1?.customPager = viewPager2
//        viewPager2?.customPager = viewPager1
//
//        viewPager1?.adapter = demoCollectionAdapter
//        viewPager2?.adapter = demoCollectionAdapter

//        TabLayoutMediator(tab_layout, viewPager) { tab, position ->
//            tab.text = "OBJECT ${(position + 1)}"
//        }.attach()

        pager1.adapter = demoCollectionAdapter
        pager2.adapter = demoCollectionAdapter2

//        pager1.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
//
//            private var scrollStateIdle = ViewPager.SCROLL_STATE_IDLE
//
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                if(scrollStateIdle == ViewPager.SCROLL_STATE_IDLE) return
//                pager2.scrollTo(pager1.scrollX, pager1.scrollY)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//                scrollStateIdle = state
//                if (state == ViewPager.SCROLL_STATE_IDLE) {
//                    pager2.setCurrentItem(pager1.currentItem, false);
//                }
//            }
//        })

        pager1.setOnTouchListener { _, event ->
            pager1.onTouchEvent(event)
            pager2.onTouchEvent(event)
        }

//        pager2.setOnTouchListener { _, event ->
//            pager1.onTouchEvent(event)
//        }

//        pager2.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
//
//            private var scrollStateIdle = ViewPager.SCROLL_STATE_IDLE
//
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                if(scrollStateIdle == ViewPager.SCROLL_STATE_IDLE) return
//                pager1.scrollTo(pager2.scrollX, pager2.scrollY)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//                scrollStateIdle = state
//                if (state == ViewPager.SCROLL_STATE_IDLE) {
//                    pager1.setCurrentItem(pager2.currentItem, false);
//                }
//            }
//        })
    }

    override fun showRecipes(recipes: List<Recipe>?) {
//        recipes.let {
//            recipes_text.text = recipes.toString()
//        }
    }
}