###### This library allows you to show dialog quickly, simply, animated and beautiful.


# SweetDialog

![](https://img.shields.io/badge/SDK-19+-success.svg) ![](https://img.shields.io/badge/Version-1.1-blue.svg)

![](https://media.giphy.com/media/Mdk3lQb5kzU5OxeqHD/giphy.gif)

### Getting Started

Add it in your root build.gradle (Project module)

```gradle
allprojects {
   repositories {
        ...
        maven { url 'https://jitpack.io' }
   }
}
```

Add the dependency in build.gradle (App module)

```gradle
dependencies {
	implementation 'com.github.felixsoares:SweetDialog:1.1'
}
```

### Documentation

1) Options.

```kotlin
SweetDialog()
	.setTitle("Lorem ipsum") // Title
	.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam nec magna diam.") // Message
	.setCancellable(false) // Can user close on back ?
	.setPositiveColor(android.R.color.holo_orange_dark) // Color of background positive button
	.setPositiveTextColor(R.color.black) // Color of text positive button 
	.setPositiveText("Positive =)") // Text of positive button
	.onPositiveClick { dialog -> 
		dialog.dismiss() // Click in positie button
	}
	.setNegativeColor(R.color.black) // Color of background negative button
	.setNegativeTextColor(R.color.red) // Color of text negative button
	.setNegativeText("Negative =(") // Text of negative button 
	.onNegativeClick { dialog ->
		dialog.dismiss() // Click in negative button
	}
	.setTimer(5000) // Timeout of dialog close
	.setType(SweetDialog.Type.SUCCESS) // Type of dialog
	.setAnimation(SweetDialog.Animation.IN_TO_OUT) // Set enter exit animation
	.show(this)
```

2) All configurations are optionals.

```kotlin
SweetDialog()
	.setTitle("Lorem ipsum")
	.setAnimation(SweetDialog.Animation.IN_TO_OUT)
	.show(this)
```

3) Types.

```kotlin
SweetDialog.Type.DEFAULT
SweetDialog.Type.SUCCESS
SweetDialog.Type.ERROR
SweetDialog.Type.DANGER
```

4) Animations.

```kotlin
SweetDialog.Animation.TOP_TO_BOTTOM
SweetDialog.Animation.TOP_TO_TOP
SweetDialog.Animation.BOTTOM_TO_BOTTOM
SweetDialog.Animation.BOTTOM_TO_TOP
SweetDialog.Animation.LEFT_TO_RIGHT
SweetDialog.Animation.LEFT_TO_LEFT
SweetDialog.Animation.RIGHT_TO_LEFT
SweetDialog.Animation.RIGTH_TO_RIGHT
SweetDialog.Animation.FADE
SweetDialog.Animation.BOUNCE
SweetDialog.Animation.IN_TO_OUT
```


MIT License

Copyright (c) 2019 Felix Soares

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
