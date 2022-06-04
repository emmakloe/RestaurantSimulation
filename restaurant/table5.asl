!get(order). //initial goal

/* Plans */

+!get(order) : true
	<- .wait(5300);
			.send(auctioneer, achieve, serve(table5,order)).
			
+has(table5,order) : true
	<- !eat(order).
-has(table5,order) : true
	<-!pay(table5).
	
+!eat(order) : has(table5, order)
	<-chew(4);
	.print("Table5 currently eating.");
	!eat(order).
+!eat(order) : not has(table5,order)
	<- true.
	
+!pay(table5):true
	<- .print("Table5 payed.");
	pay(table5).
