package com.example.anchorbookcondaggerhilt.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
    ESTA CLASE DE CON LA ESTIQUETA DE HILTANDROIDAPP FUNCIONA PARA INYECTAR LAS DEPENDENCIAS A TODA LA APP
    ESTO SIRVE PARA
 */

@HiltAndroidApp
class AnchorBookApplication: Application()
