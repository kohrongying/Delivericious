### DDD 

- This is a repository for the DDD training.

#### Context
- This is for Delivericious menuItem delivery app
- We learnt about the domain already on Event Storming session and identified bounded contexts. 
- This repository demonstrates usage of Tactical Pattern of DDD. 

##### Use cases: 
1. Add  tomato soup to foodordering.Basket
   Do not use/model User

2. Add **Sea Food salad** which costs **$12.00**
Q: what about currency? SGD, need to put in class? 
A: Yes Money(amount, currency) as a value object

3. Add **3** chocolate ice cream to Basket which cost **4$** each

4. Remove one chocolate ice cream from basket
Food should have a id to use for comparing menuItem and the basket item.
   
5. Allow user to duplicate basket for re-ordering. 
Basket Entity should have id to differentiate oldBasket and newBasket.

6. Review total price for current basket
Implement some BigDecimal methods on Money class
   
7. Limit basket to 100 
Note: created named exception: BasketQuantityExceedException to support ubiquitious language
   
8. Basket save into hashmap of <id, hashmap>
Orchestrator calls method to save basket as compared to a save method on Basket (the aggregate root)
Orchestrator = Repository
Interface to Repository helps to enforce contract

9. Basket more than 5 soup, suggest coupon "DELIVERICIOUS_10" with 10% discount
available coupons as input
tomato soup  in SOUP category

All available Coupons --> CouponRepository
Coupon()   

##### Links: 
