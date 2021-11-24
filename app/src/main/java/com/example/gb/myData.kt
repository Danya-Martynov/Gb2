package com.example.gb

import android.provider.ContactsContract

data class guide(val title:String, val descr:String, val image:Int)

data class login(val id:String,
                 val email:String,
                 val nickname:String,
                 val avatar:String,
                 val token:String)




object List {
    val list = arrayListOf(
        guide(
            title = "Быстрая\n доставка",
            descr = "Доставим день в день, в\n удобное для вас время",
            R.drawable.hello1
        ),
        guide(
            title = "Только\n свежее",
            descr = "Выберем лучшее с полок\n магазинов как для себя",
            R.drawable.hello2
        ),
        guide(
            title = "Никаких\n забот",
            descr = "Привезем тяжелые сумки\n прямо до вашей двери",
            R.drawable.hello3
        ),

    )
}
