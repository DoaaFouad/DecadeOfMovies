# DecadeOfMovies

DecadeOfMovies; android application written in Kotlin for showing last-decade movies details like rating, year of production, cast..etc.

<img src="https://attachment.outlook.live.net/owa/MSA%3Adoaa_fouad2006%40hotmail.com/service.svc/s/GetAttachmentThumbnail?id=AQMkADAwATZiZmYAZC05OQA2Ny1lNWM3LTAwAi0wMAoARgAAA4gGgEM%2BS8JMtOjmLYdl1rAHAOKs1ZKjbyZOtd3jd%2BhBJZ4AAAIBDAAAAOKs1ZKjbyZOtd3jd%2BhBJZ4AA%2BXAQ5kAAAABEgAQAEtd3zmgyjlOhtp1z09enmk%3D&thumbnailType=2&owa=outlook.live.com&scriptVer=2020082005.06&isc=1&X-OWA-CANARY=tmXTuUVbvUult9CxdV4bn0BlWjKMTtgYwtDj9hgtPQx9BkP3DFpaGRQc-yz0JLRXS7uDN5kuA50.&token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjU2MzU4ODUyMzRCOTI1MkRERTAwNTc2NkQ5RDlGMjc2NTY1RjYzRTIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJWaldJVWpTNUpTM2VBRmRtMmRueWRsWmZZLUkifQ.eyJvcmlnaW4iOiJodHRwczovL291dGxvb2subGl2ZS5jb20iLCJ1YyI6IjlmNjgzMTkzNzBmMDRjMWNiYmI0NmMxNTE3ZTdkY2MxIiwidmVyIjoiRXhjaGFuZ2UuQ2FsbGJhY2suVjEiLCJhcHBjdHhzZW5kZXIiOiJPd2FEb3dubG9hZEA4NGRmOWU3Zi1lOWY2LTQwYWYtYjQzNS1hYWFhYWFhYWFhYWEiLCJpc3NyaW5nIjoiV1ciLCJhcHBjdHgiOiJ7XCJtc2V4Y2hwcm90XCI6XCJvd2FcIixcInByaW1hcnlzaWRcIjpcIlMtMS0yODI3LTQ0MjM2NS0yNTczNzIzMDc5XCIsXCJwdWlkXCI6XCIxODk5OTQ1NzgxNjE4MTE5XCIsXCJvaWRcIjpcIjAwMDZiZmZkLTk5NjctZTVjNy0wMDAwLTAwMDAwMDAwMDAwMFwiLFwic2NvcGVcIjpcIk93YURvd25sb2FkXCJ9IiwibmJmIjoxNTk4OTc0MzI4LCJleHAiOjE1OTg5NzQ5MjgsImlzcyI6IjAwMDAwMDAyLTAwMDAtMGZmMS1jZTAwLTAwMDAwMDAwMDAwMEA4NGRmOWU3Zi1lOWY2LTQwYWYtYjQzNS1hYWFhYWFhYWFhYWEiLCJhdWQiOiIwMDAwMDAwMi0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvYXR0YWNobWVudC5vdXRsb29rLmxpdmUubmV0QDg0ZGY5ZTdmLWU5ZjYtNDBhZi1iNDM1LWFhYWFhYWFhYWFhYSIsImhhcHAiOiJvd2EifQ.fLhqbzRmCPPtX_VWZ6N5mkT0M4SMgAqZCfrwikmlqvVneL-MXME6GHMNXjmcv3AtxUAxAcZCMXapZ1wQ5SmKoRs_qANFWa7_DaML752SCHWFbyQ5cRkqKlTceUhCM02fhII9NeQAh4Uo_s-JWLt9xLoaDDEJyXnziAnE9JSAeHiruLDSjT0OFSmMvTpkGZCfDwYMK2Ef6lKy67ZwAE-7g2jZpIzHeAw609L1OpQOGsKYA11SiMp1iL5FKKjgvsfDRaE_hzVHtxmk6fVH65KDV5g_Jrg1XHUTAdR6qOLdsemkGeGYS_ZhejGZ9isAGvf_TK7fdkCODhRt6LfwpmV9Wg&animation=true" width="200" height="400" />   <img src="https://attachment.outlook.live.net/owa/MSA%3Adoaa_fouad2006%40hotmail.com/service.svc/s/GetAttachmentThumbnail?id=AQMkADAwATZiZmYAZC05OQA2Ny1lNWM3LTAwAi0wMAoARgAAA4gGgEM%2BS8JMtOjmLYdl1rAHAOKs1ZKjbyZOtd3jd%2BhBJZ4AAAIBDAAAAOKs1ZKjbyZOtd3jd%2BhBJZ4AA%2BXAQ5kAAAABEgAQAO1dOl6n0vpMujrp3aECA4Q%3D&thumbnailType=2&owa=outlook.live.com&scriptVer=2020082005.06&isc=1&X-OWA-CANARY=tmXTuUVbvUult9CxdV4bn0BlWjKMTtgYwtDj9hgtPQx9BkP3DFpaGRQc-yz0JLRXS7uDN5kuA50.&token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjU2MzU4ODUyMzRCOTI1MkRERTAwNTc2NkQ5RDlGMjc2NTY1RjYzRTIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJWaldJVWpTNUpTM2VBRmRtMmRueWRsWmZZLUkifQ.eyJvcmlnaW4iOiJodHRwczovL291dGxvb2subGl2ZS5jb20iLCJ1YyI6IjlmNjgzMTkzNzBmMDRjMWNiYmI0NmMxNTE3ZTdkY2MxIiwidmVyIjoiRXhjaGFuZ2UuQ2FsbGJhY2suVjEiLCJhcHBjdHhzZW5kZXIiOiJPd2FEb3dubG9hZEA4NGRmOWU3Zi1lOWY2LTQwYWYtYjQzNS1hYWFhYWFhYWFhYWEiLCJpc3NyaW5nIjoiV1ciLCJhcHBjdHgiOiJ7XCJtc2V4Y2hwcm90XCI6XCJvd2FcIixcInByaW1hcnlzaWRcIjpcIlMtMS0yODI3LTQ0MjM2NS0yNTczNzIzMDc5XCIsXCJwdWlkXCI6XCIxODk5OTQ1NzgxNjE4MTE5XCIsXCJvaWRcIjpcIjAwMDZiZmZkLTk5NjctZTVjNy0wMDAwLTAwMDAwMDAwMDAwMFwiLFwic2NvcGVcIjpcIk93YURvd25sb2FkXCJ9IiwibmJmIjoxNTk4OTc0MzI4LCJleHAiOjE1OTg5NzQ5MjgsImlzcyI6IjAwMDAwMDAyLTAwMDAtMGZmMS1jZTAwLTAwMDAwMDAwMDAwMEA4NGRmOWU3Zi1lOWY2LTQwYWYtYjQzNS1hYWFhYWFhYWFhYWEiLCJhdWQiOiIwMDAwMDAwMi0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvYXR0YWNobWVudC5vdXRsb29rLmxpdmUubmV0QDg0ZGY5ZTdmLWU5ZjYtNDBhZi1iNDM1LWFhYWFhYWFhYWFhYSIsImhhcHAiOiJvd2EifQ.fLhqbzRmCPPtX_VWZ6N5mkT0M4SMgAqZCfrwikmlqvVneL-MXME6GHMNXjmcv3AtxUAxAcZCMXapZ1wQ5SmKoRs_qANFWa7_DaML752SCHWFbyQ5cRkqKlTceUhCM02fhII9NeQAh4Uo_s-JWLt9xLoaDDEJyXnziAnE9JSAeHiruLDSjT0OFSmMvTpkGZCfDwYMK2Ef6lKy67ZwAE-7g2jZpIzHeAw609L1OpQOGsKYA11SiMp1iL5FKKjgvsfDRaE_hzVHtxmk6fVH65KDV5g_Jrg1XHUTAdR6qOLdsemkGeGYS_ZhejGZ9isAGvf_TK7fdkCODhRt6LfwpmV9Wg&animation=true" width="200" height="400" />


