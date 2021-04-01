package app.android.wfn.graphqldemo.datasource

import app.android.wfn.graphqldemo.LaunchListQuery
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apolloClient: ApolloClient): RemoteDataSource {
    override suspend fun getLaunchList(): Response<LaunchListQuery.Data> {
        return apolloClient.query(LaunchListQuery()).await()
    }
}