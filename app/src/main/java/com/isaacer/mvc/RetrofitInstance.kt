package com.isaacer.mvc

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private  const val  BASE="https://jsonplaceholder.typicode.com/" // bu bizim base url miz tüm isteklerimiz buradan başlayacak


    val api:ApiInterface by lazy {//api adında ApiInterface türünde değişken tanımladım
        //ApiInterface benim yazdığın interface’ti (sadece kurallar defteri).
        //by lazy:Bu değişken ilk kez kullanıldığında oluşturulur.
        //Uygulama açılır açılmaz boşuna Retrofit nesnesi oluşturmaz.
        //Bir kere oluşturuldu mu, hep aynı nesneyi kullanır → Singleton.
        Retrofit.Builder()
            .baseUrl(BASE)
            .addConverterFactory(GsonConverterFactory.create())///Sunucudan gelen JSON’u, senin data classlarına otomatik çeviren adaptör.
            //Yani List<UsersItem>’a dönüşümü burada mümkün kılıyorsun.
            .build()
            .create(ApiInterface::class.java)//Retrofit’e “benim ApiInterface interface’imi al, onun gerçek çalışan versiyonunu oluştur” demek.
    }//object = Kotlin’de singleton (tek örnek).
    //  👉 AlbumService interface’ini Retrofit’e bağlar, ondan çalışır bir servis nesnesi üretir.
   //  👉 by lazy sayesinde bu servis ilk kullanıldığında oluşturulur, sonra hep aynı kalır.
  //   👉 object içinde yazılmasının sebebi, uygulamada tek bir RetrofitClient olsun diye



}