## Features
- Filter movies by year.
- View the top-rated 5 movies of each year.
- View movie-related photos.

## App Architecture
Model View View-Model (MVVM)

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## Libraries references
#### Dependency Injection
- Koin: [https://github.com/InsertKoinIO/koin](https://github.com/InsertKoinIO/koin)
#### Reactive 
 - RxJava2: [https://github.com/ReactiveX/RxJava](https://github.com/ReactiveX/RxJava)
#### Networking
- Retrofit:  [https://github.com/square/retrofit](https://github.com/square/retrofit)
- Gson:  [https://github.com/google/gson](https://github.com/google/gson)
- OKhttp:  [https://github.com/square/okhttp](https://github.com/square/okhttp)
#### Testing
- Koin testing: [https://github.com/InsertKoinIO/koin](https://github.com/InsertKoinIO/koin)
- Hamcrest: [https://github.com/hamcrest/JavaHamcrest](https://github.com/hamcrest/JavaHamcrest)
- AndroidX test: [https://developer.android.com/jetpack/androidx/releases/test](https://developer.android.com/jetpack/androidx/releases/test)
- Robolectric: [https://github.com/robolectric/robolectric](https://github.com/robolectric/robolectric)
#### Profiling
- LeakCanary: [https://github.com/square/leakcanary](https://github.com/square/leakcanary)
####  UI
- Glide:  [https://github.com/bumptech/glide](https://github.com/bumptech/glide)
- AutoImageSlider: [https://github.com/smarteist/Android-Image-Slider](https://github.com/smarteist/Android-Image-Slider)

## Future work
- UI tests
