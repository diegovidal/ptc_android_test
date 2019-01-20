package dvidal.com.productschallenge.features.splash.domain.usecases

import dagger.Reusable
import dvidal.com.productschallenge.core.interactor.UseCase
import dvidal.com.productschallenge.features.splash.ConfigRepository
import dvidal.com.productschallenge.features.splash.data.local.ConfigDto
import javax.inject.Inject

/**
 * @author diegovidal on 20/01/19.
 */

@Reusable
class AddConfigUseCase @Inject constructor(
        private val repository: ConfigRepository
): UseCase<Long, ConfigDto?>() {

    override suspend fun run(params: ConfigDto?) = repository.addConfig(params)
}