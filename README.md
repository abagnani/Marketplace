# Marketplace

Our project is a marketplace that connects buyers and sellers. Sellers can list items of various categories and include descriptive information about the item. Buyers can view items and interact with items they wish to purchase.

For **iteration 1**, we focused on the seller side of our marketplace. We created an interface for an Item, classes for specific Item types that implement the Item interface, and an ItemManager for sellers to keep track of their Items. Specifcally, we completed the following user stories:
- A seller should be able to post items of a specific category
- A seller should be able to post clothing items
- A seller should be able to post food items
- A seller should be able to post electronic items
- A seller should be able to post furniture items
- A seller should be able to view all their existing item postings

We believe everything we implemented currently works.

We do not currently have a user interface, so compiling and running our files in the command line will not output anything.

For **iteration 2**, we first corrected issues that were identified by iteration 1. We had completed user stories that were not yet implemented within a user interface. Therefore, we focused on creating the user interface and implementing our user stories from iteration 1. We then moved on and completed the following user stories:
- A seller should be able to enter the marketplace with a single command
- A seller should be able to post items of a specific category (updated)
- A user can exit our marketplace
- A user should be able to enter the app as either a buyer or a seller
- A buyer should be able to view all current posts
- A seller should be able to enter the app with a unique Seller ID to access their postins
- A seller should be able to change/edit their items after posting (in progress)

We believe everything we implemented currently works. Note, not all of the buyer user interface has been implemented yet. 

To compile and run the code, there is a run.sh script included on the development branch. 

For **iteration 3**, we focused on completing the rest of our user stories, ensuring to use test based development whereever possible. The following user stories were updated/completed:
- A buyer should be able to search items for sale by category
- A seller should be able to change/edit their items after posting (bud update)
- A buyer should be able to favorite an item to view later
- A buyer should be able to get the contact information of the seller of the item they want to purchase
- A buyer should get informed if no sellers have posted yet when trying to view items for sale

Everything implemented works as expected, however the project can definitely be improved with increased exception handling. For example, users must be very careful when using the program to only give numbers when prompted to select options. 

To compile and run the code, there is a run.sh script included on the development branch. 


