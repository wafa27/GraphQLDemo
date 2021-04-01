package app.android.wfn.graphqldemo.di

import app.android.wfn.graphqldemo.datasource.RemoteDataSource
import app.android.wfn.graphqldemo.datasource.RemoteDataSourceImpl
import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun provideRemoteDataSource(
        apolloClient: ApolloClient
    ): RemoteDataSource {
        return RemoteDataSourceImpl(apolloClient)
    }
}