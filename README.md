# ptc_android_test

![alt tag](screen-porto-tech-center.jpg)

Jumia Porto Tech Center (PTC) is an Agile IT development center, with around 200 IT-specialists, 
where you will have the opportunity to participate in developing smart solutions for our group companies. 
We do e-commerce shops, logistics, business intelligence and mobile applications involving a wide range of high-end technologies for tens of millions customers.  

You can check our job opportunities at our site: https://group.jumia.com/careers.  

We were founded in 2012 and today we are part of Jumia Group powered by Rocket Internet, Millicom, MTN, Axa Group, 
Goldman Sachs, Orange and CDC.   Working at PTC means being in the first line of e-commerce development in emerging markets.  

What you will find in PTC?  

In PTC you will have an opportunity to develop and apply e-business software solutions for a wide range of business areas. 

You will belong to the international team with the top experts who will inspire and support you in working on an international scale impacting millions of revenue (travelling, logistics, e-shops) and users. 

We are humble and pragmatic. 

We are passionate about what we do, and we have fun while doing it. 

We move in a fast-pace and we are ready to challenge risks. 

We value sharing knowledge and learning from each other. We are flexible and we believe that anything is possible. 

We will offer you second home where you will find the opportunity for growth and career development.
You will have the opportunity to earn the bonus based on your excellent results. 
The benefit list includes but is not limited to health insurance, parental bonus, snacks and fruits.

This repo represents the current admission test that is needed to apply for an Android Developer Position.

Android Practical Admission Test
-

The idea is create an app that is able to list products requested by a query. 

The application should composed by:

    - Splash screen
    - Search screen 
    - List screen 
    - Detail screen

The following requirements need to be met:

The search must be able to list items from a certain actor or director.

1. The splash screen:
    - This screen is optional, but the application should request and save some configurations. 

2. The search screen
    - Allow submit a query

3. The list item structure should include:
    - Image;
    - Name and brand;
    - Price, old price and discount;
    - Rating;

4. The result detail should include:
    - Image or image gallery;
    - Name and brand;
    - Price, old price and discount;
    - Rating;
    - Description;

It has to use the following mocklab API 
-

NOTE: The mocklab API is based in JSON mocks, only supports the following requests.

- Get configurations

    > http://nd7d1.mocklab.io/configurations/
    
    The currency should used to format the price and old price.

- Get list items with pagination

    > http://nd7d1.mocklab.io/search/phone/page/1/
    
    > http://nd7d1.mocklab.io/search/phone/page/2/

    Paremeters:
    - *"phone"* - the query
    - *"1"* - the page number (pagination)

- Get detail item

    > http://nd7d1.mocklab.io/product/1/

    > http://nd7d1.mocklab.io/product/2/

    Paremeters:
    - *"1"* - the product identifier "sku"
    
    
- Failure cases

    HTTP 200 - Success false:
    > http://nd7d1.mocklab.io/product/3/
    
    HTTP 404 - Not Found:
    > http://nd7d1.mocklab.io/search/phone/page/2/
    
    > http://nd7d1.mocklab.io/product/4/

    

We value the following implementations:
 -
- Android Architecture Components;
- Material Design Components;
- Kotlin;
- DataBinding
- Fragments;
- RxAndroid;
- Animations;
- Swipable Content;
- Image Loader (Volley/Picasso/Glide);
- Retrofit/OKHttp client for API communication;

Similar screens:
-

![Screenshot](screen_1.jpg)


![Screenshot](screen_2.jpg)