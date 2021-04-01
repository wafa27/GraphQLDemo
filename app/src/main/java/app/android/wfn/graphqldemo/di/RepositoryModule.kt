package app.android.wfn.graphqldemo.di

import app.android.wfn.graphqldemo.datasource.RemoteDataSource
import app.android.wfn.graphqldemo.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource
    ): Repository {
        return Repository(remoteDataSource)
    }
}