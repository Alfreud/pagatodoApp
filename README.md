# pagatodoApp

1.- Como construir y ejecutar el proyecto :
  Simplemente descargue el proyecto, dirijase a la pestaña Build en Android Studio, seleccione la opción rebuild project, 
  y listo ya puede instalarlo en cualquier dispositivo movil o emulador de su preferencia
  
2.- Enfoque arquitectonico adoptado
  Para la realización de este proyecto se adopto una arquitectura Model-View-ViewModel (MVVM) debido a su fácil implementación,
  las herramientas que se poseen al ser la arquitectura sugerida por Goolgle, adicionalmente para la implementación de las vistas
  adopte un patrón de una sola activity y fragments para representar las diferentes vistas, gracias a Navigation components de la
  libreria de Jetpack compose
  
3.- Transacciones realizadas
  Debido a que uno de los tres endpoints proporcionados contenia información en formato Json, es posible ver datos de transacciones
  desplegados en una de las multiples pantallas de la app.
  
4.- Bibliotecas utilizadas en este proyecto
  Las enumero ya que si fueron bastantes, adiciionalmente anexo el link de un articulo en Medium que fue pilar importante a la hora
  de hacer este proyecto, entre otras fuentes
  
  Articulo Medium
  https://sberoch.medium.com/arquitectura-en-android-hilt-mvvm-kotlin-coroutines-live-data-room-y-retrofit-68bf458ec76e
  
  canale de youtube
  CodingInFlow - Android dev tutorials
  
  librerias de terceros
  
  // Material Design
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'com.github.florent37:shapeofview:1.0.7'

    // Navigation Components
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"

    //Dagger - Hilt
    implementation "com.google.dagger:hilt-android:2.31-alpha"
    kapt "com.google.dagger:hilt-android-compiler:2.31-alpha"

    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    kapt "androidx.hilt:hilt-compiler:1.0.0-beta01"

    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.8.1'

    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1'

    // Coroutine Lifecycle Scopes
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
