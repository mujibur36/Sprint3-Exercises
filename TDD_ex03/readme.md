<link rel='stylesheet' href='web/swiss.css'/>

# Exercise 3. Testing Spring MVC Apps Using the Spock Framework and the Spring MVC Test Framework

## :star: A. Writing feature methods

Implement the following feature methods in the class `ProductManagementSpec` using `Spock` and appropriate matchers for the assertions. 

1.

**Given** the context of the controller is set up<br/>
**When** I perform an HTTP GET '/'<br/>
**Then** I should see the view `index`<br/>

2.  

**Given** the context of the controller is set up<br/>
**When** I perform an HTTP GET '/product/'<br/>
**Then** the status of the HTTP response should be `Ok`<br/>
**And** I should see the view `form/productMaster`<br/>

3. 

**Given** the context of the controller is set up<br/>
**When** I perform an HTTP POST '/product/add' with the following parameters:
  * `submit=''`
  * `id='0'`
  * `name='Banana'`
  * `description='yellow'`
  * `price='0.16'`

**Then** the status of the HTTP response should be `Ok`
**And ** I should see the view `form/productMaster`<br/>
 
4. 

**Given** the context of the controller is set up<br/>
**And** we have already performed an HTTP POST '/product/add' with the following parameters:
  * `submit=''`
  * `id='0'`
  * `name='Banana'`
  * `description='yellow'`
  * `price='0.16'`
  
**When** I perform an HTTP POST '/product/add' with the following parameters:
  * `submit=''`
  * `id='0'`
  * `name='Banana'`
  * `description='yellow'`
  * `price='-1'`

**Then** the status of the HTTP response should be `Ok`
**And ** I should see the view `form/productDetail`<br/>
 


## :star::star: B. Building a specification from semi-informal requirements

1. The POST request `/product/add` with the data below should redirect the user to the view `form/productDetail`:
    * `submit=''`
    * `id='0'` 
    * `name='Banana'` 
    * `description='Canary Islands'` 
    * `price='-1'` 
  
2. Given that we have product with id `0`, name `Banana`, description `yellow` and price `0.16`, the POST request `/product/add` with the data below should redirect the user to the view `form/productDetail`:
    * `submit=''`
    * `id='0'` 
    * `name='Banana'` 
    * `description='Canary Islands'` 
    * no price

3. Given that we have product with id `0`, name `Banana`, description `yellow` and price `0.16`, the POST request `/product/add` with the data below should redirect the user to the view `form/productMaster`:
    * `submit=''`
    * `id='1'` 
    * `name='Orange'` 
    * `description='Valencia'` 
    * `price=0.23`

4. The POST request `/product/add` with the data below should redirect the user to the view `form/productDetail`:
    * `submit=''`
    * `id='0'` 
    * `name=''` 
    * `description='yellow'` 
    * `price=0.16`

5. The POST request `/product/add` with the data below should redirect the user to the view `form/productDetail`:
    * `submit=''`
    * `id='0'` 
    * no name
    * `description='yellow'` 
    * `price=0.16`

6. The POST request `/product/productDetail` with the data below should redirect the user to the view `form/productDetail`.

7. Given that we have product with id `0`, name `Banana`, description `yellow` and price `0.16`, the GET request `/product/productDetail?productId=0` with the data below should redirect the user to the view `form/productDetail`:
    * `id='0'` 
    * no name
    * `description='Canary Islands'` 
    * `price=0.16`

### :star::star::star: C. Build a feature specification that is complete and correct

Complete the feature specification with feature methods in order to guarantee that you have tested the web app in full. That is, find as many feature methods as possible in order to achieve 100% coverage of the source code, ensuring that all possible navigation routes have been covered. We are going to use [Jacoco](http://www.eclemma.org/jacoco/) for computing code coverage with respect to a JUnit test suite.

Optional statements in Java [are not supported in Jacoco](https://github.com/jacoco/jacoco/issues/345) and they will appear as partially covered (in yellow) on the Jacoco report.

***
&copy; Artur Boronat, 2017-18