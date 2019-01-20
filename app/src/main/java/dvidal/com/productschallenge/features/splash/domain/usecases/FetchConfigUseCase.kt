package dvidal.com.productschallenge.features.splash.domain.usecases

import dvidal.com.productschallenge.core.functional.EitherResult
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.features.splash.ConfigRepository
import dvidal.com.productschallenge.features.splash.ConfigView
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */
class FetchConfigUseCase @Inject constructor(
        private val repository: ConfigRepository
): UseCase<ConfigView?, UseCase.None>() {


    override suspend fun run(params: None) = repository.fetchConfig()
}