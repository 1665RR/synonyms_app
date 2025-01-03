package com.example.synonym_and.data.model

import java.util.UUID

data class SynonymItem(
    val id: UUID = UUID.randomUUID(),
    val title:String
)
