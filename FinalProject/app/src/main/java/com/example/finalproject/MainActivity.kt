package com.example.finalproject

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.ActivityMainBinding
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()


//        val navHostFragment1 =
//                supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//
//        NavigationUI.setupWithNavController(binding.bottomNavigationView, navHostFragment1.navController)
    }

    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Bottom navigation items ekleme
        binding.bottomNavigation.add(
            CurvedBottomNavigation.Model(1, "Anasayfa", R.drawable.ic_home)
        )
        binding.bottomNavigation.add(
            CurvedBottomNavigation.Model(2, "Favoriler", R.drawable.ic_favorite)
        )

        binding.bottomNavigation.add(
            CurvedBottomNavigation.Model(3, "Sepet", R.drawable.ic_add_shopping_cart)
        )
//        binding.bottomNavigation.add(
//            CurvedBottomNavigation.Model(3, "Profil", R.drawable.ic_)
//        )

        // Başlangıçta anasayfa seçili
        binding.bottomNavigation.show(1)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainPageFragment -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                    binding.bottomNavigation.show(1)
                }
//                R.id.shoppingCartFragment -> {
//                    binding.bottomNavigation.visibility = View.VISIBLE
//                    binding.bottomNavigation.show(3)
//                }
                else -> binding.bottomNavigation.visibility = View.GONE
            }
        }


        // Bottom navigation item click listener
        binding.bottomNavigation.setOnClickMenuListener { model ->
            when (model.id) {
                1 -> {
                    // Ana sayfa - MainPageFragment'e git
                    if (navController.currentDestination?.id != R.id.mainPageFragment) {
                        navController.navigate(R.id.mainPageFragment)
                    }
                }

                2 -> {
                    // Favoriler sayfası - eğer varsa
                    // navController.navigate(R.id.favoritesFragment)
                }

                3 -> {
                    // Profil sayfası - eğer varsa
                    if (navController.currentDestination?.id != R.id.shoppingCartFragment) {
                        navController.navigate(R.id.shoppingCartFragment)
                    }
                }
            }
        }
    }
}