package com.example.corto2.activities


import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.corto2.R
import com.example.corto2.fragments.BtnsFrag
import com.example.corto2.fragments.RedFragment
import com.example.corto2.fragments.GreenFragment
import com.example.corto2.fragments.BlueFragment

class MainActivity : AppCompatActivity(),
    BtnsFrag.OnFragmentInteractionListener,
    RedFragment.OnFragmentInteractionListener,
    GreenFragment.OnFragmentInteractionListener,
    BlueFragment.OnFragmentInteractionListener{


    lateinit var redFragment: RedFragment
    lateinit var greenFragment: GreenFragment
    lateinit var blueFragment: BlueFragment
    var currentFragment = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPrev : Button = findViewById(R.id.btn_prev)
        var btnNext : Button = findViewById(R.id.btn_next)

        btnPrev.setOnClickListener { view ->
            colorPrev(currentFragment)
        }
        btnNext.setOnClickListener { view ->
            colorNext(currentFragment)
        }
        startRedFragment()
    }

    fun startRedFragment(){
        val commit = supportFragmentManager
            .beginTransaction()
            .replace(R.id.contenedor_fragmento, redFragment)
            .addToBackStack(redFragment.toString())
            .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    fun colorPrev(pos: Int) {
        when (true) {
            pos == 1 -> {
                currentFragment = 3
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_fragmento, blueFragment)
                    .addToBackStack(blueFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            pos == 3 -> {
                currentFragment = 2
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_fragmento, greenFragment)
                    .addToBackStack(greenFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            pos == 2 -> {
                currentFragment = 1
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_fragmento, redFragment)
                    .addToBackStack(redFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }
    }

    fun colorNext(pos: Int){
        when (true) {
            pos == 1 -> {
                currentFragment = 2
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_fragmento, greenFragment)
                    .addToBackStack(greenFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            pos == 2 -> {
                currentFragment = 3
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_fragmento, blueFragment)
                    .addToBackStack(blueFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            pos == 3 -> {
                currentFragment = 1
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contenedor_fragmento, redFragment)
                    .addToBackStack(redFragment.toString())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }
    }

    override fun onFragmentInteraction(uri: Uri){}

}