package com.example.soccerquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.soccerquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingMainActivity: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)

        drawerLayout = bindingMainActivity.drawerLayout

        supportFragmentManager.beginTransaction().
        add(R.id.nav_host_fragment_container, WelcomeScreenFragment()).commit()


        val navController = this.findNavController(R.id.app_navigation)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout )
        NavigationUI.setupWithNavController(bindingMainActivity.navigationView, navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.app_navigation)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}