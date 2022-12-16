
# Food App

basic kotlin challenge , the  app uses API to show fruits category based recommendation 
follow best Android Arch. Principles ( recommended by google )

## What's New
- implemented DataBinding library in FruitDetailFragment
 
## Todo
- add horizontal PB (in HomeFragment - viewModel.loading) , to track progress  1-100%
- add Swipe Refresh on RecView (in HomeFragment)
- integrate  [Open AI APIs](https://beta.openai.com/overview)
- 
- make the detail Fruit UI  having custom LandScape mode
- set the base theme &  custom TextView style 
- use Animation lib: https://github.com/gelitenight/WaveView, https://github.com/r0adkll/Slidr


## NOTES Src:


- RecView ClickListener on item
  - [CodeLab(guessTheWordApp)-DataBinding](https://developer.android.com/codelabs/kotlin-android-training-live-data-data-binding?index=..%2F..android-kotlin-fundamentals#1)
  - [layout and Bidning Expression](https://developer.android.com/topic/libraries/data-binding/expressions#listener_bindings)
  - [CodeLab - DataBinding project ](https://developer.android.com/codelabs/android-databinding?hl=en#0)

- RecView ClickListener on item
  - [Joel bro-Section.io](https://www.section.io/engineering-education/handling-recyclerview-clicks-the-right-way/)

- Navigation: 
    - [Medium](https://medium.com/@muhamed.riyas/navigation-component-the-complete-guide-c51c9911684)

    - [Developer.Android](https://developer.android.com/guide/navigation/navigation-getting-started)

- MVVM ARch: 
    - [CodeLab Kotlin](https://developer.android.com/codelabs/kotlin-android-training-view-model?index=..%2F..android-kotlin-fundamentals#0)





## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)


## API Reference

#### BASE URL:

```http
  https://mercadosagricolaspr.com/farmer-dev/apis/
```

| API | Type     | Response                |
| :-------- | :------- | :------------------------- |
| `product/searchproductbycatagory_6prod?limit=6` | `GET` | Check Response with the help of postman |



