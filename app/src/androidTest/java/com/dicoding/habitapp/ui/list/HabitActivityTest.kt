package com.dicoding.habitapp.ui.list

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.dicoding.habitapp.R
import com.dicoding.habitapp.ui.add.AddHabitActivity

//TODO 16 : Write UI test to validate when user tap Add Habit (+), the AddHabitActivity displayed Done
@RunWith(AndroidJUnit4::class)
@LargeTest
class HabitActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(HabitListActivity::class.java)

    // Inisialisasi intent
    @Before
    fun initValid() {
        Intents.init()
    }

    // Aksi sesudah intent di inisialisasi dan melakukan test akan melakukan release setelah init
    @After
    fun initFinish() {
        Intents.release()
    }

    @Test
    fun addButtonTest() {
        activityRule.scenario
        // Press Button and then intent
        Espresso.onView(ViewMatchers.withId(R.id.fab))
            .perform(ViewActions.click())

        // Do intent
        Intents.intended(
            AllOf.allOf(
                IntentMatchers.hasComponent(AddHabitActivity::class.java.name)
            )
        )
    }
}