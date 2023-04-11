package com.dymrin.chatapp.presentation.chat

import com.dymrin.chatapp.domain.model.Message

data class ChatState(val messages: List<Message> = emptyList(), val isLoading: Boolean = false)
