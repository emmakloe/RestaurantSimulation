!get(order). //initial goal

/* Plans */

+!get(order) : true
	<- .wait(2200);
			.send(auctioneer, achieve, serve(table3,order)).

+has(table3,order) : true
	<- !eat(order).
-has(table3,order) : true
	<-!pay(table3).
	
+!eat(order) : has(table3, order)
	<-chew(2);
	.print("Table3 currently eating.");
	!eat(order).
+!eat(order) : not has(table3,order)
	<- true.
	
+!pay(table3):true
	<- .print("Table3 payed.");
	pay(table3).
