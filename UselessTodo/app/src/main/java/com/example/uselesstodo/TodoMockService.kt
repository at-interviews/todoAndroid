package com.example.uselesstodo

import android.content.Context
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Single
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import kotlin.random.nextInt

class TodoMockService(val context: Context) : TodoService {

    override fun getTodoListItems(): Single<TodoPage> {
        return Single.timer(3, TimeUnit.SECONDS)
            .map {
                val inputStream = context.resources.openRawResource(R.raw.raw_data_todo_page_response)
                val reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))

                Gson().fromJson(reader, TodoPage::class.java)
            }.map {
                if ( Random.nextInt(0 until 5) == 0) {
                    throw IOException("we are simulating an error")
                } else {
                    it
                }
            }
    }

    override fun updateTodo(todoItem: TodoItem): Single<TodoUpdate> {
        return Single.timer(3, TimeUnit.SECONDS)
            .map {
                TodoUpdate(
                    update = todoItem.copy(
                        isComplete = todoItem.isComplete.not()
                    )
                )
            }.map {
                if ( Random.nextInt(0 until 5) == 0) {
                    throw IOException("we are simulating an error")
                } else {
                    it
                }
            }
    }
}