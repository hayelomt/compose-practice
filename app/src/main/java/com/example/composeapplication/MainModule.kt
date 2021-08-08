package com.example.composeapplication

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @ActivityScoped
    @Provides
    @Named("OtherString")
    fun provideOtherString(
        @ApplicationContext context: Context,
        @Named("TestString") testString: String
    ) = "${context.getString(R.string.other_string)} -> $testString"
}