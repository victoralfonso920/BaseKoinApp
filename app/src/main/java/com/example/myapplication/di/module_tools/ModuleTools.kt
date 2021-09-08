package com.example.myapplication.di.module_tools

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.myapplication.BuildConfig
import com.example.myapplication.data.remote.ApiRemote
import com.example.myapplication.tools.Const
import com.example.myapplication.tools.GlideModule
import com.example.myapplication.tools.ResourceManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

object ModuleTools {

        val moduleTools: Module = module {
            single {
                with(OkHttpClient.Builder()) {
                    connectTimeout(300, TimeUnit.SECONDS)
                    readTimeout(80, TimeUnit.SECONDS)
                    writeTimeout(90, TimeUnit.SECONDS)
                    retryOnConnectionFailure(true)
                    when {
                        BuildConfig.DEBUG -> {
                            addInterceptor(OkHttpProfilerInterceptor())
                            addInterceptor(ChuckerInterceptor(androidContext()))
                        }
                    }
                    build()
                }
            }
            single { GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) }
            single { GlideModule() }
            single { ResourceManager(androidContext()) }
            single { getRetrofit<ApiRemote>(Const.BASE_URL, get()) }
        }

        inline fun <reified T> getRetrofit(url: String, okHttpClient: OkHttpClient): T {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(T::class.java)
        }


}