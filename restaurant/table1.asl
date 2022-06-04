!get(order). //initial goal

/* Plans */

+!get(order) : true
	<- .send(auctioneer, achieve, serve(table1,order)).

	
+has(table1,order) : true
	<- !eat(order).
-has(table1,order) : true
	<-!pay(table1).
	
+!eat(order) : has(table1, order)
	<-chew(0);
	.print("Table1 currently eating.");
	!eat(order).
+!eat(order) : not has(table1,order)
	<- true.
	
+!pay(table1):true
	<- .print("Table1 payed.");
	pay(table1).
