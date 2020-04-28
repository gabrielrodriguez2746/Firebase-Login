package com.firebase.core

interface BaseRepository<in T, out V> {

    suspend fun get(params: T): V
}