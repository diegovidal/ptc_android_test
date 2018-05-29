# ptc_android_test

![alt tag](https://www.portotechcenter.pt/wp-content/uploads/2016/07/PTC-jumia-e1468505520464.jpg)

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

3. The list item structure should include:
    - Image;
    - Name and brand;
    - Price, old price and discount;
    - Rating;

    *Simillar to*
    ![alt text](screen_1.jpg)
    ![Screenshot](screen_1.jpg)

4. The result detail should include:
    - Image or image gallery;
    - Name and brand;
    - Price, old price and discount;
    - Rating;
    - Description;

    *Simillar to*
    ![Screenshot](screen_2.jpg)


It has to use the following mock API 
-
API: http://nd7d1.mocklab.io/

NOTE: The mock only supports these requests.

- Get configurations

    > http://nd7d1.mocklab.io/configurations/

- Get list items with pagination

    > http://nd7d1.mocklab.io/search/phone/page/1/
    
    > http://nd7d1.mocklab.io/search/phone/page/2/

    Paremeters:
    - *"phone"* - the query submitted
    - *"1"* - the page number

- Get detail item

    > http://nd7d1.mocklab.io/product/1/

    > http://nd7d1.mocklab.io/product/2/

    Paremeters:
    - *"1"* - the product identifier "sku"
    

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

