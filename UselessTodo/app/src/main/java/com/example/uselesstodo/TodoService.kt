package com.example.uselesstodo

import io.reactivex.Single

interface TodoService {
    fun getTodoListItems(): Single<TodoPage>
    fun updateTodo(todoItem: TodoItem): Single<TodoUpdate>
}