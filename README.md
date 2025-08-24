📱 Retrofit MVC Example

Bu proje, Kotlin + Retrofit + Coroutines kullanılarak yapılmış basit bir Android uygulamasıdır.
Uygulama, JSONPlaceholder
 API’sinden GET isteği ile veri çeker ve ekranda bir TextView üzerinde gösterir.
 



 
 <img width="330" height="708" alt="image" src="https://github.com/user-attachments/assets/2dfe7761-91ef-4012-bd8f-28938f74b3c1" />
 <img width="350" height="769" alt="image" src="https://github.com/user-attachments/assets/30d2b59b-477c-4ba4-9e67-075c8cf67e31" />



🚀 Özellikler

Retrofit ile REST API’den veri çekme

Coroutines ile arka planda istek atma

ViewBinding kullanımı

API’den gelen JSON verisini Kotlin data class ile modelleme

İlk gelen postların ekranda gösterimi

📂 Proje Yapısı
.
├── ApiInterface.kt         # Endpointleri tanımlar
├── RetrofitInstance.kt     # Retrofit ayarları
├── UsersItem.kt            # Data class (model)
├── MainActivity.kt         # API çağrısı ve UI güncellemesi
└── res/layout              # activity_main.xml + item_post.xml

🛠 Kullanılan Teknolojiler

Kotlin

Retrofit 2

Gson Converter

Coroutines

ViewBinding

⚡ Çalıştırma

Projeyi klonla:

git clone https://github.com/kullaniciAdin/RetrofitMvcExample.git


Android Studio ile aç.

AndroidManifest.xml içinde internet izni eklenmiş olmalı:

<uses-permission android:name="android.permission.INTERNET"/>


Uygulamayı emülatörde ya da gerçek cihazda çalıştır.

👨‍💻 Geliştirici

İsa Acer
📍 Bilecik Şeyh Edebali Üniversitesi – Bilgisayar Mühendisliği
🚀 Android & Kotlin Öğrencisi
Emailim:acerisa453@gmail.com
