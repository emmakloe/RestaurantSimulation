!get(order). //initial goal

/* Plans */

+!get(order) : true
	<- .wait(1100);
			.send(auctioneer, achieve, serve(table2,order)).

+has(table2,order) : true
	<- !eat(order).
-has(table2,order) : true
	<-!pay(table2).
	
+!eat(order) : has(table2, order)
	<-chew(1);
	.print("Table2 currently eating.");
	!eat(order).
+!eat(order) : not has(table2,order)
	<- true.
	
+!pay(table2):true
	<- .print("Table2 payed.");
	pay(table2).
