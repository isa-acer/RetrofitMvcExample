package com.isaacer.mvc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.isaacer.mvc.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root )



  // suspend fonksşyonlarını direkt çağıramassın.Coroutine içinde çağırman gerekir.
        CoroutineScope(Dispatchers.IO).launch{

            //şimdi istediği atacağım


            val istekat=RetrofitInstance.api.getAllUser()
            //bu satır, @GET("/posts") fonksiyonunu çağırır ve sunucudan cevabı Response<List<UsersItem>> olarak döndürür.

            if(istekat.isSuccessful){

                val gelenveri=istekat.body()// gelen veri burada
                withContext(Dispatchers.Main){
                    //Biz şu an CoroutineScope(Dispatchers.IO) içindeyiz → yani arka plan (background) thread.
                    //
                    //Ama UI işlemleri (Toast, TextView güncelleme, Log.d yazdırma gibi şeyler) ana thread’de (Main) yapılır.
                    //
                    //withContext(Dispatchers.Main) → “şimdi bu kod bloğunu ana thread’de çalıştır” demek.

                    if(gelenveri!=null){
                        val adapterim = Mvcadapter(gelenveri)
                        binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                        binding.recyclerview.adapter = adapterim


                    }



                }


            }else{
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity,"HATA KODU: ${istekat.code()}",Toast.LENGTH_LONG).show()
                }

            }

        }


    }
}