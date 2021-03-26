package com.example.coroutine.ui.main_page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.coroutine.base.BaseViewModel
import com.example.coroutine.data.remote.ApiHelper
import com.example.coroutine.data.model.Post
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel {
    val post: MutableLiveData<Post> =
        MutableLiveData<Post>()

    constructor(){
        getTodoFromServer()
    }

    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
public  fun getPostInfo():LiveData<Post>{
    return post
}
    fun getTodoFromServer() {
        viewModelScope.launch {
            val retrofitPost = ApiHelper.getTodoRequest(1)
            when (retrofitPost) {
                is ApiHelper.Result.Success -> {
                    post.postValue(retrofitPost.data)
                }
                is ApiHelper.Result.Error -> {
                    errorMessage.postValue(retrofitPost.exception)
                }
            }
        }

    }
}