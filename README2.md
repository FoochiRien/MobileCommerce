#####/Users/Admin/Desktop/20170413_091839.jpg

#Project 2: Mobile Commerce 

###Overview
This app will allow the user to research and purchase dolls. Possible problems with the app include: images attached to the wrong doll, no error message is thrown when there are no search results found on the search activity, no function to stop the user from wrongfully deleting an item from the cart, users are not able to resize images, users are not able to "add to cart" from the search activity. 


###Main Activity
On the main activity, the user is able to access predefined searches that are categorized by sale, discount, clearance, Barbie, and ethnicity. When the user clicks on the link, they will be taken to the search activty where they can view the dolls. If the user would like to view all dolls, they are able to click on the search icon in the toolbar, which will take them to the search activity. 
The user is also able to access the shopping cart from the home page by clicking on the "shopping cart" icon in the toolbar. 


###Search Activity
On the search activity the user is able to view all the dolls available in the database. They can scroll through the list where they are able to see an image of the doll, the name and price of the doll. When the user clicks on an image they will be taken to the detail activity where they will get more information about the doll. 
The user is able to search the database from the toolbar by clicking on the search icon. They are able to search enter different search requirments. This will narrow the list results. 
The user is also able to access the shopping cart from the search activity by clicking on the shopping cart icon. 


###Detail Activity
On the detail activity the user is able to get more information about the doll. They are able to see the image, title, description, and price about the doll. The user is also able to add to thier shopping cart by clicking on the "Add to Cart" button. Once they have clicked on the button, they will see a toast indicating the item has been added to the cart. To return to the search screen the user will need to use the phones back button. To get to the shopping cart the user can click on the shopping cart icon at the bottom of the screen. 


###Shopping Cart Activity
On the shopping cart activity page, the user is able to review items in the cart, delete items, see total of items in cart, and return to the search screen. The user is able to view the image of the item, the title and price. When the user short clicks on the image, they are redirected to the detail activity. When the user long clicks on the image, it is removed from the cart. 
When the user clicks on check-out, an alert dialogue pops-up to thank them for thier purchase and all items are removed from the cart.
The user is able to search for more items by clicking on the search icon in the toolbar. 


#User Stories
######Main Activity
As a User I can, see the toolbar with two items and five buttons.

As a User I can, click on the toolbar and the buttons. 

As a User, when I click on the toolbar and buttons I am redirected to the Search Activity or the shopping cart.

As a User I can, click either, Sale, Deal, Clearance, Barbie, and Ethnic. 

######Search Activity
As a User I can, see the toolbar with two items and three textview images in the recyclerview. 

As a User I can, enter a query into the searchbar, click on the magnifing glass icon and search the database. 

As a User I can, click on the image and be redirected to a detail view of the image. 

######Detail Activity 
As a User I can, see two imageviews, four textviews, and one button.

As a User I can, add an item to my cart by clicking on the "Add to Cart".

As a User I can, add an item to my wish list by clicking on "Add to Wishlist".

As a User I can, access my shopping cart by clicking on the shoppingcart icon.

######ShoppingCart Activity 

As a User I can, see a textview, a button, and the recyclerview. 

As a User I can, remove items from my cart with a long hold on the image.  

As a User I can, go to the detail view of an item by clicking on the image. 

As a User I can view the total cost of the items in my cart. 

As a User I can purchase the items in my cart by clicking on Check Out. 

