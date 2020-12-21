package com.verygoodsecurity.veryspacyfood.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.verygoodsecurity.veryspacyfood.R
import com.verygoodsecurity.veryspacyfood.presentation.main.fragment.chackout.CheckoutFragment
import com.verygoodsecurity.veryspacyfood.presentation.main.fragment.details.ProductDetailsFragment
import com.verygoodsecurity.veryspacyfood.presentation.main.fragment.payment.CreditCardFragment
import com.verygoodsecurity.veryspacyfood.presentation.main.model.Product

class MainActivity : AppCompatActivity(), MainNavigationHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_App)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun navigateToDetails(product: Product) {
        supportFragmentManager.commit {
            replace(
                R.id.fclMainActivity,
                ProductDetailsFragment.newInstance(product),
                ProductDetailsFragment.TAG
            )
            addToBackStack(null)
        }
    }

    override fun navigateToAddCreditCard() {
        CreditCardFragment().show(supportFragmentManager, null)
    }

    override fun navigateToCheckout() {
        supportFragmentManager.commit {
            replace(R.id.fclMainActivity, CheckoutFragment(), CheckoutFragment.TAG)
            addToBackStack(null)
        }
    }

    override fun navigateBack() {
        supportFragmentManager.popBackStack()
    }
}