# Android kotlin Goma http client Library


[![License: Apache-2.0](https://img.shields.io/badge/License-Apache%202.0-yellow.svg)](http://www.apache.org/licenses/LICENSE-2.0)

## Download and Import


### Android Studio/Gradle

 - Maven:
 
 ```groovy
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
	
	

	<dependency>
	    <groupId>com.github.jkanTech</groupId>
	    <artifactId>goma</artifactId>
	    <version>1.0.0</version>
	</dependency>


 ```
 
 - JitPack.io, add `jitpack.io` repositiory and dependency to your `build.gradle`:
 
 ```groovy
    repositories {
        maven {
            url "https://jitpack.io"
        }
    }
	
    dependencies {
	        implementation 'com.github.jkantech:goma:1.0.0'
		}
```

   
### Android Studio

 ```groovy
    repositories {
        maven {
            url "https://jitpack.io"
        }
    }
	
    dependencies {
	        implementation 'com.github.jkantech:goma:1.0.0'
		}
 ```
 ### Manifests
 
```xml
    <uses-permission android:name="android.permission.INTERNET"/>

<application

        android:usesCleartextTraffic="true"

```

### Sample Kotlin Usage 
#### GET Method

```Kotlin
 private fun getuser(){
//Base URL
  Goma.init(this,"http://192.168.8.101/api/v1/")

        
        Goma.get("users",object :OnResponseListener{
           //on response
            override fun onSuccess(response: String?) {

        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()


            }

            override fun onError(error: String?) {
        Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()

            }

          

        })
    }

```
#### POST Method

```kotlin
private fun add(){
// initialize Goma Library + BaseURL
  Goma.init(this,"http://192.168.8.101/api/v1/")

 val data: HashMap<String, String> = HashMap()
        data["Appkey"] = "12345"
        data["name"] = "Canelle"
        data["title"] = "Infor"
        data["age"] = "30"

        Goma.post("adduser", data,object :OnResponseListener {
            override fun onSuccess(response: String?) {
        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun onError(error: String?) {

        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()

            }


        })
}
    

```
#### PUT Method

```kotlin
private fun add(){
// initialize Goma Library 


  Goma.init(this)

 val data: HashMap<String, String> = HashMap()
        data["Appkey"] = "12345"
        data["name"] = "Canelle"
        data["title"] = "Infor"
        data["age"] = "30"


        Goma.put("http://192.168.8.101/api/v1/adduser", data,object :OnResponseListener {
            override fun onSuccess(response: String?) {
        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun onError(error: String?) {

        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()

            }


        })
}

```

#### DELETE Method

```kotlin
private fun add(){

  Goma.init(this,"http://192.168.8.101/api/v1/")
 val data: HashMap<String, String> = HashMap()
        data["Appkey"] = "12345"
        data["id"] = "4"
        
        Goma.del("deluser", data,object :OnResponseListener {
            override fun onSuccess(response: String?) {
        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()

            }

            override fun onError(error: String?) {

        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()

            }


     
        })
}

```


<h2 id="examples">Examples :eyes:</h2>

Download the [Crud Example App]() or look at the [source code](https://github.com/jkanTech/goma/tree/master/CrudExample).


<br/>
 
## Authors

* **Jonas Kaninda**  - [jkanTech](https://github.com/jkantech)


## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.
