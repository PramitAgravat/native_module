package com.imagelistdemo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate
import com.github.chrisbanes.photoview.PhotoView

class MainActivity : ReactActivity() {

  private lateinit var viewPager: ViewPager
  private lateinit var viewPagerAdapter: ViewPagerAdapter
  private lateinit var imageList: List<Int>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // initializing variables
    // of below line with their id.
    viewPager = findViewById(R.id.idViewPager)

    viewPager.adapter = SamplePagerAdapter()
  }

  internal class SamplePagerAdapter : PagerAdapter() {
    override fun getCount(): Int {
      return sDrawables.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
      val photoView = PhotoView(container.context)
      photoView.setImageResource(sDrawables[position])
      // Now just add PhotoView to ViewPager and return it
      container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
      return photoView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
      container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
      return view === `object`
    }

    companion object {
      private val sDrawables = intArrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
    }
  }
  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  override fun getMainComponentName(): String = "ImageListDemo"

  /**
   * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
   * which allows you to enable New Architecture with a single boolean flags [fabricEnabled]
   */
  override fun createReactActivityDelegate(): ReactActivityDelegate =
      DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)
}
