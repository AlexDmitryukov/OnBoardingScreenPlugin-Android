package com.applicaster.onboarding.screen.presentation.onboarding

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.applicaster.onboardingscreen.R
import com.applicaster.plugin_manager.hook.HookListener


class OnboardingActivity : Activity() {
    companion object {
        private var hookListener: HookListener? = null
        private var previousSelections: List<String>? = null
        fun getCallingIntent(context: Context, listener: HookListener, selections: List<String>): Intent {
            previousSelections = selections
            hookListener = listener
            return Intent(context, OnboardingActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val fragmentTransaction = fragmentManager.beginTransaction()
        hookListener?.let {
            val loadingFragment = OnboardingFragment.newInstance(it, previousSelections)
            fragmentTransaction.add(R.id.fragment_container, loadingFragment, loadingFragment.javaClass.canonicalName).commit()
        }

    }
}
