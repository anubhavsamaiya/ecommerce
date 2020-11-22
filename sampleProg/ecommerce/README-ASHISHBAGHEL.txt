########################
## ECommerce Platform ##
########################

@author ashish kumar baghel
@date 10.december.2019

- Main Controller
    - SearchController

- Context Path
    - /api

- Endpoints exposed
    - /search/allproducts
        - return all the available products in the database
    - /search/groupbyclient
        - return below attributes group by client name
            # client name
            # minimum price
            # maximum price
            # no of diff. product (productCount)
            # number of available product quantities (sumCount)
            # average price of group products (avgPrice)
    - /search/groupbycolor
        - return below attributes group by product color
            # product color
            # minimum price
            # maximum price
            # no of diff. product (productCount)
            # number of available product quantities (sumCount)
            # average price of group products (avgPrice)
    - /search/groupbyprice
        - return below attributes group by product price
            # product price
            # no of diff. product (productCount)
            # number of available product quantities (sumCount)

- Junit 4 test cases included


----------------------------------------***END***----------------------------------------
