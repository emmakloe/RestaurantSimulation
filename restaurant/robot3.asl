//HASZNÁLT FORRÁS: Jason könyv: EXAMPLE: CONTRACT NET PROTOCOL + DOMESTIC ROBOT EXAMPLE
// gets the price for the task,
// (a random value between 100 and 110).
price(Task,X) :- .random(R) & X = (10*R)+100.
plays(initiator,auctioneer).



/* Plans */

// send a message to initiator introducing myself
// as a participant
+plays(initiator,In)
	: .my_name(Me)
	<- .send(In,tell,introduction(participant,Me)).
	
	
// answer a Call For Proposal
@c1 +auction(Id,Task)[source(A)]
	: plays(initiator,A)
	<- 	if(at(robot3,home3)){
   			if(Task==has(table1,order)){
				.findall(price(D),distance(robot3,table1,D),L);
				L \== [];
				.min(L,price(Dist));
				Bid=Dist;
				.print("Robot 3 sends bid");
				+mybid(Id,Task,Bid);
				.send(A,tell,place_bid(Id,Bid));
			}
			
			if(Task==has(table2,order)){
				.findall(price(D),distance(robot3,table2,D),L);
				L \== [];
				.min(L,price(Dist));
				Bid=Dist;
				.print("Robot 3 sends bid");
				+mybid(Id,Task,Bid);
				.send(A,tell,place_bid(Id,Bid));
			}
			
			if(Task==has(table3,order)){
				.findall(price(D),distance(robot3,table3,D),L);
				L \== [];
				.min(L,price(Dist));
				Bid=Dist;
				.print("Robot 3 sends bid");
				+mybid(Id,Task,Bid);
				.send(A,tell,place_bid(Id,Bid));
			}
			if(Task==has(table4,order)){
				.findall(price(D),distance(robot3,table4,D),L);
				L \== [];
				.min(L,price(Dist));
				Bid=Dist;
				.print("Robot 3 sends bid");
				+mybid(Id,Task,Bid);
				.send(A,tell,place_bid(Id,Bid));
			}
			if(Task==has(table5,order)){
				.findall(price(D),distance(robot3,table5,D),L);
				L \== [];
				.min(L,price(Dist));
				Bid=Dist;
				.print("Robot 3 sends bid");
				+mybid(Id,Task,Bid);
				.send(A,tell,place_bid(Id,Bid));
			}
		}
		else {
			Bid = 100000; //if not at home, bid really high
			+mybid(Id,Task,Bid);
			.send(A,tell,place_bid(Id,Bid));
		}.

		
@r1 +accept_bid(Id)
	: mybid(Id,Task,Bid)
	<- .print("My bid ’",Bid,"’ won Auction ",Id,
		" for ",Task,"!");	
		!Task;
		-auction(Id,Task)[source(A)];
	   -mybid(Id,_,_); // clear memory
	   .abolish(accept_bid(_)).
		
		


@r2 +reject_bid(Id)
	<- .print("I lost Auction ",Id, ".");
	-mybid(Id,_,_); // clear memory
	-auction(Id,Task)[source(A)];
	.abolish(reject_bid(_)).



+!has(table1,order):true
	<- get(0);
	!at(robot3,table1);
	hand_in(0);
	!at(robot3,home3).
	
+!has(table2,order):true
	<- get(1);
	!at(robot3,table2);
	hand_in(1);
	!at(robot3,home3).
	
+!has(table3,order):true
	<- get(2);
	!at(robot3,table3);
	hand_in(2);
	!at(robot3,home3).
	
+!has(table4,order):true
	<- get(3);
	!at(robot3,table4);
	hand_in(3);
	!at(robot3,home3).
	
+!has(table5,order):true
	<- get(4);
	!at(robot3,table5);
	hand_in(4);
	!at(robot3,home3).
	
+!at(robot3,P):at(robot3,P)
	<- true.
	
+!at(robot3,P): not at(robot3,P)
	<- move_towards(P,2);
		!at(robot3,P).
