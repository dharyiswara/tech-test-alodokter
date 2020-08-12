package com.dharyiswara.alodokter.ui.main.home

import com.dharyiswara.alodokter.base.BaseView
import com.dharyiswara.alodokter.model.Images

class HomePresenter(private val view: BaseView) {

    private val imageList = mutableListOf<Images>()

    fun loadImage() {
        imageList.clear()
        imageList.add(Images("https://www.vets4pets.com/siteassets/species/cat/kitten/tiny-kitten-in-field.jpg?w=585&scale=down"))
        imageList.add(Images("https://i.ytimg.com/vi/jANE8lpoj2c/sddefault.jpg"))
        imageList.add(Images("https://icatcare.org/app/uploads/2019/09/The-Kitten-Checklist-1.png"))
        view.successLoadData()
    }

    fun getImageList(): List<Images> = imageList

}