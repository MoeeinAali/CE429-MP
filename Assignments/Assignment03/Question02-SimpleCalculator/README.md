# Assignment03 - Question02 - SimpleCalculator
![text](https://github.com/MoeeinAali/CE429-MP/blob/e853565f8061dd9da4262e482f17b5ee190fc897/Assignments/Assignment03/Question02-SimpleCalculator/Animation.gif)
## MainActivity Codes ~ Kotlin

* Use **Binding** for Getting Layouts
```
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
```
* Auto Horizontal Scroll Bar
```
val viewTree: ViewTreeObserver = binding.horizontalScrollViewETInput.viewTreeObserver
        viewTree.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.horizontalScrollViewETInput.viewTreeObserver.removeOnGlobalLayoutListener(this)
                binding.horizontalScrollViewETInput.smoothScrollTo(binding.ETInput.width, 0)
            }
        })
```


## Build.Gradle Codes ~ Json

* Using **Binding** for Getting Layouts
```
android {
    buildFeatures {
        viewBinding true
    }
}
```

* Using **exp4j** Library 
```
dependencies {
    implementation 'net.objecthunter:exp4j:0.4.8'
}
```

