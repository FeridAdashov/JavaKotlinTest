
import data.api.RetrofitClient
import data.mappers.MainMapper
import data.repositories.MainRepositoryImpl
import domain.interactors.MainInteractor
import kotlinx.coroutines.runBlocking
import ui.viewModel.MainViewModel


fun main() = runBlocking {

    val retrofitHttpClient = RetrofitClient.makeRetrofitService()
    val mainMapper = MainMapper()
    val repositoryImpl = MainRepositoryImpl(retrofitHttpClient, mainMapper)
    val interactor = MainInteractor(repositoryImpl)
    val viewModel = MainViewModel(interactor)

    var f = true

//    CoroutineScope(Dispatchers.IO).launch {
//        val data = viewModel.f()
//
//        println(data)
//
//        f = false
//    }


    repeat(50000) { // launch a lot of coroutines
        Thread {
            Thread.sleep(1000L)
            print(".")
        }.start()
    }
}