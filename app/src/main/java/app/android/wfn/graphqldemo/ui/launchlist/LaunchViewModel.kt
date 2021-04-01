package app.android.wfn.graphqldemo.ui.launchlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import app.android.wfn.graphqldemo.LaunchListQuery
import app.android.wfn.graphqldemo.repository.Repository
import com.apollographql.apollo.api.Response

class LaunchViewModel @ViewModelInject constructor(
    repository: Repository
): ViewModel() {
    val response : LiveData<Response<LaunchListQuery.Data>> = repository.launchList.asLiveData()
}