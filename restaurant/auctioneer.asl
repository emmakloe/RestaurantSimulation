+!serve(table1,order): true
 	<-!start_auction(1,has(table1,order)). 
 
 +!serve(table2,order): true
 	<-!start_auction(2,has(table2,order)). 

+!serve(table3,order): true
 	<-!start_auction(3,has(table3,order)).
	
+!serve(table4,order): true
 	<-!start_auction(4,has(table4,order)).
	
+!serve(table5,order): true
 	<-!start_auction(5,has(table5,order)).
	
	
+!start_auction(Id,Task)
	<-  .print("Start a new auction for table",Id,"!!!");
		.wait(2000); //wait participants introduction
		+auction_state(Id,bid); //remember state of auction
		.findall(Name,introduction(participant,Name),LP);
		.print("Sending auction to ",LP);
		.send(LP,tell,auction(Id,Task));
		.concat("+!place_bid(",Id,")",Event);
		.at("now +4 seconds", Event).
		// the deadline of the Auction is now + 4 seconds, so
		// the event +!place_bid(Id) is generated at that time
/*	
//receive bids, if proposals have been received, don't wait for the deadline
@r1 +bid(Id,Bid)
	: auction_state(Id,bid) & all_bids_received(Id)
	<- !place_bid(Id,_).

//receive refusals
@r2 +refuse(Id)
	: auction_state(Id,bid) & all_bids_received(Id)
	<- !place_bid(Id,_).*/
	
	

// announce current bid
@pb1[atomic]
+place_bid(Id,_)     // receives bids and checks for new winner
   :    .findall(b(B,A),place_bid(Id,B)[source(A)],L) &
        .length(L,3)  // all 3 expected bids was received
   <-   .print("Bids are ",L);
   		L \==[]; //lehet nem kell
        .min(L,b(Wbid,WAg));
		.print("Winner is ",WAg," with ", Wbid);
		!announce_result(Id,L,WAg);
		-+auction_state(Id,finished). 
		
@pb2 +!place_bid(Id).
		
-place_bid(Id,_)
	<- .print("Auction for table",Id," has failed!").
	
//announce to winner
+!announce_result(Id,[b(B,WAg)|T],WAg)
	<- .send(WAg,tell,accept_bid(Id));
	.print("Telling winning to ",WAg);
	!announce_result(Id,T,WAg).

//announce to others
+!announce_result(Id,[b(B,LAg)|T],WAg)
	<- .send(LAg,tell,reject_bid(Id));
	!announce_result(Id,T,WAg). 
	
+!announce_result(_,[],_).


