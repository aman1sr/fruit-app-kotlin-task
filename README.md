
# Food App

basic kotlin challenge , the  app uses API to show fruits category based recommendation 

## What's New

 - Added Progress Bar 
 - Updated RecyclerView Layout in NestedScrollView
 
## Todo
- add horizontal PB (in HomeFragment) , to track progress  1-100%
- add Swipe Refresh on RecView (in HomeFragment)
- survive device Rotation Changes
- 


## NOTES Src:

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



