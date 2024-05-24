# Akıllı Durak/Navigasyon ve Sesli Yönlendirme Sistemi

## Proje Tanımı

Bu proje, görme engelli bireyler için sesli navigasyon sağlamak üzere tasarlanmış mobil tabanlı bir uygulamadır. Projenin amacı, görme engelli kullanıcıların otobüs duraklarına ve diğer hedeflere güvenli bir şekilde ulaşabilmeleri için sesli rehberlik sağlamaktır. Kullanıcılar hedef noktalarını sesli olarak girebilir ve bu bilgiler metne dönüştürülerek hedefe yönelik sesli talimatlar verilir. Ayrıca, görüntü işleme teknolojileri kullanılarak trafik ışıkları ve engeller gibi durumlarda kullanıcıya sesli uyarılar yapılır.

## Proje Ekibi

- **Gökdeniz Yılmaz** - Bilişim Sistemleri Mühendisliği, Kocaeli Üniversitesi
- **Mustafa İnce** - Bilişim Sistemleri Mühendisliği, Kocaeli Üniversitesi
- **Taha Rıdvan Öztürk** - Bilişim Sistemleri Mühendisliği, Kocaeli Üniversitesi

## İçindekiler

- [Giriş](#giriş)
- [Literatür Taraması](#literatür-taraması)
- [Yöntem](#yöntem)
- [Kullanılan Teknolojiler ve Araçlar](#kullanılan-teknolojiler-ve-araçlar)
- [Algoritma ve Akış Diyagramları](#algoritma-ve-akış-diyagramları)
- [Sistem Tasarımı](#sistem-tasarımı)
- [Uygulamanın Geliştirilmesi](#uygulamanın-geliştirilmesi)
- [Test ve Doğrulama](#test-ve-doğrulama)
- [Katkıda Bulunanlar](#katkıda-bulunanlar)
- [Lisans](#lisans)

## Giriş

Bu proje, görme engelli bireyler için sesli navigasyon sağlayan mobil tabanlı bir uygulamanın geliştirilmesine odaklanmaktadır. Ana hedef, kullanıcıların sesli rehberlik sistemini kullanarak otobüs duraklarına ve diğer hedeflere güvenli bir şekilde ulaşmalarını sağlamaktır. 

## Literatür Taraması

Görme engelliler için sesli yönlendirme uygulamaları genellikle GPS ve dijital harita hizmetlerine dayanır. Mevcut navigasyon uygulamaları üzerinde yapılan araştırmalar, farklı konum tespit uygulamaları alternatiflerine ulaşsa da bu uygulamalar genellikle belirli özellikleri tam olarak sunamazlar ve genellikle tek bir yapı üzerine kurulurlar.

## Yöntem

Projeye, uygulamadaki gereksinimlerin tespit edilmesi ile başlanmıştır. Kullanıcının ve hedef konumun bilgileri alınarak gerçek zamanlı haritalama işlemleri gerçekleştirilir ve kullanıcıya aralıklarla direktifler verilerek yönlendirme yapılır.

## Kullanılan Teknolojiler ve Araçlar

- **Android Studio**: Android tabanlı proje geliştirme ortamı.
- **Kotlin**: Programlama dili.
- **Google Maps Geocoding ve Fused Location Provider API'leri**: Harita ve navigasyon amaçları için.
- **Google SpeechRecognizer ve Text-to-Speech API'leri**: Sesli giriş ve çıkış işlemleri için.
- **YoloV8**: Engel ve trafik lambası tespit modeli.

## Algoritma ve Akış Diyagramları

### Uygulama Genel İşleyişi
1. Kullanıcının konum bilgisi alınır.
2. Kullanıcıdan sesli olarak gitmek istediği konum bilgisi alınır.
3. Konum, Google Maps API'ye gönderilir ve rota hesaplanır.
4. Rota adımları, Text-to-Speech API ile kullanıcıya bildirilir.
5. TensorFlowLite Görüntü işleme modeli ile çevresel engeller tespit edilir ve sesli uyarılar yapılır.
6. Hedefe ulaşıldığında kullanıcı bilgilendirilir ve süreç tamamlanır.

## Sistem Tasarımı

Uygulama, görme engelli kullanıcılar için basit ve kullanımı kolay bir arayüze sahiptir. Kullanıcı, sesli direktifler ve görüntü tespiti işlevlerini kullanabilir.

### Navigasyon Ekranı
Kullanıcıdan izinler alındıktan sonra mevcut ve hedef konum belirlenir ve rota oluşturulur. Kullanıcıya belirli aralıklarla sesli talimatlar verilir.

### Görüntü Tespit Ekranı
Kamera izni alındıktan sonra trafik lambası ve engel tespiti yapılır. Hedef nesneler bulunursa kullanıcı sesli direktiflerle uyarılır.

## Uygulamanın Geliştirilmesi

### İzinler
- `android.permission.ACCESS_COARSE_LOCATION`
- `android.permission.ACCESS_FINE_LOCATION`

### Fonksiyonlar
- `getLastLocation()`
- `getCurrentLocation()`
- `requestLocationUpdates()`
- `onSaveInstanceState()`

### Apiler
- **Google Routes API**
- **Google Directions API**
- **Google Geocoding API**

## Test ve Doğrulama

API'ler eklenmeden önce örnek uygulamalarda test edilmiş ve ardından ana uygulamaya entegre edilmiştir.

### Rota Testi
Google Routes API ile test edilerek çalışması doğrulanmıştır.

### Maps API Testi
Google Maps API'si ile haritanın yüklenmesi ve konum tespiti test edilmiştir.

### Speech-to-Text API Testi
Speech-to-Text API ile sesli girişlerin doğru bir şekilde işlenip işlenmediği test edilmiştir.
