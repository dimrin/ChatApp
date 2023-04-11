package com.dymrin.chatapp.data.remote

import com.dymrin.chatapp.data.remote.dto.MessageDto
import com.dymrin.chatapp.domain.model.Message
import io.ktor.client.*
import io.ktor.client.request.*

class MessageServiceImpl(private val client: HttpClient): MessageService {
    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.Endpoints.GetAllMessages.url).map {
                it.toMessage()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}