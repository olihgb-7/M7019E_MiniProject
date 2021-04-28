package ltu.m7019e.m7019e_miniproject.utils

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.AdapterView


class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {

    fun isEnabled(position: Int): Boolean {
        return position != 0
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {



        Log.i("POSITION", parent.getItemAtPosition(pos).toString())
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }
}