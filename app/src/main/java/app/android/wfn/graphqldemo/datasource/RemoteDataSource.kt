package app.android.wfn.graphqldemo.datasource

import app.android.wfn.graphqldemo.LaunchListQuery
import com.apollographql.apollo.api.Response

interface RemoteDataSource {
    suspend fun getLaunchList(): Response<LaunchListQuery.Data>
}
