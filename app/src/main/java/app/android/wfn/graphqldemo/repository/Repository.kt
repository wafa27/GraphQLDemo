package app.android.wfn.graphqldemo.repository

import app.android.wfn.graphqldemo.LaunchListQuery
import app.android.wfn.graphqldemo.datasource.RemoteDataSource
import com.apollographql.apollo.api.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource){

    val launchList: Flow<Response<LaunchListQuery.Data>> = flow {
        val list = remoteDataSource.getLaunchList()
        emit(list)
    }
}