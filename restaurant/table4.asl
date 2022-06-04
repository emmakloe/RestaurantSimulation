!get(order). //initial goal

/* Plans */

+!get(order) : true
	<- .wait(4000);
			.send(auctioneer, achieve, serve(table4,order)).
			
+has(table4,order) : true
	<- !eat(order).
-has(table4,order) : true
	<-!pay(table4).
	
+!eat(order) : has(table4, order)
	<-chew(3);
	.print("Table4 currently eating.");
	!eat(order).
+!eat(order) : not has(table4,order)
	<- true.
	
+!pay(table4):true
	<- .print("Table4 payed.");
	pay(table4).
