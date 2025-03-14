package com.example.synonym_and.data.repository

import Constants.PREFERENCE_KEY
import Constants.PREFERENCE_NAME
import android.content.Context
import android.renderscript.RenderScript
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)
@ViewModelScoped
class DataStoreRepository @Inject constructor(
    @ApplicationContext private val context: Context
){
    private object PreferencesKeys {
        val sortKey = stringPreferencesKey(name = PREFERENCE_KEY)
    }
    private val dataStore = context.dataStore

    suspend fun  persistSortState(priority: RenderScript.Priority) {
        dataStore.edit {
                preference ->
            preference[PreferencesKeys.sortKey] = priority.name
        }
    }
    val readSortState: Flow<String> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val sortState = preferences[PreferencesKeys.sortKey] ?: ""
            sortState
        }
}