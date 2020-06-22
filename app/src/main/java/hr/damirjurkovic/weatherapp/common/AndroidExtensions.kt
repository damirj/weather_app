package hr.damirjurkovic.weatherapp.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlin.math.round

fun FragmentActivity.showFragment(
    containerId: Int,
    fragment: Fragment,
    shouldAddToBackStack: Boolean = false,
    tag: String = ""
) {
    supportFragmentManager.beginTransaction().apply {
        if (shouldAddToBackStack) {
            addToBackStack(tag)
        }
    }.replace(containerId, fragment).commitAllowingStateLoss()
}

fun <T> LiveData<T>.subscribe(owner: LifecycleOwner, onDataChange: (T) -> Unit) {
    this.observe(owner, Observer { onDataChange(it) })
}

fun convertToCelsius(kelvin: Double): Double {
    return round((kelvin - 272.15) * 10) / 10
}

