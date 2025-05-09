import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.serialization)
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.ebookc.bookapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ebookc.bookapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)

    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //
    implementation(libs.androidx.room.ktx) // KTX para Room
    implementation(libs.androidx.room.runtime) // Runtime do Room

    ksp("androidx.room:room-compiler:2.6.1")

    implementation(platform("com.google.firebase:firebase-bom:33.13.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-database")
    implementation("com.google.firebase:firebase-storage-ktx") // Versão é gerenciada pelo BOM


    implementation("com.google.firebase:firebase-messaging")



    /*implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.gson)*/


    implementation(libs.retrofit)

    implementation(libs.retrofit.gson.converter)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.gson)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    implementation(platform(libs.okhttp.bom))

    //daggerhilt
    implementation(libs.dagger.hilt)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.compiler)


//navigation

    implementation(libs.compose.navigation)
    implementation(libs.kotlinx.serialization.json)

    //

    implementation("io.coil-kt.coil3:coil-compose:3.1.0")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.1.0")

    coreLibraryDesugaring ("com.android.tools:desugar_jdk_libs:2.0.3")

    implementation ("androidx.compose.foundation:foundation:1.5.0") // ou versão mais recente



    //////////////
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.33.2-alpha")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")

    ////

    implementation ("androidx.compose.material:material-icons-extended-android:1.7.8")
    implementation ("androidx.compose.material:material-icons-extended:1.7.8")

    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:12.1.0")

//
    //permission handling
    implementation ("com.google.accompanist:accompanist-permissions:0.30.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")

    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.github.grizzi91:bouquet:1.1.2")


    //

    implementation ("androidx.navigation:navigation-compose:2.4.0") // ou a versão mais recente
    implementation ("androidx.compose.ui:ui:1.0.0") // ou a versão mais recente
        // outras dependências do Compose

    implementation ("androidx.compose.material:material:1.0.0") // se você estiver usando Material Design
    implementation ("androidx.compose.ui:ui-tooling:1.0.0") // para ferramentas de UI
        // outras dependências do Compose





}