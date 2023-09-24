package com.example.challenge_chap1

import kotlinx.coroutines.delay


//enum class untuk memberikan value tetap pada metode pengiriman
enum class Pengiriman(var namaPengriman: String) {
    TAKE_AWAY(namaPengriman = " Take Away") {
        //override untuk mewarisi fungsi abstract
        //suspend digunakan untuk delays coroutine -> untuk hold dengan waktu yang ditentukan
        override suspend fun statusPesanan(): String {
            println("Makanan mu sedang di masak .....")
            delay(5000)
            println("Makanan mu sudah siap! Silakan ambil di resto ya! .....")
            delay(5000)
            println("Pesenan selesai!..")
            return 0.toString()
        }
    },
    DELIVERY(namaPengriman = " Delivery") {
        override suspend fun statusPesanan(): String {
            println("Makanan mu sedang di masak .....")
            delay(5000)
            println("Makanan mu sudah siap! Silakan ambil di resto ya! .....")
            delay(5000)
            println("Pesenan selesai!..")
            return 0.toString()
        }
    };

    //fungsi abstract dalam class enum
    abstract suspend fun statusPesanan(): String
}

//fungsi main merupakan fungsi utama yang akan merunning program
suspend fun main() {

    //list menu menggunakan mutableListOf untuk menampung nilai yang dapat diubah
    val menu = mutableListOf(
        "Ayam Bakar " to 50000, "Ayam Goreng " to 40000, "Ayam Geprek" to 40000,
        "Kulit Ayam Crispy" to "15000", "Sate usus ayam" to 5000
    )
    //menggunakan foreach untuk looping list menu
    menu.forEachIndexed { index, pair ->
        println(" ${index + 1}. ${pair.first} = ${pair.second} /porsi")
    }

    print("Pilih Menu Makanan: ")
    val strInput =
        readLine()?.toInt() //mengunakan readline() untuk melakukan input, dan di covert menjadi integer

    //menggunakan kondisi if else untuk menentukan kondisi inputan yang dipilih
    if (strInput == 1) {
        println()
        println(
            """ Kamu memilih menu 1
            | Nama makanan : ${menu[0].first}
            | Harga: Rp. ${menu[0].second}
               """.trimMargin()
        )

        print("Silahkan Input Pembayaran: ")
        val strInput2 = readLine()?.toInt()

        if (strInput2 == menu[0].second) {
            println()
            println("Terima kasih, Anda Berhasil Memesan Makanan")
        } else {
            println()
            println("Maaf, Pembayaran Anda Gagal!")
            return main()
        }
    } else if (strInput == 2) {
        println()
        println(
            """ Kamu memilih menu 1
            | Nama makanan : ${menu[1].first}
            | Harga: Rp. ${menu[1].second}
               """.trimMargin()
        )

        print("Silahkan Input Pembayaran: ")
        val strInput2 = readLine()?.toInt()

        if (strInput2 == menu[1].second) {
            println()
            println("Terima kasih, Anda Berhasil Memesan Makanan")
        } else {
            println()
            println("Maaf, Pembayaran Anda Gagal!")
            return main()
        }
    } else if (strInput == 3) {
        println()
        println(
            """ Kamu memilih menu 1
            | Nama makanan : ${menu[2].first}
            | Harga: Rp. ${menu[2].second}
               """.trimMargin()
        )

        print("Silahkan Input Pembayaran: ")
        val strInput2 = readLine()?.toInt()

        if (strInput2 == menu[2].second) {
            println()
            println("Terima kasih, Anda Berhasil Memesan Makanan")
        } else {
            println()
            println("Maaf, Pembayaran Anda Gagal!")
            return main()
        }
    } else if (strInput == 4) {
        println()
        println(
            """ Kamu memilih menu 1
            | Nama makanan : ${menu[3].first}
            | Harga: Rp. ${menu[3].second}
               """.trimMargin()
        )

        print("Silahkan Input Pembayaran: ")
        val strInput2 = readLine()?.toInt()

        if (strInput2 == menu[3].second) {
            println()
            println("Terima kasih, Anda Berhasil Memesan Makanan")
        } else {
            println()
            println("Maaf, Pembayaran Anda Gagal!")
            return main()
        }
    } else if (strInput == 5) {
        println()
        println(
            """ Kamu memilih menu 1
            | Nama makanan : ${menu[4].first}
            | Harga: Rp. ${menu[4].second}
               """.trimMargin()
        )

        print("Silahkan Input Pembayaran: ")
        val strInput2 = readLine()?.toInt()

        if (strInput2 == menu[4].second) {
            println()
            println("Terima kasih, Anda Berhasil Memesan Makanan")
        } else {
            println()
            println("Maaf, Pembayaran Anda Gagal!")
            return main()
        }
    } else {
        println()
        println("Input yang benar!!")
        return main()


    }

    //melakukan looping list metode pengiriman makanan dari class enum Pengiriman
    println()
    println("Metode Pengiriman Makanan: ")
    for (pengiriman in Pengiriman.values()){
        println("${pengiriman.ordinal+1}. ${pengiriman.namaPengriman}")
    }


    //input pemilihan metode dan akan menampilkan isi dari fungsi yang diwarisi
    println()
    print("Masukan Pilihan anda: ")
    when (readLine()!!.toInt()) {
        1 -> Pengiriman.TAKE_AWAY.statusPesanan()
        2 -> Pengiriman.DELIVERY.statusPesanan()
    }
}
