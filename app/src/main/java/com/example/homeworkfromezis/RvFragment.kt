package com.example.homeworkfromezis

import DetailFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homeworkfromezis.databinding.FragmentRvBinding


class RvFragment : Fragment(), OnClick {

    private lateinit var binding: FragmentRvBinding
    private val list = listOf(
        CarModel("https://i.pinimg.com/736x/52/8b/6e/528b6eeb16a745065373219818897f06.jpg",
            "BMW", "0551191716", 2000, "Хорошая машина"),
        CarModel("https://www.carscoops.com/wp-content/uploads/2014/10/99335fb6-mercedes-benz-s550-coupe-30.jpg",
            "Mercedes", "0505556071", 2005, "Отличная машина"),
        CarModel("https://avatars.mds.yandex.net/get-ydo/6058772/2a0000017e4e1c9a75f664b0b6b6431fba2d/diploma",
            "Volkswagen", "0505556072", 2010, "Превосходная машина"),
        CarModel("https://i.pinimg.com/736x/8c/46/be/8c46be670187e80ebf31a78b4cc10854.jpg",
            "Audi", "0505556073", 2015, "Самая дорогая машина"),
        CarModel("https://www.major-auto.ru/files/images/Toyota-Auris-2013-1.jpg",
            "Toyota", "0505556074", 2020, "Лучшая машина"),
        CarModel("https://images.caricos.com/n/nissan/2015_nissan_altima/images/1920x1080/2015_nissan_altima_1_1920x1080.jpg",
            "Nissan", "0505556075", 2025, "Самая дешевая машина"),
        CarModel("https://yandex-images.clstorage.net/wkZa52151/5dda44zwZP/_Sq4KrunM8hhswGUCIX2JndE66Iuxeu45s02M_mmkLLzagGL0dZi8WquBwYo8r4bGmJ6v-q-dH-CGtf4YM0QHr94_Hz_-XTIZKdKnkSf-jZiCPbhO4fyvOGUOmLCmrDG01Yqv62hHdskqg0AfOvxFAMNQ_34gix20DGO_2aTbk_OJ7UGr7lq42eHQY4ahuATVyLQtS-9xOj500glzYOc8vNTKZ6SoyHwGZMxFVDVhg8LF3Gz-7kbeusMie9NmWxZ7S-1Cpm5T-BqtFa-Ga_aIWkOwKErmtXW9vFvJdy0q8vEYwK9nYcW-givBRdBwIcZLh5PiOqQN0fVErP2R6hPVtwCuz-Krn7gdItrrCS-8AxgI822HqbE6cDmQxDVjrPW50o9p6uIBuINgAISWNy5KREcTojWqhd80hCM_UW3a2D-I5YEmYVN4UCjR4MbuNEXez3ftyKj7O_t-kAm2Kih18F5HaOisCzxP68uI1z2kDgwNFmI_KwJefsItMh7kGxd7gGmLaaRV-ZDh2KIB4fDL3wF4KoLkMjTzNptJs-OlPb1USSjoZc20hWyLAlL0YkLHyh_n-mVDlj9KLnoW7h_Y_gZjR6FmEzwQJFdqQOPxCphAdGJF77W7OTAZwv4p4bm9ksAvZGPGsY2si4UQ-WpDA0oWLbIrwBRyDKg4muvRkfNAaQvp4586EeSab8ehPAGZCDIghGmwMPs3H4k-YOB0cluCaiprDnaMoUiJlrAjxYuH0iH7pweb_YUufRYjVBY-ROUBq-2UfZ_sliHLIbTOWgj_6kbmM3g4sReFtiLsOPWXgCUjJ8t_zCYOQp3xLEMKTxRltaQO1v6GojhfI5BYsgknyG-mF7cboxtqw-g1yheBeSiIJjY_dnKZjXbjrDv0nwKta2nBOUEiSQ1adieLCgCfofomgZV1DCpwWa5U1veJKoaq7F_zU-JYr8Qg9YMfADErzWcwNPp-WkU7rY",
            "Honda", "0505556076", 2030, "Самая новая машина"),
        CarModel("https://www.conceptcarz.com/images/Ford/2011-Ford-Explorer-SUV_Image-032-1680.jpg",
            "Ford", "0505556077", 2035, "Самая старая машина"),
        CarModel("https://s2.usedcars.ru/photos/2019/01/1280x1024/15477148223353.jpg",
            "Chevrolet", "0505556078", 2040, "Самая крупная машина"),
        CarModel("https://yandex-images.clstorage.net/wkZa52151/5dda44iF1a/-zj2ZOa1a8RxoV2eR4b2MCET5Kk-j_qp4cx_fvqgharwfBGClpN54zK4TFErpehPTmMz7LfseX_UGtWQPdkaF7l_qS-r7XiQPfEdjg3eoHQ7WbPoa9iyt_eQO2HCmrDG01Yqv62hHdskqg0AfOvxFAMNQ_34gix20DGO_2aTbk_OJ7UGr7lq42eHQY4ahuATVyLQtS-9xOj500glzYOc8vNTKZ6SoyHwGZMxFVDVhg8LF3Gz-7kbeusMie9NmWxZ7S-1Cpm5T-BqtFa-Ga_aIWkOwKErmtXW9vFvJdy0q8vEYwK9nYcW-givBRdBwIcZLh5PiOqQN0fVErP2R6hPVtwCuz-Krn7gdItrrCS-8AxgI822HqbE6cDmQxDVjrPW50o9p6uIBuINgAISWNy5KREcTojWqhd80hCM_UW3a2D-I5YEmYVN4UCjR4MbuNEXez3ftyKj7O_t-kAm2Kih18F5HaOisCzxP68uI1z2kDgwNFmI_KwJefsItMh7kGxd7gGmLaaRV-ZDh2KIB4fDL3wF4KoLkMjTzNptJs-OlPb1USSjoZc20hWyLAlL0YkLHyh_n-mVDlj9KLnoW7h_Y_gZjR6FmEzwQJFdqQOPxCphAdGJF77W7OTAZwv4p4bm9ksAvZGPGsY2si4UQ-WpDA0oWLbIrwBRyDKg4muvRkfNAaQvp4586EeSab8ehPAGZCDIghGmwMPs3H4k-YOB0cluCaiprDnaMoUiJlrAjxYuH0iH7pweb_YUufRYjVBY-ROUBq-2UfZ_sliHLIbTOWgj_6kbmM3g4sReFtiLsOPWXgCUjJ8t_zCYOQp3xLEMKTxRltaQO1v6GojhfI5BYsgknyG-mF7cboxtqw-g1yheBeSiIJjY_dnKZjXbjrDv0nwKta2nBOUEiSQ1adieLCgCfofomgZV1DCpwWa5U1veJKoaq7F_zU-JYr8Qg9YMfADErzWcwNPp-WkU7rY",
            "Mitsubishi", "0505556079", 2045, "Самая большая машина")
    )

    private val adapter = RvAdapter(list, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentRvBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.rvContinent.adapter = adapter
    }

    override fun onItemClick(model: CarModel) {
        val bundle = Bundle().apply {
            putSerializable("key", model)
        }

        val detailFragment = DetailFragment().apply {
            arguments = bundle
        }

        parentFragmentManager.beginTransaction()
            .replace(R.id.container, detailFragment)
            .addToBackStack(null)
            .commit()
    }


}